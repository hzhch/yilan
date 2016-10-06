package hzc.yilan.entity;

import java.io.Serializable;
import java.util.List;

public class NewsData implements Serializable{
	private List<News> news;
	/**
	 * 每条新闻集合的下标值
	 */
	private int position;
	
	public NewsData() {
		super();
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
}
