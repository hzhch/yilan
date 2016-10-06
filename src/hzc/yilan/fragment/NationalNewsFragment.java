package hzc.yilan.fragment;

import hzc.yilan.R;
import hzc.yilan.activity.ContentActivity2;
import hzc.yilan.adapter.NationalNewsAdapter;
import hzc.yilan.entity.NationalNews;
import hzc.yilan.presenter.INationalNewsListPresenter;
import hzc.yilan.presenter.impl.NationalNewsPresenterImpl;
import hzc.yilan.view.INationalNewsView;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NationalNewsFragment extends Fragment implements INationalNewsView{
	//private PullToRefreshListView listView;
    private ListView listView;
	private List<NationalNews> nationalNews = new ArrayList<NationalNews>();
	private NationalNewsAdapter adapter;
	private INationalNewsListPresenter presenter;
	private RequestQueue mQueue;
	private View view;
	private NationalNews news;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_national_list, null);
		presenter = new NationalNewsPresenterImpl(this);
		presenter.loadNationalNews();
		//初始化控件
		listView = (ListView) view.findViewById(R.id.listView1);
		setListeners();
		
		return view;
	}

	

	private void setListeners() {//点击item：1 获取新闻对象，传给父activity，并同时启动承载内容的activity
		//给ListView添加监听
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				NationalNews data = nationalNews.get(position);
				Intent intent = new Intent(getActivity(), ContentActivity2.class);
				intent.putExtra("data", data);
				startActivity(intent);
//				presenter.loadNationalNewsContent(data);
//				trans.transmitItemTouched(data);
			}
		});
		
		//下拉刷新
//		listView.setOnRefreshListener(new OnRefreshListener<ListView>() {
//
//			@Override
//			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
//				presenter.loadNationalNews();
//				String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
//						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
//				// Update the LastUpdatedLabel
//				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
//				
//			}
//		});
	}

	@Override
	public void setData(List<NationalNews> news) {
		this.nationalNews = news;

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
//		View firstTitle = LayoutInflater.from(getActivity()).inflate(R.layout.item_rl_first_nationalnews, null);
//		RelativeLayout rlFirstNews = (RelativeLayout) firstTitle.findViewById(R.id.rlFirstNews);
//		holder.ivFirstImage = (ImageView) rlFirstNews.findViewById(R.id.ivFirstImage);
//		holder.tvFirstTitle = (TextView) rlFirstNews.findViewById(R.id.tvFirstTitle);
//		holder.tvUpdateTime = (TextView) rlFirstNews.findViewById(R.id.tvUpdateTime);
//		
//		//设置头条的数据
//		//ivFirstImage
		mQueue = Volley.newRequestQueue(getActivity());
//		
//		ImageRequest ireq = new ImageRequest(nationalNews.get(0).getPicUrl(), new Listener<Bitmap>(){
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
//		holder.tvFirstTitle.setText(nationalNews.get(0).getTitle());
//		holder.tvUpdateTime.setText(nationalNews.get(0).getHottime());
//		rlFirstNews.setTag(holder);
//		listView.addHeaderView(rlFirstNews);
		adapter = new NationalNewsAdapter(getActivity(),nationalNews,mQueue);
		listView.setAdapter(adapter);
		
		
	}
}
