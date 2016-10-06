package hzc.yilan.utils;

import hzc.yilan.app.MyApplication;

import java.io.PrintWriter;
import java.io.StringWriter;

import android.util.Log;

public class ExceptionHandler {
	public static void handleException(Throwable e){
		if(MyApplication.isRelease){
			//���������������  ���쳣��Ϣת���ַ���
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			//�쳣��Ϣ�ȴ�ӡ��printWriter���ٴ�stringWriter��
			e.printStackTrace(printWriter);
			String errorInfo = stringWriter.toString();
			
			Log.i("errorInfo", errorInfo);
			//����������
		}else{
			//�ǿ����׶Σ��쳣��Ϣ��ʾ��logcat
			e.printStackTrace();
		}
	}
}
