package fr.croco.contiguous_access_benefits;


public class TestContiguousAccessBenefits 
{
	static final boolean DEBUG = false;
	static final int OBJECT_COUNT = 512000;
	static long startTime, stopTime, elapsedTime;
	
	public static void main(String[] args) 
	{
		
		// Object Oriented Structure
		testWithObjectOrientedStructure();
		printElapsedTime("testWithObjectOrientedStructure");
		
		// Data Oriented Structure
		testWithDataOrientedStructure();
		printElapsedTime("testWithDataOrientedStructure");

	}
	
	public static void testWithObjectOrientedStructure()
	{
		PlaceholderSingleObject[] myObjects = new PlaceholderSingleObject[OBJECT_COUNT];
		
		for (int i=0; i<OBJECT_COUNT; i++)
			myObjects[i] = new PlaceholderSingleObject("item"+i);
		
		
		startTime = System.nanoTime();
		for (PlaceholderSingleObject p : myObjects)
			p.resourceHeavyMethod1();
		for (PlaceholderSingleObject p : myObjects)
			p.resourceHeavyMethod2();
		stopTime = System.nanoTime();
		
		if (DEBUG)
			debugSingleObject(myObjects);

	}
	
	
	public static void testWithDataOrientedStructure()
	{
		PlaceholderArrayObject myObjectArray = new PlaceholderArrayObject(OBJECT_COUNT);
		
		startTime = System.nanoTime();
		myObjectArray.resourceHeavyMethod1();
		myObjectArray.resourceHeavyMethod2();
		stopTime = System.nanoTime();
		
		if (DEBUG)
			debugArrayObject(myObjectArray);
		
	}

	public static void printElapsedTime(String msg)
	{
		elapsedTime = stopTime - startTime;
		System.out.printf("[ %s ] ", msg);
		System.out.printf("Execution time: %d ms\n", elapsedTime / 1000000);
	}
	
	
	public static void debugSingleObject(PlaceholderSingleObject[] data)
	{
		for (PlaceholderSingleObject p : data)
			System.out.println(p);
		System.out.println();
	}
	
	public static void debugArrayObject(PlaceholderArrayObject data)
	{
		System.out.println(data);
		System.out.println();
	}
	

	
}
