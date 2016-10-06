package hzc.yilan.activity;

import hzc.yilan.R;
import hzc.yilan.entity.NationalNews;
import hzc.yilan.fragment.ContentFragment2;

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

public class ContentActivity2 extends BaseActivity {
	@ViewInject(R.id.relativeTitleBar)
	private RelativeLayout relaitiveTitleBar;
	@ViewInject(R.id.viewPager)
	private ViewPager viewPagerText;
	private ArrayList<Fragment> fragments;
	private TextPagerAdapter adapter;
	private NationalNews nn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tech_content);
		x.view().inject(this);
		
		Intent intent = getIntent();
		nn = (NationalNews) intent.getSerializableExtra("data");
		
		//…Ë÷√Fragmentµƒ  ≈‰∆˜
		setAdapter();
		
	}
	
	private void setAdapter() {
		fragments = new ArrayList<Fragment>();
		ContentFragment2 ContentFragment2 = new ContentFragment2();
		ContentFragment2.setNationalNews(nn);
		fragments.add(ContentFragment2);
		
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
