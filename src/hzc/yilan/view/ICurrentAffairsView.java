package hzc.yilan.view;

import hzc.yilan.entity.CurrentAffairs;

import java.util.List;

public interface ICurrentAffairsView {
	/**
	 * ���������б������Դ
	 * @param News
	 */
	public void setData(List<CurrentAffairs> currentAffairs);
	/**
	 * ��ʾ�����б���setData()����֮����ã�
	 */
	public void showList();
}
