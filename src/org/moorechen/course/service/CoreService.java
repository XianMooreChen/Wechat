/**
 * 
 */
package org.moorechen.course.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.moorechen.course.message.resp.TextMessage;
import org.moorechen.course.util.MessageUtil;

/**
 * 核心服务类
 * @author Administrator
 *
 */
public class CoreService {

	public static String processRequest(HttpServletRequest request){
		//XML格式的消息数据
		String respXml = null;
		//默认返回的文本消息内容
		String respContent = "未知的消息类型";
		
		try {
			//调用parseXml方法解析请求消息
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			//发送方账号
			String fromUserName = requestMap.get("FromUserName");
			//开发者微信号
			String toUserName = requestMap.get("ToUserName");
			//消息类型
			String msgType = requestMap.get("MsgType");
			
			//回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			
			//文本消息
			if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
				respContent = "您发送的是文本消息!";
			}
			//图片消息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
				respContent = "您发送的是图片消息!";
			}
			//语音消息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
				respContent = "您发送的是语音消息!";
			}
			//视频消息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)){
				respContent = "您发送的是视频消息!";
			}
			//地理位置消息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
				respContent = "您发送的是地理位置消息!";
			}
			//链接消息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
				respContent = "您发送的是链接消息!";
			}
			//事件推送
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
				//事件类型
				String eventType = requestMap.get("Event");
				//关注
				if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
					respContent = "谢谢您的关注!";
				}
				//取消关注
				else if(eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){
					
				}
				//扫描带参数二维码
				else if(eventType.equals(MessageUtil.EVENT_TYPE_SCAN)){
					
				}
				//上报地理位置
				else if(eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)){
					
				}
				//自定义菜单
				else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){
					String eventKey = requestMap.get("EventKey");
					if(eventKey.equals("V1001_UNBELIEVABLE")){
						respContent = "有啥震惊的!";
					} else if (eventKey.equals("V1001_LI_HIGH")){
						respContent = "你也厉害";
					} else if (eventKey.equals("V1001_WORD_GE")){
						respContent = "WORD哥,点【今天它】提前体验!";
					}
				}
			}
			//设置文本消息的内容
			textMessage.setContent(respContent);
			//将文本消息对象转换成XML
			respXml = MessageUtil.messageToXml(textMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
