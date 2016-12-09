
public class Palindrone
{
    String reg = "";
	String rev = "";
	int sp = 0;

    public Palindrone()
    {
    }
    public boolean getStatus(String x, int space)
    {
		reg = x;
		rev = "";
		sp = space;

    	for(int i = 0; i<=(reg.length()-1); i++)//loops until a reversed string is created
    	{
    		if(sp == 0)//no spaces
    		{
    			reg = reg.replaceAll(" ", "");
				rev = rev + reg.substring((reg.length() - (i+1)),(reg.length() - i));
				rev = rev.replaceAll(" ", "");
    		}
    		else//spaces
    		{
				rev = rev + reg.substring((reg.length() - (i+1)),(reg.length() - i));
    		}
    	}
    	if(reg.equalsIgnoreCase(rev))
    	{
    		return true;
    	}
    	return false;
    }
    public String getReversed()
    {
    	return rev;
    }
    public String getRegular()
    {
    	return reg;
    }
    public int getSpace()
    {
    	return sp;
    }
}
//up to date: 925