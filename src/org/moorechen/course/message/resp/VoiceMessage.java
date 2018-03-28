package org.moorechen.course.message.resp;

/**
 * 语音消息
 * @author Administrator
 *
 */
public class VoiceMessage extends BaseMessage {

	/**
	 * 媒体ID
	 */
	private Voice Voice;

	/**
	 * @return the voice
	 */
	public Voice getVoice() {
		return Voice;
	}

	/**
	 * @param voice the voice to set
	 */
	public void setVoice(Voice voice) {
		Voice = voice;
	}
	
}
