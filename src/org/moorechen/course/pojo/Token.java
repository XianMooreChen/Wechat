/**
 * 
 */
package org.moorechen.course.pojo;

/**
 * 凭证
 * @author Administrator
 *
 */
public class Token {

	/**
	 * 接口访问凭证
	 */
	private String accessToken;
	
	/**
	 * 凭证有效期,单位:秒
	 */
	private int expiresIn;

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the expiresIn
	 */
	public int getExpiresIn() {
		return expiresIn;
	}

	/**
	 * @param expiresIn the expiresIn to set
	 */
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}
