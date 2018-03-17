package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class CH08 extends Applet implements MouseListener, MouseMotionListener {
	Image img; // ����Image���͵ı���img
	int x = 70, y = 60, posX = 70, posY = 60, dx, dy;

	public void init() {
//		img=getImage(getCodeBase(),"img/img01.jpg");
		try {
			img = getImage(new URL("file:///D:/Cource/StudentDemo_Applet/WebContent/img/img01.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 ����Ӱ��
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX() - dx; // ȡ����ҷʱ��׼���x����
		y = e.getY() - dy; // ȡ����ҷʱ��׼���y����
		if (dx > 0 && dx < 120 && dy > 0 && dy < 60)
		// ���ָ������ͼ���Ϸ�
		{
			Graphics g = getGraphics();
			update(g);
			// ��ջ���Ϊ������ɫ���ٵ���paint()
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		dx = e.getX() - posX;
		// ȡ�ð��µ����׼��x����ľ���
		dy = e.getY() - posY;
		// ȡ�ð��µ����׼��y����ľ���

	}

	public void paint(Graphics g) {
		g.drawImage(img, x, y, 120, 60, this);
		// ��img����applet��
		posX = x; // ���»�׼���x����
		posY = y; // ���»�׼���y����
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
