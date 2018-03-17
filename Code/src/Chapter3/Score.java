public class Score{
	public static final int maxEntries=10;//number of high scores we keep
	protected int numEntries;//�ֳɼ�������
	protected GameEntry[] entries;//����GameEntry�������entries[]
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
		int newScore=e.getScore();//�õ��������ڵ�ĳɼ�
		if (numEntries==maxEntries){//�ɼ����Ѿ����ˣ����µĳɼ����������һ���Ƚ�
			if (newScore<=entries[numEntries-1].getScore())	
				//�ýڵ�ĳɼ������ߣ�û���ʸ����룬�÷�������Ĳ��費��ִ��
				return;
		}
		//��δ������������
		numEntries++;
		int i=numEntries-1;
		for (;(i>=1) &&(newScore>entries[i-1].getScore());i--)
		//   ����󲿿�ʼ�Ƚϣ�  ��������������һλ���������߳ɼ����ڵ�ǰָ���ߵĳɼ������������ǰ��
			entries[i]=entries[i-1];//����һλ
		entries[i]=e;//�������ڵ�����ҵ���λ��
	}

	//Remove and return the high score at index i
	public GameEntry remove(int i) throws IndexOutOfBoundsException{
		if ((i<0)||(i>=numEntries))
			throw new IndexOutOfBoundsException("Invalid index:"+i);//�±��Ϸ����׳��쳣
		GameEntry temp=entries[i];//��Ҫ��ȥ�ĵ�Ԫ��ʱ�洢����
		//Ԫ��i�����Ԫ�ظ���ǰ��һλ��
		for (int j=i;j<numEntries-1;j++)
			entries[j]=entries[j+1];
		entries[numEntries-1]=null;//���һ����Ԫ��Ϊ��ֵ
		numEntries--;//Ԫ������һ
		return temp;//�����Ƴ�ֵ
	}
}