package hzc.yilan.entity;

import java.io.Serializable;

import android.graphics.Bitmap;

public class NewsContent implements Serializable{
	
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
	private Bitmap pic;
	/**
	 * 文章地址
	 */
	private String content;
	
	public NewsContent() {
		super();
	}

	public NewsContent(String title, String ctime, String description,
			Bitmap pic, String content) {
		super();
		this.title = title;
		this.ctime = ctime;
		this.description = description;
		this.pic = pic;
		this.content = content;
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

	public Bitmap getPic() {
		return pic;
	}

	public void setPic(Bitmap pic) {
		this.pic = pic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
