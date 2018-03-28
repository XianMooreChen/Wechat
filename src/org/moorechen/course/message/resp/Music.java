/**
 * 
 */
package org.moorechen.course.message.resp;

/**
 * 视频model
 * @author Administrator
 *
 */
public class Music {

	/**
	 * 音乐标题
	 */
	private String Title;
	
	/**
	 * 音乐描述
	 */
	private String Description;
	
	/**
	 * 音乐链接
	 */
	private String MusicUrl;
	
	/**
	 * 高质量音乐链接，Wi-Fi环境优先使用该链接播放音乐
	 */
	private String HQMusicUrl;
	
	/**
	 * 缩略图的媒体ID，吐过上传多媒体文件得到的ID
	 */
	private String ThumbMediaId;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the musicUrl
	 */
	public String getMusicUrl() {
		return MusicUrl;
	}

	/**
	 * @param musicUrl the musicUrl to set
	 */
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	/**
	 * @return the hQMusicUrl
	 */
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	/**
	 * @param hQMusicUrl the hQMusicUrl to set
	 */
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
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
