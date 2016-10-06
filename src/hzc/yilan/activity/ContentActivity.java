package hzc.yilan.activity;

import hzc.yilan.R;
import hzc.yilan.entity.News;
import hzc.yilan.entity.NewsData;
import hzc.yilan.fragment.ContentFragment0;

import java.util.ArrayList;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

public class ContentActivity extends BaseActivity {
	@ViewInject(R.id.relativeTitleBar)
	private RelativeLayout relaitiveTitleBar;
	@ViewInject(R.id.viewPager)
	private ViewPager viewPagerText;
	private ArrayList<Fragment> fragments;
	private TextPagerAdapter adapter;
	private NewsData data;
	private News news;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tech_content);
		x.view().inject(this);
		
		Intent intent = getIntent();
		data = (NewsData) intent.getSerializableExtra("data");
		int fragmentPosition = data.getPosition();
		news = data.getNews().get(fragmentPosition);//等待传递的数据
//		Fragment fragment = fragments.get(fragmentPosition);//要传递数据的目标Fragment
		
		//设置Fragment的适配器
		setAdapter();
		
	}
	
	private void setAdapter() {
		fragments = new ArrayList<Fragment>();
		ContentFragment0 ContentFragment0 = new ContentFragment0();
		ContentFragment0.setNews(news);
		fragments.add(ContentFragment0);//0

		
		adapter = new TextPagerAdapter(getSupportFragmentManager());
		viewPagerText.setAdapter(adapter );
	}
	
	class TextPagerAdapter extends FragmentPagerAdapter{
		public TextPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}
		@Override
		public int getCount() {
			return fragments.size();
		}
		
	}
	
}
