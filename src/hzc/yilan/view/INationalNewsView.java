package hzc.yilan.view;

import hzc.yilan.entity.NationalNews;

import java.util.List;

public interface INationalNewsView {
	/**
	 * 设置新闻列表的数据源
	 * @param News
	 */
	public void setData(List<NationalNews> news);
	/**
	 * 显示新闻列表（在setData()方法之后调用）
	 */
	public void showList();
}
