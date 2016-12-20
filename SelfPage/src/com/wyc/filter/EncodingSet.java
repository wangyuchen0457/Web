package com.wyc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodingSet
 */
@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "charset", value = "UTF-8") }, filterName = "f0")
public class EncodingSet implements Filter {
	private String charset;

	public EncodingSet() {

	}

	public void destroy() {
		System.out.println("编码设置过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("编码设置");
		request.setCharacterEncoding(this.charset);
		chain.doFilter(request, response);
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("编码设置过滤器初始化");
		this.charset=fConfig.getInitParameter("charset");
	}

}
