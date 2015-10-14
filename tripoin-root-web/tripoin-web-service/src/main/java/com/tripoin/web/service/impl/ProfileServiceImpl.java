package com.tripoin.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripoin.core.dto.ProfileData;
import com.tripoin.core.dto.ProfileTransferObject;
import com.tripoin.core.dto.UserData;
import com.tripoin.core.dto.UserTransferObject;
import com.tripoin.web.common.ICommonRest;
import com.tripoin.web.common.IStateFullRest;
import com.tripoin.web.common.WebServiceConstant;
import com.tripoin.web.service.IProfileService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Service("profileService")
public class ProfileServiceImpl implements IProfileService {

	private static transient final Logger LOGGER = LoggerFactory.getLogger(ProfileServiceImpl.class);

	@Autowired
	private ICommonRest commonRest;
	
	@Autowired
	private IStateFullRest stateFullRest;
	
	@Override
	public ProfileData getProfile() {
		ProfileTransferObject profileTransferObject = stateFullRest.get(commonRest.getUrl(WebServiceConstant.HTTP_PROFILE), ProfileTransferObject.class);
		return profileTransferObject.getProfileDatas().get(0);
	}

	@Override
	public String saveProfile(ProfileData profileData, UserData userData) {
		stateFullRest.setUsername("ridla");
		stateFullRest.setPassword("ridla");
		LOGGER.info("SHOW URL: "+commonRest.getUrl(WebServiceConstant.HTTP_USER_SAVE));
//		ProfileTransferObject profileTransferObject = stateFullRest.post(commonRest.getUrl(WebServiceConstant.HTTP_PROFILE_SAVE), profileData, ProfileTransferObject.class);
		UserTransferObject userTransferObject = stateFullRest.post(commonRest.getUrl(WebServiceConstant.HTTP_USER_UPDATE), userData, UserTransferObject.class);
//		LOGGER.debug("Response Body Profile : "+profileTransferObject.getProfileDatas());
		LOGGER.debug("Response Body User : "+userTransferObject.getUserDatas());
	
		return "Successfully";
	}

	@Override
	public String updateProfile(ProfileData profileData, UserData userData) {
		// TODO Auto-generated method stub
		return null;
	}

}
