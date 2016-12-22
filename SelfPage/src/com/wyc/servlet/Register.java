package com.wyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns="/servlet/Register",name="register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库启动成功");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		String name = request.getParameter("usrname");
		String pwd = request.getParameter("password");
		Boolean check=false;
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
			if(check==false){
			PreparedStatement Statement = connect.prepareStatement("INSERT INTO user (name,pwd) VALUES(?,?)");
			Statement.setString(1, name);
			Statement.setString(2, pwd);
			Statement.executeUpdate();
			response.sendRedirect("/SelfPage/jsp/registerOK.jsp");
			}else{
				response.sendRedirect("/SelfPage/jsp/uNameexist.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
