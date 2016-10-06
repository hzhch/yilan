package hzc.yilan.model.impl;

import hzc.yilan.app.MyApplication;
import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.entity.NationalNews;
import hzc.yilan.entity.News;
import hzc.yilan.model.INewsContentModel;
import hzc.yilan.utils.CommonCallback;
import hzc.yilan.utils.LogUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class NewsContentModelImpl implements INewsContentModel {

	private Bitmap bitmap;
	private String content;
	private RequestQueue mQueue;
	
	public NewsContentModelImpl(){
		//创建RequestQueue对象
		mQueue = Volley.newRequestQueue(MyApplication.getApp().getApplicationContext());
	}
	/**
	 * 用volley框架，通过URL获取Bitmap
	 */
	@Override
	public void getPic(News news, final CommonCallback callback) {
		String picUrl = news.getPicUrl();
		ImageRequest req = new ImageRequest(picUrl , new Listener<Bitmap>(){
			@Override
			public void onResponse(Bitmap response) {
				Bitmap pic = response;
				callback.onDataLoaded(pic); 
				LogUtil.i("tag", response);
			}}, 0, 0, Config.RGB_565, new ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
				}
			});
		mQueue.add(req);
		
	}
	/**
	 * 用volley框架，通过URL获取html，并用Jsoup对解析html，提取出文本内容
	 */
	@Override
	public void getContent(News news, final CommonCallback callback) {
		String url = news.getUrl();
		StringRequest req = new StringRequest(url , new Listener<String>() {
			@Override
			public void onResponse(String response) {
				
//				Document doc = Jsoup.connect(url).get();
				String html = response;
				Document doc = Jsoup.parse(html);
//				String text = doc.getElementById("Cnt-Main-Article-QQ").text();;
				String text = doc.select("p").text();
				
				callback.onDataLoaded(text);
				LogUtil.i("tag", text);
		
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		mQueue.add(req);
	}
	/**
	 * 用volley框架，通过URL获取Bitmap
	 */
	@Override
	public void getPic(CurrentAffairs news, final CommonCallback callback) {
		String picUrl = news.getPicUrl();
		ImageRequest req = new ImageRequest(picUrl , new Listener<Bitmap>(){
			@Override
			public void onResponse(Bitmap response) {
				Bitmap pic = response;
				callback.onDataLoaded(pic); 
				LogUtil.i("tag", response);
			}}, 0, 0, Config.RGB_565, new ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
				}
			});
		mQueue.add(req);
	}
	
	/**
	 * 用volley框架，通过URL获取html，并用Jsoup对解析html，提取出文本内容
	 */
	@Override
	public void getContent(CurrentAffairs news, final CommonCallback callback) {
		String url = news.getUrl();
		StringRequest req = new StringRequest(url , new Listener<String>() {
			@Override
			public void onResponse(String response) {
				
//				Document doc = Jsoup.connect(url).get();
				String html = response;
				Document doc = Jsoup.parse(html);
				String text = doc.select("p").text();
				
				callback.onDataLoaded(text);
				LogUtil.i("tag", text);
		
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		mQueue.add(req);
		
	}
	
	@Override
	public void getPic(NationalNews news, final CommonCallback callback) {
		String picUrl = news.getPicUrl();
		ImageRequest req = new ImageRequest(picUrl , new Listener<Bitmap>(){
			@Override
			public void onResponse(Bitmap response) {
				Bitmap pic = response;
				callback.onDataLoaded(pic); 
				LogUtil.i("tag", response);
			}}, 0, 0, Config.RGB_565, new ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
				}
			});
		mQueue.add(req);
		
	}
	@Override
	public void getContent(NationalNews news, final CommonCallback callback) {
		String url = news.getUrl();
		StringRequest req = new StringRequest(url , new Listener<String>() {
			@Override
			public void onResponse(String response) {
				
//				Document doc = Jsoup.connect(url).get();
				String html = response;
				Document doc = Jsoup.parse(html);
				String text = doc.select("p").text();
				
				callback.onDataLoaded(text);
				LogUtil.i("tag", text);
		
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		mQueue.add(req);
		
	}

}
