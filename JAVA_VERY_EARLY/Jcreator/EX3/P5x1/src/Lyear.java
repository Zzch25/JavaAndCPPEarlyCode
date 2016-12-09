
public class Lyear
{
	int year;

    public Lyear(int inpyear)
    {
    	year=inpyear;
    }
    public boolean getLy()
    {
    	if(year % 100 == 0)
    	{
    		return false;
    	}
    	else if(year % 4 == 0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}