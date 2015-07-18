package com.tripoin.web;

import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tripoin.web.authentication.IAccessControl;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.servlet.DiscoveryNavigator;
import com.tripoin.web.view.login.LoginScreen;
import com.tripoin.web.view.login.LoginScreen.LoginListener;
import com.tripoin.web.view.menu.BaseMenuLayout;
import com.tripoin.web.view.valo.CommonParts;
import com.tripoin.web.view.valo.StringGenerator;
import com.tripoin.web.view.valo.TestIcon;
import com.tripoin.web.view.valo.ValoMenuLayout;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Container.Hierarchical;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
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
	private ApplicationContext applicationContext;
	
	@Autowired
    private IAccessControl accessControl;
	
	@Autowired
	private IStateFullRest stateFullRest;

	private BaseMenuLayout baseMenuLayout;

    public void setBaseMenuLayout(BaseMenuLayout baseMenuLayout) {
		this.baseMenuLayout = baseMenuLayout;
	}

	ValoMenuLayout root = new ValoMenuLayout();
    ComponentContainer viewDisplay = root.getContentContainer();
    private DiscoveryNavigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("Tripoin");
        if (vaadinRequest.getParameter("test") != null) {
            testMode = true;

            if (browserCantRenderFontsConsistently()) {
                getPage().getStyles().add(
                        ".v-app.v-app.v-app {font-family: Sans-Serif;}");
            }
        }
        if (accessControl.isUserSignedIn()) {
            showMainView();
        }else{
            setContent(new LoginScreen(accessControl, new LoginListener() {
            	
				private static final long serialVersionUID = -4033665849275819444L;

				@Override
                public void loginSuccessful() {
                    showMainView();
                }
            }));
        }
    }

    protected void showMainView() { 
    	setTheme("tripoin-valo");
        if (getPage().getWebBrowser().isIE() && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
        	baseMenuLayout.setWidth("320px");
        } 
        
        try{
        	Thread.sleep(2000);
        }catch(InterruptedException e){
        	e.printStackTrace();
        }

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

    public IAccessControl getAccessControl() {
        return accessControl;
    }
    
    public void setAplicationContext(VaadinRequest request){
    	WrappedSession session = request.getWrappedSession();
    	HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
    	ServletContext servletContext = httpSession.getServletContext();
    	applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
    
    public ApplicationContext getAplicationContext(){
    	return applicationContext;
    }

	@Override
	public void close() {
		getAccessControl().clearSecurityContext();
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

	private boolean testMode = false;
    public static boolean isTestMode() {
        return ((TripoinUI) getCurrent()).testMode;
    }
    
    private boolean browserCantRenderFontsConsistently() {
        return getPage().getWebBrowser().getBrowserApplication().contains("PhantomJS") || (getPage().getWebBrowser().isIE() && getPage() .getWebBrowser().getBrowserMajorVersion() <= 9);
    }

    public static Handler actionHandler = new Handler() {
    	
		private static final long serialVersionUID = -1297210206380850953L;
		private final Action ACTION_ONE = new Action("Action One");
        private final Action ACTION_TWO = new Action("Action Two");
        private final Action ACTION_THREE = new Action("Action Three");
        private final Action[] ACTIONS = new Action[] { ACTION_ONE, ACTION_TWO, ACTION_THREE };

        @Override
        public void handleAction(final Action action, final Object sender, final Object target) {
            Notification.show(action.getCaption());
        }

        @Override
        public Action[] getActions(final Object target, final Object sender) {
            return ACTIONS;
        }
    };

    public static Handler getActionHandler() {
        return actionHandler;
    }

    public static final String CAPTION_PROPERTY = "caption";
    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String ICON_PROPERTY = "icon";
    public static final String INDEX_PROPERTY = "index";

    @SuppressWarnings("unchecked")
    public static Container generateContainer(final int size, final boolean hierarchical) {
        final TestIcon testIcon = new TestIcon(90);
        final IndexedContainer container = hierarchical ? new HierarchicalContainer() : new IndexedContainer();
        final StringGenerator sg = new StringGenerator();
        container.addContainerProperty(CAPTION_PROPERTY, String.class, null);
        container.addContainerProperty(ICON_PROPERTY, Resource.class, null);
        container.addContainerProperty(INDEX_PROPERTY, Integer.class, null);
        container.addContainerProperty(DESCRIPTION_PROPERTY, String.class, null);
        for (int i = 1; i < size + 1; i++) {
            final Item item = container.addItem(i);
            item.getItemProperty(CAPTION_PROPERTY).setValue(
                    sg.nextString(true) + " " + sg.nextString(false));
            item.getItemProperty(INDEX_PROPERTY).setValue(i);
            item.getItemProperty(DESCRIPTION_PROPERTY).setValue(
                    sg.nextString(true) + " " + sg.nextString(false) + " "
                            + sg.nextString(false));
            item.getItemProperty(ICON_PROPERTY).setValue(testIcon.get());
        }
        container.getItem(container.getIdByIndex(0))
                .getItemProperty(ICON_PROPERTY).setValue(testIcon.get());

        if (hierarchical) {
            for (int i = 1; i < size + 1; i++) {
                for (int j = 1; j < 5; j++) {
                    final String id = i + " -> " + j;
                    Item child = container.addItem(id);
                    child.getItemProperty(CAPTION_PROPERTY).setValue(
                            sg.nextString(true) + " " + sg.nextString(false));
                    child.getItemProperty(ICON_PROPERTY).setValue(
                            testIcon.get());
                    // ((Hierarchical) container).setChildrenAllowed(id, false);
                    ((Hierarchical) container).setParent(id, i);

                    for (int k = 1; k < 6; k++) {
                        final String id2 = id + " -> " + k;
                        child = container.addItem(id2);
                        child.getItemProperty(CAPTION_PROPERTY).setValue(
                                sg.nextString(true) + " "
                                        + sg.nextString(false));
                        child.getItemProperty(ICON_PROPERTY).setValue(
                                testIcon.get());
                        // ((Hierarchical) container)
                        // .setChildrenAllowed(id, false);
                        ((Hierarchical) container).setParent(id2, id);

                        for (int l = 1; l < 5; l++) {
                            final String id3 = id2 + " -> " + l;
                            child = container.addItem(id3);
                            child.getItemProperty(CAPTION_PROPERTY).setValue(
                                    sg.nextString(true) + " "
                                            + sg.nextString(false));
                            child.getItemProperty(ICON_PROPERTY).setValue(
                                    testIcon.get());
                            // ((Hierarchical) container)
                            // .setChildrenAllowed(id, false);
                            ((Hierarchical) container).setParent(id3, id2);
                        }
                    }
                }
            }
        }
        return container;
    }
    
}
