package com.tripoin.util.api.instagram.dto;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class PaginationInstagram {

	private String next_url;
	private String next_min_id;
	private String next_max_id;
	private String next_max_tag_id;
	private String next_min_tag_id;
	private String deprecation_warning;

	public String getNext_url() {
		return next_url;
	}

	public void setNext_url(String next_url) {
		this.next_url = next_url;
	}

	public String getNext_min_id() {
		return next_min_id;
	}

	public void setNext_min_id(String next_min_id) {
		this.next_min_id = next_min_id;
	}

	public String getNext_max_id() {
		return next_max_id;
	}

	public void setNext_max_id(String next_max_id) {
		this.next_max_id = next_max_id;
	}

	public String getNext_max_tag_id() {
		return next_max_tag_id;
	}

	public void setNext_max_tag_id(String next_max_tag_id) {
		this.next_max_tag_id = next_max_tag_id;
	}

	public String getNext_min_tag_id() {
		return next_min_tag_id;
	}

	public void setNext_min_tag_id(String next_min_tag_id) {
		this.next_min_tag_id = next_min_tag_id;
	}

	public String getDeprecation_warning() {
		return deprecation_warning;
	}

	public void setDeprecation_warning(String deprecation_warning) {
		this.deprecation_warning = deprecation_warning;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deprecation_warning == null) ? 0 : deprecation_warning.hashCode());
		result = prime * result + ((next_max_id == null) ? 0 : next_max_id.hashCode());
		result = prime * result + ((next_max_tag_id == null) ? 0 : next_max_tag_id.hashCode());
		result = prime * result + ((next_min_id == null) ? 0 : next_min_id.hashCode());
		result = prime * result + ((next_min_tag_id == null) ? 0 : next_min_tag_id.hashCode());
		result = prime * result + ((next_url == null) ? 0 : next_url.hashCode());
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
		PaginationInstagram other = (PaginationInstagram) obj;
		if (deprecation_warning == null) {
			if (other.deprecation_warning != null)
				return false;
		} else if (!deprecation_warning.equals(other.deprecation_warning))
			return false;
		if (next_max_id == null) {
			if (other.next_max_id != null)
				return false;
		} else if (!next_max_id.equals(other.next_max_id))
			return false;
		if (next_max_tag_id == null) {
			if (other.next_max_tag_id != null)
				return false;
		} else if (!next_max_tag_id.equals(other.next_max_tag_id))
			return false;
		if (next_min_id == null) {
			if (other.next_min_id != null)
				return false;
		} else if (!next_min_id.equals(other.next_min_id))
			return false;
		if (next_min_tag_id == null) {
			if (other.next_min_tag_id != null)
				return false;
		} else if (!next_min_tag_id.equals(other.next_min_tag_id))
			return false;
		if (next_url == null) {
			if (other.next_url != null)
				return false;
		} else if (!next_url.equals(other.next_url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaginationInstagramData [next_url=" + next_url + ", next_min_id=" + next_min_id + ", next_max_id="
				+ next_max_id + ", next_max_tag_id=" + next_max_tag_id + ", next_min_tag_id=" + next_min_tag_id
				+ ", deprecation_warning=" + deprecation_warning + "]";
	}

}
