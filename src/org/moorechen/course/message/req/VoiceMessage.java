package org.moorechen.course.message.req;

/**
 * 语音消息
 * @author Administrator
 *
 */
public class VoiceMessage extends BaseMessage {

	/**
	 * 媒体ID
	 */
	private String MediaId;
	
	/**
	 * 语音格式
	 */
	private String Format;
	
	/**
	 * 语音识别结果
	 */
	private String Recognition;

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
	 * @return the format
	 */
	public String getFormat() {
		return Format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		Format = format;
	}

	/**
	 * @return the recognition
	 */
	public String getRecognition() {
		return Recognition;
	}

	/**
	 * @param recognition the recognition to set
	 */
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
	
}
