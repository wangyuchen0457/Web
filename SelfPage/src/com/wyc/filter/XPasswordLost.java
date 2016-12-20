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
 * Servlet Filter implementation class UserNameLost
 */
@WebFilter(servletNames="Login",filterName="f2")
public class XPasswordLost implements Filter {

    /**
     * Default constructor. 
     */
    public XPasswordLost() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("密码检测过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String pwd = request.getParameter("password");
		if(pwd!=null && !"".equals(pwd) && !"请输入密码".equals(pwd)){
			System.out.println("密码不为空，过滤器通过");
		chain.doFilter(request, response);
		}else{
			HttpServletResponse hs = (HttpServletResponse) response;
			System.out.println("密码为空，转到密码缺失页面");
			hs.sendRedirect("/SelfPage/html/passwordLost.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("密码检测过滤器初始化");
	}

}
