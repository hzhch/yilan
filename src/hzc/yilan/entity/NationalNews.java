package hzc.yilan.entity;

import java.io.Serializable;

public class NationalNews implements Serializable{
	
	/**
	 * ���ű���
	 */
	private String title;
	/**
	 * �������ڼ�ʱ��  ���磺2015-10-21 11:57
	 */
	private String hottime;
	/**
	 * ����ժҪ   
	 */
	private String description;
	/**
	 * ͼƬ��ַ
	 */
	private String picUrl;
	/**
	 * ���µ�ַ
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
