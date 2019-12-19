package fr.croco.contiguous_access_benefits;

import java.util.Vector;

public class PlaceholderSingleObject 
{
	static final Integer TEST_ITERATIONS = 10000;
	private PlaceholderObject data;
	
	public PlaceholderSingleObject(Vector<Double> position, Vector<Double> velocity, String label) 
	{
		this.data = new PlaceholderObject(position, velocity, label);
	}

	
	// Random bullshit sur les vector
	public void resourceHeavyMethod()
	{
		for(int i=0; i<TEST_ITERATIONS; ++i)
		{
			this.rotateZ(this.data.position, Math.PI / 2);
			this.rotateZ(this.data.velocity, Math.PI / 3);
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
			return this.data.toString();
	}
	

}
