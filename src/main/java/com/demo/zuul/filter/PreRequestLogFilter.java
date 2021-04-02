/* 
 * Created by 2018年8月9日
 */
package com.demo.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author fangang
 */
public class PreRequestLogFilter extends ZuulFilter {
	private static final Log log = LogFactory.getLog(
	            PreRequestLogFilter.class);
	@Override
	public Object run() {
	     RequestContext context = RequestContext.getCurrentContext();
	     HttpServletRequest reqeust = context.getRequest();
	     log.info(
	                String.format("send %srequest to %s",
	                reqeust.getMethod(),
	                reqeust.getRequestURL().toString()));
	     return null;
	}
	@Override
	public boolean shouldFilter() {
		return true; // 判断是否需要过滤
	}
	@Override
	public int filterOrder() {
		return 1; // 过滤器的优先级，越大越靠后执行
	}
	@Override
	public String filterType() {
		return "pre"; // 过滤器类型
	}
}

