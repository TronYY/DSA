package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;

public class CH01 extends Applet {
	public String s;

	public void init() {

		s = new String("Hello World!���ǲ��Եĵ�һ������");
	}

	public void paint(Graphics g) {

		g.drawString(s, 45, 45);

	}

}
