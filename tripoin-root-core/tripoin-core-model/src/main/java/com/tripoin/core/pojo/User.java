package com.tripoin.core.pojo;


import com.tripoin.core.dto.UserData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Entity
@Table(name = "sec_user")
public class User {


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
    private Role role;
    private List<VersionFilter> versionFilter;
    private Profile profile;
	
 
    public User(){}
    
    public User(UserData userData) {
        if (userData.getId() != null) {
            this.id = userData.getId();
            this.username = userData.getUsername();
            this.enabled = userData.getEnabled();
            this.expiredDate = userData.getExpiredDate();
            this.password = userData.getPassword();
            this.role = new Role(userData.getRoleData());
            this.nonLocked = userData.getNonLocked();
            this.auth = userData.getAuth();
            this.status = userData.getStatus();
            this.remarks = userData.getRemarks();
			this.email = userData.getEmail();
        }
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "user_username", length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "user_email", length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
		this.email = email;
	}

    @Column(name = "user_fullname", length = 20)
    public String getFullname() {
        return fullname;
    }
    
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
    

    @Column(name = "user_password", length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_enabled")
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Column(name = "user_expired_date")
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Column(name = "user_non_locked")
    public Integer getNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(Integer nonLocked) {
        this.nonLocked = nonLocked;
    }

    @Column(name = "user_auth", length = 255)
    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Column(name = "user_status")
    public Integer getStatus() {
        return status;
    }   
	
	public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "user_remarks", length = 255)
    public String getRemarks() {
        return remarks;
    }  

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
	
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }       

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    public List<VersionFilter> getVersionFilter() {
        return versionFilter;
    }

    public void setVersionFilter(List<VersionFilter> versionFilter) {
        this.versionFilter = versionFilter;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", fullname=" + fullname + ", password="
                + password + ", enabled=" + enabled + ", expiredDate="
                + expiredDate + ", nonLocked=" + nonLocked + ", auth=" + auth
                + ", status=" + status + ", remarks=" + remarks + ", role="
                + role + "]";
    }

}
