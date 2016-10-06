package hzc.yilan.utils;

import hzc.yilan.app.MyApplication;
import android.util.Log;

public class LogUtil {
	public static void i(String tag,Object msg){
		//运行在真机上不执行log.i，开发阶段执行
		if(MyApplication.isRelease){
			return;
		}else{
			Log.i(tag, String.valueOf(msg));
		}
	}
}
