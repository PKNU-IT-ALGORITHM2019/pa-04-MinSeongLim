import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
	public ArrayList<Log> list  = new ArrayList<Log>();
	int num = 0;
	
	public Controller()
	{
		exe();
	}
	
	private void exe()
	{		
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.print("$ ");
			String text = sc.nextLine();
			String[] arr = text.split(" ");
			
			if(arr.length!=1 && arr[0].compareTo("read")==0)
				read(arr[1]);			
			else if(arr[0].compareTo("print")==0)
				print();
			else if(arr.length!=1 && arr[0].compareTo("sort")==0 )
				sort(arr[1]);
			else if(text.compareTo("exit")==0)
				break;
			else
				System.out.println("Command Error");
		}
		sc.close();
	}

	private void sort(String c) {
		if(c.compareTo("-t")==0)
		{
			Collections.sort(list, (o1, o2) -> time_comparable(o1,o2));
			this.num = 0;
		}
		else if(c.compareTo("-ip")==0)
		{
			Collections.sort(list, (o1, o2) -> ip_comparable(o1,o2));		
			this.num = 1;
		}
	}
			
	private int ip_comparable(Log o1, Log o2)
	{
		if(o1.IP.compareTo(o2.IP)>0)
			return 1;
		else if(o1.IP.compareTo(o2.IP)<0)
			return -1;
		else
			return time_comparable(o1,o2);	
	}
	
	private int time_comparable(Log o1, Log o2)
	{
		if(o1.Time > o2.Time)
			return 1;
		else if(o1.Time < o2.Time)
			return -1;
		else
			return 0;
	}

	private void print() {
		Iterator<Log> it = list.iterator();
		while(it.hasNext())
		{			
			Log log = it.next();
			if(this.num==0)
				log.print_time();
			else
				log.print_ip();
		}		
	}
	
	private void read(String file) {
		try {
			Scanner sc = new Scanner(new File(file));
			sc.nextLine();
			while(sc.hasNext())
			{				
				String line = sc.nextLine();				
				String[] arr = line.split(",");
				list.add(new Log(arr));	
			}
			sc.close();
		} catch (FileNotFoundException e) {
		}		
	}	

}
