package com.tripoin.util.api.instagram.dto;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class MetaInstagram {

	private String code;
	private String error_type;
	private String error_message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError_type() {
		return error_type;
	}

	public void setError_type(String error_type) {
		this.error_type = error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((error_message == null) ? 0 : error_message.hashCode());
		result = prime * result + ((error_type == null) ? 0 : error_type.hashCode());
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
		MetaInstagram other = (MetaInstagram) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (error_message == null) {
			if (other.error_message != null)
				return false;
		} else if (!error_message.equals(other.error_message))
			return false;
		if (error_type == null) {
			if (other.error_type != null)
				return false;
		} else if (!error_type.equals(other.error_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GeneralRCInstagram [code=" + code + ", error_type=" + error_type + ", error_message=" + error_message
				+ "]";
	}
	
}
