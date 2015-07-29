package com.tripoin.web;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tripoin.web.authentication.IAccessControl;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.servlet.DiscoveryNavigator;
import com.tripoin.web.view.ErrorView;
import com.tripoin.web.view.login.LoginScreen;
import com.tripoin.web.view.login.LoginScreen.LoginListener;
import com.tripoin.web.view.menu.BaseMenuLayout;
import com.tripoin.web.view.menu.BaseMenuLayout.LogoutListener;
import com.tripoin.web.view.valo.ValoMenuLayout;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Tripoin UI class of the application that shows either the login screen or the
 * main view of the application depending on whether a user is signed in.
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Viewport("user-scalable=no,initial-scale=1.0")
@Widgetset("com.tripoin.web.TripoinWidgetSet")
@Theme("tripoin-base")
@Title("")
@PreserveOnRefresh
public class TripoinUI extends UI implements ErrorHandler {
	
	private static final long serialVersionUID = -57029129041123227L;
    private static Logger LOGGER = LoggerFactory.getLogger(TripoinUI.class);
    private CssLayout menuItems;
    private CssLayout menuItemsLayout;
	private ValoMenuLayout root = new ValoMenuLayout();
    private ComponentContainer viewDisplay = root.getContentContainer();
    private DiscoveryNavigator navigator;
    private ApplicationContext applicationContext;
    
    @Autowired
    private LoginScreen login;
	
	@Autowired
    private IAccessControl accessControl;
	
	@Autowired
	private IStateFullRest stateFullRest;

	@Autowired
	private BaseMenuLayout baseMenuLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        try{
        	SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        	getSession().setErrorHandler(this);
	        Responsive.makeResponsive(this);
	        addStyleName(ValoTheme.UI_WITH_MENU);
	        setLocale(Locale.US);
	        if (vaadinRequest.getParameter("test") != null) {
	            if (getPage().getWebBrowser().getBrowserApplication().contains("PhantomJS") || (getPage().getWebBrowser().isIE() && getPage() .getWebBrowser().getBrowserMajorVersion() <= 9)) {
	                getPage().getStyles().add(".v-app.v-app.v-app {font-family: Sans-Serif;}");
	            }
	        }
	        if (accessControl.isUserSignedIn()){
	            mainView();
	        }else{
	        	login.addLoginListener(new LoginListener() {
					private static final long serialVersionUID = 5327649431527930757L;
					@Override
					public void loginSuccessful() {
						mainView();
					}
				});
	        	getPage().setTitle("Tripoin");
	            setContent(login);
	        }       	
        }catch(Exception e){
        	LOGGER.error(e.getMessage(), e);
        	error(new com.vaadin.server.ErrorEvent(new AccessDeniedException("Oops! We've run out of web pages.")));
        }
    }

    protected void mainView() {
    	getPage().setTitle("Tripoin Web Application");
    	setTheme("tripoin-valo");
    	baseMenuLayout.addLogoutListener(new LogoutListener() {
			private static final long serialVersionUID = -8249206203052668842L;
			@Override
			public void doLogout() {
				close();
			}
		});
    	if(stateFullRest != null && stateFullRest.getAdditionalDataMenu() != null && !stateFullRest.getAdditionalDataMenu().isEmpty())
    		baseMenuLayout.setAdditionalDataMenu(stateFullRest.getAdditionalDataMenu());
        if(menuItems == null)
        	menuItems = baseMenuLayout.getMenu();
    	if(menuItemsLayout == null)
    		menuItemsLayout = baseMenuLayout.getMenuItemsLayout();
    	baseMenuLayout.updateUser(accessControl.getUsername());
        if (getPage().getWebBrowser().isIE() && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
        	baseMenuLayout.setWidth("320px");
        }
        root.addMenu(menuItems);
        root.setWidth("100%"); 
		removeStyleName("login-screen");
		removeStyleName("login-information");
		removeStyleName("login-form");
		removeStyleName("centering-layout");
        setContent(root);
        generateNavigator();
    }
    
    private void generateNavigator(){
        navigator = new DiscoveryNavigator(this, viewDisplay);
        final String f = Page.getCurrent().getUriFragment();
        if (f == null || f.equals("") || f.equals("#!")) {
            navigator.navigateTo("");
        }  
        navigator.setErrorView(ErrorView.class);
        navigator.addViewChangeListener(new ViewChangeListener() {
			private static final long serialVersionUID = -1255484519903571054L;
			@Override
            public boolean beforeViewChange(final ViewChangeEvent event) {
                return true;
            }
            @Override
            public void afterViewChange(final ViewChangeEvent event) {
                for (final Iterator<com.vaadin.ui.Component> it = menuItemsLayout.iterator(); it.hasNext();) {
                    it.next().removeStyleName("selected");
                }
                for (final Entry<String, String> item : stateFullRest.getAdditionalDataMenu().entrySet()) {
                    if (event.getViewName().equals(item.getKey())) {
                        for (final Iterator<com.vaadin.ui.Component> it = menuItemsLayout.iterator(); it.hasNext();) {
                            final com.vaadin.ui.Component c = it.next();
                            if (c.getCaption() != null && c.getCaption().startsWith(item.getValue())) {
                                c.addStyleName("selected");
                                break;
                            }
                        }
                        break;
                    }
                }
                baseMenuLayout.removeStyleName("valo-menu-visible");
            }
        });    	
    }

    public static TripoinUI get() {
        return (TripoinUI) UI.getCurrent();
    }    

	@Override
	public void close() {
		if(stateFullRest != null && stateFullRest.getAdditionalDataMenu() != null && !stateFullRest.getAdditionalDataMenu().isEmpty())
			stateFullRest.clearAllCookies();
        VaadinSession.getCurrent().close();
		getSession().getSession().invalidate();
		getSession().close();
		Page.getCurrent().setLocation("/j_spring_security_logout");
		setPollInterval(3000);
	}

	@Override
	public void error(com.vaadin.server.ErrorEvent event) {
		if (event.getThrowable().getCause() instanceof AccessDeniedException){
            AccessDeniedException accessDeniedException = (AccessDeniedException) event.getThrowable().getCause();
            Notification.show(accessDeniedException.getMessage(), Notification.Type.ERROR_MESSAGE);
            setContent(new ErrorView());
            return;
        }
		if (event.getThrowable() instanceof AccessDeniedException){
            AccessDeniedException exception = (AccessDeniedException) event.getThrowable();
            Notification.show(exception.getMessage(), Notification.Type.ERROR_MESSAGE);
            setContent(new ErrorView());
            return;
        }
	}
    
    public void setAplicationContext(VaadinRequest vaadinRequest){
    	WrappedSession session = vaadinRequest.getWrappedSession();
    	HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
    	ServletContext servletContext = httpSession.getServletContext();
    	applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
    
    public ApplicationContext getAplicationContext(){
    	return applicationContext;
    }
    
}
