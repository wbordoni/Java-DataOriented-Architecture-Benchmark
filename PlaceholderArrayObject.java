package fr.croco.contiguous_access_benefits;

import java.util.Vector;

public class PlaceholderArrayObject 
{
	static final Integer TEST_ITERATIONS = 10000;
	private Vector<PlaceholderObject> data;
	
	
	
	public PlaceholderArrayObject(int size) 
	{
		data = new Vector<PlaceholderObject>(size);
		
		for (PlaceholderObject p : data)
		{
			p =  new PlaceholderObject(PlaceholderObject.getRandom3DVector(), PlaceholderObject.getRandom3DVector(), "label");
			
		}
		
	}

	// Random bullshit sur les vector
	public void resourceHeavyMethod()
	{
		for (PlaceholderObject p : this.data)
		{
		for(int i=0; i<TEST_ITERATIONS; ++i)
			{
				this.rotateZ(p.position, Math.PI / 2);
				this.rotateZ(p.velocity, Math.PI / 3);
			}
		}
	
	}
	
	private void rotateZ(Vector<Double> vector, double angle) 
	{ 
	
		double oldX = vector.get(0); 
		vector.set(0, (double)(vector.get(0) * Math.cos(angle) - vector.get(1) * Math.sin(angle)));
		vector.set(1, (double)(oldX * Math.sin(angle) + vector.get(1) * Math.cos(angle)) );
	}
	
	public static Vector<Double> getRandom3DVector()
	{

		Vector<Double> v = new Vector<Double>(3);
		
		v.add(Math.random() * 100.0);
		v.add(Math.random() * 100.0);
		v.add(Math.random() * 100.0);
		
		return v;
	}
	
	@Override
	public String toString()
	{
		String returnString = "";
		for (PlaceholderObject p : this.data)
			returnString += p.toString();
		
		return returnString;
	}
	
	
}
