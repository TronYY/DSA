//��Ծ���д洢��ÿ��Ԫ��ʵ����

public class SkipListEntry {
	public String key;
	public Integer value;

	public int pos; //��ҪΪ�˴�ӡ ������

	public SkipListEntry up, down, left, right; // �������� �ĸ�ָ��

	public static String negInf = new String("-oo"); // ������
	public static String posInf = new String("+oo"); // ������

	public SkipListEntry(String k, Integer v) {
		key = k;
		value = v;

		up = down = left = right = null;
	}

	public Integer getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	public Integer setValue(Integer val) {
		Integer oldValue = value;
		value = val;
		return oldValue;
	}

	public boolean equals(Object o) {
		SkipListEntry ent;
		try {
			ent = (SkipListEntry) o; // �������
		} catch (ClassCastException ex) {
			return false;
		}
		return (ent.getKey() == key) && (ent.getValue() == value);
	}

	public String toString() {
		return "(" + key + "," + value + ")";
	}
}