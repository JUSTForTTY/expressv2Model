package com.hundsun.jresplus.quickstart.pagecache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.web.cache.PageImage;
import com.hundsun.jresplus.web.cache.PageStaticCache;

public class PageCacheWithEhcache implements PageStaticCache, InitializingBean {

	private Cache cache;

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void put(String key, PageImage content) {
		if (StringUtil.isBlank(key)) {
			return;
		}
		Element ele = new Element(key, content);
		if (content != null) {
			ele.setTimeToLive(content.getTimeToLiveSeconds());
			ele.setTimeToIdle(content.getTimeToDleSeconds());
		}
		cache.put(ele);

	}

	public PageImage get(String key) {
		Element ele = cache.get(key);
		if (ele == null || ele.getValue() == null) {
			return null;
		}
		Object obj = ele.getValue();
		if (obj instanceof PageImage) {
			return (PageImage) obj;
		}
		return null;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache, "cache is null.");
	}

 }
