package fr.croco.contiguous_access_benefits;

import java.util.Vector;

public class PlaceholderArrayObject 
{
	private double[][] position;
	private double[][] velocity;
	private String[] label;
	private int toProcess;
	
	
	
	public PlaceholderArrayObject(int size) 
	{
		this.toProcess = size;
		this.position = new double[size][3];
		this.velocity = new double[size][3];
		this.label = new String[size];
		
		for (int i=0; i< this.toProcess; i++)
		{
			this.label[i] = "item"+i;
			for (int j=0; j<3; j++)
			{
				this.randomFill(this.position[i]);
				this.randomFill(this.velocity[i]);
			}
		}

		
	}

	// Random bullshit sur les vector
	public void resourceHeavyMethod1()
	{

		this.rotateZ(this.position, 0.2);

	}
	
	public void resourceHeavyMethod2()
	{

		this.rotateZ(this.velocity, 0.3);

	}
	
	
	
	private void rotateZ(double[][] v, double angle) 
	{ 
	
		for (int i=0; i<this.toProcess; i++)
		{
			double oldX = v[i][0]; 
			v[i][0] = (double)(v[i][0] * Math.cos(angle) - v[i][1] * Math.sin(angle));
			v[i][1] = (double)(oldX * Math.sin(angle) + v[i][1] * Math.cos(angle));
		}
	}
	
	@Override
	public String toString()
	{
		String returnString = "";
		for (int i=0; i<this.toProcess; i++)
			returnString += String.format("%s <(%05.3f, %05.3f, %05.3f), (%05.3f, %05.3f, %05.3f)>\n", 
			this.label[i], this.position[i][0], this.position[i][1], this.position[i][2], this.velocity[i][0], this.velocity[i][1], this.velocity[i][2]);
		
		return returnString;
	}
	
	private void randomFill(double[] v) 
	{
		for (int i=0; i<3; i++)
		{
			v[i] = new Double(Math.random() * 50.0);
		}
	}
	
	
}
