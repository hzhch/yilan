package hzc.yilan.utils;

import hzc.yilan.app.MyApplication;
import android.util.Log;

public class LogUtil {
	public static void i(String tag,Object msg){
		//����������ϲ�ִ��log.i�������׶�ִ��
		if(MyApplication.isRelease){
			return;
		}else{
			Log.i(tag, String.valueOf(msg));
		}
	}
}
