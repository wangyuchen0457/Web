package com.wyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class MySQLLogin
 */
@WebServlet(urlPatterns="/servlet/Login",name="Login")
//@WebServlet(urlPatterns = "/servlet/MySQLLogin", name = "SQLLogin")
public class MySQLLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MySQLLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库链接成功");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean check=false;
		String name = request.getParameter("usrname");
		String pwd = request.getParameter("password");
		Connection connect;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_selfpage", "root", "root");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			while (rs.next()) {
				String sqlname=rs.getString("name");
				if(!name.equals(sqlname)){
					continue;
				}else{
					check=true;
					break;
				}
		      }
			if (check) {
				if (rs.getString("pwd").equals(pwd)) {
					HttpSession session= request.getSession();
					session.setAttribute("userid", name);
					response.sendRedirect("/SelfPage/jsp/welcome.jsp");
				}else{
					response.sendRedirect("/SelfPage/jsp/loginWrong.jsp");
				}
			}else{
				response.sendRedirect("/SelfPage/jsp/uNamelost.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
