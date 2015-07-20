package com.tripoin.core.rest.endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.tripoin.core.common.ECommonOperator;
import com.tripoin.core.common.ParameterConstant;
import com.tripoin.core.common.RoleConstant;
import com.tripoin.core.dao.filter.FilterArgument;
import com.tripoin.core.dto.MenuData;
import com.tripoin.core.dto.UserData;
import com.tripoin.core.dto.UserMenuTransferObject;
import com.tripoin.core.pojo.Menu;
import com.tripoin.core.pojo.User;
import com.tripoin.core.service.IGenericManagerJpa;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component("loginMenuEndpoint")
public class LoginMenuEndpoint {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginMenuEndpoint.class);

	@Autowired
	private IGenericManagerJpa iGenericManagerJpa;

	private String currentUserName;
	
	private String currentRole;

	@Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
	public Message<UserMenuTransferObject> getUserMenu(Message<?> inMessage){
		UserMenuTransferObject userMenuTransferObject = new UserMenuTransferObject();
		Map<String, Object> responseHeaderMap = new HashMap<String, Object>();	
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    this.currentUserName = authentication.getName();
		    GrantedAuthority grantedAuthority = authentication.getAuthorities().iterator().next();
		    this.currentRole = grantedAuthority.getAuthority();
		}
		
		try {
			FilterArgument[] filterArguments = new FilterArgument[] { 
					new FilterArgument("username", ECommonOperator.EQUALS) 
			};
			List<User> userList = iGenericManagerJpa.loadObjectsFilterArgument(User.class, filterArguments, new Object[] { this.currentUserName }, null, null);
			if (userList != null) {
				UserData userData = new UserData(userList.get(0));
				List<UserData> userDatas = new ArrayList<UserData>();
				userDatas.add(userData);
				userMenuTransferObject.setUserDatas(userDatas);
			}
			List<Menu> menuList = iGenericManagerJpa.loadObjectsJQLStatement("SELECT mn FROM Menu mn INNER JOIN mn.roles role WHERE role.code = ?", new Object[] { this.currentRole }, null);
			if (menuList != null) {
				List<MenuData> menuDatas = new ArrayList<MenuData>();
				for (Menu menu : menuList) {
					MenuData menuData = new MenuData(menu);
					menuDatas.add(menuData);
				}
				userMenuTransferObject.setMenuDatas(menuDatas);
			}
			userMenuTransferObject.setResponseCode("0");
			userMenuTransferObject.setResponseMsg(ParameterConstant.RESPONSE_SUCCESS);
			userMenuTransferObject.setResponseDesc("Login Menu Success");
		} catch (Exception e) {
			LOGGER.error("Login Menu System Error : "+e.getLocalizedMessage(), e);
			userMenuTransferObject.setResponseCode("1");
			userMenuTransferObject.setResponseMsg(ParameterConstant.RESPONSE_FAILURE);
			userMenuTransferObject.setResponseDesc("Login Menu System Error : " + e.getMessage());
		}
		
		setReturnStatusAndMessage(userMenuTransferObject, responseHeaderMap);
		Message<UserMenuTransferObject> message = new GenericMessage<UserMenuTransferObject>(userMenuTransferObject, responseHeaderMap);
		return message;	
	}
	
	private void setReturnStatusAndMessage(UserMenuTransferObject userMenuTransferObject, Map<String, Object> responseHeaderMap){		
		responseHeaderMap.put("Return-Status", userMenuTransferObject.getResponseCode());
		responseHeaderMap.put("Return-Status-Msg", userMenuTransferObject.getResponseDesc());
	}
	
}
