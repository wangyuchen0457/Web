package com.wyc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class IsLogin
 */
@WebFilter(urlPatterns={"/jsp/welcome.jsp","/game/*","/nineNine/*"})
public class IsLogin implements Filter {

  
    public IsLogin() {
        
    }
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr= (HttpServletRequest) request;
		HttpSession session=hr.getSession();
		System.out.println("是否登陆过滤器执行");
		String uid=(String) session.getAttribute("userid");
		if (uid!=null && !"".equals(uid)) {
			System.out.println("用户已登录");
			chain.doFilter(request, response);
		}else{
			System.out.println("用户未登录");
			request.getRequestDispatcher("/html/noLogin.html").include(request, response);
			HttpServletResponse hResponse=(HttpServletResponse) response;
			System.out.println("跳转登陆界面");
			hResponse.setHeader("refresh", "2;url=/SelfPage/jsp/login.jsp");
			//hResponse.sendRedirect("/SelfPage/jsp/login.jsp");
			//request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("是否登陆过滤器初始化");
	}

}
