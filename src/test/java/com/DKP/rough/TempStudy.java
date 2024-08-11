package com.DKP.rough;

import java.util.Scanner;

public class TempStudy {

	static int toy;
	int a100=45;
	int b100=67;
	public static TempStudy t;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int i1=20;
		//i1=--i1; //Here are not first incrementing hte value thne program execution flow comes to left side 
		//and once program flow comes to left side it will come to right side and further code execution continue
		//System.out.println(i1);
		//System.out.println(i1);
		
		/*
		int i=200;
		int j=200;
		Scanner Scan= new Scanner(System.in);
		Scan.nextLine();
		System.out.println(i%j);
		
		//System.out.println(i==j);
		//System.out.println(i);
		
		/*
		short s=10;
		char c='a';
		System.out.println(s+c);
		
		
		/*
		String st1="Rahul";
		String st2="Rahul";
		
		System.out.println(st1);
		System.out.println(st2);
		

		System.out.println(st1+","+st2);
		System.out.println(st1+st2);
		
		//Finding Largest Three Number using ternory Operator
		int a=1000;
		int b=4000;
		int c=900;
		System.out.println((a>b)?((a>c)?"A is Largest Number ":"C is Largest Number "):((b>c)?"B is Largest NUmber":"C is Largest Number"));
		*/
		
		//TempStudy t=new TempStudy();
		
		
		//int Result=Summation1(10, 20);
		TempStudy t=Summation1(10,20);
		int Result =t.Summation(80, 20);
		t.printSumresult(Result);
		
		
		
	}
	
	public int Summation(int a ,int b) 
	{
		
		
		int sum=a+b;
		return sum;//Simply writing return statement does not mean that method will return its value. We have write Return data type also 
		//in method name along with return statement then only it will return data
		
		//TempStudy t=new TempStudy();
		//t.printSumresult(sum);
		
		
	}
	
	public static TempStudy Summation1(int a,int b) 
	{
		/*Here we are making object of main class TempStudy in this method "Summation1" and returning this Class object from this method
		 * so we have kept method return Type as Class Name.
		 * 
		 * Queries: in this scenario, Can we keep method return type as Object???????
		 * */
		
		TempStudy t=new TempStudy();
		
		//t.printSumresult(sum);
		return t ;
	}
	
	public void printSumresult(int d)
	{
		
		System.out.println(d);
		
	}

}
