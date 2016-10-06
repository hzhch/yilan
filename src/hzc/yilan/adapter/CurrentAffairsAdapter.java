package hzc.yilan.adapter;

import hzc.yilan.R;
import hzc.yilan.entity.CurrentAffairs;
import hzc.yilan.utils.LogUtil;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;

public class CurrentAffairsAdapter extends BaseAdapter {
	private Context context;
	private List<CurrentAffairs> currentAffairs;
	private LayoutInflater inflater;
	private ImageLoader imageLoader;
	private Map<String, SoftReference<Bitmap>> cache = new HashMap<String, SoftReference<Bitmap>>();
	
	public CurrentAffairsAdapter(Context context,List<CurrentAffairs> currentAffairs,RequestQueue mQueue){
		this.context = context;
		this.currentAffairs = currentAffairs;
		inflater = inflater.from(context);
		
		imageLoader = new ImageLoader(mQueue, new ImageCache() {
			public void putBitmap(String url, Bitmap bitmap) {
				// 向内存缓存中存入
				cache.put(url, new SoftReference<Bitmap>(bitmap));
			}
			public Bitmap getBitmap(String url) {
				// 从内存缓存中取
				SoftReference<Bitmap> ref = cache.get(url);
				if(ref!=null){
					return ref.get();
				}
				return null;
			}
		});
	}
	
	public int getCount() {
//		return currentAffairs.size()-1;
		return currentAffairs.size();
	}
	
	public CurrentAffairs getItem(int position) {
		return currentAffairs.get(position+1);
	}
	
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public int getItemViewType(int position) {
		int a=(position)%4;
		if(a==0){
			return 0;			
		}
			return 1;
	}
	
	@Override
	public int getViewTypeCount() {
		return 2;
	}
	
	public View getView( int position, View convertView, ViewGroup parent) {
		ViewHolder1 holder1=new ViewHolder1();		
		ViewHolder2 holder2=new ViewHolder2();
		int type=getItemViewType(position);

		if(convertView == null){
			if(type==0){
				convertView = inflater.inflate(R.layout.item_lv_bigpic_currentaffairs, null);
				holder1.ivImage1 = (ImageView) convertView.findViewById(R.id.imageView1);
				holder1.tvTitle1 = (TextView) convertView.findViewById(R.id.textView1);
				holder1.tvTime1 = (TextView) convertView.findViewById(R.id.tvNewsUpdateTime1);
				convertView.setTag(holder1);
				Log.d("hzc", "holder1-->"+position);
			}
			if(type==1) {
				convertView = inflater.inflate(R.layout.item_lv_smallpic_currentaffairs, null);
				holder2.ivImage2 = (ImageView) convertView.findViewById(R.id.ivNewsPic2);
				holder2.tvTitle2 = (TextView) convertView.findViewById(R.id.tvNewsTitle2);
				holder2.tvTime2 = (TextView) convertView.findViewById(R.id.tvNewsUpdateTime2);
				convertView.setTag(holder2);
				Log.d("hzc", "holder2-->"+position);
			}
		}
		CurrentAffairs ca = getItem(position);
		LogUtil.i("tedu",  ca.getTitle());
		if(type==0){
			holder1=(ViewHolder1)convertView.getTag();
		}
		if(type==1){
			holder2=(ViewHolder2)convertView.getTag();
		}

		
		if(type==0){
			holder1.tvTitle1.setText(ca.getTitle());
			holder1.tvTime1.setText(ca.getCtime());
			ImageListener listener1 = ImageLoader.getImageListener(holder1.ivImage1, 0, 0);
			imageLoader.get(ca.getPicUrl(), listener1);
		}
		if(type==1){
			holder2.tvTitle2.setText(ca.getTitle());
			holder2.tvTime2.setText(ca.getCtime());	
			ImageListener listener2 = ImageLoader.getImageListener(holder2.ivImage2, 0, 0);
			imageLoader.get(ca.getPicUrl(), listener2);
		}

		return convertView;
	}
	
	
	class ViewHolder1{
		ImageView ivImage1;
		TextView tvTitle1;
		TextView tvTime1;
	}
	class ViewHolder2{
		ImageView ivImage2;
		TextView tvTitle2;
		TextView tvTime2;
	}
	
}
