package hzc.yilan.fragment;

import hzc.yilan.R;
import hzc.yilan.activity.ContentActivity1;
import hzc.yilan.adapter.CurrentAffairsAdapter;
import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.entity.CurrentAffairsData;
import hzc.yilan.presenter.ICurrentAffairsListPresenter;
import hzc.yilan.presenter.impl.CurrentAffairsPresenterImpl;
import hzc.yilan.view.ICurrentAffairsView;

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


public class CurrentAffairsFragment extends Fragment implements ICurrentAffairsView{
	private PullToRefreshListView listView;
	private List<CurrentAffairs> currentAffairs = new ArrayList<CurrentAffairs>();
	private CurrentAffairsAdapter adapter;
	private ICurrentAffairsListPresenter presenter;
	private RequestQueue mQueue;
	private View view;
	private CurrentAffairs news;
	private CurrentAffairsData data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_currentaffairs_list, null);
		presenter = new CurrentAffairsPresenterImpl(this);
		presenter.loadCurrentAffairsList();
		//初始化控件
		listView = (PullToRefreshListView) view.findViewById(R.id.listView1);
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
				data = new CurrentAffairsData();			
				data.setNews(currentAffairs);
				data.setPosition(position);
				Intent intent = new Intent(getActivity(), ContentActivity1.class);
				intent.putExtra("data", data);
				startActivity(intent);
			}
		});
		
		//下拉刷新
		listView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				presenter.loadCurrentAffairsList();
				String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
				// Update the LastUpdatedLabel
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
				
			}
		});
	}

	@Override
	public void setData(List<CurrentAffairs> currentAffairs) {
		this.currentAffairs = currentAffairs;
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
//		View firstTitle = LayoutInflater.from(getActivity()).inflate(R.layout.item_rl_first_CurrentAffairs, null);
//		RelativeLayout rlFirstNews = (RelativeLayout) firstTitle.findViewById(R.id.rlFirstNews);
//		holder.ivFirstImage = (ImageView) rlFirstNews.findViewById(R.id.ivFirstImage);
//		holder.tvFirstTitle = (TextView) rlFirstNews.findViewById(R.id.tvFirstTitle);
//		holder.tvUpdateTime = (TextView) rlFirstNews.findViewById(R.id.tvUpdateTime);
//		
//		//设置头条的数据
//		//ivFirstImage
		mQueue = Volley.newRequestQueue(getActivity());
//		
//		ImageRequest ireq = new ImageRequest(CurrentAffairs.get(0).getPicUrl(), new Listener<Bitmap>(){
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
//		holder.tvFirstTitle.setText(CurrentAffairs.get(0).getTitle());
//		holder.tvUpdateTime.setText(CurrentAffairs.get(0).getCtime());
//		rlFirstNews.setTag(holder);
//		listView.addView(rlFirstNews);
		adapter = new CurrentAffairsAdapter(getActivity(),currentAffairs,mQueue);
		listView.setAdapter(adapter);
		
		
	}
}
