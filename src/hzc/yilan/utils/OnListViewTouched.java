package hzc.yilan.utils;

import hzc.yilan.entity.NewsData;

/**
 *当新闻列表中的某一个item被点击后回调 
 */
public interface OnListViewTouched {
	void onItemSelected(NewsData data);
}
