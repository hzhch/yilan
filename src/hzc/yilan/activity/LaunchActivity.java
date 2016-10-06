package hzc.yilan.activity;

import hzc.yilan.R;
import hzc.yilan.utils.ExceptionHandler;

import org.xutils.view.annotation.ViewInject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LaunchActivity extends BaseActivity {
	
	@ViewInject(R.id.ivRotateAnimation)
	private ImageView ivRotateAnimation;
//	@ViewInject(R.id.relative)
//	private RelativeLayout relative;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		try{
			setContentView(R.layout.activity_main_launch);
//			float x = relative.getWidth()/2;
//			float y = relative.getHeight()/2;
			ivRotateAnimation= (ImageView) findViewById(R.id.ivRotateAnimation);
			//执行旋转动画
//			RotateAnimation anim = new RotateAnimation(0, 360, ivRotateAnimation.getWidth()/2, ivRotateAnimation.getHeight()/2);
			//无限循环
			Animation anim = AnimationUtils.loadAnimation(this, R.anim.launch);
//			anim.setRepeatCount(Animation.INFINITE);
//			anim.setDuration(2000);
//			anim.setInterpolator(new LinearInterpolator());
			ivRotateAnimation.startAnimation(anim);
			
			
			Handler handler = new Handler();
			//sleep 2000,执行run（）
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					try{
						startActivity(new Intent(LaunchActivity.this, ListActivity.class));
						finish();
					}catch(Exception e){
						ExceptionHandler.handleException(e);
					}
				}
			}, 4000);
		}catch(Exception e){
			ExceptionHandler.handleException(e);
		}
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
