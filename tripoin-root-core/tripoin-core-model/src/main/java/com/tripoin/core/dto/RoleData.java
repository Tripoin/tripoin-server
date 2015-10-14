package com.tripoin.core.dto;

import java.util.List;
import com.tripoin.core.pojo.Menu;
import com.tripoin.core.pojo.Role;
import com.tripoin.core.pojo.User;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class RoleData {

	private Integer id;
	private String code;
	private List<User> users;
	private Integer status;
	private String remarks;
	private List<Menu> menus;	

	public RoleData() {}

	public RoleData(Role role) {
		if(role != null){
			this.setId(role.getId());
			this.setCode(role.getCode());
//			this.setUsers(role.getUsers());
			this.setStatus(role.getStatus());
			this.setRemarks(role.getRemarks());
//			this.setMenus(role.getMenus());
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

//	public List<User> getUsers() {
//		return users;
//	}

//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

//	public List<Menu> getMenus() {
//		return menus;
//	}
//
//	public void setMenus(List<Menu> menus) {
//		this.menus = menus;
//	}
	@Override
	public String toString() {
		return "RoleData [id=" + id + ", code=" + code + ", status=" + status
				+ ", remarks=" + remarks + "]";
	}

}
