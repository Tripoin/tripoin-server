package com.tripoin.web.common.impl;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;

import com.tripoin.web.common.ICommonRest;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class CommonRestImpl implements ICommonRest {
	
	private String protocolHTTP;	
	private String hostHTTP;
	private String portHTTP;
	private String homeContextHTTP;
	private String wsContextHTTP;
	private boolean isOAuth;
	
	public void setProtocolHTTP(String protocolHTTP) {this.protocolHTTP = protocolHTTP;}
	public void setHostHTTP(String hostHTTP) {this.hostHTTP = hostHTTP;}
	public void setPortHTTP(String portHTTP) {this.portHTTP = portHTTP;}
	public void setHomeContextHTTP(String homeContextHTTP) {this.homeContextHTTP = homeContextHTTP;}	
	public void setWsContextHTTP(String wsContextHTTP) {this.wsContextHTTP = wsContextHTTP;}
	public void setIsOAuth(boolean isOAuth) {this.isOAuth = isOAuth;}
	
	private HttpHeaders encodeUserCredentials(HttpHeaders headers, String username, String password){
		String combinedUsernamePassword = username+":"+password;
		byte[] base64Token = Base64.encode(combinedUsernamePassword.getBytes());
		String base64EncodedToken = new String (base64Token);
		headers.add("Authorization","Basic ".concat(base64EncodedToken));
		return headers;
	}
	
	public String getUrl(String paramContext) {
		return protocolHTTP.concat(hostHTTP).concat(portHTTP).concat(homeContextHTTP).concat(wsContextHTTP).concat(paramContext);
	}
	
	public HttpHeaders buildHeaders(String username, String password) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		if(isOAuth)
			headers = encodeUserCredentials(headers, username, password);		
		return headers;
	}

}
