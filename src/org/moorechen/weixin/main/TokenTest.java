/**
 * 
 */
package org.moorechen.weixin.main;

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

import org.apache.commons.lang.StringUtils;
import org.moorechen.course.menu.Button;
import org.moorechen.course.menu.ClickButton;
import org.moorechen.course.menu.ComplexButton;
import org.moorechen.course.menu.Menu;
import org.moorechen.course.menu.ViewButton;
import org.moorechen.course.util.MyX509TrustManager;

import net.sf.json.JSONObject;

/**
 * 测试获取凭证
 * @author Administrator
 *
 */
public class TokenTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		createButtonToWechat();
	}

	public static void createButtonToWechat(){
		String accessToken = getAccessToken();
		if(StringUtils.isEmpty(accessToken)){
			return;
		}
		try {
			//菜单创建接口地址
			String menuCreateUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=".concat(accessToken);
			//建立连接
			URL url = new URL(menuCreateUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			//使用自定义的信任管理器
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			conn.setSSLSocketFactory(ssf);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//设置请求方式
			conn.setRequestMethod("POST");
			//像输出流写菜单结构
			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(TokenTest.createButton().getBytes("UTF-8"));
			outputStream.close();
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
			conn.disconnect();
			//输出返回结果
			System.out.println(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public static String createButton(){
		ClickButton btn1 = new ClickButton();
		btn1.setName("今日歌曲");
		btn1.setType("click");
		btn1.setKey("V1001_TODAY_MUSIC");
		
		ViewButton btn2 = new ViewButton();
		btn2.setName("歌手简介");
		btn2.setType("view");
		btn2.setUrl("https://www.baidu.com/");
		
		ClickButton btn31 = new ClickButton();
		btn31.setName("hello world");
		btn31.setType("click");
		btn31.setKey("V1001_HELLO_WORLD");
		
		ClickButton btn32 = new ClickButton();
		btn32.setName("赞一下我们");
		btn32.setType("click");
		btn32.setKey("V1001_GOOD");
		
		//复核按钮包含2歌click类型的按钮
		ComplexButton btn3 = new ComplexButton();
		btn3.setName("菜单");
		btn3.setSub_button(new Button[] {btn31, btn32});
		
		//创建菜单对象
		Menu menu = new Menu();
		menu.setButton(new Button[] {btn1, btn2, btn3});
		
		//将菜单对象转换成JSON字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		System.out.println(jsonMenu);
		
		return jsonMenu;
	}
	
	/**
	 * 接口调用请求说明
	 */
	public static String getAccessToken(){
		String accessToken = "";
		try {
			//获取凭证接口地址
			String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx93669af2bdc92b4e&secret=7f2f09a8459f1a6fdc01b0eb0edfc5de";
			//建立连接
			URL url = new URL(tokenUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			//使用自定义的信任管理器
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			conn.setSSLSocketFactory(ssf);
			conn.setDoInput(true);
			//设置请求方式
			conn.setRequestMethod("GET");
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
			conn.disconnect();
			//输出返回结果
			System.out.println(buffer);
			//将返回的JSON字符串转换成JSONObject
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			//接口访问凭证
			accessToken = jsonObject.getString("access_token");
			//凭证有效期
			int expiresIn = jsonObject.getInt("expires_in");
			System.out.println(expiresIn);
			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}
}
