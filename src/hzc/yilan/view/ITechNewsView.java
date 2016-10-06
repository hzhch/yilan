package hzc.yilan.view;

import hzc.yilan.entity.News;

import java.util.List;

public interface ITechNewsView {
	/**
	 * 设置新闻列表的数据源
	 * @param News
	 */
	public void setData(List<News> news);
	/**
	 * 显示新闻列表（在setData()方法之后调用）
	 */
	public void showList();
}
