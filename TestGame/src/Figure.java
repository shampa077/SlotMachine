public abstract class Figure {
	protected String name;
	protected int figurevalue;
	public abstract void figureValue(int v);
	
    public abstract void setName(String n);
    public String getName()
    {
    	return name;
    }
    
    public int getFigureValue()
    {
    	return figurevalue;
    }
}
