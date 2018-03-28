package org.moorechen.course.message.resp;

/**
 * 音乐消息
 * @author Administrator
 *
 */
public class MusicMessage extends BaseMessage {

	/**
	 * 媒体ID
	 */
	private Music Music;

	/**
	 * @return the music
	 */
	public Music getMusic() {
		return Music;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusic(Music music) {
		Music = music;
	}

}
