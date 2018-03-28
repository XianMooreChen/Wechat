package org.moorechen.course.message.resp;

/**
 * 文本消息
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage {

	/**
	 * 回复的消息内容
	 */
	private String Content;

	/**
	 * @return the content
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		Content = content;
	}
	
}
