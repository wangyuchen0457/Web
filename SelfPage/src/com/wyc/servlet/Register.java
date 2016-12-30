package com.wyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns="/servlet/Register",name="register")
public class Register extends MySQLLogin {
/*	private static final long serialVersionUID = 1L;
	public static final String DBDRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/db_selfpage";
	public static final String DBUSER="root";
	public static final String DBPWD="root";*/
	public Register() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName(DBDRIVER);
			System.out.println("数据库链接成功");
		} catch (ClassNotFoundException e1) {
		}
		String name = request.getParameter("usrname");
		String pwd = request.getParameter("password");
		Boolean check=false;
		Connection connect;
		try {
			connect = DriverManager.getConnection(DBURL,DBUSER,DBPWD);
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
			PreparedStatement Statement = connect.prepareStatement("INSERT INTO user (name,pwd) VALUES(?,md5(?))");
			Statement.setString(1, name);
			Statement.setString(2, pwd);
			Statement.executeUpdate();
			response.sendRedirect("/SelfPage/jsp/registerOK.jsp");
			}else{
				response.sendRedirect("/SelfPage/jsp/uNameexist.jsp");
			}
			rs.close();
			stmt.close();
			connect.close();
		} catch (SQLException e) {
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
