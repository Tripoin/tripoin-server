package com.tripoin.util.api.instagram.dto.data;

import com.tripoin.util.api.instagram.dto.data.media.MediaQualityInstagramData;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class VideoInstagramData {

	private MediaQualityInstagramData low_bandwidth;
	private MediaQualityInstagramData standard_resolution;
	private MediaQualityInstagramData low_resolution;

	public MediaQualityInstagramData getLow_bandwidth() {
		return low_bandwidth;
	}

	public void setLow_bandwidth(MediaQualityInstagramData low_bandwidth) {
		this.low_bandwidth = low_bandwidth;
	}

	public MediaQualityInstagramData getStandard_resolution() {
		return standard_resolution;
	}

	public void setStandard_resolution(MediaQualityInstagramData standard_resolution) {
		this.standard_resolution = standard_resolution;
	}

	public MediaQualityInstagramData getLow_resolution() {
		return low_resolution;
	}

	public void setLow_resolution(MediaQualityInstagramData low_resolution) {
		this.low_resolution = low_resolution;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((low_bandwidth == null) ? 0 : low_bandwidth.hashCode());
		result = prime * result + ((low_resolution == null) ? 0 : low_resolution.hashCode());
		result = prime * result + ((standard_resolution == null) ? 0 : standard_resolution.hashCode());
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
		VideoInstagramData other = (VideoInstagramData) obj;
		if (low_bandwidth == null) {
			if (other.low_bandwidth != null)
				return false;
		} else if (!low_bandwidth.equals(other.low_bandwidth))
			return false;
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
		return true;
	}

	@Override
	public String toString() {
		return "VideosInstagramData [low_bandwidth=" + low_bandwidth + ", standard_resolution=" + standard_resolution
				+ ", low_resolution=" + low_resolution + "]";
	}

}
