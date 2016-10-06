package hzc.yilan.model;

import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.entity.NationalNews;
import hzc.yilan.entity.News;
import hzc.yilan.utils.CommonCallback;

public interface INewsContentModel {

	public void getPic(News news,CommonCallback callback);
	public void getContent(News news,CommonCallback callback);
	
	public void getPic(CurrentAffairs news,CommonCallback callback);
	public void getContent(CurrentAffairs news,CommonCallback callback);
	
	public void getPic(NationalNews news,CommonCallback callback);
	public void getContent(NationalNews news,CommonCallback callback);
	
}
