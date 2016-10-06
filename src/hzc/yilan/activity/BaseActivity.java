package hzc.yilan.activity;


import hzc.yilan.app.MyApplication;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		MyApplication myApplication = (MyApplication) getApplication();
		// this:调方这个方法的当前对象
		// 当前对象可以是这个类BaseActivity的对象,也可以是子类MainActivity,MainFragmentActivity的对象

		// this在运行时，指向了不同的子类的对象，叫多态
		// 面向父类编程，面向接口编程
		myApplication.activityList.add(this);
	}

	@Override
	protected void onDestroy() {
		MyApplication myApplication = (MyApplication) getApplication();
		myApplication.activityList.remove(this);
		super.onDestroy();
	}

}
