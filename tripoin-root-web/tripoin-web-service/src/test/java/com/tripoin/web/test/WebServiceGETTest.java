package com.tripoin.web.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tripoin.core.dto.GeneralConnectionDTO;
import com.tripoin.web.common.ICommonRest;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.common.WebServiceConstant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext-web-service.xml" })
public class WebServiceGETTest implements ApplicationContextAware {
	
	private static transient final Logger LOGGER = LoggerFactory.getLogger(WebServiceGETTest.class);
	
	@Autowired
	private ICommonRest commonRest;
	
	@Autowired
	private IStateFullRest stateFullRest;
		
	private ApplicationContext applicationContext;
	
	public <T> T getBean(Class<T> beanType) {
		return applicationContext.getBean(beanType);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Test
	public void runResponseTest() {
		stateFullRest.setUsername("spring");
		stateFullRest.setPassword("spring");
		GeneralConnectionDTO generalConnectionDTO = stateFullRest.get(commonRest.getUrl(WebServiceConstant.HTTP_CONNECTION), GeneralConnectionDTO.class); 

		LOGGER.debug("Response Body 1 : ".concat(generalConnectionDTO.getResponse_msg()));
		
	}
	
	@After
	/*@Test(expected=HttpClientErrorException.class)*/
	public void runNotResponseTest() {
		stateFullRest.setUsername(null);
		stateFullRest.setPassword(null);
		/*stateFullRest.clearAllCookies();*/
		
		GeneralConnectionDTO generalConnectionDTO = stateFullRest.get(commonRest.getUrl(WebServiceConstant.HTTP_CONNECTION), GeneralConnectionDTO.class); 

		LOGGER.debug("Response Body 2 : ".concat(generalConnectionDTO.toString()));
		
	}

}
