package com.DKP.rough;
import java.util.*;
public class TreeMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap t= new TreeMap(new MyComparator());
		t.put("xxx",10);
		t.put("AAA",20);
		t.put("zzz",30);
		t.put("LLL",40);
		System.out.println(t);
	}

}

class MyComparator implements Comparator
{
	public int compare(Object obj1, Object obj2)
	{
		String s1= obj1.toString();
		String s2= obj2.toString();
		return s2.compareTo(s1);
	}
}

