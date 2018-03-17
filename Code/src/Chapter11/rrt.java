//Bjq.java 
import java.awt.*; 
import java.awt.print.*; 
import java.awt.datatransfer.*; 
import java.applet.*; 
import javax.swing.JColorChooser; 
import javax.swing.event.*; 
import java.awt.event.*; 
import java.io.*; 
import javax.swing.*; 
import javax.swing.text.*; 
import javax.swing.colorchooser.*;  
public class Bjq extends JPanel   {  
	private JPopupMenu popupMenu = new JPopupMenu();  
	JTextArea aa = new JTextArea("", 20, 50);//构造一个文本域  JScrollPane bb = new JScrollPane(aa); 
}
 JMenuBar cc = new JMenuBar();//创建一个空的菜单条  
JMenu file = new JMenu("文件"); 
                                        //创建"文件"和"编辑"这两个菜单项  JMenu edit = new JMenu("编辑");   
 // 菜单内容  JMenuItem dd;  // 实例化剪切板 
 Clipboard clipbd = getToolkit().getSystemClipboard();  /////// 
 
JMenu fileMenu; 
 JPopupMenu jPopupMenuOne;  JMenuItem openFile,closeFile,exit;