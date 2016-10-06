package hzc.yilan.utils;


/**
 * 用于生产所需要的url字符串
 */
public class UrlFactory {
	/**
	 * 获取科技新闻的url地址
	 * @param page 请求页数 默认为1
	 * @param rows 请求条数 默认为最大值50
	 * @return
	 */
//	public static String getTechNewsListUrl(int page, int rows){
//		String url = "http://api.avatardata.cn/TechNews/Query?key=c417ccb43f9f472aaf68343a32c8ab96&page="+page+"&rows="+rows;
//		return url;
//	}
	public static String getTechNewsResultUrl(){
		String url = "http://api.avatardata.cn/TechNews/Query?key=c417ccb43f9f472aaf68343a32c8ab96&page=1&rows=50";
		return url;
	}
	/**
	 * 获取时事新闻的url地址(国际新闻)
	 * @return
	 */
	public static String getCurrentAffairsResultUrl(){
		String url = "http://api.avatardata.cn/WorldNews/Query?key=3332a89bc0e44e6cb21ea3031f028d62&page=3&rows=50";
		return url;
	}
	/**
	 * 获取国内新闻的url地址:通过关键字搜索相关主题：keyword=财经
	 * @param page 请求页数 默认为1
	 * @param rows 请求条数 默认为最大值50
	 * @return
	 */
	public static String getNationalNewsResultUrl(){
		String url = "http://api.avatardata.cn/WxNews/Query?key=03c6d71c83074d269fe008b599795b47&page=1&rows=50&keyword=%E8%B4%A2%E7%BB%8F";
		return url;
}
	
}
