package com.tripoin.web.servlet.view;

import org.jsoup.nodes.Element;

import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class ValoThemeSessionInitListener implements SessionInitListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5668257846901364990L;

	@Override
    public void sessionInit(final SessionInitEvent event) throws ServiceException {
        event.getService().setSystemMessagesProvider(
                new SystemMessagesProvider() {

                    /**
					 * 
					 */
					private static final long serialVersionUID = -340666228323933907L;

					@Override
                    public SystemMessages getSystemMessages(final SystemMessagesInfo systemMessagesInfo) {
                        CustomizedSystemMessages csm = new CustomizedSystemMessages();
                        csm.setSessionExpiredNotificationEnabled(false);
                        return csm;
                    }
                });
        event.getSession().addBootstrapListener(new BootstrapListener() {

            /**
			 * 
			 */
			private static final long serialVersionUID = 8733637496824201946L;

			@Override
            public void modifyBootstrapPage(final BootstrapPageResponse response) {
                final Element head = response.getDocument().head();
                head.appendElement("meta").attr("name", "viewport").attr("content", "width=device-width, initial-scale=1");
                head.appendElement("meta").attr("name", "apple-mobile-web-app-capable").attr("content", "yes");
                head.appendElement("meta").attr("name", "apple-mobile-web-app-status-bar-style").attr("content", "black");
            }

            @Override
            public void modifyBootstrapFragment(final BootstrapFragmentResponse response) {
            	
            }
        });
    }

}
