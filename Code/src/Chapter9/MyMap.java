public class MyMap<K, V> {
	protected static int INIT_CAPACITY = 16;// Ĭ������
	protected int size;// ��ǰ����
	protected MyEntry<K,V>[] container;// ʵ�ʴ洢���ݵ��������
	protected static float LOAD_FACTOR = 0.75f;// װ������
	protected int max;// �ܴ��������=capacity*factor
	protected int count;//��������
	
	
	/**
	 * ����ʵ�ʱ������ݵ��ڲ���,��Ϊ���ù����������ͻ�����ڲ������Ϊ������ʽ
	 * 
	 * @param <K>key
	 * @param <V>value
	 *            
	 */
	protected static class MyEntry<K,V> implements Entry<K,V> {
		MyEntry<K, V> next;// ��һ�����
		K key;// key
		V value;// value
		int hash;// ���key��Ӧ��hash�룬��Ϊһ����Ա���������´���Ҫ�õ�ʱ����Բ������¼���
		
		
		// ���췽��
		public MyEntry(K k, V v, int hash) {
			this.key = k;
			this.value = v;
			this.hash = hash;
			
		}

		public K getKey(){
			return key;
		}
		
		public V getValue(){
			return value;
		}

	}

	// �����Զ�������װ�����ӵĹ��췽��
	public MyMap(int init_Capaticy, float load_factor) {
		if (init_Capaticy < 0)
			throw new IllegalArgumentException("Illegal initial capacity: "
					+ init_Capaticy);
		if (load_factor <= 0 || Float.isNaN(load_factor))
			throw new IllegalArgumentException("Illegal load factor: "
					+ load_factor);
		this.LOAD_FACTOR = load_factor;
		max = (int) (init_Capaticy * load_factor);
		container = new MyEntry[init_Capaticy];
	}

	// ʹ��Ĭ�ϲ����Ĺ�����
	public MyMap() {
		this(INIT_CAPACITY, LOAD_FACTOR);
	}

	/**
	 * ��
	 * 
	 * @param k
	 * @param v
	 * @return
	 */
	public boolean put(K k, V v) {
		// ����K��hashֵ
		// ����JDK������hashCode()����������hashֵ
		int hash = k.hashCode();
		//��������Ϣ��װΪһ��MyEntry
		MyEntry<K,V> temp=new MyEntry(k,v,hash);
            if(setMyEntry(temp, container)){
            	// ��С��һ
        		size++;
        		return true;
            }
            return false;
	}


	/**
	 * ���ݵķ���
	 * 
	 * �µ�������С @param newSize
	 *            
	 */
	protected void reSize(int newSize) {
		// 1.����������
		MyEntry<K, V>[] newTable = new MyEntry[newSize];
		max = (int) (newSize * LOAD_FACTOR);
		// 2.��������Ԫ��,����������Ԫ�أ�ÿ��Ԫ���ٴ�һ��
		for (int j = 0; j < container.length; j++) {
			MyEntry<K, V> myEntry = container[j];
			while (null != myEntry) {
				setMyEntry(myEntry, newTable);
				myEntry = myEntry.next;
			}
		}
		// 3.�ı�ָ��
		container = newTable;
		
	}
	
	/**
	 *��ָ���Ľ��temp��ӵ�ָ����hash��table����
	 * ���ʱ�жϸý���Ƿ��Ѿ�����
	 * ����Ѿ����ڣ�����false
	 * ��ӳɹ�����true
	 * @param temp
	 * @param table
	 * @return
	 */
	protected boolean setMyEntry(MyEntry<K,V> temp,MyEntry[] table){
		// ����hashֵ�ҵ��±�
		int index = indexFor(temp.hash, table.length);
		//�����±��ҵ���ӦԪ��
		MyEntry<K, V> MyEntry = table[index];
		// 3.������
		if (null != MyEntry) {
			// 3.1�������������ж��Ƿ����
			while (null != MyEntry) {
				//�ж���ȵ�����ʱӦ��ע�⣬���˱Ƚϵ�ַ��ͬ�⣬���ô��ݵ������equals()�����Ƚ�
				//����򲻴棬����false
				if ((temp.key == MyEntry.key||temp.key.equals(MyEntry.key)) && temp.hash == MyEntry.hash&&(temp.value==MyEntry.value||temp.value.equals(MyEntry.value))) {
					return false;
				}
				//�������Ƚ���һ��Ԫ��
				else if (temp.key != MyEntry.key && temp.value != MyEntry.value) {
						//�����β���ж�ѭ��
						if(null==MyEntry.next){
							break;
						}
						// û�е����β������������һ��Ԫ��
						MyEntry = MyEntry.next;
				}
			}
			// 3.2���������˶�β�������û����ͬ��Ԫ�أ��򽫸�Ԫ�ع��ڶ�β
			addMyEntry2Last(MyEntry,temp);
				
		}
		// 4.��������,ֱ�����ó�ʼ��Ԫ��
		setFirstMyEntry(temp,index,table);
		return true;
	}
	
    protected void addMyEntry2Last(MyEntry<K, V> MyEntry, MyEntry<K, V> temp) {
    	if (size > max) {
			reSize(container.length * 4);
		}
    	MyEntry.next=temp;
		
	}

	/**
     * ��ָ�����temp����ӵ�ָ����hash��table��ָ���±�index��
     * @param temp
     * @param index
     * @param table
     */
	protected void setFirstMyEntry(MyEntry<K, V> temp, int index, MyEntry[] table) {
		// 1.�жϵ�ǰ�����Ƿ񳬱꣬������꣬�������ݷ���
		if (size > max) {
			reSize(table.length * 4);
		}
		// 2.�����꣬���������Ժ�����Ԫ��
		table[index] = temp;
		//��Ϊÿ�����ú����µ�������Ҫ�����ӵĽ�㶼ȥ��
		temp.next=null;
	}

	/**
	 * ȡ
	 * 
	 * @param k
	 * @return
	 */
	public V get(K k) {
		MyEntry<K, V> myEntry = null;
		// 1.����K��hashֵ
		int hash = k.hashCode();
		// 2.����hashֵ�ҵ��±�
		int index = indexFor(hash, container.length);
		// 3������index�ҵ�����
		myEntry = container[index];
		// 3��������Ϊ�գ�����null
		if (null == myEntry) {
			return null;
		}
		// 4������Ϊ�գ����������Ƚ�k�Ƿ����,���k��ȣ��򷵻ظ�value
		while (null != myEntry) {
			if (k == myEntry.key||myEntry.key.equals(k)) {
				return myEntry.value;
			}
			myEntry = myEntry.next;
		}
		// ����������˲���ȣ��򷵻ؿ�
		return null;

	}

	/**
	 * ����hash�룬��������ĳ���,����ù�ϣ�������������е��±�ֵ
	 * 
	 * @param hashcode
	 * @param containerLength
	 * @return
	 */
	public int indexFor(int hashcode, int containerLength) {
		return hashcode & (containerLength - 1);

	}
	
	
	public void dispMyMap(){
		int i;
		for (i=0;i<container.length;i++){
			System.out.print(i+"()");
			MyEntry<K, V> myEntry =container[i];
			if (myEntry==null) {
				System.out.println();
				continue;
			}
			
			else {
				int nowCount=0;
				while (myEntry!=null){
					nowCount++;
					System.out.print("--->("+myEntry.getKey()+")");
					count+=nowCount;
					myEntry=myEntry.next;
				}
			
			}
		System.out.println();
		
			
		}
	}
	
	

	
}

