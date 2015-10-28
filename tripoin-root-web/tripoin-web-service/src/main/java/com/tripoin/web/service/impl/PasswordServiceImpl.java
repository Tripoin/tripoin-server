package com.tripoin.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import com.tripoin.core.dto.UserData;
import com.tripoin.core.dto.UserTransferObject;
import com.tripoin.web.common.ICommonRest;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.common.WebServiceConstant;
import com.tripoin.web.service.IPasswordService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Service("passwordService")
public class PasswordServiceImpl implements IPasswordService {

	private static transient final Logger LOGGER = LoggerFactory.getLogger(PasswordServiceImpl.class);

	@Autowired
	private ICommonRest commonRest;
	
	@Autowired
	private IStateFullRest stateFullRest;
	
	@Override
	public String updatePassword(UserData userData) {
		stateFullRest.setUsername(userData.getUsername());
		stateFullRest.setPassword(userData.getPassword());
		System.out.println("ANJAR GANTENG ORI = "+userData.getPassword());
		userData.setPassword(new String(Base64.encode(userData.getPassword().getBytes())));
		System.out.println("ANJAR GANTENG ENCODE BASE64 = "+userData.getPassword());
		UserTransferObject userTransferObject = stateFullRest.post(commonRest.getUrl(WebServiceConstant.HTTP_PASSWORD_UPDATE), userData, UserTransferObject.class);
		LOGGER.debug("Response Body User : "+userTransferObject.getUserDatas());
	
		return "Successfully";
	}

}
