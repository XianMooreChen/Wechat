package org.moorechen.course.template;

/**
 * 跳小程序所需数据
 * @author chen6
 *
 */
public class Miniprogram {

	//所需跳转到的小程序appid
	private String appid;
	
	//所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar）
	private String pagepath;

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * @return the pagepath
	 */
	public String getPagepath() {
		return pagepath;
	}

	/**
	 * @param pagepath the pagepath to set
	 */
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	
}
