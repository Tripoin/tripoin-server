package com.tripoin.web.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class BaseAuthentication {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseAuthentication.class);

    private AuthenticationManager authenticationManager;

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public boolean login(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            if (authentication.isAuthenticated())
            	LOGGER.debug("User {} successfully logged in", username);
            return true;
        } catch (BadCredentialsException bce) {
        	LOGGER.warn("Cannot login: {}", bce.getMessage());
        } catch (Exception e) {
        	LOGGER.warn("Authentication failed for user {}", username);
        }
        return false;
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }

}
