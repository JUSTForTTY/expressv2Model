/**
 * 
 */
package com.hundsun.jresplus.quickstart.common.cookie;

import java.util.HashSet;
import java.util.Set;

import com.hundsun.jresplus.web.nosession.cookie.AttributeCookieStore;
import com.hundsun.jresplus.web.nosession.cookie.Encode;

/**
 * cookie存储类
 * @author zhangsen
 *
 */
public class WebappCookieAttributeStore implements AttributeCookieStore{
	
	private Set<String> keyNames = new HashSet<String>();
	
	private String cookieName;
	
	private String path = "/";
	
	private String domain;
	
	private int maxInactiveInterval = -1;

	private Encode encode;

	@Override
	public int getOrder() {
		return 20;
	}

	@Override
	public Set<String> getAttributeNames() {
		return keyNames;
	}

	@Override
	public String getCookieName() {
		return cookieName;
	}

	@Override
	public String getDomain() {
		return domain;
	}

	@Override
	public Encode getEncode() {
		return encode;
	}

	@Override
	public int getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public boolean isMatch(String key) {
		return keyNames.contains(key);
	}

	public Set<String> getKeyNames() {
		return keyNames;
	}

	public void setKeyNames(Set<String> keyNames) {
		this.keyNames = keyNames;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setMaxInactiveInterval(int maxInactiveInterval) {
		this.maxInactiveInterval = maxInactiveInterval;
	}

	public void setEncode(Encode encode) {
		this.encode = encode;
	}

}
