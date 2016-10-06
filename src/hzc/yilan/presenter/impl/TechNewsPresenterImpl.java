package hzc.yilan.presenter.impl;

import hzc.yilan.entity.News;
import hzc.yilan.model.INewsListModel;
import hzc.yilan.model.impl.NewsListModelImpl;
import hzc.yilan.presenter.ITechNewsListPresenter;
import hzc.yilan.utils.CommonCallback;
import hzc.yilan.view.ITechNewsView;

import java.util.List;

public class TechNewsPresenterImpl implements ITechNewsListPresenter{
	private INewsListModel model;
	private ITechNewsView view;
	
	public TechNewsPresenterImpl(ITechNewsView view){
		this.model = new NewsListModelImpl();
		this.view = view;
	}
	
	public void loadTechNewsList() {
		model.getTechNewsResult(new CommonCallback() {
			public void onDataLoaded(Object data) {
				List<News> news=(List<News>) data;
				view.setData(news);
				view.showList();

			}
		});
	}

}
