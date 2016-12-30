package com.wyc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/servlet/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] checkname = request.getParameterValues("check");// 获取选定的checkbox数组
		if (checkname != null) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_selfpage", "root", "root");
			System.out.println("数据库连接成功！");
			PreparedStatement prestmt=null;
				for (int i = checkname.length - 1; i >= 0; i--) {// 循环删除
					// 要先删除索引最大的值，否则批量删除list最后长度减少，索引不对应
					String sqlname = checkname[i];
					String sql = "delete from user where name='" + sqlname + "';";
					prestmt = connect.prepareStatement(sql);
					prestmt.executeUpdate();
				}
			System.out.println("关闭数据库连接");
			prestmt.close();
			connect.close();
			response.sendRedirect("/SelfPage/admin/adminPage.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
