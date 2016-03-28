package com.tripoin.util.api.instagram.dto.data;

import com.tripoin.util.api.instagram.dto.data.media.MediaPositionInstagramData;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class UserInImageInstagramData {

	private MediaPositionInstagramData position;
	private UserInstagramData user;

	public MediaPositionInstagramData getPosition() {
		return position;
	}

	public void setPosition(MediaPositionInstagramData position) {
		this.position = position;
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
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInImageInstagramData other = (UserInImageInstagramData) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
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
		return "UserInImageInstagramData [position=" + position + ", user=" + user + "]";
	}

}
