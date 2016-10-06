package hzc.yilan.utils;

import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.entity.NationalNews;
import hzc.yilan.entity.News;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParse {
	/**
	 * 通过JSONArray解析result集合
	 * @param arr [{},{},{},{},{},{}]
	 * @return
	 * @throws JSONException 
	 */
	public static List<News> parseTechNewsResult(JSONArray arr) throws JSONException {
		List<News> news= new ArrayList<News>();
 		for(int i=0; i<arr.length(); i++){
 			JSONObject o = arr.getJSONObject(i);
 			News n = new News();
 			n.setCtime(o.getString("ctime"));
 			n.setDescription(o.getString("description"));
 			n.setPicUrl(o.getString("picUrl"));
 			n.setTitle(o.getString("title"));
 			n.setUrl(o.getString("url"));
 			news.add(n);
		}
		return news;
	}

	public static List<CurrentAffairs> parseCurrentAffairsResult(JSONArray arr) throws JSONException {
		List<CurrentAffairs> currentAffairs= new ArrayList<CurrentAffairs>();
 		for(int i=0; i<arr.length(); i++){
 			JSONObject o = arr.getJSONObject(i);
 			CurrentAffairs c = new CurrentAffairs();
 			c.setCtime(o.getString("ctime"));
 			c.setDescription(o.getString("description"));
 			c.setPicUrl(o.getString("picUrl"));
 			c.setTitle(o.getString("title"));
 			c.setUrl(o.getString("url"));
 			currentAffairs.add(c);
		}
		return currentAffairs;
	}

	public static List<NationalNews> parseNationalNewsResult(JSONArray arr) throws JSONException {
		List<NationalNews> nn= new ArrayList<NationalNews>();
 		for(int i=0; i<arr.length(); i++){
 			JSONObject o = arr.getJSONObject(i);
 			NationalNews n = new NationalNews();
 			n.setHottime(o.getString("hottime"));
 			n.setDescription(o.getString("description"));
 			n.setPicUrl(o.getString("picUrl"));
 			n.setTitle(o.getString("title"));
 			n.setUrl(o.getString("url"));
 			nn.add(n);
		}
		return nn;
	}
}
