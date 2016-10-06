package hzc.yilan.entity;

import java.io.Serializable;
import java.util.List;

public class CurrentAffairsData implements Serializable{
	private List<CurrentAffairs> news;
	/**
	 * 每条新闻集合的下标值
	 */
	private int position;
	
	public CurrentAffairsData() {
		super();
	}

	public List<CurrentAffairs> getNews() {
		return news;
	}

	public void setNews(List<CurrentAffairs> news) {
		this.news = news;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
}
