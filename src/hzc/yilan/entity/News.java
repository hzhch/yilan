package hzc.yilan.entity;

import java.io.Serializable;

public class News implements Serializable{
	
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 新闻日期及时间  例如：2015-10-21 11:57
	 */
	private String ctime;
	/**
	 * 来源   
	 */
	private String description;
	/**
	 * 图片地址
	 */
	private String picUrl;
	/**
	 * 文章地址
	 */
	private String url;
	
	public News() {
		super();
	}
	
	public News(String title, String ctime, String description,
			String picUrl, String url) {
		super();
		this.title = title;
		this.ctime = ctime;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getCtime() {
		return ctime;
	}




	public void setCtime(String ctime) {
		this.ctime = ctime;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getPicUrl() {
		return picUrl;
	}




	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	@Override
	public String toString() {
		return "TechNews [title=" + title + "\nctime=" + ctime
				+ "\ndescription=" + description + "\npicUrl=" + picUrl
				+ "\nurl=" + url + "]";
	}



	
	
}
