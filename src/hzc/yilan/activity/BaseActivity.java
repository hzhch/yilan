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
		// this:������������ĵ�ǰ����
		// ��ǰ��������������BaseActivity�Ķ���,Ҳ����������MainActivity,MainFragmentActivity�Ķ���

		// this������ʱ��ָ���˲�ͬ������Ķ��󣬽ж�̬
		// �������̣�����ӿڱ��
		myApplication.activityList.add(this);
	}

	@Override
	protected void onDestroy() {
		MyApplication myApplication = (MyApplication) getApplication();
		myApplication.activityList.remove(this);
		super.onDestroy();
	}

}
