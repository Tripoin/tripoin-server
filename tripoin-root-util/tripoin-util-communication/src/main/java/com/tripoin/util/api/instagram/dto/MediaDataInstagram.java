package com.tripoin.util.api.instagram.dto;

import java.util.List;

import com.tripoin.util.api.instagram.dto.data.CaptionInstagramData;
import com.tripoin.util.api.instagram.dto.data.CommentInstagramData;
import com.tripoin.util.api.instagram.dto.data.ImageInstagramData;
import com.tripoin.util.api.instagram.dto.data.LikeInstagramData;
import com.tripoin.util.api.instagram.dto.data.LocationInstagramData;
import com.tripoin.util.api.instagram.dto.data.UserInImageInstagramData;
import com.tripoin.util.api.instagram.dto.data.UserInstagramData;
import com.tripoin.util.api.instagram.dto.data.VideoInstagramData;

/**
 * @author <a href="ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class MediaDataInstagram {

	private String id;
	private String attribution;
	private List<String> tags;
	private String type;
	private LocationInstagramData location;
	private CommentInstagramData comments;
	private String filter;
	private String created_time;
	private String link;
	private LikeInstagramData likes;
	private ImageInstagramData images;
	private VideoInstagramData videos;
	private List<UserInImageInstagramData> users_in_photo;
	private CaptionInstagramData caption;
	private boolean user_has_liked;
	private UserInstagramData user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttribution() {
		return attribution;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocationInstagramData getLocation() {
		return location;
	}

	public void setLocation(LocationInstagramData location) {
		this.location = location;
	}

	public CommentInstagramData getComments() {
		return comments;
	}

	public void setComments(CommentInstagramData comments) {
		this.comments = comments;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public LikeInstagramData getLikes() {
		return likes;
	}

	public void setLikes(LikeInstagramData likes) {
		this.likes = likes;
	}

	public ImageInstagramData getImages() {
		return images;
	}

	public void setImages(ImageInstagramData images) {
		this.images = images;
	}

	public VideoInstagramData getVideos() {
		return videos;
	}

	public void setVideos(VideoInstagramData videos) {
		this.videos = videos;
	}

	public List<UserInImageInstagramData> getUsers_in_photo() {
		return users_in_photo;
	}

	public void setUsers_in_photo(List<UserInImageInstagramData> users_in_photo) {
		this.users_in_photo = users_in_photo;
	}

	public CaptionInstagramData getCaption() {
		return caption;
	}

	public void setCaption(CaptionInstagramData caption) {
		this.caption = caption;
	}

	public boolean isUser_has_liked() {
		return user_has_liked;
	}

	public void setUser_has_liked(boolean user_has_liked) {
		this.user_has_liked = user_has_liked;
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
		result = prime * result + ((attribution == null) ? 0 : attribution.hashCode());
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((created_time == null) ? 0 : created_time.hashCode());
		result = prime * result + ((filter == null) ? 0 : filter.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + (user_has_liked ? 1231 : 1237);
		result = prime * result + ((users_in_photo == null) ? 0 : users_in_photo.hashCode());
		result = prime * result + ((videos == null) ? 0 : videos.hashCode());
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
		MediaDataInstagram other = (MediaDataInstagram) obj;
		if (attribution == null) {
			if (other.attribution != null)
				return false;
		} else if (!attribution.equals(other.attribution))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (created_time == null) {
			if (other.created_time != null)
				return false;
		} else if (!created_time.equals(other.created_time))
			return false;
		if (filter == null) {
			if (other.filter != null)
				return false;
		} else if (!filter.equals(other.filter))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (user_has_liked != other.user_has_liked)
			return false;
		if (users_in_photo == null) {
			if (other.users_in_photo != null)
				return false;
		} else if (!users_in_photo.equals(other.users_in_photo))
			return false;
		if (videos == null) {
			if (other.videos != null)
				return false;
		} else if (!videos.equals(other.videos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MediaDataInstagram [id=" + id + ", attribution=" + attribution + ", tags=" + tags + ", type=" + type
				+ ", location=" + location + ", comments=" + comments + ", filter=" + filter + ", created_time="
				+ created_time + ", link=" + link + ", likes=" + likes + ", images=" + images + ", videos=" + videos
				+ ", users_in_photo=" + users_in_photo + ", caption=" + caption + ", user_has_liked=" + user_has_liked
				+ ", user=" + user + "]";
	}

}
