package org.moorechen.course.template;

/**
 * 模版的基类
 * @author Administrator
 *
 */
public class BaseTemplate {

	//接收者openid
	private String touser;
	
	//模板ID
	private String template_id;
	
	//模板跳转链接
	private String url;
	
	//跳小程序所需数据，不需跳小程序可不用传该数据
	private Miniprogram miniprogram;

	/**
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}

	/**
	 * @param touser the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}

	/**
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the miniprogram
	 */
	public Miniprogram getMiniprogram() {
		return miniprogram;
	}

	/**
	 * @param miniprogram the miniprogram to set
	 */
	public void setMiniprogram(Miniprogram miniprogram) {
		this.miniprogram = miniprogram;
	}
	
}
