package com.tripoin.core.rest.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.tripoin.core.common.RoleConstant;
import com.tripoin.core.service.IGenericManagerJpa;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component("logoutEndpoint")
public class LogoutEndpoint extends XReturnStatus {

    private static Logger LOGGER = LoggerFactory.getLogger(LogoutEndpoint.class);

	@Autowired
	private IGenericManagerJpa iGenericManagerJpa;

	private String currentUserName;

	@Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
	public void doLogout(Message<?> inMessage){	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}		
		SecurityContextHolder.clearContext();
		LOGGER.debug(currentUserName.concat(" has been logout."));		
	}	
	
}
