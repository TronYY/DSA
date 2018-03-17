package com.stbyte.tech;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		   
	    /*输出HTML文档*/
	  
	    out.print("<html><head><title>welcome</title></head>");
	    out.print("<body>");
	    out.print("<h1 align=center>欢迎："+name+"</h>");
	    out.print("</body></html>");
	     
	    //out.close(); //关闭PrintWriter
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");  
	    /*输出HTML文档*/
	    
	    out.println("<html><head><title>welcome</title></head>");
	    out.println("<body>");
	    out.println("<h1 align=center>欢迎:"+name+"</h>");
	    out.println("<br>");
	    out.println("<h1 align=center>您的密码是："+password+"</h>");
	    out.println("</body></html>");
	     
	    out.close(); //关闭PrintWriter
	}

}
