package com.stbyte.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AndroidServlet
 */
@WebServlet(description = "测试android的Http通信", urlPatterns = { "/AndroidServlet" })
public class AndroidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		
	//	String sAction = request.getParameter("name");
	//	System.out.println(sAction);
		String gname = request.getParameter("loginid");
		String gage = request.getParameter("password");
		
	//	String pname = request.getParameter("pname");
	//	String page = request.getParameter("page");
		
	//	if(sAction == null || sAction.equals("")){
	//		 out.println("<p>action的参数没有传过来！</P>");
	//	}
		//if(sAction.equals("getReq")){
		//	 out.println("<p>get提交数据，名字是：" + gname +",年龄是：" + gage + "</P>");
		//}
		/*
		if(sAction.equals("postReq")){
			out.println("<p>post提交数据，名字是：" + pname + ",年龄是：" + page + "</P>");
		}
		
		if(gname == null || gname.equals("")){
			//System.out.println("user name is null");
			 out.println("<p>提交数据，名字是：" + gname +",年龄是：" + gage + "</P>");
		}*/
		//if(gname.equals("admin") && gage.equals("123456")){
			//System.out.println("user name is" + gname +", password is"+ gage );
			 out.println("<p>commit data,user name is:" + gname +",password is:" + gage + "</P>");
		//}
			
		
	}
	    

}
