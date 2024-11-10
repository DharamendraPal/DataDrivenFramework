package com.DKP.rough;

public class B {
	
	public synchronized void bar(A a)
	{
		System.out.println("Thread2 Start execution bar");
		
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Inside Catch Block");
		}
		
		System.out.println("Thread2 trying to catch a's last()");
		a.last();
	}
	
	public synchronized void last()
	{
		System.out.println("Inside B This is last()");
	}

}
