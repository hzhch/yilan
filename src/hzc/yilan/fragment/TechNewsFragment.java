package hzc.yilan.fragment;

import hzc.yilan.R;
import hzc.yilan.activity.ContentActivity;
import hzc.yilan.adapter.TechNewsAdapter;
import hzc.yilan.entity.News;
import hzc.yilan.entity.NewsData;
import hzc.yilan.presenter.ITechNewsListPresenter;
import hzc.yilan.presenter.impl.TechNewsPresenterImpl;
import hzc.yilan.view.ITechNewsView;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class TechNewsFragment extends Fragment implements ITechNewsView{
	private PullToRefreshListView listView;
	private List<News> techNews = new ArrayList<News>();
	private TechNewsAdapter adapter;
	private ITechNewsListPresenter presenter;
	private RequestQueue mQueue;
	private View view;
	private News news;
	private NewsData data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_tech_list, null);
		presenter = new TechNewsPresenterImpl(this);
		//初始化控件
		listView = (PullToRefreshListView) view.findViewById(R.id.listView1);
		presenter.loadTechNewsList();
		setListeners();
		
		return view;
	}

	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	private void setListeners() {//点击item：1 获取新闻对象，传给父activity，并同时启动承载内容的activity
		//给ListView添加监听
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
//				news = techNews.get(position);//数据
				data = new NewsData();			
				data.setNews(techNews);
				data.setPosition(position);
				Intent intent = new Intent(getActivity(), ContentActivity.class);
				intent.putExtra("data", data);
				startActivity(intent);
//				presenter.loadTechNewsContent(data);
//				trans.transmitItemTouched(data);
			}
		});
		
		//下拉刷新
		listView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				presenter.loadTechNewsList();
				String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
				// Update the LastUpdatedLabel
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
		
				//refreshView.onRefreshComplete();
				
				
				
		
			}
		});
	}

	@Override
	public void setData(List<News> news) {
		this.techNews = news;
		listView.onRefreshComplete();

	}
	
	@Override
	public void showList() {
		//设置头条的控件
//		class ViewHolder{
//			ImageView ivFirstImage;
//			TextView tvFirstTitle;
//			TextView tvUpdateTime;
//		}
//		final ViewHolder holder = new ViewHolder();
//		View firstTitle = LayoutInflater.from(getActivity()).inflate(R.layout.item_rl_first_technews, null);
//		RelativeLayout rlFirstNews = (RelativeLayout) firstTitle.findViewById(R.id.rlFirstNews);
//		holder.ivFirstImage = (ImageView) rlFirstNews.findViewById(R.id.ivFirstImage);
//		holder.tvFirstTitle = (TextView) rlFirstNews.findViewById(R.id.tvFirstTitle);
//		holder.tvUpdateTime = (TextView) rlFirstNews.findViewById(R.id.tvUpdateTime);
//		
//		//设置头条的数据
//		//ivFirstImage
		mQueue = Volley.newRequestQueue(getActivity());
//		
//		ImageRequest ireq = new ImageRequest(techNews.get(0).getPicUrl(), new Listener<Bitmap>(){
//			public void onResponse(Bitmap response) {
//				//头条图片加载完毕
//				holder.ivFirstImage.setImageBitmap(response);
//			}}, 0, 0, Config.ARGB_8888, new ErrorListener(){
//				public void onErrorResponse(VolleyError error) {
//					error.printStackTrace();
//				}});
//		mQueue.add(ireq);
//
//		//tvFirstTitle  tvUpdateTime
//		holder.tvFirstTitle.setText(techNews.get(0).getTitle());
//		holder.tvUpdateTime.setText(techNews.get(0).getCtime());
//		rlFirstNews.setTag(holder);
//		listView.addView(rlFirstNews);
		adapter = new TechNewsAdapter(getActivity(),techNews,mQueue);
		listView.setAdapter(adapter);
		
		
	}
}
