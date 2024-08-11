package com.DKP.rough;

import java.util.Scanner;

public class PrintMathsTable {

	Byte a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		byte b=100;
		b=b+10;
		*/
		
		/*
		String name="Ajay";
		String name1="dhar";
		String name2="pal";
		
		System.out.println(name.concat("Trainer"));
		
		System.out.println(name,name1,name2);
		
	*/
		/*
		int []a=new int[10];
		for(int i=1;i<=10;i++)	
		{
			a[i-1]=i;
		}
		
		for(int j=0;j<10;j++)
		{
			System.out.println("Array value is    "+a[j]);
		}	
		*/
		
		/*
		char c1='%';
		System.out.println(c1);
		int i4=c1;
		System.out.println(i4);
		
		int i=99;
		System.out.println(i);
		char c2= (char)i;
		System.out.println(c2);
		*/
		
		//System.out.println(new PrintMathsTable().a);
			
		//System.out.print("Enter the Number to Print its Table : ");
		//Scanner Scan= new Scanner(System.in);
		//String str=Scan.nextLine();
		//new PrintMathsTable().missingChar(str,1);
		//System.out.println(new PrintMathsTable().missingChar(str));
		System.out.println(new PrintMathsTable().OTPNUmber());
		
		//new PrintMathsTable().notString(str);
		//ystem.out.println("Inside Main Method---" + str);
		
		//int number=Integer.parseInt(Scan.nextLine());
	
		
		/*
		for(int i=1;i<=10;i++)
		{
			int result=number*i;
			System.out.println(number+"*"+i+"="+result);
			
		}
		*/
		/*
		int i=1;
		while(i<=10)
		{
			int result=number*i;
			System.out.println(number+"*"+i+"="+result);
			i++;
		}
		*/
	}
	
	public String notString(String str) {
		  if(str.length() >=3 && str.substring(0,3).equals("not"))
		  {
			  return str ;
		    
		  }
		  else
		  {
			  return "not"+str ;
		  }
		}

	
	public String missingChar(String str) {
		String  FrontSt=Character.toString(str.charAt(0));
		    	String  BackSt=Character.toString(str.charAt(str.length()-1));	    	
		    	String Mid=str.substring(1, str.length()-1);
		    	return BackSt+Mid+FrontSt ;
		    }

    public int OTPNUmber()
    {
    	int number=(int)(Math.random()*1000);
    	if (number>=1000)
    	{
    		return number;
    	}
    	else
    	{
    		return OTPNUmber();
    	}
    	
    }


    
    
    public void add() 
    {
    	System.out.println("inside Add method");
    	
    }
}
	


