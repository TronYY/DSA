public class InsertionSort {
	static char[] a=new char[]{'A','C','Y','O','B'};
	public static void insertionSort(char[] a){
		int n=a.length;
		for (int i=1;i<n;i++){
			char cur=a[i];
			int j=i-1;
			while ((j>=0)&&(a[j]>cur)){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=cur;
		}
	}
	public static void output(char[] a,String s){
		System.out.print(s+":");
		for (int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		output(a,"Before Sorting:");
		insertionSort(a);
		output(a,"After Sorting:");
	}

}
