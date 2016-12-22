package com.wyc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
//@WebServlet(urlPatterns="/servlet/Login",name="Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> uMap = new HashMap<String, String>();
		ServletContext context= getServletContext();
		String name = request.getParameter("usrname");
		String pwd = request.getParameter("password");
		//String uip=request.getRemoteAddr();
		uMap.put("wangyuchen", "123456");
		uMap.put("chenqingbao", "123456");
		uMap.put("zhangwei", "123456");
		uMap.put("zhangsan", "123456");
		uMap.put("王昱晨", "123456");
		if (uMap.containsKey(name)){
			if(uMap.get(name).equals(pwd)){
				HttpSession session= request.getSession();
				//session.setAttribute("uip", uip);
				session.setAttribute("userid", name);
				response.sendRedirect("/SelfPage/jsp/welcome.jsp");
			}else{
/*				request.getRequestDispatcher("/jsp/loginWrong.jsp").include(request, response);
				//response.setHeader("refresh", "1;url=/SelfPage/jsp/login.jsp");
*/				response.sendRedirect("/SelfPage/jsp/loginWrong.jsp");
			}
		}else{
			//request.getRequestDispatcher("/jsp/uNamelost.jsp").include(request, response);
			response.sendRedirect("/SelfPage/jsp/uNamelost.jsp");

		}
		
		
		/*一个用户名*/
/*		String name = request.getParameter("usrname");
		String pwd = request.getParameter("password");
		if("wangyuchen".equals(name) && "123456".equals(pwd)){
			//ServletContext context= getServletContext();
			//     RequestDispatcher rd = context.getRequestDispatcher("/jsp/welcome.jsp");
			HttpSession session= request.getSession();
			session.setAttribute("userid", name);
			response.sendRedirect("/SelfPage/jsp/welcome.jsp");
			//     rd.forward(request, response);
			//context.setAttribute("userid", name);
			//     request.setAttribute("userid", name);
		}else{
			//RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			//rd.forward(request, response);
			response.sendRedirect("/SelfPage/jsp/login.jsp");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
