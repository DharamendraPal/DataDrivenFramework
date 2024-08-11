package com.DKP.rough;

public class ThreeDimArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintMathsTable pt=new PrintMathsTable();
		pt.add();
		
		
		/*
		int[][][]arr=new int[2][3][4];
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				for(int k=0;k<arr[i][j].length;k++)
				{
					//int number=(int)(Math.random()*1000);
					//System.out.println(number);
					arr[i][j][k] = (int)(Math.random()*1000);
					System.out.println(arr[i][j][k]);
				}
			}
		}	
		 */
		
		/*
		ThreeDimArrays[] arr=new ThreeDimArrays[3];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=new ThreeDimArrays();
			System.out.println(arr[i]);
		}
		*/
		/*
		int[] array4=new ThreeDimArrays().addArrays();
		for(int k=0;k<array4.length;k++)
		{
			System.out.println(array4[k]); 
		}
		*/
		String[] arr=new String[10];
		arr[0]="Dharmendra";
		System.out.println(arr[0]);
		
		
		
	}
	
	
	public int[] addArrays()
	{
		int[] array1= {1,2,3,4,5};
		int[] array2= {11,12,13,14,15};
		int[] array3= new int[5];
		for(int i=0;i<array1.length;i++)
		{
			array3[i]=array1[i]+array2[i];
		}
		return array3;
	}

	
	
	
}
