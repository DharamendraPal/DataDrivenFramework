package com.DKP.rough;

import java.util.ArrayList;

public class GenericNonGeneric {
	public static void main(String[] args) {
		ArrayList<String> l=new ArrayList<String>();
		l.add("A");
		//l.add(10);
		method1(l);
		System.out.println(l);
	}
	
	
	public static void method1(ArrayList l )
	{
		l.add(0);
		l.add(10.5);
		l.add(true);
	}

}
