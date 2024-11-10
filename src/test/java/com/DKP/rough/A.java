package com.DKP.rough;

public class A {
	
	public synchronized void foo(B b)
	{
		System.out.println("Thread1 Start execution foo");
		
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Inside Catch Block");
		}
		
		System.out.println("Thread1 trying to catch b's last()");
		b.last();
	}
	
	public synchronized void last()
	{
		System.out.println("Inside A This is last()");
	}

}
