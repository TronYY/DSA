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
	Image img; // 声明Image类型的变量img
	int x = 70, y = 60, posX = 70, posY = 60, dx, dy;

	public void init() {
//		img=getImage(getCodeBase(),"img/img01.jpg");
		try {
			img = getImage(new URL("file:///D:/Cource/StudentDemo_Applet/WebContent/img/img01.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 加载影像
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX() - dx; // 取得拖曳时基准点的x坐标
		y = e.getY() - dy; // 取得拖曳时基准点的y坐标
		if (dx > 0 && dx < 120 && dy > 0 && dy < 60)
		// 如果指针落在图形上方
		{
			Graphics g = getGraphics();
			update(g);
			// 清空画面为背景颜色，再调用paint()
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		dx = e.getX() - posX;
		// 取得按下点与基准点x方向的距离
		dy = e.getY() - posY;
		// 取得按下点与基准点y方向的距离

	}

	public void paint(Graphics g) {
		g.drawImage(img, x, y, 120, 60, this);
		// 将img画在applet上
		posX = x; // 更新基准点的x坐标
		posY = y; // 更新基准点的y坐标
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
