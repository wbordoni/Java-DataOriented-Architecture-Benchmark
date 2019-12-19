package fr.croco.contiguous_access_benefits;

import java.util.Vector;

public class PlaceholderArrayObject 
{
	private Vector<PlaceholderObject> data;
	
	
	
	public PlaceholderArrayObject(int size) 
	{
		data = new Vector<PlaceholderObject>(size);
		
		for (int i=0; i< size; i++)
		{
			data.add(new PlaceholderObject(PlaceholderObject.getRandom3DVector(), PlaceholderObject.getRandom3DVector(), "item"+i));		
		}
		
	}

	// Random bullshit sur les vector
	public void resourceHeavyMethod()
	{
		for (PlaceholderObject p : this.data)
		{
			this.rotateZ(p.position, 0.2);
			this.rotateZ(p.velocity, 0.3);
		}
	
	}
	
	private void rotateZ(Vector<Double> vector, double angle) 
	{ 
	
		double oldX = vector.get(0); 
		vector.set(0, (double)(vector.get(0) * Math.cos(angle) - vector.get(1) * Math.sin(angle)));
		vector.set(1, (double)(oldX * Math.sin(angle) + vector.get(1) * Math.cos(angle)) );
	}
	
	@Override
	public String toString()
	{
		String returnString = "";
		for (PlaceholderObject p : this.data)
			returnString += p.toString() + "\n";
		
		return returnString;
	}
	
	
}
