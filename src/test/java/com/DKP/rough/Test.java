package com.DKP.rough;


public class Test {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MyThread1 t=new MyThread1();
		//t.setDaemon(true);
		t.start();
		System.out.println("End of Main");
	}

}

class MyThread1 extends Thread
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("Lazy Thread");
		}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

