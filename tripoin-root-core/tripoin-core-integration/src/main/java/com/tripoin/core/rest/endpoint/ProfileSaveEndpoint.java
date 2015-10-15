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
import org.springframework.stereotype.Component;
import com.tripoin.core.common.ParameterConstant;
import com.tripoin.core.common.RoleConstant;
import com.tripoin.core.dto.ProfileData;
import com.tripoin.core.dto.ProfileTransferObject;
import com.tripoin.core.pojo.Profile;
import com.tripoin.core.service.IGenericManagerJpa;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component("profileSaveEndpoint")
public class ProfileSaveEndpoint extends XReturnStatus {

    private static Logger LOGGER = LoggerFactory.getLogger(ProfileSaveEndpoint.class);

	@Autowired
	private IGenericManagerJpa iGenericManagerJpa;

	@Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
	public Message<ProfileTransferObject> saveProduct(Message<ProfileData> inMessage){	
		ProfileTransferObject profileTransferObject = new ProfileTransferObject();
		Map<String, Object> responseHeaderMap = new HashMap<String, Object>();	
		
		try{
            Profile profilePayLoad = new Profile(inMessage.getPayload());
            iGenericManagerJpa.saveObject(profilePayLoad);
			List<Profile> profileList = iGenericManagerJpa.loadObjects(Profile.class);
			List<ProfileData> profileDatas = new ArrayList<ProfileData>();
			if(profileList != null){
				for(Profile profile : profileList){
					ProfileData profileData = new ProfileData(profile);
					profileDatas.add(profileData);
				}
				profileTransferObject.setProfileDatas(profileDatas);
			}
			profileTransferObject.setResponseCode("0");
			profileTransferObject.setResponseMsg(ParameterConstant.RESPONSE_SUCCESS);
			profileTransferObject.setResponseDesc("Save Profile Data Success");			
		}catch (Exception e){
			LOGGER.error("Save Profile System Error : "+e.getLocalizedMessage(), e);
			profileTransferObject.setResponseCode("1");
			profileTransferObject.setResponseMsg(ParameterConstant.RESPONSE_FAILURE);
			profileTransferObject.setResponseDesc("Save Profile System Error : "+e.getLocalizedMessage());
		}
		
		setReturnStatusAndMessage(profileTransferObject, responseHeaderMap);
		Message<ProfileTransferObject> message = new GenericMessage<ProfileTransferObject>(profileTransferObject, responseHeaderMap);
		return message;		
	}
	
}
