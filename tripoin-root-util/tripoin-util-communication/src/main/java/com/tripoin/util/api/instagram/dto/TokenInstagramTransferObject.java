package com.tripoin.util.api.instagram.dto;

import com.tripoin.util.api.instagram.dto.data.UserInstagramData;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TokenInstagramTransferObject extends MetaInstagram {
	
	private String access_token;
	
	private UserInstagramData user;
	
	public TokenInstagramTransferObject(){}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public UserInstagramData getUser() {
		return user;
	}

	public void setUser(UserInstagramData user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenInstagramTransferObject other = (TokenInstagramTransferObject) obj;
		if (access_token == null) {
			if (other.access_token != null)
				return false;
		} else if (!access_token.equals(other.access_token))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TokenInstagramTransferObject [access_token=" + access_token + ", user=" + user + ", rc=" + super.toString() + "]";
	}

}
