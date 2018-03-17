public class Score{
	public static final int maxEntries=10;//number of high scores we keep
	protected int numEntries;//现成绩榜人数
	protected GameEntry[] entries;//声明GameEntry类的数组entries[]
	//Constructor
	public Score(){
		entries=new GameEntry[maxEntries];
		numEntries=0;
	}
	public String toString(){
		String s="[";
		for (int i=0;i<numEntries;i++){
			if (i>0) s+=",";
			s+=entries[i];		
		}
		return s+"]";
	}

	//Add a new high score to the collection
	public void add(GameEntry e){
		int newScore=e.getScore();//得到欲新增节点的成绩
		if (numEntries==maxEntries){//成绩表已经满了，将新的成绩与现有最后一名比较
			if (newScore<=entries[numEntries-1].getScore())	
				//该节点的成绩不够高，没有资格排入，该方法下面的步骤不再执行
				return;
		}
		//表未满，将其排入
		numEntries++;
		int i=numEntries-1;
		for (;(i>=1) &&(newScore>entries[i-1].getScore());i--)
		//   从最后部开始比较；  排名榜上至少有一位，且新增者成绩大于当前指向者的成绩——则继续往前找
			entries[i]=entries[i-1];//后移一位
		entries[i]=e;//将新增节点放入找到的位置
	}

	//Remove and return the high score at index i
	public GameEntry remove(int i) throws IndexOutOfBoundsException{
		if ((i<0)||(i>=numEntries))
			throw new IndexOutOfBoundsException("Invalid index:"+i);//下表不合法，抛出异常
		GameEntry temp=entries[i];//将要移去的单元暂时存储到别处
		//元素i后面的元素各向前移一位；
		for (int j=i;j<numEntries-1;j++)
			entries[j]=entries[j+1];
		entries[numEntries-1]=null;//最后一个单元赋为空值
		numEntries--;//元素量减一
		return temp;//返回移除值
	}
}