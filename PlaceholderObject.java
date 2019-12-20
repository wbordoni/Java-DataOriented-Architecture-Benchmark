package fr.croco.contiguous_access_benefits;


public class PlaceholderObject 
{
	protected Double[] position;
	protected Double[] velocity;
	private String label; 
	
	public PlaceholderObject(String label) 
	{
		position = new Double[3];
		velocity = new Double[3];
		this.label = label;		
	}
	
	@Override
	public  String toString()
	{
		return String.format("%s <(%05.3f, %05.3f, %05.3f), (%05.3f, %05.3f, %05.3f)>", label, position[0], position[1], position[2], velocity[0], velocity[1], velocity[2] );
	}
	
	
}
