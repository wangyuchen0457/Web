package com.wyc.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/servlet/Login")
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
		String name = request.getParameter("usrname");
		String pwd = request.getParameter("password");
		if("wangyuchen".equals(name) && "123456".equals(pwd)){
			ServletContext context= getServletContext();
			//RequestDispatcher rd = context.getRequestDispatcher("/jsp/welcome.jsp");
			response.sendRedirect("/SelfPage/jsp/welcome.jsp");
			//rd.forward(request, response);
			context.setAttribute("userid", name);
			//request.setAttribute("userid", name);
		}else{
			//RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
			//rd.forward(request, response);
			response.sendRedirect("/SelfPage/jsp/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
