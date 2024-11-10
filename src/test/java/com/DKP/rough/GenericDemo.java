package com.DKP.rough;

public class GenericDemo {
	public static void main(String[] args) {
		
		MyOwnGeneric<String> G1=new MyOwnGeneric<String>("Dharmendra");
		G1.show();
		System.out.println(G1.getObject());
		
		
		MyOwnGeneric<Integer> G2=new MyOwnGeneric<Integer>(10);
		G2.show();
		System.out.println(G2.getObject());
	}
}


class MyOwnGeneric<T> 
{
	T obj;
	MyOwnGeneric(T obj)
	{
		this.obj=obj;
	}
	
	public void show()
	{
		System.out.println("The Type of Object is"+obj.getClass().getName());
	}
	
	public T getObject()
	{
		return obj;
	}
}