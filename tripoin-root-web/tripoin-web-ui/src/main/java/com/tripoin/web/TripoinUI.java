package com.tripoin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tripoin.web.authentication.AccessControl;
import com.tripoin.web.authentication.LoginScreen;
import com.tripoin.web.authentication.LoginScreen.LoginListener;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.view.MainScreen;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Main UI class of the application that shows either the login screen or the
 * main view of the application depending on whether a user is signed in.
 *
 * The @Viewport annotation configures the viewport meta tags appropriately on
 * mobile devices. Instead of device based scaling (default), using responsive
 * layouts.
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Viewport("user-scalable=no,initial-scale=1.0")
@Theme("tripoin")
@Widgetset("com.tripoin.web.TripoinAppWidgetset")
@Scope("prototype")
@Component
public class TripoinUI extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -57029129041123227L;
	
	@Autowired
    private AccessControl baseAccessControl;
	
	@Autowired
	private IStateFullRest stateFullRest;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("Tripoin");
        if (!baseAccessControl.isUserSignedIn()) {
            setContent(new LoginScreen(baseAccessControl, new LoginListener() {
            	
                /**
				 * 
				 */
				private static final long serialVersionUID = -4033665849275819444L;

				@Override
                public void loginSuccessful() {
                    showMainView();
                }
            }));
        } else {
            showMainView();
        }
    }

    protected void showMainView() {
        addStyleName(ValoTheme.UI_WITH_MENU);
        setContent(new MainScreen(TripoinUI.this));
        getNavigator().navigateTo(getNavigator().getState());
    }

    public static TripoinUI get() {
        return (TripoinUI) UI.getCurrent();
    }

    public AccessControl getAccessControl() {
        return baseAccessControl;
    }

	@Override
	public void close() {
		super.close();
		stateFullRest.clearAllCookies();
	}

}
