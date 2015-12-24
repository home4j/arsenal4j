package me.joshua.arsenal4j.spring.rest.wordpress;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import me.joshua.arsenal4j.java.commons.BaseObject;

public class Post extends BaseObject {

	private static final long serialVersionUID = -2222955680685279936L;

	private Long id;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date date;

	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date modified;

	private String slug;

	private String type;

	private String link;

	private RenderedText title;

	private RenderedText content;

	private Long author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public RenderedText getTitle() {
		return title;
	}

	public void setTitle(RenderedText title) {
		this.title = title;
	}

	public RenderedText getContent() {
		return content;
	}

	public void setContent(RenderedText content) {
		this.content = content;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

}
