package com.stbyte.tech;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayDate
 */
public class DisplayDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDate() {
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
		
		Date todate = new Date();
		response.setContentType("text/html;charset=GB2312");
		   
	    /*输出HTML文档*/
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>DisplayDate</title></head>");
	    out.println("<body>");
	    out.println("<h1 align=center>今天的日期是："+todate+"</h>");
	    out.println("</body></html>");
	     
	    out.close(); //关闭PrintWriter
	}

}
