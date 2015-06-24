package com.tripoin.web.samples.authentication;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tripoin.core.dto.GeneralConnectionDTO;
import com.tripoin.web.common.ICommonRest;
import com.tripoin.web.common.WebServiceConstant;

/**
 * Default mock implementation of {@link AccessControl}. This implementation
 * accepts any string as a password, and considers the user "admin" as the only
 * administrator.
 */
public class BasicAccessControl implements AccessControl {

	private ICommonRest commonRest;	
	
	public void setCommonRest(ICommonRest commonRest) {
		this.commonRest = commonRest;
	}

	private final RestTemplate restTemplate = new RestTemplate();
	
    @Override
    public boolean signIn(String username, String password) {
    	HttpEntity<Integer> entity = new HttpEntity<>(commonRest.buildHeaders(username, password));
		ResponseEntity<GeneralConnectionDTO> response = restTemplate.exchange(commonRest.getUrl(WebServiceConstant.HTTP_CONNECTION), HttpMethod.GET, entity, GeneralConnectionDTO.class);

        if (HttpStatus.OK != response.getStatusCode())
            return false;

        CurrentUser.set(username);
        return true;
    }

    @Override
    public boolean isUserSignedIn() {
        return !CurrentUser.get().isEmpty();
    }

    @Override
    public boolean isUserInRole(String role) {
        if ("spring".equals(role)) {
            // Only the "admin" user is in the "admin" role
            return getPrincipalName().equals("spring");
        }

        // All users are in all non-admin roles
        return true;
    }

    @Override
    public String getPrincipalName() {
        return CurrentUser.get();
    }

}
