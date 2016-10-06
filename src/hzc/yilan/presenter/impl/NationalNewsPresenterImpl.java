package hzc.yilan.presenter.impl;

import hzc.yilan.entity.NationalNews;
import hzc.yilan.model.INewsListModel;
import hzc.yilan.model.impl.NewsListModelImpl;
import hzc.yilan.presenter.INationalNewsListPresenter;
import hzc.yilan.utils.CommonCallback;
import hzc.yilan.view.INationalNewsView;

import java.util.List;

public class NationalNewsPresenterImpl implements INationalNewsListPresenter{
	private INewsListModel model;
	private INationalNewsView view;
	public NationalNewsPresenterImpl(INationalNewsView view){
		this.model = new NewsListModelImpl();
		this.view = view;
	}
	
	public void loadNationalNews() {
		model.getNationalNewsResult(new CommonCallback() {
			
			@Override
			public void onDataLoaded(Object data) {
				List<NationalNews>  news= (List<NationalNews> ) data;
						view.setData(news);
						view.showList();
			}
		});
			
	}
}
