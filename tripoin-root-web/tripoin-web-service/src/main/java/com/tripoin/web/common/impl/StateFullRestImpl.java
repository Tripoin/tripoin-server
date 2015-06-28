package com.tripoin.web.common.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tripoin.web.common.IStateFullRest;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class StateFullRestImpl implements IStateFullRest {

	private static final Logger LOG = LoggerFactory.getLogger(StateFullRestImpl.class);

	private final Map<String, String> cookies;
	private String username;
	private String password;
	private boolean isOAuth;
	private final RestTemplate template;
	private static StateFullRestImpl instance;
	private HttpStatus statusCode;

	private StateFullRestImpl() {
		template = new RestTemplate();
		cookies = new HashMap<>();
	}
	
	public StateFullRestImpl getInstance(){
		if(instance == null)
			return new StateFullRestImpl();
		return instance;
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public void clearAllCookies() {
		cookies.clear();
	}

	public void setCookie(String key, String value) {
		cookies.put(key, value);
	}	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public HttpStatus getStatusCode(){
		return statusCode;
	}	
	
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public void setIsOAuth(boolean isOAuth) {this.isOAuth = isOAuth;}

	public RestTemplate getTemplate() {
		return template;
	}

	public void removeCookie(String key) {
		cookies.remove(key);
	}

	public <T> T get(String url, Class<T> clazz) {
		return getObject(HttpMethod.GET, url, null, clazz);
	}

	public <T> T delete(String url, Object data, Class<T> clazz) {
		return getObject(HttpMethod.DELETE, url, data, clazz);
	}

	public <T> T post(String url, Object data, Class<T> clazz) {
		return getObject(HttpMethod.POST, url, data, clazz);
	}

	public <T> T put(String url, Object data, Class<T> clazz) {
		return getObject(HttpMethod.PUT, url, data, clazz);
	}

	public <T> T getObject(HttpMethod method, String url, Object data, Class<T> clazz) {
		HttpEntity<?> request = new HttpEntity<Object>(data, getHeaders());
		ResponseEntity<T> response;
		try{
			response = template.exchange(url, method, request, clazz);
			extractCookies(response.getHeaders());
		}catch(HttpClientErrorException hcee){
			response = new ResponseEntity<>(hcee.getStatusCode());
			clearAllCookies();
		}catch(Exception e){
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			clearAllCookies();			
		}
		setStatusCode(response.getStatusCode());
		return response.getBody();
	}

	/**
	 * <b>Description :</b><br>
	 * Extract cookies from a response header. Will overight previous cookies if new one arrive with
	 * the same key.
	 *
	 * @param headers response header
	 */
	protected void extractCookies(HttpHeaders headers) {
		List<String> cookiesList = headers.get("Set-Cookie");
		if (cookiesList != null && !cookiesList.isEmpty()) {
			String cookiesStr = cookiesList.get(0);
			if (LOG.isTraceEnabled()) {
				LOG.trace("Cookies read from response : " + cookiesStr);
			}
			String[] cookiesSplit = cookiesStr.split(";");
			for (String cookieStr : cookiesSplit) {
				String[] keyValueSplit = cookieStr.split("=");
				cookies.put(keyValueSplit[0], keyValueSplit[1]);
			}
		}
	}

	/**
	 * <b>Description :</b><br>
	 * Get the cookies string to write in the request header.
	 *
	 * @return cookies as string
	 */
	protected String getCookiesString() {
		StringBuilder sb = new StringBuilder();
		if (!cookies.isEmpty()) {
			for(Entry<String, String> entry : cookies.entrySet()){
				sb.append(entry.getKey());
				sb.append("=");
				sb.append(entry.getValue());
				sb.append(";");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("Cookies added to request : " + sb.toString());
		}
		return sb.toString();
	}

	protected HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		if(cookies.isEmpty()) {
			if(isOAuth){
				return encodeUserCredentials(headers, username, password);	
			}
		}
		headers.put("Cookie", Arrays.asList(new String[]{getCookiesString()}));
		return headers;
	}
	
	private HttpHeaders encodeUserCredentials(HttpHeaders headers, String username, String password){
		String combinedUsernamePassword = username+":"+password;
		byte[] base64Token = Base64.encode(combinedUsernamePassword.getBytes());
		String base64EncodedToken = new String (base64Token);
		headers.add("Authorization","Basic ".concat(base64EncodedToken));
		return headers;
	}
}
