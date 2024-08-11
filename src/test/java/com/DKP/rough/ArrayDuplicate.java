package com.DKP.rough;

import java.util.HashSet;
import java.util.Set;

public class ArrayDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		// Logic Implementted using two For loops
		int[] arr= {1,2,3,3,2,1,2,4};
		boolean[] DuplicateCounted=new boolean[arr.length];
		int UniqueDuplicatecount=0;
		int[] UniqueElement=new int[5];
		
		for(int i=0;i<arr.length;i++)
		{
			if(DuplicateCounted[i]) 
			{
				continue;
			}
			boolean isDuplicate=false;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					isDuplicate=true;
					DuplicateCounted[j]=true;
					
				}
			}
			
			if(isDuplicate)
			{
				UniqueDuplicatecount++;
				UniqueElement[i]=arr[i];
				DuplicateCounted[i]=true;
			}
			
		}
		System.out.println("Number of Duplicate Element is---"+UniqueDuplicatecount);
		for(int k=0;k<UniqueElement.length;k++)
		{
			System.out.println(UniqueElement[k]);
		}
		 	
	
		/*
		//Implemented Using Sets Collections
		int[] arr = {1, 2, 3, 3, 2, 1, 2, 4};
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Number of Unique Duplicate Elements is---" + duplicates.size());
        for (int dup : duplicates) {
            System.out.println(dup);
        }
        
        */
    }		
	
	}
	