package com.tripoin.core.rest.endpoint.employee;

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
import com.tripoin.core.dto.EmployeeData;
import com.tripoin.core.dto.EmployeeTransferObject;
import com.tripoin.core.pojo.Employee;
import com.tripoin.core.rest.endpoint.XReturnStatus;
import com.tripoin.core.service.IGenericManagerJpa;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component("employeeSaveEndpoint")
public class EmployeeSaveEndpoint extends XReturnStatus {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeSaveEndpoint.class);

	@Autowired
	private IGenericManagerJpa iGenericManagerJpa;

	@Secured({RoleConstant.ROLE_SUPERADMIN, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_USER})
	public Message<EmployeeTransferObject> saveProduct(Message<EmployeeData> inMessage){	
		EmployeeTransferObject employeeTransferObject = new EmployeeTransferObject();
		Map<String, Object> responseHeaderMap = new HashMap<String, Object>();
		
		try{
			Employee employeePayload = new Employee(inMessage.getPayload());
			iGenericManagerJpa.saveObject(employeePayload);
			List<Employee> employeeList = iGenericManagerJpa.loadObjects(Employee.class);
			List<EmployeeData> employeeDatas = new ArrayList<EmployeeData>();
			if(employeeList != null){
				for(Employee employee : employeeList){
					EmployeeData employeeData = new EmployeeData(employee);
					employeeDatas.add(employeeData);
				}
				employeeTransferObject.setEmployeeDatas(employeeDatas);
			}
			employeeTransferObject.setResponseCode("0");
			employeeTransferObject.setResponseMsg(ParameterConstant.RESPONSE_SUCCESS);
			employeeTransferObject.setResponseDesc("Save Product Data Success");			
		}catch (Exception e){
			LOGGER.error("Save Product System Error : "+e.getLocalizedMessage(), e);
			employeeTransferObject.setResponseCode("1");
			employeeTransferObject.setResponseMsg(ParameterConstant.RESPONSE_FAILURE);
			employeeTransferObject.setResponseDesc("Save Product System Error : "+e.getLocalizedMessage());
		}
		
		setReturnStatusAndMessage(employeeTransferObject, responseHeaderMap);
		Message<EmployeeTransferObject> message = new GenericMessage<EmployeeTransferObject>(employeeTransferObject, responseHeaderMap);
		return message;		
	}
	
}
