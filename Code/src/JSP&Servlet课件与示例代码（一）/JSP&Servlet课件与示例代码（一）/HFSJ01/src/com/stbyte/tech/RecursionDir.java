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
		//����doPost������ʹdoGet������doPost����ִ����ͬ�Ĵ���
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ��������Ķ���
				PrintWriter out=response.getWriter();
				//��ȡ��վ��Ŀ¼����ʵ·��
				String realPath=getServletConfig().getServletContext().getRealPath(getInitParameter("ROOT"));
				//�����ļ�����
				File f=new File(realPath);
				//���õݹ麯�������Ŀ¼
				printChilds(f,out,0);
			}
			
			private void printChilds(File dir,PrintWriter out,int level){
				//��ȡdirĿ¼�µ�������а������ļ���Ŀ¼������ֻ���Ŀ¼
				File[] childs=dir.listFiles();
				//ѭ��ÿһ����������Ŀ¼�ģ��Ž������
				for(int idx=0;idx<childs.length;idx++){
					if (childs[idx].isDirectory()){
						//��Ӧ�������Ŀ¼������ǰ���ӡlevel���̺���
						for(int indent=0;indent<level;indent++)
							out.print("-");
						out.print(childs[idx].getName());
						//����
						out.print("<br>");
						//�����ݹ��Ŀ¼�µ�����
						printChilds(childs[idx],out,level+1);
					}
				}
			}

	

}
