package me.joshua.arsenal4j.spring.rest.wordpress;

import java.util.Map;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class User extends BaseObject {

	private static final long serialVersionUID = -8610698048333708274L;

	private Long id;
	private String link;
	private String name;
	private String slug;
	private String description;
	private Map<String, String> avatarUrls;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, String> getAvatarUrls() {
		return avatarUrls;
	}

	public void setAvatarUrls(Map<String, String> avatarUrls) {
		this.avatarUrls = avatarUrls;
	}

}
