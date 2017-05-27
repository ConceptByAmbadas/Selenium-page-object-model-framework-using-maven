package com.Info.MainTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Loop {
	int i=0;
	int n=5;

	
	//DateFormat dateformat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	static String dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime());
	 Calendar calobj = Calendar.getInstance();
	 //Calendar calobj = Calendar.getInstance();
    
	
	public void show()
	{
		try
		{
		/*for(i=0;i<=n;i++)
		{
			System.out.println("value of i:"+i);
			System.out.println("value of n:"+n);
			//break;
		}*/
		System.out.println("welcome");
		System.out.println("Date format is"+dateFormat);
		// System.out.println(dateFormat.format(calobj.getTime()));
		//System.out.println( new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) );
	}
		catch(Exception es)
		{System.out.println("Ex is"+es.getMessage());}
	}
	public void show1()
	{
		try
		{
		/*for(i=0;i<=n;i++)
		{
			System.out.println("value of i:"+i);
			System.out.println("value of n:"+n);
			//break;
		}*/
		System.out.println("welcome");
		System.out.println("Date format is"+dateFormat);
		//System.out.println( new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()) );
		}
		catch(Exception es)
		{System.out.println("Ex is"+es.getMessage());}
	}
	public static void main(String[] args) {
		
		Loop l=new Loop();
		l.show();
		l.show1();
		
		
		// TODO Auto-generated method stub

	}

}
