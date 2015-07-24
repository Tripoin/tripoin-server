package com.tripoin.web.authentication.impl;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tripoin.core.common.RoleConstant;
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

	@Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
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
        if (authentication != null){
        	GrantedAuthority grantedAuthority = authentication.getAuthorities().iterator().next();
        	if(!RoleConstant.ROLE_ANONYMOUS.equals(grantedAuthority.getAuthority()))
        		return true;
        	else
        		return false;
        }else
        	return false;
    }

    @Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
	@Override
	public String getUsername() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if(authentication == null)
    		return null;
		return authentication.getName();
	}

	@Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
	@Override
	public String getRole() {	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if(authentication == null)
    		return null;
    	GrantedAuthority grantedAuthority = authentication.getAuthorities().iterator().next();
		return grantedAuthority.getAuthority();
	}   

}
