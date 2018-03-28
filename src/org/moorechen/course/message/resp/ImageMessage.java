/**
 * 
 */
package org.moorechen.course.message.resp;

/**
 * 图片消息
 * @author Administrator
 *
 */
public class ImageMessage extends BaseMessage {

	/**
	 * 图片
	 */
	private Image Image;

	/**
	 * @return the image
	 */
	public Image getImage() {
		return Image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		Image = image;
	}
	
}
