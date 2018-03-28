/**
 * 
 */
package org.moorechen.course.message.event;

/**
 * 自定义菜单事件
 * @author Administrator
 *
 */
public class MenuEvent extends BaseEvent {

	/**
	 * 事件KEY值，与自定义菜单接口中的KEY值对应
	 */
	private String EventKey;

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
	
}
