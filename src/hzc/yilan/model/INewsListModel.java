package hzc.yilan.model;

import hzc.yilan.utils.CommonCallback;

public interface INewsListModel {
	/**
	 * ��ȡ�Ƽ�����
	 * @param callback
	 */
	public void getTechNewsResult(CommonCallback callback);
	/**
	 * ��ȡʱ������
	 * @param callback
	 */
	public void getCurrentAffairsResult(CommonCallback callback);
	/**
	 * ��ȡ��������
	 * @param callback
	 */
	public void getNationalNewsResult(CommonCallback callback);
	
}
