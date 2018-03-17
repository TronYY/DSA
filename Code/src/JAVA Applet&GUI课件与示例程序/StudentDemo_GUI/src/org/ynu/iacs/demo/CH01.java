package org.ynu.iacs.demo;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CH01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 JFrame jframe = new JFrame();
		 JButton jbutton = new JButton("Click me!");
		 jbutton.setSize(18, 30);
		 
		 //window 关闭时结束程序
		 jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //把button加到jframe的panel上
		 jframe.getContentPane().add(jbutton);
		 //设置jframe的大小
		 jframe.setSize(300, 300);
		 //显示jframe
		 jframe.setVisible(true);

	}

}
