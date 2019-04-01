import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Log {
	String IP;
	long Time;
	String URL;
	String Status;
	
	public Log(String[] arr)
	{
		this.IP = arr[0];
		this.URL = arr[2];
		this.Status = arr[3];
		String text = arr[1].substring(1);		
		try {
			this.Time = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss",new Locale("en", "US")).parse(text).getTime();
		} 
		catch (ParseException e)
		{}		
	}
	
	public void print_ip()
	{		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss",new Locale("en", "US"));
		System.out.println(IP);
		System.out.println("	" + sdf.format(Time));
		System.out.println("	" + URL);
		System.out.println("	" + Status+"\n");			
	}
	
	public void print_time()
	{		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss",new Locale("en", "US"));
		System.out.println(sdf.format(Time));
		System.out.println("	" + IP);		
		System.out.println("	" + URL);
		System.out.println("	" + Status+"\n");			
	}
}
