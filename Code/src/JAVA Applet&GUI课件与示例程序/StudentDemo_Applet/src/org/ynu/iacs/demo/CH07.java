package org.ynu.iacs.demo;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

public class CH07 extends Applet {
	// ����ֻ����������Ҫ����
	Image img; // ����Image���͵ı���img
	public void init() {
		img=getImage(getCodeBase(),"img/img01.jpg");
//	try {
//			
//			 img = getImage(new URL("file:///D:/Eclipse Workspace/StudentDemo_Applet/WebContent/img/sa.jpg"));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // ����ͼƬ

System.out.println(getDocumentBase());
System.out.println(getCodeBase());
	}  
 

	public void paint(Graphics g) {
		g.drawImage(img, 20, 20, this); // ��img����applet��
	}
    
}
