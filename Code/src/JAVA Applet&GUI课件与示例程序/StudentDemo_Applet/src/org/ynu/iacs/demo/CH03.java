package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;

public class CH03 extends Applet {

	private String paramName; // 保存返回对应参数值的字符串

	public void init() {
	           paramName=getParameter("who");
	           if (paramName==null) { 
	        	   paramName="小王"; 
	               }  
	           }

	public void paint(Graphics g) {
	           super.paint(g);
	           g.drawString("你好"+paramName+ " ! ", 50,50);      
	           }

}
