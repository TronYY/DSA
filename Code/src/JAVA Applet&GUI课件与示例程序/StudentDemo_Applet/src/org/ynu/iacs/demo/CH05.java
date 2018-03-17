package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;

public class CH05 extends Applet {
	int initCounter = 0;
	int startCounter = 0;
	int stopCounter = 0;
	int destroyCounter = 0;

	public void init() {
		initCounter++;
		repaint();
	}

	public void start() {
		startCounter++;
		repaint();
	}

	public void stop() {
		stopCounter++;
		repaint();
	}

	public void destroy() {
		destroyCounter++;
		repaint();
	}

	public void paint(Graphics g){
		g.drawString("init has been invoked" + String.valueOf (initCounter) +"times",20,20);

		g.drawString("start has been invoked" + String.valueOf (startCounter) + "times",20,45);

		g.drawString("destroy has been invoked" + String. valueOf(destroyCounter) +" times",20,65);
	}
}
