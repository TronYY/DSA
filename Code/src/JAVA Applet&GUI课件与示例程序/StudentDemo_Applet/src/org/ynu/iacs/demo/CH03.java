package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;

public class CH03 extends Applet {

	private String paramName; // ���淵�ض�Ӧ����ֵ���ַ���

	public void init() {
	           paramName=getParameter("who");
	           if (paramName==null) { 
	        	   paramName="С��"; 
	               }  
	           }

	public void paint(Graphics g) {
	           super.paint(g);
	           g.drawString("���"+paramName+ " ! ", 50,50);      
	           }

}
