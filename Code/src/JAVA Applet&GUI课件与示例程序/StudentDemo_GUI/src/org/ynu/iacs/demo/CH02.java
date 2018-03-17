package org.ynu.iacs.demo;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CH02 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {	
		CH02 frame = new CH02();
		frame.setSize(300, 100);
		frame.setVisible(true);  
		}
	public   CH02(){
		Container pane = getContentPane();
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		JScrollPane sp = new JScrollPane(p);//添加滚动条
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		p.add(b1);  
		p.add(b2);
 		JTextField tf = new JTextField("Hello!", 10);
		p.add(tf);
 		JCheckBox one = new JCheckBox("One", true);
		JCheckBox two = new JCheckBox("Two", false); 
		JCheckBox three = new JCheckBox("Three", true); 
		p.add(one);  
		p.add(two);  
		p.add(three);
		pane.add(sp);
		 		}

}
