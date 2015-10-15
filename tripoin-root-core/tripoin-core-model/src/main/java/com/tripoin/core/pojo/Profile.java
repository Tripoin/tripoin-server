package com.tripoin.core.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tripoin.core.dto.ProfileData;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Entity
@Table(name="sec_profile")
public class Profile implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5575840012553613210L;
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
    private User user;

    public Profile() {}
    
    public Profile(ProfileData profileData) {
    	this.id = profileData.getId();
    	this.email = profileData.getEmail();
    	this.name = profileData.getName();
    	this.sex = profileData.getSex();
    	this.birthplace = profileData.getBirthplace();
    	this.birthdate = profileData.getBirthdate();
    	this.address = profileData.getAddress();
    	this.telp = profileData.getTelp();
    	this.phone = profileData.getPhone();
    	this.photo = profileData.getPhoto();
    	this.bio = profileData.getBio();
    	this.user = new User(profileData.getUserData());
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="profile_id")
    @NotNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	@Column(name="profile_email", length=150)
    @NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 

	@Column(name="profile_name", length=150)
    @NotNull
    @Size(min = 5, message = "Name must have at least five characters")
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="profile_sex", length=10)
    @NotNull
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name="profile_birthplace", length=150)
    @NotNull
	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Column(name="profile_birthdate")
    @NotNull
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name="profile_address")
    @NotNull
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="profile_telp", length=20)
	public String getTelp() {
		return telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

	@Column(name="profile_phone", length=20)
    @NotNull
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="profile_photo")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name="profile_bio")
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", email=" + email + ", name=" + name
				+ ", birthplace=" + birthplace + ", birthdate=" + birthdate
				+ ", address=" + address + ", telp=" + telp + ", phone="
				+ phone + ", photo=" + photo + ", bio=" + bio + ", user=" + user + "]";
	} 
	
}
