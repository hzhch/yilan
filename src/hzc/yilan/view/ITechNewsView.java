package hzc.yilan.view;

import hzc.yilan.entity.News;

import java.util.List;

public interface ITechNewsView {
	/**
	 * ���������б������Դ
	 * @param News
	 */
	public void setData(List<News> news);
	/**
	 * ��ʾ�����б���setData()����֮����ã�
	 */
	public void showList();
}
