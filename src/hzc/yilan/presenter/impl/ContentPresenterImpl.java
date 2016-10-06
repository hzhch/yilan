package hzc.yilan.presenter.impl;

import hzc.yilan.entity.News;
import hzc.yilan.entity.NewsContent;
import hzc.yilan.model.INewsContentModel;
import hzc.yilan.model.impl.NewsContentModelImpl;
import hzc.yilan.presenter.IContentPresenter;
import hzc.yilan.utils.CommonCallback;
import hzc.yilan.view.IContentView0;
import android.graphics.Bitmap;

public class ContentPresenterImpl implements IContentPresenter {
	private IContentView0 view;
	private INewsContentModel model;
//	private String content;
//	private Bitmap bitmap;
	
	public ContentPresenterImpl(IContentView0 view) {
		super();
		this.view = view;
		model = new NewsContentModelImpl();
	}


	@Override
	public void loadContent() {
		News news = view.getNews();
		final NewsContent nc = new NewsContent();
		nc.setTitle(news.getTitle());
		nc.setDescription(news.getDescription());
		nc.setCtime(news.getCtime());
		
		model.getPic(news,new CommonCallback() {
			@Override
			public void onDataLoaded(Object data) {
//				ContentPresenterImpl.this.bitmap = (Bitmap)data;
				nc.setPic((Bitmap)data);
				view.updateNewsContent(nc);
			}
		});
		model.getContent(news,new CommonCallback() {
			
			@Override
			public void onDataLoaded(Object data) {
//				ContentPresenterImpl.this.content = (String)data;
				nc.setContent((String)data);
				view.updateNewsContent(nc);
			}
		});
		
		
	}

}
