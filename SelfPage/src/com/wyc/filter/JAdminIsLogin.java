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
 * Servlet Filter implementation class AdminIsLogin
 */
@WebFilter("/admin/*")
public class JAdminIsLogin implements Filter {
    public JAdminIsLogin() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr= (HttpServletRequest) request;
		HttpSession session=hr.getSession();
		String adminid=(String) session.getAttribute("aPwd");
		if (adminid!=null && !"".equals(adminid)) {
			System.out.println("用户已登录");
			chain.doFilter(request, response);
		}else{
			System.out.println("用户未登录");
			request.getRequestDispatcher("/admin/adminWrong.jsp").include(request, response);
			HttpServletResponse hResponse=(HttpServletResponse) response;
			System.out.println("跳转登陆界面");
			hResponse.setHeader("refresh", "2;url=/SelfPage/jsp/AdminLogin.jsp");
			}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
