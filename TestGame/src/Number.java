public class Number extends ColouredFigure{
	private int typeval;
	private String type;
	private int catval;
	public Number(String ty)
	{
		super(new String("")); //set no color
		type=ty; //set type
		catval=8;
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
		if(type.equals("1"))
			typeval=10;
		else if(type.equals("2"))
			typeval=20;
		else if(type.equals("3"))
			typeval=30;
		else
			typeval=0;
	}

}
