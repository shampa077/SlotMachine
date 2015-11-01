
public class ColouredFigure extends Figure{
	protected String color;
	public ColouredFigure(String col){
		color=col;
	}
	public void figureValue(int v)
	{
		super.figurevalue=v;
	}
	public void setName(String n)
	{
		super.name=n;
	}
	public String getColor()
	{
			return color;
	}

}
