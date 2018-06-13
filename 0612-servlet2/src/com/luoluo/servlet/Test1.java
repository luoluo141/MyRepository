package com.luoluo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//计算访问次数
/**
 * @author chenjie  
 * @version 创建时间：2018年6月12日  下午3:58:06
 */
@WebServlet("/Test1")
public class Test1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext context = request.getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if (count==null) {
			context.setAttribute("count", 1);
		}
		else{
			context.setAttribute("count", count+1);
		}
		out.print("欢迎");
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}