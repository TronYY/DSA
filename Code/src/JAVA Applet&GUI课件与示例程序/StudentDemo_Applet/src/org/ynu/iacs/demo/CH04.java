package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;

public class CH04 extends Applet {
	public void paint(Graphics g) {
	       g.drawString(getParameter("str1"),30,40);    // ȡ��html���str1��
	       g.drawString(getParameter("str2"),30,60);    // ȡ��html���str2��
	}
}
