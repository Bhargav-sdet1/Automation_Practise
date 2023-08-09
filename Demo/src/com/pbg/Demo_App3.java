package com.pbg;

public class Demo_App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num =12221;
		int rev =0;
		int orgNum=num;
		int reminder;
		
		while(num !=0)
		{
			reminder=num%10;
			rev=rev*10+reminder;
			num=num/10;			
		}
		System.out.println(rev);
		if(orgNum==rev) {
			System.out.println(rev+" is palindrome");
		}
		else
			System.out.println(rev+" is not a palindrome");	
	}

}
