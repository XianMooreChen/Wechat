/**
 * 
 */
package org.moorechen.course.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.moorechen.course.pojo.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 *
 */
public class CommonUtil {

	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);
	
	//凭证获取(GET)
	public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * 发送https请求
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式
	 * @param outputStr 提交的数据
	 * @return JSONObject (通过JSONObject.get(key)的方式获取JSON对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr){
		JSONObject jsonObject = null;
		
		try {
			//使用自定义的信任管理器
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			
			//建立连接
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			//设置请求方式(GET/POST)
			conn.setRequestMethod(requestMethod);
			
			if(!StringUtils.isEmpty(outputStr)){
				//像输出流写菜单结构
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			
			//取得输入流
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			//读取响应内容
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			//关闭/释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			
			jsonObject = JSONObject.fromObject(buffer.toString());
			
		} catch (Exception e) {
			log.error("https请求异常:{}", e);
		}
		return jsonObject;
	}
	
	/**
	 * 获取接口访问凭证
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static Token getToken(String appid, String appsecret){
		Token token = null;
		String requestUrl = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		//发起GET请求获取凭证
		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
		
		if(jsonObject!=null){
			try {
				token = new Token();
				token.setAccessToken(jsonObject.getString("access_token"));
				token.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				token = null;
				log.error("获取token失败errcode:{} errmsg:{}",
						jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return token;
	}
	
	
	
	
	
}
