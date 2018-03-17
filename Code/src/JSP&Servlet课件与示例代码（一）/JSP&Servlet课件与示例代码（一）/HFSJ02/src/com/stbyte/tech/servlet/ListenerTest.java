package com.stbyte.tech.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stbyte.tech.student.Student;

/**
 * Servlet implementation class ListenerTest
 */
public class ListenerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("test content attributes set by lintener.<br>");
		out.println("<br>");
		//现在从ServletContext得到Student，如果监听者正常，第一次调用服务方法之前，Student就已经放在上下文中了
		Student student = (Student)getServletContext().getAttribute("stu");
		//类型要一致
		out.println("Student's Number is:"+ student.getStuNum());
		
		
	}

}
