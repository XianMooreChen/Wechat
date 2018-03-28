package org.moorechen.course.message.req;

/**
 * 图片消息
 * @author Administrator
 *
 */
public class ImageMessage extends BaseMessage {

	/**
	 * 图片链接
	 */
	private String PicUrl;

	/**
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return PicUrl;
	}

	/**
	 * @param picUrl the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	
}
