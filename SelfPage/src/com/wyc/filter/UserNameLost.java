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
@WebFilter(servletNames="Login",filterName="f1")
public class UserNameLost implements Filter {

    /**
     * Default constructor. 
     */
    public UserNameLost() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("用户名检测过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name = request.getParameter("usrname");
		if(name!=null && !"".equals(name) && !"请输入用户名".equals(name)){
			System.out.println("用户名不为空，过滤器通过");
		chain.doFilter(request, response);
		}else{
			HttpServletResponse hs = (HttpServletResponse) response;
			System.out.println("用户名为空，转到用户名缺失页面");
			hs.sendRedirect("/SelfPage/html/userNameLost.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("用户名检测过滤器初始化");
	}

}
