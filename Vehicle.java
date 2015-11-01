
public class Vehicle extends ColouredFigure{
	private int typeval;
	private String type;
	private int catval;
	public Vehicle(String ty,String color)
	{
		super(color); //set color
		type=ty; //set type
		catval=3;
		loadTypeVal(); //calculate value
		super.setName(this.getImage()); //set the value as figure name
		super.figureValue(typeval); //set the value as figure value 
	}
	public String getImage()
	{
		String name=getColor();
        name+=type;
		return name;
	}
	public int getCatVal()
	{
		return catval;
	}
	public void loadTypeVal()
	{
		if(type.equals("Taxi"))
			typeval=8;
		else if (type.equals("Truck"))
			typeval=5;
		else if	(super.color.equals("Yellow") && type.equals("Bus"))
			typeval=15;
		else if	(super.color.equals("Red") && type.equals("Bus"))
			typeval=20;
		else
			typeval=0;
	}
	

}
