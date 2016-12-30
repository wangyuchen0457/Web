package com.wyc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CheckFilter
 */
@WebFilter("/admin/Update.jsp")
public class CheckFilter implements Filter {
    public CheckFilter() {
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*  
		 * 用来判断update选定的checkbox数量，如果不是一个则跳转错误页
		 * 是一个则通过。
		 * */
		System.out.println("check启动！");
		String[] chname = request.getParameterValues("check"); 
		HttpServletResponse  hResponse=(HttpServletResponse) response;
		if (chname==null) {
			//判断checked值
			hResponse.sendRedirect("/SelfPage/admin/CheckFail.jsp");
		}else if (chname.length!=1) {
			hResponse.sendRedirect("/SelfPage/admin/CheckFail.jsp");
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
