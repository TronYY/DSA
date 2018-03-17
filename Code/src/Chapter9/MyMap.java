public class MyMap<K, V> {
	protected static int INIT_CAPACITY = 16;// 默认容量
	protected int size;// 当前容量
	protected MyEntry<K,V>[] container;// 实际存储数据的数组对象
	protected static float LOAD_FACTOR = 0.75f;// 装载因子
	protected int max;// 能存的最大的数=capacity*factor
	protected int count;//搜索次数
	
	
	/**
	 * 用来实际保存数据的内部类,因为采用挂链法解决冲突，此内部类设计为链表形式
	 * 
	 * @param <K>key
	 * @param <V>value
	 *            
	 */
	protected static class MyEntry<K,V> implements Entry<K,V> {
		MyEntry<K, V> next;// 下一个结点
		K key;// key
		V value;// value
		int hash;// 这个key对应的hash码，作为一个成员变量，当下次需要用的时候可以不用重新计算
		
		
		// 构造方法
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

	// 设置自定容量和装载因子的构造方法
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

	// 使用默认参数的构造器
	public MyMap() {
		this(INIT_CAPACITY, LOAD_FACTOR);
	}

	/**
	 * 存
	 * 
	 * @param k
	 * @param v
	 * @return
	 */
	public boolean put(K k, V v) {
		// 计算K的hash值
		// 调用JDK给出的hashCode()方法来计算hash值
		int hash = k.hashCode();
		//将所有信息封装为一个MyEntry
		MyEntry<K,V> temp=new MyEntry(k,v,hash);
            if(setMyEntry(temp, container)){
            	// 大小加一
        		size++;
        		return true;
            }
            return false;
	}


	/**
	 * 扩容的方法
	 * 
	 * 新的容器大小 @param newSize
	 *            
	 */
	protected void reSize(int newSize) {
		// 1.声明新数组
		MyEntry<K, V>[] newTable = new MyEntry[newSize];
		max = (int) (newSize * LOAD_FACTOR);
		// 2.复制已有元素,即遍历所有元素，每个元素再存一遍
		for (int j = 0; j < container.length; j++) {
			MyEntry<K, V> myEntry = container[j];
			while (null != myEntry) {
				setMyEntry(myEntry, newTable);
				myEntry = myEntry.next;
			}
		}
		// 3.改变指向
		container = newTable;
		
	}
	
	/**
	 *将指定的结点temp添加到指定的hash表table当中
	 * 添加时判断该结点是否已经存在
	 * 如果已经存在，返回false
	 * 添加成功返回true
	 * @param temp
	 * @param table
	 * @return
	 */
	protected boolean setMyEntry(MyEntry<K,V> temp,MyEntry[] table){
		// 根据hash值找到下标
		int index = indexFor(temp.hash, table.length);
		//根据下标找到对应元素
		MyEntry<K, V> MyEntry = table[index];
		// 3.若存在
		if (null != MyEntry) {
			// 3.1遍历整个链表，判断是否相等
			while (null != MyEntry) {
				//判断相等的条件时应该注意，除了比较地址相同外，引用传递的相等用equals()方法比较
				//相等则不存，返回false
				if ((temp.key == MyEntry.key||temp.key.equals(MyEntry.key)) && temp.hash == MyEntry.hash&&(temp.value==MyEntry.value||temp.value.equals(MyEntry.value))) {
					return false;
				}
				//不相等则比较下一个元素
				else if (temp.key != MyEntry.key && temp.value != MyEntry.value) {
						//到达队尾，中断循环
						if(null==MyEntry.next){
							break;
						}
						// 没有到达队尾，继续遍历下一个元素
						MyEntry = MyEntry.next;
				}
			}
			// 3.2当遍历到了队尾，如果都没有相同的元素，则将该元素挂在队尾
			addMyEntry2Last(MyEntry,temp);
				
		}
		// 4.若不存在,直接设置初始化元素
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
     * 将指定结点temp，添加到指定的hash表table的指定下标index中
     * @param temp
     * @param index
     * @param table
     */
	protected void setFirstMyEntry(MyEntry<K, V> temp, int index, MyEntry[] table) {
		// 1.判断当前容量是否超标，如果超标，调用扩容方法
		if (size > max) {
			reSize(table.length * 4);
		}
		// 2.不超标，或者扩容以后，设置元素
		table[index] = temp;
		//因为每次设置后都是新的链表，需要将其后接的结点都去掉
		temp.next=null;
	}

	/**
	 * 取
	 * 
	 * @param k
	 * @return
	 */
	public V get(K k) {
		MyEntry<K, V> myEntry = null;
		// 1.计算K的hash值
		int hash = k.hashCode();
		// 2.根据hash值找到下标
		int index = indexFor(hash, container.length);
		// 3。根据index找到链表
		myEntry = container[index];
		// 3。若链表为空，返回null
		if (null == myEntry) {
			return null;
		}
		// 4。若不为空，遍历链表，比较k是否相等,如果k相等，则返回该value
		while (null != myEntry) {
			if (k == myEntry.key||myEntry.key.equals(k)) {
				return myEntry.value;
			}
			myEntry = myEntry.next;
		}
		// 如果遍历完了不相等，则返回空
		return null;

	}

	/**
	 * 根据hash码，容器数组的长度,计算该哈希码在容器数组中的下标值
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

