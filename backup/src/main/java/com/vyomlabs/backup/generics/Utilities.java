package com.vyomlabs.backup.generics;

public class Utilities {

	public static void SleepInsecsoncds(long Seconds)
	{
		try {
			Thread.sleep(Seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String ConvertToInterger(String ProductId)
	{
		return ProductId.substring(0, 1);
	}
}
