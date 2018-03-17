package com.stbyte.tech;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecursionDir
 */
@WebServlet("/RecursionDir")
public class RecursionDir extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RecursionDir() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//调用doPost方法，使doGet请求与doPost请求都执行相同的代码
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取用于输出的对象
				PrintWriter out=response.getWriter();
				//获取网站根目录的真实路径
				String realPath=getServletConfig().getServletContext().getRealPath(getInitParameter("ROOT"));
				//创建文件对象
				File f=new File(realPath);
				//调用递归函数输出子目录
				printChilds(f,out,0);
			}
			
			private void printChilds(File dir,PrintWriter out,int level){
				//获取dir目录下的子项，其中包含了文件与目录。我们只输出目录
				File[] childs=dir.listFiles();
				//循环每一个子项，如果是目录的，才进行输出
				for(int idx=0;idx<childs.length;idx++){
					if (childs[idx].isDirectory()){
						//相应级别的子目录，就在前面打印level个短横线
						for(int indent=0;indent<level;indent++)
							out.print("-");
						out.print(childs[idx].getName());
						//换行
						out.print("<br>");
						//继续递归该目录下的子项
						printChilds(childs[idx],out,level+1);
					}
				}
			}

	

}
