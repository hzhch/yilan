package hzc.yilan.view;

import hzc.yilan.entity.NationalNews;

import java.util.List;

public interface INationalNewsView {
	/**
	 * ���������б������Դ
	 * @param News
	 */
	public void setData(List<NationalNews> news);
	/**
	 * ��ʾ�����б���setData()����֮����ã�
	 */
	public void showList();
}
