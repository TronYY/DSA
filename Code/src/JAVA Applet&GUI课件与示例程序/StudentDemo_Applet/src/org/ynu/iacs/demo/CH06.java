package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CH06 extends Applet implements ActionListener {
	Button btn; // 声明Button类型的变量btn

	public void init() {
		btn = new Button("Start"); // 创建btn对象
		btn.addActionListener(this); // applet本身作btn的聆听者
		add(btn); // 将btn按钮加入applet窗口里
	}

	public void actionPerformed(ActionEvent e) {
		if (btn.getLabel() == "Start")
			btn.setLabel("Stop"); // 设置按钮上方的文字为Stop
		else
			btn.setLabel("Start"); // 设置按钮上方的文字为Start
	}

}
