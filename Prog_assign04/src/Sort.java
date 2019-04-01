import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
	
	ArrayList<int[]> list;
	int[] arr;

	public Sort()
	{
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("		Random1000		Reverse1000		Random10000		Reverse10000		Random100000		Reverse100000");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		exe();
	}
	
	public void exe()
	{
		create_array();
		heap_time();
		lib_time();
	}
	
	private void get_time(double time)
	{
		System.out.printf("%.5fsec		",(System.currentTimeMillis() - time) / 1000);
	}
	
	private void create_array()
	{
		list = new ArrayList<int[]>();
		int k = 1000;
		
		int i = 0;
		while(i<6)
		{
			list.add(new int[k]);
			for(int j = 0 ; j<k ; j++)			
				list.get(i)[j] = ((int)(Math.random()*(k-1)) +1);
			i++;
			list.add(new int[k]);
			for(int j = 0 ; j<k; j++)
				list.get(i)[j] = k-1-j;
			i++;
			k *= 10;
		}		
	}
	
	private void lib_time() {
		System.out.print("Library Sort	");
		for(int i = 0 ; i<6; i++)
		{
			arr = list.get(i).clone();
			long time = System.currentTimeMillis();
			Arrays.sort(list.get(i));
			get_time(time);
		}
		System.out.println("\n");
	}
	
	private void heap_time() {
		System.out.print("Heap Sort	");
		for(int i = 0 ; i<6; i++)
		{
			arr = list.get(i).clone();
			long time = System.currentTimeMillis();
			heap_sort(arr);
			get_time(time);
		}
		System.out.println("\n");
	}

	private void heap_sort(int[] arr)
	{
		int n = arr.length;
		for(int i = (n/2 -1) ; i>=0 ; i--)
			heapify(arr, n, i);
		
		for(int i  = n-1; i>0 ; i--)
		{
			swap(arr,0,i);
			heapify(arr,i,0);
		}
	}

	private void heapify(int[] arr, int n, int i) {
		int p = i;
		int q = i*2 +1;
		int r = i*2 +2;
		
		if(q < n && arr[p] < arr[q])
			p = q;
		if(r < n && arr[p] < arr[r])
			p = r;
		if(i != p)
		{
			swap(arr,p,i);
			heapify(arr,n,p);
		}		
	}

	private void swap(int[] arr, int p, int i) {
		int tmp = arr[p];
		arr[p] = arr[i];
		arr[i] = tmp;		
	}	
}