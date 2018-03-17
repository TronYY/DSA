package org.ynu.iacs.demo;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListenDemo implements MouseListener, MouseMotionListener {

	private JFrame f;
	private JTextField tf;

	public static void main(String args[]) {
		ListenDemo two = new ListenDemo();
		two.go();
	}

	public void go() {
		f = new JFrame("Two listeners example");
		f.add(new JLabel("Click and drag the mouse"), BorderLayout.NORTH);
		tf = new JTextField(30);
		f.add(tf, BorderLayout.SOUTH);
		f.addMouseMotionListener(this);
		f.addMouseListener(this);
		f.setSize(300, 200);
		f.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		String s = "Mouse dragging: X = " + e.getX() + " Y = " + e.getY();
		tf.setText(s);

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		String s = "The mouse has left the building";
		tf.setText(s);

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		String s = "The mouse entered";
		tf.setText(s);

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
