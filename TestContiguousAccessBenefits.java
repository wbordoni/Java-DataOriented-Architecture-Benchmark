package fr.croco.contiguous_access_benefits;

import  java.util.Vector;

public class TestContiguousAccessBenefits 
{
	static final boolean DEBUG = true;
	static final int OBJECT_COUNT = 5;
	static long startTime, stopTime, elapsedTime;
	
	public static void main(String[] args) 
	{
		
		startTime = System.nanoTime();
		testWithObjectOrientedStructure();
		stopTime = System.nanoTime();
		printElapsedTime("testWithObjectOrientedStructure");
		
		startTime = System.nanoTime();
		testWithDataOrientedStructure();
		stopTime = System.nanoTime();
		printElapsedTime("testWithDataOrientedStructure");

	}
	
	public static void testWithObjectOrientedStructure()
	{
		Vector<PlaceholderSingleObject> myObjects = new Vector<PlaceholderSingleObject>(OBJECT_COUNT);
		
		for (PlaceholderSingleObject p: myObjects)
			p = new PlaceholderSingleObject(PlaceholderObject.getRandom3DVector(), PlaceholderObject.getRandom3DVector(), "item");
		
		for (PlaceholderSingleObject p : myObjects)
			p.resourceHeavyMethod();
		
		if (DEBUG)
			debugSingleObject(myObjects);

	}
	
	
	public static void testWithDataOrientedStructure()
	{
		PlaceholderArrayObject myObjectArray = new PlaceholderArrayObject(OBJECT_COUNT);
		myObjectArray.resourceHeavyMethod();
		
		if (DEBUG)
			debugArrayObject(myObjectArray);
		
	}

	public static void printElapsedTime(String msg)
	{
		elapsedTime = stopTime - startTime;
		System.out.printf("[ %s ] ", msg);
		System.out.printf("Execution time: %d ms\n", elapsedTime / 1000000);
	}
	
	public static void debugSingleObject(Vector<PlaceholderSingleObject> data)
	{
		for (PlaceholderSingleObject p : data)
			System.out.println(p);
	}
	
	public static void debugArrayObject(PlaceholderArrayObject data)
	{
		System.out.println(data);
	}
	

	
}
