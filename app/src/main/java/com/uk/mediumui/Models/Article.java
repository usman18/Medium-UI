package com.uk.mediumui.Models;

import java.io.Serializable;

public class Article implements Serializable {
	
	private String articleImage;
	private String authorProfilePic;
	private String author;
	private String title;
	private String duration;
	private boolean premium;
	private String topic;
	private String timestamp;
	
	
	public Article(String articleImage, String authorProfilePic, String author, String title, String duration, boolean premium) {
		this.articleImage = articleImage;
		this.authorProfilePic = authorProfilePic;
		this.author = author;
		this.title = title;
		this.duration = duration;
		this.premium = premium;
	}
	
	public Article(String articleImage, String authorProfilePic, String author, String title, String duration, boolean premium, String topic, String timestamp) {
		this.articleImage = articleImage;
		this.authorProfilePic = authorProfilePic;
		this.author = author;
		this.title = title;
		this.duration = duration;
		this.premium = premium;
		this.topic = topic;
		this.timestamp = timestamp;
	}
	
	public Article(String articleImage, String authorProfilePic, String author, String title, String duration, boolean premium, String timestamp) {
		this.articleImage = articleImage;
		this.authorProfilePic = authorProfilePic;
		this.author = author;
		this.title = title;
		this.duration = duration;
		this.premium = premium;
		this.timestamp = timestamp;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getArticleImage() {
		return articleImage;
	}
	
	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}
	
	public String getAuthorProfilePic() {
		return authorProfilePic;
	}
	
	public void setAuthorProfilePic(String authorProfilePic) {
		this.authorProfilePic = authorProfilePic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public boolean isPremium() {
		return premium;
	}
	
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
}
