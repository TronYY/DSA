package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CH06 extends Applet implements ActionListener {
	Button btn; // ����Button���͵ı���btn

	public void init() {
		btn = new Button("Start"); // ����btn����
		btn.addActionListener(this); // applet������btn��������
		add(btn); // ��btn��ť����applet������
	}

	public void actionPerformed(ActionEvent e) {
		if (btn.getLabel() == "Start")
			btn.setLabel("Stop"); // ���ð�ť�Ϸ�������ΪStop
		else
			btn.setLabel("Start"); // ���ð�ť�Ϸ�������ΪStart
	}

}
