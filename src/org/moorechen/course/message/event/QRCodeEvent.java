/**
 * 
 */
package org.moorechen.course.message.event;

/**
 * 扫描带参数二维码事件
 * @author Administrator
 *
 */
public class QRCodeEvent extends BaseEvent {

	/**
	 * 事件KEY值
	 */
	private String EventKey;
	
	/**
	 * 用于换取二维码图片
	 */
	private String Ticket;

	/**
	 * @return the eventKey
	 */
	public String getEventKey() {
		return EventKey;
	}

	/**
	 * @param eventKey the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return Ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
}
