package fr.croco.contiguous_access_benefits;


public class PlaceholderSingleObject 
{
	private PlaceholderObject data;
	
	public PlaceholderSingleObject(String label) 
	{
		this.data = new PlaceholderObject(label);
		this.randomFill();
	}

	
	// Random bullshit sur les vector
	public void resourceHeavyMethod1()
	{
		this.rotateZ(this.data.position, 0.2);
	}
	
	
	public void resourceHeavyMethod2()
	{

		this.rotateZ(this.data.velocity, 0.3);
	}
	
	private void rotateZ(Double[] v, double angle) 
	{ 
		double oldX = v[0]; 
		v[0] = (double)(v[0] * Math.cos(angle) - v[1] * Math.sin(angle));
		v[1] = (double)(oldX * Math.sin(angle) + v[1] * Math.cos(angle));
	}
	
	@Override 
	public String toString()
	{
			return this.data.toString();
	}
	
	public Double getRandomDouble()
	{
		return new Double(Math.random() * 50.0);
	}
	
	private void randomFill() 
	{
		for (int i=0; i<3; i++)
		{
			this.data.position[i] = getRandomDouble();
			this.data.velocity[i] = getRandomDouble();
		}
	
	}


}
