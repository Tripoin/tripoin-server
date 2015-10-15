package com.tripoin.core.dto;

import java.util.Date;

import com.tripoin.core.pojo.User;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class UserData {

	private Integer id;
	private String username;
	private String email;
	private String fullname;
	private String password;
	private Integer enabled;
	private Date expiredDate;
	private Integer nonLocked;
	private String auth;
	private Integer status;
	private String remarks;
	private RoleData roleData;
	
	public UserData(){}
	
	public UserData(User user) {
		if(user != null){
			this.setId(user.getId());
			this.setUsername(user.getUsername());
			this.setEmail(user.getEmail());
			this.setFullname(user.getFullname());
			this.setPassword(user.getPassword());
			this.setEnabled(user.getEnabled());
			this.setExpiredDate(user.getExpiredDate());
			this.setNonLocked(user.getNonLocked());
			this.setAuth(user.getAuth());
			this.setStatus(user.getStatus());
			this.setRemarks(user.getRemarks());
			if(user.getRole() != null)
				this.setRoleData(new RoleData(user.getRole()));
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Integer getNonLocked() {
		return nonLocked;
	}

	public void setNonLocked(Integer nonLocked) {
		this.nonLocked = nonLocked;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public RoleData getRoleData() {
		return roleData;
	}

	public void setRoleData(RoleData roleData) {
		this.roleData = roleData;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", username=" + username + ", fullname=" + fullname + ", email=" + email + ", enabled=" + enabled + ", expiredDate="
				+ expiredDate + ", nonLocked=" + nonLocked + ", auth=" + auth
				+ ", status=" + status + ", remarks=" + remarks + ", roleData="
				+ roleData + "]";
	}

}
