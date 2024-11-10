package com.DKP.rough;

public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t=new MyThread();
		t.start();
		t.run(1);
		t.run();
		t.start(5);
		for(int i=0;i<=10;i++)
		{
			System.out.println("Main Thread");
		}
	}
}

class MyThread extends Thread {
	
	//Overriding Start Method
	
	public void start()
	{
		
		System.out.println("Overriding Start Method");
	}
	
	public void start(int l)
	{
		
		System.out.println("OverLoad Start Method"+l);
	}
	
	public void run()
	{
		//super.start();
		for(int i=0;i<=10;i++)
		{
			System.out.println("Executing Child Thread");
		}
	}
	//Overloading of Run Method
	public void run(int k)
	{
		for(int i=0;i<=k;i++)
		{
			System.out.println("Executing Argument overloaded Run method");
		}
	}
	
}


