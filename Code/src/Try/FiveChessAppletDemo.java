package Try;

//Java��̣���������ϷԴ����
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.PrintStream;
import javax.swing.JComponent;
import javax.swing.JPanel;

/*
*main����������ChessFrame���һ��ʵ������cf����
*��������Ļ��ʾ��ʾ��ʵ������
**/
public class FiveChessAppletDemo {
public static void main(String args[]){
 ChessFrame cf = new ChessFrame();
 cf.show();
}
}

/*
*��ChessFrame��Ҫ�����Ǵ�����������Ϸ������Ͳ˵�
**/
class ChessFrame extends JFrame implements ActionListener {
private String[] strsize={"20x15","30x20","40x30"};//�ɹ�ѡ������̴�С
private String[] strmode={"�˻�����","���˶���"};
public static boolean iscomputer=true,checkcomputer=true;
private int width,height;
private ChessModel cm;
private MainPanel mp;

//������������Ϸ��������
public ChessFrame() {
 this.setTitle("��������Ϸ");
 cm=new ChessModel(1);
 mp=new MainPanel(cm);
 Container con=this.getContentPane();
 con.add(mp,"Center");
 this.setResizable(false);
 this.addWindowListener(new ChessWindowEvent());
 MapSize(20,15);
 JMenuBar mbar = new JMenuBar();
 this.setJMenuBar(mbar);
 JMenu gameMenu = new JMenu("��Ϸ");
 mbar.add(makeMenu(gameMenu, new Object[] {
  "����", "����","ģʽ", null, "�˳�"
  }, this));
 JMenu lookMenu =new JMenu("��ͼ");
 mbar.add(makeMenu(lookMenu,new Object[] {
  "Metal","Motif","Windows"
  },this));
 JMenu helpMenu = new JMenu("����");
 mbar.add(makeMenu(helpMenu, new Object[] {
  "����"
 }, this));
}

//������������Ϸ�����˵�
public JMenu makeMenu(Object parent, Object items[], Object target){
 JMenu m = null;
 if(parent instanceof JMenu)
  m = (JMenu)parent;
 else if(parent instanceof String)
  m = new JMenu((String)parent);
 else
  return null;
 for(int i = 0; i < items.length; i++)
  if(items[i] == null)
   m.addSeparator();
  else if(items[i] == "����"){
   JMenu jm = new JMenu("����");
   ButtonGroup group=new ButtonGroup();
   JRadioButtonMenuItem rmenu;
   for (int j=0;j<strsize.length;j++){
    rmenu=makeRadioButtonMenuItem(strsize[j],target);
    if (j==0)
     rmenu.setSelected(true);
    jm.add(rmenu);
    group.add(rmenu);
   }
   m.add(jm);
  }else if(items[i] == "ģʽ"){
   JMenu jm = new JMenu("ģʽ");
   ButtonGroup group=new ButtonGroup();
   JRadioButtonMenuItem rmenu;
   for (int h=0;h<strmode.length;h++){
    rmenu=makeRadioButtonMenuItem(strmode[h],target);
    if(h==0)
     rmenu.setSelected(true);
    jm.add(rmenu);
    group.add(rmenu);
   }
   m.add(jm);
  }else
   m.add(makeMenuItem(items[i], target));
 return m;
}

//������������Ϸ�Ĳ˵���
public JMenuItem makeMenuItem(Object item, Object target){
 JMenuItem r = null;
 if(item instanceof String)
  r = new JMenuItem((String)item);
 else if(item instanceof JMenuItem)
  r = (JMenuItem)item;
 else
  return null;
 if(target instanceof ActionListener)
  r.addActionListener((ActionListener)target);
 return r;
}

//������������Ϸ�ĵ�ѡ��ťʽ�˵���
public JRadioButtonMenuItem makeRadioButtonMenuItem(
  Object item, Object target){
  JRadioButtonMenuItem r = null;
  if(item instanceof String)
     r = new JRadioButtonMenuItem((String)item);
  else if(item instanceof JRadioButtonMenuItem)
     r = (JRadioButtonMenuItem)item;
  else
     return null;
  if(target instanceof ActionListener)
     r.addActionListener((ActionListener)target);
  return r;
  }
  
  public void MapSize(int w,int h){
  setSize(w * 20+50 , h * 20+100 );
  if(this.checkcomputer)
     this.iscomputer=true;
  else
     this.iscomputer=false;
  mp.setModel(cm);
  mp.repaint();
  }
  
  public boolean getiscomputer(){
  return this.iscomputer;
  }
  
  public void restart(){
  int modeChess = cm.getModeChess();
  if(modeChess <= 3 && modeChess >= 1){
     cm = new ChessModel(modeChess);
     MapSize(cm.getWidth(),cm.getHeight());
  }else{
     System.out.println("\u81EA\u5B9A\u4E49");
  }
  }
  
  public void actionPerformed(ActionEvent e){
  String arg=e.getActionCommand();
  try{
     if (arg.equals("Windows"))
      UIManager.setLookAndFeel(
       "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
     else if(arg.equals("Motif"))
   UIManager.setLookAndFeel(
    "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
  else
   UIManager.setLookAndFeel(
    "javax.swing.plaf.metal.MetalLookAndFeel" );
  SwingUtilities.updateComponentTreeUI(this);
 }catch(Exception ee){}
 if(arg.equals("20x15")){
  this.width=20;
  this.height=15;
  cm=new ChessModel(1);
  MapSize(this.width,this.height);
  SwingUtilities.updateComponentTreeUI(this);
 }
 if(arg.equals("30x20")){
  this.width=30;
  this.height=20;
  cm=new ChessModel(2);
  MapSize(this.width,this.height);
  SwingUtilities.updateComponentTreeUI(this);
 }
 if(arg.equals("40x30")){
  this.width=40;
  this.height=30;
  cm=new ChessModel(3);
  MapSize(this.width,this.height);
  SwingUtilities.updateComponentTreeUI(this);
 }
 if(arg.equals("�˻�����")){
  this.checkcomputer=true;
  this.iscomputer=true;
  cm=new ChessModel(cm.getModeChess());
  MapSize(cm.getWidth(),cm.getHeight());
  SwingUtilities.updateComponentTreeUI(this);
 }
 if(arg.equals("���˶���")){
  this.checkcomputer=false;
  this.iscomputer=false;
  cm=new ChessModel(cm.getModeChess());
  MapSize(cm.getWidth(),cm.getHeight());
  SwingUtilities.updateComponentTreeUI(this);
 }
 if(arg.equals("����")){
  restart();
 }
 if(arg.equals("����"))
  JOptionPane.showMessageDialog(this, "��������Ϸ���԰汾", "����", 0);
 if(arg.equals("�˳�"))
  System.exit(0);
}
}

/*
*��ChessModelʵ������������������㷨�ĺ���
*/
class ChessModel {
//���̵Ŀ�ȡ��߶ȡ����̵�ģʽ����20��15��
private int width,height,modeChess;
//���̷���ĺ�����������
private int x=0,y=0;
//���̷���ĺ���������������Ӧ��������ɫ��
//����arrMapShowֻ��3��ֵ��1��2��3��-5��
//����1��������̷������µ�����Ϊ���ӣ�
//2��������̷������µ�����Ϊ���ӣ�
//3����Ϊ�����̷�����û�����ӣ�
//-5��������̷����ܹ�������
private int[][] arrMapShow;
//�������ֵı�ʶ�����̷������Ƿ������ӵı�ʶ��
private boolean isOdd,isExist;

public ChessModel() {}

//�ù��췽�����ݲ�ͬ������ģʽ��modeChess����������Ӧ��С������
public ChessModel(int modeChess){
 this.isOdd=true;
 if(modeChess == 1){
  PanelInit(20, 15, modeChess);
 }
 if(modeChess == 2){
  PanelInit(30, 20, modeChess);
 }
 if(modeChess == 3){
  PanelInit(40, 30, modeChess);
 }
}

//��������ģʽ�������̴�С,
private void PanelInit(int width, int height, int modeChess){
 this.width = width;
 this.height = height;
 this.modeChess = modeChess;
 arrMapShow = new int[width+1][height+1];
 for(int i = 0; i <= width; i++){
  for(int j = 0; j <= height; j++){
   arrMapShow[i][j] = -5;
  }
 }
}

//��ȡ�Ƿ񽻻����ֵı�ʶ��
public boolean getisOdd(){
 return this.isOdd;
}

//���ý������ֵı�ʶ��
public void setisOdd(boolean isodd){
 if(isodd)
  this.isOdd=true;
 else
  this.isOdd=false;
}

//��ȡĳ���̷����Ƿ������ӵı�ʶֵ
public boolean getisExist(){
 return this.isExist;
}

//��ȡ���̿��
public int getWidth(){
 return this.width;
}

//��ȡ���̸߶�
public int getHeight(){
 return this.height;
}

//��ȡ����ģʽ
public int getModeChess(){
 return this.modeChess;
}

//��ȡ���̷��������ӵ���Ϣ
public int[][] getarrMapShow(){
 return arrMapShow;
}

//�ж����ӵĺ������������Ƿ�Խ��
private boolean badxy(int x, int y){
 if(x >= width+20 || x < 0)
  return true;
 return y >= height+20 || y < 0;
}

//����������ĳһ�����ϰ˸��������ӵ����ֵ��
//��˸�����ֱ��ǣ����ҡ��ϡ��¡����ϡ����¡����ϡ�����
public boolean chessExist(int i,int j){
 if(this.arrMapShow[i][j]==1 || this.arrMapShow[i][j]==2)
  return true;
 return false;
}

//�жϸ�����λ���Ƿ��������
public void readyplay(int x,int y){
 if(badxy(x,y))
  return;
 if (chessExist(x,y))
  return;
 this.arrMapShow[x][y]=3;
}

//�ڸ�����λ��������
public void play(int x,int y){
 if(badxy(x,y))
  return;
 if(chessExist(x,y)){
  this.isExist=true;
  return;
 }else
  this.isExist=false;
 if(getisOdd()){
  setisOdd(false);
 this.arrMapShow[x][y]=1;
 }else{
  setisOdd(true);
  this.arrMapShow[x][y]=2;
 }
}

//���������
/*
*˵��������ٷ��ж�ÿһ���������ĸ�����ĵ������������
*���ó����������ֵ�����꣬����
**/
public void computerDo(int width,int height){
 int max_black,max_white,max_temp,max=0;
 setisOdd(true);
 System.out.println("��������� ...");
 for(int i = 0; i <= width; i++){
  for(int j = 0; j <= height; j++){
   if(!chessExist(i,j)){//�㷨�ж��Ƿ�����
    max_white=checkMax(i,j,2);//�жϰ��ӵ����ֵ
    max_black=checkMax(i,j,1);//�жϺ��ӵ����ֵ
    max_temp=Math.max(max_white,max_black);
    if(max_temp>max){
     max=max_temp;
     this.x=i;
     this.y=j;
    }
   }
  }
 }
 setX(this.x);
 setY(this.y);
 this.arrMapShow[this.x][this.y]=2;
}

//��¼�������Ӻ�ĺ�������
public void setX(int x){
 this.x=x;
}

//��¼�������Ӻ����������
public void setY(int y){
 this.y=y;
}

//��ȡ�������ӵĺ�������
public int getX(){
 return this.x;
}

//��ȡ�������ӵ���������
public int getY(){
 return this.y;
}

//����������ĳһ�����ϰ˸��������ӵ����ֵ��
//��˸�����ֱ��ǣ����ҡ��ϡ��¡����ϡ����¡����ϡ�����
public int checkMax(int x, int y,int black_or_white){
 int num=0,max_num,max_temp=0;
 int x_temp=x,y_temp=y;
 int x_temp1=x_temp,y_temp1=y_temp;
 //judge right
 for(int i=1;i<5;i++){
  x_temp1+=1;
  if(x_temp1>this.width)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 //judge left
 x_temp1=x_temp;
 for(int i=1;i<5;i++){
  x_temp1-=1;
  if(x_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 if(num<5)
  max_temp=num;

 //judge up
 x_temp1=x_temp;
 y_temp1=y_temp;
 num=0;
 for(int i=1;i<5;i++){
  y_temp1-=1;
  if(y_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 //judge down
 y_temp1=y_temp;
 for(int i=1;i<5;i++){
  y_temp1+=1;
  if(y_temp1>this.height)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 if(num>max_temp&&num<5)
  max_temp=num;

 //judge left_up
 x_temp1=x_temp;
 y_temp1=y_temp;
 num=0;
 for(int i=1;i<5;i++){
  x_temp1-=1;
  y_temp1-=1;
  if(y_temp1<0 || x_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 //judge right_down
 x_temp1=x_temp;
 y_temp1=y_temp;
 for(int i=1;i<5;i++){
  x_temp1+=1;
  y_temp1+=1;
  if(y_temp1>this.height || x_temp1>this.width)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 if(num>max_temp&&num<5)
  max_temp=num;

 //judge right_up
 x_temp1=x_temp;
 y_temp1=y_temp;
 num=0;
 for(int i=1;i<5;i++){
  x_temp1+=1;
  y_temp1-=1;
  if(y_temp1<0 || x_temp1>this.width)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 //judge left_down
 x_temp1=x_temp;
 y_temp1=y_temp;
 for(int i=1;i<5;i++){
  x_temp1-=1;
  y_temp1+=1;
  if(y_temp1>this.height || x_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==black_or_white)
   num++;
  else
   break;
 }
 if(num>max_temp&&num<5)
  max_temp=num;
 max_num=max_temp;
 return max_num;
}

//�ж�ʤ��
public boolean judgeSuccess(int x,int y,boolean isodd){
 int num=1;
 int arrvalue;
 int x_temp=x,y_temp=y;
 if(isodd)
  arrvalue=2;
 else
  arrvalue=1;
 int x_temp1=x_temp,y_temp1=y_temp;
 //�ж��ұ�
 for(int i=1;i<6;i++){
  x_temp1+=1;
  if(x_temp1>this.width)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 //�ж����
 x_temp1=x_temp;
 for(int i=1;i<6;i++){
  x_temp1-=1;
  if(x_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 if(num==5)
  return true;

 //�ж��Ϸ�
 x_temp1=x_temp;
 y_temp1=y_temp;
 num=1;
 for(int i=1;i<6;i++){
  y_temp1-=1;
  if(y_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 //�ж��·�
 y_temp1=y_temp;
 for(int i=1;i<6;i++){
  y_temp1+=1;
  if(y_temp1>this.height)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 if(num==5)
  return true;

 //�ж�����
 x_temp1=x_temp;
 y_temp1=y_temp;
 num=1;
 for(int i=1;i<6;i++){
  x_temp1-=1;
  y_temp1-=1;
  if(y_temp1<0 || x_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 //�ж�����
 x_temp1=x_temp;
 y_temp1=y_temp;
 for(int i=1;i<6;i++){
 x_temp1+=1;
 y_temp1+=1;
 if(y_temp1>this.height || x_temp1>this.width)
  break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 if(num==5)
  return true;

 //�ж�����
 x_temp1=x_temp;
 y_temp1=y_temp;
 num=1;
 for(int i=1;i<6;i++){
  x_temp1+=1;
  y_temp1-=1;
  if(y_temp1<0 || x_temp1>this.width)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 //�ж�����
 x_temp1=x_temp;
 y_temp1=y_temp;
 for(int i=1;i<6;i++){
  x_temp1-=1;
  y_temp1+=1;
  if(y_temp1>this.height || x_temp1<0)
   break;
  if(this.arrMapShow[x_temp1][y_temp1]==arrvalue)
   num++;
  else
   break;
 }
 if(num==5)
  return true;
 return false;
}

//Ӯ������ʾ
public void showSuccess(JPanel jp){
 JOptionPane.showMessageDialog(jp,"��Ӯ�ˣ�������!","win",
  JOptionPane.INFORMATION_MESSAGE);
}

//��������ʾ
public void showDefeat(JPanel jp){
 JOptionPane.showMessageDialog(jp,"�����ˣ������¿�ʼ!","lost",
  JOptionPane.INFORMATION_MESSAGE);
}
}

/*
*��MainPanel��Ҫ������¹��ܣ�
*1������һ����壬�ڸ�����ϻ������̣�
*2�������ڸ������ϵ�����¼��������������������Ҽ����������϶��ȣ�
**/
class MainPanel extends JPanel 
implements MouseListener,MouseMotionListener{
private int width,height;//���̵Ŀ�Ⱥ͸߶�
private ChessModel cm;

//��������ģʽ�趨���Ĵ�С
MainPanel(ChessModel mm){
 cm=mm;
 width=cm.getWidth();
 height=cm.getHeight();
 addMouseListener(this);
}
  
  //��������ģʽ�趨���̵Ŀ�Ⱥ͸߶�
public void setModel(ChessModel mm){
 cm = mm;
 width = cm.getWidth();
 height = cm.getHeight();
}

//���������������̷������ӵ���Ϣ������ӻ��Ǻ��ӣ���
//Ȼ�����draw�����������ϻ�����Ӧ������
public void paintComponent(Graphics g){
 super.paintComponent(g);
 for(int j = 0; j <= height; j++){
  for(int i = 0; i <= width; i++){
   int v = cm.getarrMapShow()[i][j];
   draw(g, i, j, v);
  }
 }
}

//�����ṩ��������Ϣ����ɫ�����꣩������
public void draw(Graphics g, int i, int j, int v){
 int x = 20 * i+20;
 int y = 20 * j+20;
 //������
 if(i!=width && j!=height){
  g.setColor(Color.white);
  g.drawRect(x,y,20,20);
 }
 //����ɫ����
 if(v == 1 ){
  g.setColor(Color.gray);
  g.drawOval(x-8,y-8,16,16);
  g.setColor(Color.black);
  g.fillOval(x-8,y-8,16,16);
 }
 //����ɫ����
 if(v == 2 ){
  g.setColor(Color.gray);
  g.drawOval(x-8,y-8,16,16);
  g.setColor(Color.white);
  g.fillOval(x-8,y-8,16,16);
 }
 if(v ==3){
  g.setColor(Color.cyan);
  g.drawOval(x-8,y-8,16,16);
 }
}

//��Ӧ���ĵ���¼����������ĵ�������壬
//���������ж�ʤ����
public void mousePressed(MouseEvent evt){
 int x = (evt.getX()-10) / 20;
 int y = (evt.getY()-10) / 20;
 System.out.println(x+" "+y);
 if (evt.getModifiers()==MouseEvent.BUTTON1_MASK){
  cm.play(x,y);
  System.out.println(cm.getisOdd()+" "+cm.getarrMapShow()[x][y]);
  repaint();
  if(cm.judgeSuccess(x,y,cm.getisOdd())){
   cm.showSuccess(this);
   evt.consume();
   ChessFrame.iscomputer=false;
  }
  //�ж��Ƿ�Ϊ�˻�����
  if(ChessFrame.iscomputer&&!cm.getisExist()){
   cm.computerDo(cm.getWidth(),cm.getHeight());
   repaint();
   if(cm.judgeSuccess(cm.getX(),cm.getY(),cm.getisOdd())){
    cm.showDefeat(this);
    evt.consume();
   }
  }
 }
}

public void mouseClicked(MouseEvent evt){}
public void mouseReleased(MouseEvent evt){}
public void mouseEntered(MouseEvent mouseevt){}
public void mouseExited(MouseEvent mouseevent){}
public void mouseDragged(MouseEvent evt){}
  
  //��Ӧ�����϶��¼�
public void mouseMoved(MouseEvent moveevt){
 int x = (moveevt.getX()-10) / 20;
 int y = (moveevt.getY()-10) / 20;
 cm.readyplay(x,y);
 repaint();
} 
}

class ChessWindowEvent extends WindowAdapter{
public void windowClosing(WindowEvent e){
 System.exit(0);
}

ChessWindowEvent()

{
}
}
