package com.DKP.rough;

public class DB_Driver {
	
	//System.out.println("Inside Class");
	public void getDriver()
	{
		System.out.println("Type-1 Driver");
	}
}

class New_DB_Driver extends DB_Driver {
	
	@Override
	public void getDriver()
	{
		System.out.println("Type -4 Driver");
	}
}

class TestOverrideAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//New_DB_Driver t=new New_DB_Driver();
		DB_Driver t=new New_DB_Driver();
		
		t.getDriver();
			
	}

}
