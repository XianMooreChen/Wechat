/**
 * 
 */
package org.moorechen.weixin.main;

import org.moorechen.course.menu.Button;
import org.moorechen.course.menu.ClickButton;
import org.moorechen.course.menu.ComplexButton;
import org.moorechen.course.menu.Menu;
import org.moorechen.course.menu.ViewButton;
import org.moorechen.course.pojo.Token;
import org.moorechen.course.util.CommonUtil;
import org.moorechen.course.util.MenuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器类
 * @author Administrator
 *
 */
public class MenuManager {

	private static Logger log = LoggerFactory.getLogger(MenuManager.class);
	
	/**
	 * 定义菜单结构
	 * @return
	 */
	private static Menu getMenu(){
		ClickButton btn1 = new ClickButton();
		btn1.setName("震惊");
		btn1.setType("click");
		btn1.setKey("V1001_UNBELIEVABLE");
		
		ViewButton btn2 = new ViewButton();
		btn2.setName("cafe框架");
		btn2.setType("view");
		btn2.setUrl("http://192.168.93.67:8087/cafe-example-web/");
		
		ClickButton btn31 = new ClickButton();
		btn31.setName("厉害了");
		btn31.setType("click");
		btn31.setKey("V1001_LI_HIGH");
		
		ClickButton btn32 = new ClickButton();
		btn32.setName("word哥");
		btn32.setType("click");
		btn32.setKey("V1001_WORD_GE");
		
		//复核按钮包含2歌click类型的按钮
		ComplexButton btn3 = new ComplexButton();
		btn3.setName("升级了");
		btn3.setSub_button(new Button[] {btn31, btn32});
		
		//创建菜单对象
		Menu menu = new Menu();
		menu.setButton(new Button[] {btn1, btn2, btn3});
		
		return menu;
	}
	
	
	public static void main(String[] args) {
		String appId = "wx93669af2bdc92b4e";
		String appSecret = "7f2f09a8459f1a6fdc01b0eb0edfc5de";
		
		//调用接口获取凭证
		Token token = CommonUtil.getToken(appId, appSecret);
		
		if(token!=null){
			//创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			
			//判断菜单创建结果
			if(result){
				log.info("菜单创建成功");
			} else {
				log.info("菜单创建失败");
			}
		}
	}
}
