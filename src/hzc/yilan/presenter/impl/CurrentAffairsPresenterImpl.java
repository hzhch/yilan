package hzc.yilan.presenter.impl;

import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.model.INewsListModel;
import hzc.yilan.model.impl.NewsListModelImpl;
import hzc.yilan.presenter.ICurrentAffairsListPresenter;
import hzc.yilan.utils.CommonCallback;
import hzc.yilan.view.ICurrentAffairsView;

import java.util.List;

public class CurrentAffairsPresenterImpl implements ICurrentAffairsListPresenter{
	private INewsListModel model;
	private ICurrentAffairsView view;
	
	public CurrentAffairsPresenterImpl(ICurrentAffairsView view){
		this.model = new NewsListModelImpl();
		this.view = view;
	}
	
	public void loadCurrentAffairsList() {
		model.getCurrentAffairsResult(new CommonCallback() {
			public void onDataLoaded(Object data) {
				List<CurrentAffairs> currentAffairs=(List<CurrentAffairs>) data;
				view.setData(currentAffairs);
				view.showList();
			}
		});
	}

}
