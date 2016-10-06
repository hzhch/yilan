package hzc.yilan.activity;

import hzc.yilan.R;
import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.entity.CurrentAffairsData;
import hzc.yilan.fragment.ContentFragment1;

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

public class ContentActivity1 extends BaseActivity {
	@ViewInject(R.id.relativeTitleBar)
	private RelativeLayout relaitiveTitleBar;
	@ViewInject(R.id.viewPager)
	private ViewPager viewPagerText;
	private ArrayList<Fragment> fragments;
	private TextPagerAdapter adapter;
	private CurrentAffairsData data1;
	private CurrentAffairs ca;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tech_content);
		x.view().inject(this);
		
		Intent intent1 = getIntent();
		data1 = (CurrentAffairsData) intent1.getSerializableExtra("data");
		int fragmentPosition1 = data1.getPosition();
		ca = data1.getNews().get(fragmentPosition1);//等待传递的数据
		
		
//		Fragment fragment = fragments.get(fragmentPosition);//要传递数据的目标Fragment
		
		//设置Fragment的适配器
		setAdapter();
		
	}
	
	private void setAdapter() {
		fragments = new ArrayList<Fragment>();
		ContentFragment1 ContentFragment1 = new ContentFragment1();
		ContentFragment1.setCurrentAffairs(ca);
		fragments.add(ContentFragment1);
		
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
