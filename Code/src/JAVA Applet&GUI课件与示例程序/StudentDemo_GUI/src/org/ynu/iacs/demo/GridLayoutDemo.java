package org.ynu.iacs.demo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -837988110087008456L;
	private JFrame f;
	private JButton b1, b2, b3, b4, b5, b6;

	public static void main(String args[]) {
		GridLayoutDemo grid = new GridLayoutDemo();
		grid.go();
	}

	public void go() {
		f = new JFrame("Grid example");
		f.setLayout(new GridLayout(3, 2));
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.pack();
		f.setVisible(true);
	}

}
