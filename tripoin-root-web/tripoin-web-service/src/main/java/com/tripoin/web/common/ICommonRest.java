package com.tripoin.web.common;

import org.springframework.http.HttpHeaders;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ICommonRest {
	
	/**
	 * <b>Sample Code:</b><br>
	 * <code>getUrl(WebServiceConstant.HTTP_CONNECTION)</code><br>
	 * @param paramContext
	 * @return
	 */
	public String getUrl(String paramContext);

	/**
	 * <b>Sample Code:</b><br>
	 * <code>buildHeaders(username, password)</code><br>
	 * @param username
	 * @param password
	 * @return
	 */
	public HttpHeaders buildHeaders(String username, String password);

}
