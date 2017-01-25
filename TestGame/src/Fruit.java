
public class Fruit extends ColouredFigure{
	private int typeval;
	private String type;
	private int catval;
	public Fruit(String ty,String color)
	{
		super(color); //set color
		type=ty; //set type
		catval=5;
		loadTypeVal(); //calculate value
		super.setName(this.getImage()); //set the value as figure name
		super.figureValue(typeval); //set the value as figure value 
	}
	public String getImage()
	{
		String name=type;
        name+=getColor();
		return name;
	}
	public int getCatVal()
	{
		return catval;
	}
	public void loadTypeVal()
	{
		if(type.equals("kiwi"))
			typeval=10;
		else if	(super.color.equals("Yellow") && type.equals("banana"))
			typeval=12;
		else if	(super.color.equals("Red") && type.equals("apple"))
			typeval=15;
		else if	(super.color.equals("Green") && type.equals("apple"))
			typeval=18;
		else
			typeval=0;
	}

}
