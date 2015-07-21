package com.tripoin.web;

import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;

import com.tripoin.web.authentication.IAccessControl;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.servlet.DiscoveryNavigator;
import com.tripoin.web.view.login.LoginScreen;
import com.tripoin.web.view.login.LoginScreen.LoginListener;
import com.tripoin.web.view.menu.BaseMenuLayout;
import com.tripoin.web.view.valo.CommonParts;
import com.tripoin.web.view.valo.ValoMenuLayout;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
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
@Theme("tripoin-base")
@Title("Tripoin")
@PreserveOnRefresh
public class TripoinUI extends UI implements ErrorHandler {
	
	private static final long serialVersionUID = -57029129041123227L;
    private CssLayout menuItems;
    private CssLayout menuItemsLayout;
	private ValoMenuLayout root = new ValoMenuLayout();
    private ComponentContainer viewDisplay = root.getContentContainer();
    private DiscoveryNavigator navigator;
	
	@Autowired
    private IAccessControl accessControl;
	
	@Autowired
	private IStateFullRest stateFullRest;

	@Autowired
	private BaseMenuLayout baseMenuLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("Tripoin");
        if (vaadinRequest.getParameter("test") != null) {
            if (browserCantRenderFontsConsistently()) {
                getPage().getStyles().add(".v-app.v-app.v-app {font-family: Sans-Serif;}");
            }
        }
        if (accessControl.isUserSignedIn()){
            mainView();
        }else{
            setContent(new LoginScreen(accessControl, new LoginListener() {            	
				private static final long serialVersionUID = -4033665849275819444L;
				@Override
                public void loginSuccessful() {
                    mainView();
                }
            }));
        }
    }

    protected void mainView() { 
    	setTheme("tripoin-valo");
        if (getPage().getWebBrowser().isIE() && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
        	baseMenuLayout.setWidth("320px");
        } 
        
        /*try{
        	Thread.sleep(2000);
        }catch(InterruptedException e){
        	e.printStackTrace();
        }*/

        navigator = new DiscoveryNavigator(this, viewDisplay);
        if(baseMenuLayout.getNavigator() == null)
        	baseMenuLayout.setNavigator(navigator);
        if(menuItems == null)
        	menuItems = baseMenuLayout.getMenu();
    	if(menuItemsLayout == null)
    		menuItemsLayout = baseMenuLayout.getMenuItemsLayout();

        getPage().setTitle("Tripoin Web Application");
        setContent(root);
        root.setWidth("100%");
        root.addMenu(menuItems);
        addStyleName(ValoTheme.UI_WITH_MENU);

        final String f = Page.getCurrent().getUriFragment();
        if (f == null || f.equals("")) {
            navigator.navigateTo("common");
        }

        navigator.setErrorView(CommonParts.class);

        navigator.addViewChangeListener(new ViewChangeListener() {
			private static final long serialVersionUID = -1255484519903571054L;
			@Override
            public boolean beforeViewChange(final ViewChangeEvent event) {
                return true;
            }
            @Override
            public void afterViewChange(final ViewChangeEvent event) {
                for (final Iterator<Component> it = menuItemsLayout.iterator(); it.hasNext();) {
                    it.next().removeStyleName("selected");
                }
                for (final Entry<String, String> item : stateFullRest.getAdditionalDataMenu().entrySet()) {
                    if (event.getViewName().equals(item.getKey())) {
                        for (final Iterator<Component> it = menuItemsLayout.iterator(); it.hasNext();) {
                            final Component c = it.next();
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
		accessControl.clearSecurityContext();
        getSession().close();
		super.close();
	}

	@Override
	public void error(com.vaadin.server.ErrorEvent event) {
		if (event.getThrowable().getCause() instanceof AccessDeniedException){
            AccessDeniedException accessDeniedException = (AccessDeniedException) event.getThrowable().getCause();
            Notification.show(accessDeniedException.getMessage(), Notification.Type.ERROR_MESSAGE);
            setContent(null);
            return;
        }
		if (event.getThrowable() instanceof AccessDeniedException){
            AccessDeniedException exception = (AccessDeniedException) event.getThrowable();
            Notification.show(exception.getMessage(), Notification.Type.ERROR_MESSAGE);
            setContent(null);
            return;
        }
	}
    
    private boolean browserCantRenderFontsConsistently() {
        return getPage().getWebBrowser().getBrowserApplication().contains("PhantomJS") || (getPage().getWebBrowser().isIE() && getPage() .getWebBrowser().getBrowserMajorVersion() <= 9);
    }
    
}
