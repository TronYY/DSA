package com.stbyte.tech.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.stbyte.tech.student.Student;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	//���¼��õ�ServletContext
    	ServletContext sc =  event.getServletContext();
         //ʹ�������ĳ�ʼ������
        String stuNum = sc.getInitParameter("stuNum");
         //����һ���µ�Student����	
        Student stuNumber = new Student(stuNum);		
        //ʹ�����������������ԣ���/����ԣ���������Ծ���Student������Ӧ�õ��������־��ܵõ�student������ֵ��
        sc.setAttribute("stu", stuNumber);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
