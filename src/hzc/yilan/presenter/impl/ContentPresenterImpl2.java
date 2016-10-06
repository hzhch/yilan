package hzc.yilan.presenter.impl;

import hzc.yilan.entity.NationalNews;
import hzc.yilan.entity.NewsContent;
import hzc.yilan.model.INewsContentModel;
import hzc.yilan.model.impl.NewsContentModelImpl;
import hzc.yilan.presenter.IContentPresenter2;
import hzc.yilan.utils.CommonCallback;
import hzc.yilan.view.IContentView2;
import android.graphics.Bitmap;

public class ContentPresenterImpl2 implements IContentPresenter2 {
	private IContentView2 view;
	private INewsContentModel model;
//	private String content;
//	private Bitmap bitmap;
	
	public ContentPresenterImpl2(IContentView2 view) {
		super();
		this.view = view;
		model = new NewsContentModelImpl();
	}


	@Override
	public void loadContent() {
		NationalNews news = view.getNationalNews();
		final NewsContent nc = new NewsContent();
		nc.setTitle(news.getTitle());
		nc.setDescription(news.getDescription());
		
		model.getPic(news,new CommonCallback() {
			@Override
			public void onDataLoaded(Object data) {
				nc.setPic((Bitmap)data);
				view.updateNewsContent(nc);
			}
		});
		model.getContent(news,new CommonCallback() {
			
			@Override
			public void onDataLoaded(Object data) {
				nc.setContent((String)data);
				view.updateNewsContent(nc);
			}
		});
		
		
	}

}
