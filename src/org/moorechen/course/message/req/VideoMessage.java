/**
 * 
 */
package org.moorechen.course.message.req;

/**
 * 视频消息
 * @author Administrator
 *
 */
public class VideoMessage extends BaseMessage {

	/**
	 * 视频消息媒体ID
	 */
	private String MediaId;
	
	/**
	 * 视频消息缩略图的媒体ID
	 */
	private String ThumbMediaId;

	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return MediaId;
	}

	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	/**
	 * @return the thumbMediaId
	 */
	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	/**
	 * @param thumbMediaId the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
}
