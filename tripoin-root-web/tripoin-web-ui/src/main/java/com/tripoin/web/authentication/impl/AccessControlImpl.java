package com.tripoin.web.authentication.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tripoin.web.authentication.BaseAuthentication;
import com.tripoin.web.authentication.IAccessControl;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class AccessControlImpl implements IAccessControl {

    private BaseAuthentication baseAuthentication;    
	
	public void setBaseAuthentication(BaseAuthentication baseAuthentication) {
		this.baseAuthentication = baseAuthentication;
	}

	@Override
	public void clearSecurityContext(){
		baseAuthentication.logout();		
	}

	@Override
    public boolean signIn(String username, String password) {
		boolean sucess = baseAuthentication.login(username, password);
        return sucess;
    }

    @Override
    public boolean isUserSignedIn() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
        if (authentication != null && authentication.isAuthenticated())
        	return true;
        else
        	return false;
    }

	@Override
	public String getUsername() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
		return authentication.getName();
	}

	@Override
	public String getRole() {	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	
    	GrantedAuthority grantedAuthority = authentication.getAuthorities().iterator().next();
		return grantedAuthority.getAuthority();
	}   

}
