package org.moorechen.course.message.resp;

/**
 * 视频消息
 * @author Administrator
 *
 */
public class VideoMessage extends BaseMessage {

	/**
	 * 媒体ID
	 */
	private Video Video;

	/**
	 * @return the video
	 */
	public Video getVideo() {
		return Video;
	}

	/**
	 * @param video the video to set
	 */
	public void setVideo(Video video) {
		Video = video;
	}

}
