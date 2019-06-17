package com.uk.mediumui.Models;

public class Article {
	
	private String articleImage;
	private String authorProfilePic;
	private String author;
	private String title;
	private String duration;
	private boolean premium;
	
	
	public Article(String articleImage, String authorProfilePic, String author, String title, String duration, boolean premium) {
		this.articleImage = articleImage;
		this.authorProfilePic = authorProfilePic;
		this.author = author;
		this.title = title;
		this.duration = duration;
		this.premium = premium;
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
	
	public boolean isPremium() {
		return premium;
	}
	
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
}
