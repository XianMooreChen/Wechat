/**
 * 
 */
package org.moorechen.course.template;

/**
 * 模板数据
 * @author chen6
 *
 */
public class MyTemplateData1 {

	//请假流程模版數據{{first.DATA}}
	private TemplateKeynote first;
	
	private TemplateKeynote employee;
	
	private TemplateKeynote status;
	
	private TemplateKeynote time;
	
	private TemplateKeynote remark;

	/**
	 * @return the first
	 */
	public TemplateKeynote getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(TemplateKeynote first) {
		this.first = first;
	}

	/**
	 * @return the employee
	 */
	public TemplateKeynote getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(TemplateKeynote employee) {
		this.employee = employee;
	}

	/**
	 * @return the status
	 */
	public TemplateKeynote getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TemplateKeynote status) {
		this.status = status;
	}

	/**
	 * @return the time
	 */
	public TemplateKeynote getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(TemplateKeynote time) {
		this.time = time;
	}

	/**
	 * @return the remark
	 */
	public TemplateKeynote getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(TemplateKeynote remark) {
		this.remark = remark;
	}
	
}
