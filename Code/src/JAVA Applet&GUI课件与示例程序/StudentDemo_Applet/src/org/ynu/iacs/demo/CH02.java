package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;

public class CH02 extends Applet {
	public String s;

	public void init() {

		s = new String("���ǲ��Եĵڶ�������");
	}

	public void paint(Graphics g) {

		g.drawString(s, 45, 45);

	}

}
