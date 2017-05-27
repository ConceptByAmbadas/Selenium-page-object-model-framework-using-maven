package com.Info.Utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.Info.TestBase.TestBase;

public class Demo_Window_Handler extends TestBase{
	
	List<String>  windowId=new ArrayList<String>();
	@Test
	public void TestAllWindow()
	{
		Iterator<String> itr=getAllWindowhandle();
		System.out.println("All window"+itr);
		while(itr.hasNext())
		{
			windowId.add(itr.next());
		}
		Driver.Instance.switchTo().window(windowId.get(0));
	}

}
