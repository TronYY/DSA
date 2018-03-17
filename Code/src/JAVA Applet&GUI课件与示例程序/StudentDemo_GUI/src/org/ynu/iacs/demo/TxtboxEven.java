package org.ynu.iacs.demo;

import javax.swing.*;
import java.awt.event.*;
public class TxtboxEven extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField price ;
	JTextField amount ;
	 JTextField total;
	 JButton button;
	   public void CountNumber (){
		   JFrame f = new JFrame("计算价格");
	    	JPanel p = new JPanel();
	    	price = new JTextField(10);
	    	amount = new JTextField(10);
	    	total= new JTextField(10);
	    	JLabel label1 = new JLabel("单价");
	    	JLabel label2 = new JLabel("数量");
	    	JLabel label3 = new JLabel("总价");
	        button = new JButton("成本");//新建文本框，标签，按钮，内容面板，顶层容器
	        button.addActionListener(this);
	        p.add(label1);p.add(price);
	        p.add(label2);p.add(amount);
	        p.add(button);
	        p.add(label3);p.add(total);
	        f.add(p);
	        f.setVisible(true);//使其可见
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
	        f.setBounds(50,50,50,50);
	        f.pack();//将组件添加到顶层容器，并显示出来
	        
	   }
	   public void actionPerformed (ActionEvent e){
		   String p =price.getText();
		   
		   String a =amount.getText();
		 
		   int p1 = Integer.parseInt(p);
		   int a1 = Integer.parseInt(a);
		   if(e.getActionCommand().equals("成本")){
			   int t = p1*a1;
			   total.setText(t+"");
		   }
	   }
	    public static void main(String args[]){
	    	TxtboxEven jl=new TxtboxEven();
	    	jl.CountNumber();
	    }
    }
