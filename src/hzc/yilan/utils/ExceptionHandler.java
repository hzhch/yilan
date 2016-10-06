package hzc.yilan.utils;

import hzc.yilan.app.MyApplication;

import java.io.PrintWriter;
import java.io.StringWriter;

import android.util.Log;

public class ExceptionHandler {
	public static void handleException(Throwable e){
		if(MyApplication.isRelease){
			//程序在真机上运行  把异常信息转成字符串
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			//异常信息先打印到printWriter，再打到stringWriter上
			e.printStackTrace(printWriter);
			String errorInfo = stringWriter.toString();
			
			Log.i("errorInfo", errorInfo);
			//再联网发送
		}else{
			//是开发阶段，异常信息显示在logcat
			e.printStackTrace();
		}
	}
}
