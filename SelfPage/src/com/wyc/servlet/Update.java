package com.wyc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/servlet/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String checkname=(String) request.getParameter("checkname");
			System.out.println("checkname:"+checkname);
			String sqluname=request.getParameter("cname");
			Connection connect = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/db_selfpage","root","root");
			System.out.println("数据库连接成功！");
			String sql="update user set name=? where name='"+checkname+"';";
			PreparedStatement prestmt = connect.prepareStatement(sql);
			prestmt.setString(1, sqluname);
			prestmt.executeUpdate();
			prestmt.close();
			connect.close();
			System.out.println("关闭数据库连接");
			response.sendRedirect("/SelfPage/admin/adminPage.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
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
