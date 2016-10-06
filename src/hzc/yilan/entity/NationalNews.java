package hzc.yilan.entity;

import java.io.Serializable;

public class NationalNews implements Serializable{
	
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 新闻日期及时间  例如：2015-10-21 11:57
	 */
	private String hottime;
	/**
	 * 新闻摘要   
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
	public NationalNews(String title, String hottime, String description,
			String picUrl, String url) {
		super();
		this.title = title;
		this.hottime = hottime;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
	}
	public NationalNews() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHottime() {
		return hottime;
	}
	public void setHottime(String hottime) {
		this.hottime = hottime;
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
	

	
	
}
