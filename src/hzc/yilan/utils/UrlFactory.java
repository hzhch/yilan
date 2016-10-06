package hzc.yilan.utils;


/**
 * ������������Ҫ��url�ַ���
 */
public class UrlFactory {
	/**
	 * ��ȡ�Ƽ����ŵ�url��ַ
	 * @param page ����ҳ�� Ĭ��Ϊ1
	 * @param rows �������� Ĭ��Ϊ���ֵ50
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
	 * ��ȡʱ�����ŵ�url��ַ(��������)
	 * @return
	 */
	public static String getCurrentAffairsResultUrl(){
		String url = "http://api.avatardata.cn/WorldNews/Query?key=3332a89bc0e44e6cb21ea3031f028d62&page=3&rows=50";
		return url;
	}
	/**
	 * ��ȡ�������ŵ�url��ַ:ͨ���ؼ�������������⣺keyword=�ƾ�
	 * @param page ����ҳ�� Ĭ��Ϊ1
	 * @param rows �������� Ĭ��Ϊ���ֵ50
	 * @return
	 */
	public static String getNationalNewsResultUrl(){
		String url = "http://api.avatardata.cn/WxNews/Query?key=03c6d71c83074d269fe008b599795b47&page=1&rows=50&keyword=%E8%B4%A2%E7%BB%8F";
		return url;
}
	
}
