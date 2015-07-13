package com.tripoin.web.servlet;

import java.io.IOException;

import com.tripoin.web.servlet.view.ValoThemeSessionInitListener;
import com.vaadin.server.*;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SpringVaadinServlet extends VaadinServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5912117157703160443L;
	
    /**
     * Servlet parameter name for system message bean
     */
    private static final String SYSTEM_MESSAGES_BEAN_NAME_PARAMETER = "systemMessagesBeanName";
    private static final String CONTEXT_CONFIG_LOCATION_PARAMETER = "contextConfigLocation";
    
    /**
     * Spring Application Context
     */
    private transient ApplicationContext applicationContext;
    
    /**
     * system message bean name
     */
    private String systemMessagesBeanName = "";

    @Override
    public void init(ServletConfig config) throws ServletException {
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        if (config.getInitParameter(CONTEXT_CONFIG_LOCATION_PARAMETER) != null) {
            XmlWebApplicationContext context = new XmlWebApplicationContext();
            context.setParent(applicationContext);
            context.setConfigLocation(config.getInitParameter(CONTEXT_CONFIG_LOCATION_PARAMETER));
            context.setServletConfig(config);
            context.setServletContext(config.getServletContext());
            context.refresh();
            applicationContext = context;
        }
        if (config.getInitParameter(SYSTEM_MESSAGES_BEAN_NAME_PARAMETER) != null) {
            systemMessagesBeanName = config.getInitParameter(SYSTEM_MESSAGES_BEAN_NAME_PARAMETER);
        }
        if (SpringApplicationContext.getApplicationContext() == null){
            SpringApplicationContext.setApplicationContext(applicationContext);
        }
        super.init(config);
    }

    protected void initializePlugin(VaadinServletService service) {
        // Spring system messages provider
        if (systemMessagesBeanName != null && systemMessagesBeanName != "") {
            SpringVaadinSystemMessagesProvider messagesProvider = new SpringVaadinSystemMessagesProvider(applicationContext, systemMessagesBeanName);
            service.setSystemMessagesProvider(messagesProvider);
        }
        String uiProviderProperty = service.getDeploymentConfiguration().getApplicationOrSystemProperty(Constants.SERVLET_PARAMETER_UI_PROVIDER, null);
        // Add SpringUIProvider if custom provider doesn't defined.
        if (uiProviderProperty == null) {
            service.addSessionInitListener(new SessionInitListener() {
            	
                /**
				 * 
				 */
				private static final long serialVersionUID = 7821444940054741472L;

				@Override
                public void sessionInit(SessionInitEvent event) throws ServiceException {
                    event.getSession().addUIProvider(new SpringUIProvider());
                }
            });
        }
    }

    @Override
    protected VaadinServletService createServletService(DeploymentConfiguration deploymentConfiguration) throws ServiceException {
        final VaadinServletService service = super.createServletService(deploymentConfiguration);
        initializePlugin(service);
        return service;
    }
    
    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new ValoThemeSessionInitListener());
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
		super.service(request, response);
	}
    
}
