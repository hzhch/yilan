package hzc.yilan.model;

import hzc.yilan.utils.CommonCallback;

public interface INewsListModel {
	/**
	 * 获取科技新闻
	 * @param callback
	 */
	public void getTechNewsResult(CommonCallback callback);
	/**
	 * 获取时事新闻
	 * @param callback
	 */
	public void getCurrentAffairsResult(CommonCallback callback);
	/**
	 * 获取国内新闻
	 * @param callback
	 */
	public void getNationalNewsResult(CommonCallback callback);
	
}
