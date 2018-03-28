package org.moorechen.course.util;

import net.sf.json.JSONObject;

import org.moorechen.course.menu.Menu;
import org.moorechen.course.template.BaseTemplate;
import org.moorechen.course.template.MyLeaveTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TemplateUtil {

	private static Logger log = LoggerFactory.getLogger(TemplateUtil.class);
	
	//设置所属行业(POST)
	public final static String template_set_industry_url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";

	//获取设置的行业信息(GET)
	public final static String template_get_industry_url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";

	//获得模板ID(POST)
	public final static String template_add_template_url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
	
	//获取模板列表(GET)
	public final static String template_get_all_template_url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
	
	//删除模板(POST)
	public final static String template_del_template_url = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
	
	//发送模板消息(POST)
	public final static String template_send_template_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

	/**
	 * 查询模板列表
	 * @param accessToken 凭证
	 * @return
	 */
	public static String getTemplate(String accessToken){
		String result  = null;
		String url = template_get_all_template_url.replace("ACCESS_TOKEN", accessToken);
		//发起GET请求获取模板列表
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
		
		if(jsonObject!=null){
			result = jsonObject.toString(); 
		}
		return result;
	}
	
	/**
	 * 发送模版消息
	 * @param template 模版
	 * @param accessToken 凭证
	 * @return 是否成功
	 */
	public static boolean sendLeaveTemplate(BaseTemplate template, String accessToken){
		boolean result  = false;
		String url = template_send_template_url.replace("ACCESS_TOKEN", accessToken);
		//将模版对象转换成JSON字符串
		String jsonTemplate = JSONObject.fromObject(template).toString();
		//发起POST请求创建模版
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonTemplate);
		
		if(jsonObject!=null){
			int errorCode = jsonObject.getInt("errcode");
			String errmsg = jsonObject.getString("errmsg");
			if(errorCode == 0){
				result = true; 
			} else {
				result = false; 
				log.error("发送模版消息失败 errcode:{} errmsg:{}", errorCode, errmsg);
			}
		}
		return result;
	}
	
}
