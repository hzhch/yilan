package hzc.yilan.activity;

import hzc.yilan.R;
import hzc.yilan.app.MyApplication;
import hzc.yilan.fragment.CurrentAffairsFragment;
import hzc.yilan.fragment.NationalNewsFragment;
import hzc.yilan.fragment.TechNewsFragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/**
 *盛放各个子栏目列表（fragment）
 */
public class ListActivity extends BaseActivity {
	private RelativeLayout relativeTitleBar;//顶部栏
	private ImageView ivTitleBarName;//点点上的文字
	private LinearLayout LLSmallCircle;//圆点点点容器
	private ImageView ivCircleDot0;
	private ImageView ivCircleDot1;
	private ImageView ivCircleDot2;
	private ImageView ivCircleDot3;
	private ImageView ivCircleDot4;
	private ImageView ivCircleDot5;
	private ImageView ivCircleDot6;
	private ImageView ivCircleDot7;
	private ViewPager viewPager;
	private ArrayList<Fragment> fragments;
	private MainPagerAdapter pagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyApplication myApplication = (MyApplication) getApplication();
		myApplication.activityList.add(this);
		//初始化控件
		setViews();
		//设置适配器
		setAdapter();
		//设置监听器
		setListeners();
	}
	
	
	/**
	 * 设置监听器
	 */
	private void setListeners() {
		// viewPager控制点点的颜色变化
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			public void onPageSelected(int index) {
				// 选中viewPager里面的某fragment（0～7）时，圆点颜色由默认白色变换为对应颜色
				switch (index) {
				case 0:
					initColor();
					ivCircleDot0.setImageResource(R.drawable.title_circle_ffffff_bai0);
					ivTitleBarName.setImageResource(R.drawable.yilan);
					break;
				case 1:
					initColor();
					ivCircleDot1.setImageResource(R.drawable.title_circle_ff0000_chi1);
					ivTitleBarName.setImageResource(R.drawable.shishi2);
					break;
				case 2:
					initColor();
					ivCircleDot2.setImageResource(R.drawable.title_circle_ff7f00_cheng2);
					ivTitleBarName.setImageResource(R.drawable.caijing3);
					break;
				case 3:
					initColor();
					ivCircleDot3.setImageResource(R.drawable.title_circle_ffff00_huang3);
					ivTitleBarName.setImageResource(R.drawable.baiye4);
					break;
				case 4:
					initColor();
					ivCircleDot4.setImageResource(R.drawable.title_circle_7fff00_lv4);
					ivTitleBarName.setImageResource(R.drawable.shenghuo5);
					break;
				case 5:
					initColor();
					ivCircleDot5.setImageResource(R.drawable.title_circle_00ffff_qing5);
					ivTitleBarName.setImageResource(R.drawable.baitai6);
					break;
				case 6:
					initColor();
					ivCircleDot6.setImageResource(R.drawable.title_circle_56aaff_lan6);
					ivTitleBarName.setImageResource(R.drawable.sixiang7);
					break;
				case 7:
					initColor();
					ivCircleDot7.setImageResource(R.drawable.title_circle_7f00ff6_zi7);
					ivTitleBarName.setImageResource(R.drawable.dushu8);
					break;
				}
			}
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}
	
	void initColor(){
		ivCircleDot0.setImageResource(R.drawable.title_circle_ffffff_bai0);
		ivCircleDot1.setImageResource(R.drawable.title_circle_ffffff_bai0);
		ivCircleDot2.setImageResource(R.drawable.title_circle_ffffff_bai0);
		ivCircleDot3.setImageResource(R.drawable.title_circle_ffffff_bai0);
		ivCircleDot4.setImageResource(R.drawable.title_circle_ffffff_bai0);
		ivCircleDot5.setImageResource(R.drawable.title_circle_ffffff_bai0);
		ivCircleDot6.setImageResource(R.drawable.title_circle_ffffff_bai0);
		ivCircleDot7.setImageResource(R.drawable.title_circle_ffffff_bai0);
	}
	
	
	/**
	 * 设置适配器
	 */
	private void setAdapter() {
		//准备Fragment数据源   List<Fragment>
		fragments = new ArrayList<Fragment>();
		fragments.add(new TechNewsFragment());
		fragments.add(new CurrentAffairsFragment());
		fragments.add(new NationalNewsFragment());
		pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(pagerAdapter);
		
	}
	/**
	 * viewPager的适配器
	 */
	class MainPagerAdapter extends FragmentPagerAdapter{
		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		public Fragment getItem(int position) {
			return fragments.get(position);
		}
		public int getCount() {
			return fragments.size();
		}
	}
	/**
	 * 控件初始化 
	 */
	private void setViews() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		relativeTitleBar = (RelativeLayout) findViewById(R.id.relativeTitleBar);
		ivTitleBarName = (ImageView) findViewById(R.id.ivTitleBarName);
		LLSmallCircle = (LinearLayout) findViewById(R.id.LLSmallCircle);
		ivCircleDot0 = (ImageView) findViewById(R.id.ivCircleDot0);
		ivCircleDot1 = (ImageView) findViewById(R.id.ivCircleDot1);
		ivCircleDot2 = (ImageView) findViewById(R.id.ivCircleDot2);
		ivCircleDot3 = (ImageView) findViewById(R.id.ivCircleDot3);
		ivCircleDot4 = (ImageView) findViewById(R.id.ivCircleDot4);
		ivCircleDot5 = (ImageView) findViewById(R.id.ivCircleDot5);
		ivCircleDot6 = (ImageView) findViewById(R.id.ivCircleDot6);
		ivCircleDot7 = (ImageView) findViewById(R.id.ivCircleDot7);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
}
