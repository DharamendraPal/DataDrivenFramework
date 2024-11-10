package com.DKP.rough;

public class DeadLock  extends Thread {

	A a=new A();
	B b=new B();
	
	DeadLock()
	{
		this.start();
		a.foo(b);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		b.bar(a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DeadLock();
	}

}
