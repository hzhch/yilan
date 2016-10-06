package hzc.yilan.entity;

import java.io.Serializable;

import android.graphics.Bitmap;

public class NewsContent implements Serializable{
	
	/**
	 * ���ű���
	 */
	private String title;
	/**
	 * �������ڼ�ʱ��  ���磺2015-10-21 11:57
	 */
	private String ctime;
	/**
	 * ��Դ   
	 */
	private String description;
	/**
	 * ͼƬ��ַ
	 */
	private Bitmap pic;
	/**
	 * ���µ�ַ
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
