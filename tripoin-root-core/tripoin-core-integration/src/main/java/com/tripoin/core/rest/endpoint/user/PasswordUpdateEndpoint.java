package com.tripoin.core.rest.endpoint.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.jasypt.digest.StandardStringDigester;
//import org.springframework.security.crypto.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.tripoin.core.common.ParameterConstant;
import com.tripoin.core.common.RoleConstant;
import com.tripoin.core.dto.UserData;
import com.tripoin.core.dto.UserTransferObject;
import com.tripoin.core.pojo.User;
import com.tripoin.core.rest.endpoint.XReturnStatus;
import com.tripoin.core.service.IGenericManagerJpa;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component("passwordUpdateEndpoint")
public class PasswordUpdateEndpoint extends XReturnStatus {

    private static Logger LOGGER = LoggerFactory.getLogger(PasswordUpdateEndpoint.class);
	
//	@Autowired
//	private StandardStringDigester jasyptStringDigester;

    @Autowired
    private IGenericManagerJpa iGenericManagerJpa;

    @Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
    public Message<UserTransferObject> saveProduct(Message<UserData> inMessage) {
        UserTransferObject userTransferObject = new UserTransferObject();
        Map<String, Object> responseHeaderMap = new HashMap<String, Object>();

        try {
            User userPayload = new User(inMessage.getPayload());
//            String passToBase64 = new String(Base64.decode(userPayload.getPassword().getBytes()));
//            String passToJasypt = jasyptStringDigester.digest(passToBase64);
//            userPayload.setPassword(passToJasypt);
            iGenericManagerJpa.updateObject(userPayload);
            List<User> userList = iGenericManagerJpa.loadObjects(User.class);
            List<UserData> userDatas = new ArrayList<UserData>();
            if (userList != null) {
                for (User user : userList) {
                    UserData userData = new UserData(user);
                    userDatas.add(userData);
                }
                userTransferObject.setUserDatas(userDatas);
            }
            userTransferObject.setResponseCode("0");
            userTransferObject.setResponseMsg(ParameterConstant.RESPONSE_SUCCESS);
            userTransferObject.setResponseDesc("Update User Data Success");
        } catch (Exception e) {
            LOGGER.error("Save Product System Error : " + e.getLocalizedMessage(), e);
            userTransferObject.setResponseCode("1");
            userTransferObject.setResponseMsg(ParameterConstant.RESPONSE_FAILURE);
            userTransferObject.setResponseDesc("Update User System Error : " + e.getLocalizedMessage());
        }

        setReturnStatusAndMessage(userTransferObject, responseHeaderMap);
        Message<UserTransferObject> message = new GenericMessage<UserTransferObject>(userTransferObject, responseHeaderMap);
        return message;
    }

}
