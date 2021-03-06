package com.tripoin.core.dto;

import java.util.Date;
import com.tripoin.core.pojo.Profile;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class ProfileData {

	private int id;
	private String email;
	private String name;
	private String sex;
	private String birthplace;
	private Date birthdate;
	private String address;
	private String telp;
	private String phone;
	private String photo;
	private String bio;
	private UserData userData;

	public ProfileData() {}
	
	public ProfileData(Profile profile){
		super();
		this.id = profile.getId();
		this.email = profile.getEmail();
		this.name = profile.getName();
		this.sex = profile.getSex();
		this.birthplace = profile.getBirthplace();
		this.birthdate = profile.getBirthdate();
		this.address = profile.getAddress();
		this.telp = profile.getTelp();
		this.phone = profile.getPhone();
		this.photo = profile.getPhoto();
		this.bio = profile.getBio();
		this.userData = new UserData(profile.getUser());
	}
	
	public ProfileData(int id, String email, String name, String sex,
			String birthplace, Date birthdate, String address, String telp,
			String phone, String photo, String bio, UserData userData) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.birthplace = birthplace;
		this.birthdate = birthdate;
		this.address = address;
		this.telp = telp;
		this.phone = phone;
		this.photo = photo;
		this.bio = bio;
		this.userData = userData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelp() {
		return telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

}
