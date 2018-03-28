package org.moorechen.weixin.main;

import org.moorechen.course.pojo.Token;
import org.moorechen.course.template.MyLeaveTemplate;
import org.moorechen.course.template.MyTemplateData1;
import org.moorechen.course.template.TemplateKeynote;
import org.moorechen.course.util.CommonUtil;
import org.moorechen.course.util.TemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateManager {

	private static Logger log = LoggerFactory.getLogger(TemplateManager.class);
	
	public static void main(String[] args) {
		String appId = "wx93669af2bdc92b4e";
		String appSecret = "7f2f09a8459f1a6fdc01b0eb0edfc5de";
		
		//调用接口获取凭证
		Token token = CommonUtil.getToken(appId, appSecret);
		
		if(token!=null){
			//發送請假模版消息
			boolean result = TemplateUtil.sendLeaveTemplate(getTemplate(), token.getAccessToken());
			
			//發送請假流程结果
			if(result){
				log.info("發送(請假流程)模版消息成功");
			} else {
				log.info("發送(請假流程)模版消息失败");
			}
		}
	}
	
	/**
	 * 請假流程模版消息
	 * @return
	 */
	private static MyLeaveTemplate getTemplate(){
		MyTemplateData1 templateData1 = new MyTemplateData1();
		
		TemplateKeynote first = new TemplateKeynote();
		first.setValue("申請假單");
		first.setColor("#743A3A");
		templateData1.setFirst(first);
		
		TemplateKeynote employee = new TemplateKeynote();
		employee.setValue("劉波");
		employee.setColor("#0000FF");
		templateData1.setEmployee(employee);
		
		TemplateKeynote status = new TemplateKeynote();
		status.setValue("待審核");
		status.setColor("#0000FF");
		templateData1.setStatus(status);
		
		TemplateKeynote time = new TemplateKeynote();
		time.setValue("03/16 09:00 ~ 03/16 12:00");
		time.setColor("#0000FF");
		templateData1.setTime(time);
		
		TemplateKeynote remark = new TemplateKeynote();
		remark.setValue("家裡有事，請批准，謝謝");
		remark.setColor("#008000");
		templateData1.setRemark(remark);
		
		MyLeaveTemplate leaveTemplate = new MyLeaveTemplate();
		leaveTemplate.setTouser("oWu1WxNEJRV1ACdRk0swdGjwzljE");
		leaveTemplate.setTemplate_id("qbS03ImjXfTMMvYagfBXl7GX3hLBeL2pHbYIn4d2gpk");
		leaveTemplate.setUrl("http://192.168.93.67:8087/cafe-example-web/jsp/weui-jsp/weui_approveLeave.jsp");
		leaveTemplate.setData(templateData1);
		
		return leaveTemplate;
	}
}
