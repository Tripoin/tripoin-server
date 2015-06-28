package com.tripoin.web.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tripoin.core.dto.GeneralConnectionDTO;
import com.tripoin.web.common.ICommonRest;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.common.WebServiceConstant;

/**
 * Default mock implementation of {@link AccessControl}. This implementation
 * accepts any string as a password, and considers the user "admin" as the only
 * administrator.
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class BasicAccessControl implements AccessControl {

	private ICommonRest commonRest;	
	
	public void setCommonRest(ICommonRest commonRest) {
		this.commonRest = commonRest;
	}
	
	@Autowired
	private IStateFullRest stateFullRest;
	
    @Override
    public boolean signIn(String username, String password) {
    	stateFullRest.setUsername(username);
    	stateFullRest.setPassword(password);
    	GeneralConnectionDTO loginRest = stateFullRest.get(commonRest.getUrl(WebServiceConstant.HTTP_CONNECTION), GeneralConnectionDTO.class);
        if(HttpStatus.OK != stateFullRest.getStatusCode() || loginRest == null || !WebServiceConstant.RESPONSE_SUCCESS.equals(loginRest.getResult())){
        	return false;
        }
        CurrentUser.setUser(username);
        return true;
    }

    @Override
    public boolean isUserSignedIn() {
        return !CurrentUser.getUser().isEmpty();
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
        return CurrentUser.getUser();
    }

}
