
public class Sign extends ColouredFigure{
	private int typeval;
	private String type;
	private int catval;
	public Sign(String ty)
	{
		super(new String("")); //set no color
		type=ty; //set type
		catval=80;
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
		if(type.equals("asterisk"))
			typeval=40;
		else if(type.equals("dollar"))
			typeval=100;
		else
			typeval=0;
	}

}
