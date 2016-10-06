package hzc.yilan.app;

import hzc.yilan.entity.NewsContent;
import hzc.yilan.entity.NewsData;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

public class MyApplication extends Application {
	private static MyApplication app;
	// true �������  false�������׶�
	public static boolean isRelease = false;
	public static ArrayList<Activity> activityList = new ArrayList<Activity>();
	
	private static NewsData data;
	private static NewsContent nc;
	
	
	
	public void onCreate() {
		app = this;

//		CrashHandler crashHandler = new CrashHandler(this);
//		// �ص���ͨ����ܵ�����д��ʵ����Ķ���  ���߿�ܵ��ĸ�����
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
		// finish���е� activity
		for (Activity activity : activityList) {
			activity.finish();
		}
		// ��������
		Process.killProcess(Process.myPid());
	}
	
	
}
