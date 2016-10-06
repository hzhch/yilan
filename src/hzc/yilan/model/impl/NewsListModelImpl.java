package hzc.yilan.model.impl;

import hzc.yilan.app.MyApplication;
import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.entity.NationalNews;
import hzc.yilan.entity.News;
import hzc.yilan.model.INewsListModel;
import hzc.yilan.utils.CommonCallback;
import hzc.yilan.utils.HttpUtils;
import hzc.yilan.utils.JSONParse;
import hzc.yilan.utils.UrlFactory;

import java.io.InputStream;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NewsListModelImpl implements INewsListModel {
	private RequestQueue mQueue;
	public NewsListModelImpl(){
		//����RequestQueue����
		mQueue = Volley.newRequestQueue(MyApplication.getApp().getApplicationContext());
	}

	/**
	 * ��ȡ�Ƽ����ţ�ʹ���첽����+�ص���ʽ��
	 */
	public void getTechNewsResult(final CommonCallback callback) {
		AsyncTask<String, String, List<News>> task = new AsyncTask<String, String, List<News>>() {
			protected List<News> doInBackground(String... params) {
				try {
					String url = UrlFactory.getTechNewsResultUrl();
					InputStream is = HttpUtils.getInputStream(url);
					String json = HttpUtils.isToString(is);
					//����json
					JSONObject object = new JSONObject(json);
					JSONArray arr = object.getJSONArray("result");
					List<News> techNews = JSONParse.parseTechNewsResult(arr);
					return techNews;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			protected void onPostExecute(List<News> techNews) {
				callback.onDataLoaded(techNews);
			}
		};
		task.execute();
	}
	
	/**
	 * ��ȡʱ�����ţ�ʹ���첽����+�ص���ʽ��
	 */
	@Override
	public void getCurrentAffairsResult(final CommonCallback callback) {
		AsyncTask<String, String, List<CurrentAffairs>> task = new AsyncTask<String, String, List<CurrentAffairs>>() {
			protected List<CurrentAffairs> doInBackground(String... params) {
				try {
					String url = UrlFactory.getCurrentAffairsResultUrl();
					InputStream is = HttpUtils.getInputStream(url);
					String json = HttpUtils.isToString(is);
					//����json
					JSONObject object = new JSONObject(json);
					JSONArray arr = object.getJSONArray("result");
					List<CurrentAffairs> currentAffairs = JSONParse.parseCurrentAffairsResult(arr);
					return currentAffairs;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			protected void onPostExecute(List<CurrentAffairs> currentAffairs) {
				callback.onDataLoaded(currentAffairs);
			}
		};
		task.execute();

		
	}
	
	/**
	 * ��ȡ�������ţ�ʹ���첽����+�ص���ʽ��
	 */
	
	@Override
	public void getNationalNewsResult(final CommonCallback callback) {
		AsyncTask<String, String, List<NationalNews>> task = new AsyncTask<String, String, List<NationalNews>>() {
			protected List<NationalNews> doInBackground(String... params) {
				try {
					String url = UrlFactory.getNationalNewsResultUrl();
					InputStream is = HttpUtils.getInputStream(url);
					String json = HttpUtils.isToString(is);
					//����json
					JSONObject object = new JSONObject(json);
					JSONArray arr = object.getJSONArray("result");
					List<NationalNews> nationalNews = JSONParse.parseNationalNewsResult(arr);
					return nationalNews;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			protected void onPostExecute(List<NationalNews> nationalNews) {
				callback.onDataLoaded(nationalNews);
			}
		};
		task.execute();

	}



}
