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
    	//由事件得到ServletContext
    	ServletContext sc =  event.getServletContext();
         //使用上下文初始化参数
        String stuNum = sc.getInitParameter("stuNum");
         //建立一个新的Student对象	
        Student stuNumber = new Student(stuNum);		
        //使用上下文来设置属性（名/对象对），这个属性就是Student，现在应用的其他部分就能得到student的属性值了
        sc.setAttribute("stu", stuNumber);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
