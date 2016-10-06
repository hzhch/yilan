package hzc.yilan.utils;

import hzc.yilan.activity.LaunchActivity;
import hzc.yilan.app.MyApplication;

import java.lang.Thread.UncaughtExceptionHandler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

//�����쳣��û��try
//��Ҫ�Ӷϵ�
public class CrashHandler implements UncaughtExceptionHandler {
	private MyApplication myApplication;

	public CrashHandler(MyApplication myApplication) {
		this.myApplication = myApplication;
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.i("CrashHandler", "���쳣��" + ex.getMessage());
		// 1,���쳣��Ϣת���ַ�������������
		ExceptionHandler.handleException(ex);
		// 2,��toast��ʾ�Զ�����
		// ԭ�ȳ��쳣�����߳�Ҫ����
		new Thread() {
			public void run() {
				// toast.show�õ��˶��У�������looper�Ӷ���ȡ��Ϣ��
				// �����߳���û��looper,���߳�����looper

				// �Լ�����looper
				Looper.prepare();
				Toast.makeText(myApplication, "��Ǹ����������", Toast.LENGTH_LONG).show();
				Looper.loop();
			};
		}.start();
		// 3,��һ������

		Intent intent = new Intent(myApplication, LaunchActivity.class);
		// myApplication.startActivity(intent);
		PendingIntent pendingIntent = PendingIntent.getActivity(myApplication,100, intent, Intent.FLAG_ACTIVITY_NEW_TASK);

		// AlarmManager��ʱ��
		AlarmManager alarmManager = (AlarmManager) myApplication.getSystemService(Context.ALARM_SERVICE);
		// RTC:�����˲�ִ������
		alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 2000,pendingIntent);

		try {
			//����sleep��toast������
			Thread.currentThread().sleep(2000);
		} catch (Exception e) {
		}
		myApplication.finish();

	}
}
