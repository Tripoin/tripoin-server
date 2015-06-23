package com.tripoin.web.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tripoin.core.dto.GeneralConnectionDTO;
import com.tripoin.web.common.ICommonRest;
import com.tripoin.web.common.WebServiceConstant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/WEB-INF/config/web-application-config.xml" })
public class WebServiceGETTest implements ApplicationContextAware {
	
	private static transient final Logger LOGGER = LoggerFactory.getLogger(WebServiceGETTest.class);
	
	@Autowired
	private ICommonRest commonRest;
	
	private final RestTemplate restTemplate = new RestTemplate();
		
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
		HttpEntity<Integer> entity = new HttpEntity<>(commonRest.buildHeaders("spring", "spring"));
		ResponseEntity<GeneralConnectionDTO> response = restTemplate.exchange(commonRest.getUrl(WebServiceConstant.HTTP_CONNECTION), HttpMethod.GET, entity, GeneralConnectionDTO.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		LOGGER.debug("Response Body : ".concat(response.getBody().toString()));
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void runNotResponseTest() {
		HttpEntity<Integer> entity = new HttpEntity<>(commonRest.buildHeaders("", ""));
		ResponseEntity<GeneralConnectionDTO> response = restTemplate.exchange(commonRest.getUrl(WebServiceConstant.HTTP_CONNECTION), HttpMethod.GET, entity, GeneralConnectionDTO.class);

		LOGGER.debug("Response Body : ".concat(response.getBody().toString()));		
	}

}
