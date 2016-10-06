package hzc.yilan.app;

import hzc.yilan.entity.NewsContent;
import hzc.yilan.entity.NewsData;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

public class MyApplication extends Application {
	private static MyApplication app;
	// true 软件发布  false：开发阶段
	public static boolean isRelease = false;
	public static ArrayList<Activity> activityList = new ArrayList<Activity>();
	
	private static NewsData data;
	private static NewsContent nc;
	
	
	
	public void onCreate() {
		app = this;

//		CrashHandler crashHandler = new CrashHandler(this);
//		// 回调：通过框架调我们写的实现类的对象  告诉框架调哪个对象
//		Thread.currentThread().setDefaultUncaughtExceptionHandler(crashHandler);
		
		data = new NewsData();
		nc = new NewsContent();
	};

	public static MyApplication getApp() {
		return app;
	}
	
	public void saveNewsData(NewsData data){
		this.data = data;
	}
	
	public NewsData getNewsData(){
		return data;
	}
	
	public void saveNewsContent(NewsContent nc){
		this.nc = nc;
	}
	public NewsContent getNewsContent(){
		return nc;
	}
	
	
	public void finish() {
		// finish所有的 activity
		for (Activity activity : activityList) {
			activity.finish();
		}
		// 结束进程
		Process.killProcess(Process.myPid());
	}
	
	
}
