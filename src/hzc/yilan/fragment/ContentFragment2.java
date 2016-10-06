package hzc.yilan.fragment;

import hzc.yilan.R;
import hzc.yilan.entity.NationalNews;
import hzc.yilan.entity.News;
import hzc.yilan.entity.NewsContent;
import hzc.yilan.presenter.impl.ContentPresenterImpl2;
import hzc.yilan.view.IContentView2;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentFragment2 extends Fragment implements IContentView2{
	@ViewInject(R.id.tvTitle)
	private TextView tvTitle;
	@ViewInject(R.id.tvOrigin)
	private TextView tvOrigin;
	@ViewInject(R.id.tvDate)
	private TextView tvDate;
	@ViewInject(R.id.ivPic)
	private ImageView ivPic;
	@ViewInject(R.id.tvText)
	private TextView tvText;
	private ContentPresenterImpl2 presenter;
	private NationalNews nationalNews;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_content, null);
		x.view().inject(this, view);
		presenter = new ContentPresenterImpl2(this);
		presenter.loadContent();
		return view;
	}

	
	/**
	 *当新闻列表中的某一个item被点击后回调 
	 */
	public interface OnFragmentZeroListViewTouched {
		void transmitItemTouched(News news);
	}
		
	
	public void updateNewsContent(NewsContent nc) {
		tvTitle.setText(nc.getTitle());
		tvOrigin.setText(nc.getDescription());
		tvDate.setText(nc.getCtime());
		ivPic.setImageBitmap(nc.getPic());
		tvText.setText(nc.getContent());
	}
	
	public void setNationalNews(NationalNews nn){
	    this.nationalNews=nn;
	}


	@Override
	public NationalNews getNationalNews() {
		return nationalNews;
	}

	
	
}
