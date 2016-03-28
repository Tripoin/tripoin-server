package com.tripoin.util.api.instagram.dto.data;

import com.tripoin.util.api.instagram.dto.data.media.MediaQualityInstagramData;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class ImageInstagramData {

	private MediaQualityInstagramData low_resolution;
	private MediaQualityInstagramData thumbnail;
	private MediaQualityInstagramData standard_resolution;

	public MediaQualityInstagramData getLow_resolution() {
		return low_resolution;
	}

	public void setLow_resolution(MediaQualityInstagramData low_resolution) {
		this.low_resolution = low_resolution;
	}

	public MediaQualityInstagramData getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(MediaQualityInstagramData thumbnail) {
		this.thumbnail = thumbnail;
	}

	public MediaQualityInstagramData getStandard_resolution() {
		return standard_resolution;
	}

	public void setStandard_resolution(MediaQualityInstagramData standard_resolution) {
		this.standard_resolution = standard_resolution;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((low_resolution == null) ? 0 : low_resolution.hashCode());
		result = prime * result + ((standard_resolution == null) ? 0 : standard_resolution.hashCode());
		result = prime * result + ((thumbnail == null) ? 0 : thumbnail.hashCode());
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
		ImageInstagramData other = (ImageInstagramData) obj;
		if (low_resolution == null) {
			if (other.low_resolution != null)
				return false;
		} else if (!low_resolution.equals(other.low_resolution))
			return false;
		if (standard_resolution == null) {
			if (other.standard_resolution != null)
				return false;
		} else if (!standard_resolution.equals(other.standard_resolution))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImageInstagramData [low_resolution=" + low_resolution + ", thumbnail=" + thumbnail
				+ ", standard_resolution=" + standard_resolution + "]";
	}

}
