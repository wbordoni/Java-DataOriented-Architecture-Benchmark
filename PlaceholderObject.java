package fr.croco.contiguous_access_benefits;

import java.util.Vector;

public class PlaceholderObject 
{
	protected Vector<Double> position;
	protected Vector<Double> velocity;
	private String label; 
	private static final double ANGLE = 0.2;
	
	public PlaceholderObject(Vector<Double> position, Vector<Double> velocity, String label) 
	{
		this.position = position;
		this.velocity = velocity;
		this.label = label;
	}
	
	@Override
	public  String toString()
	{
		return String.format("%s <%s %s>", label, position, velocity);
	}
	
	
	public static Vector<Double> getRandom3DVector()
	{

		Vector<Double> v = new Vector<Double>(3);
		
		v.add(Math.random() * 100.0);
		v.add(Math.random() * 100.0);
		v.add(Math.random() * 100.0);
		
		return v;
	}
	
}
