
public class cTest
{
	String inp;
	String l1;
	String l2;

    public cTest(String in)
    {
    	inp=in;
    	l1=inp.substring(0,1);
    	l2=inp.substring(1);
    }
    public String getAnswer()
    {
    	if(l1.equals("A"))
    	{
    		l1 = "Ace";
    	}
    	else if(l1.equals("K"))
    	{
    		l1 = "King";
    	}
    	else if(l1.equals("Q"))
    	{
    		l1 = "Queen";
    	}
    	else if(l1.equals("J"))
    	{
    		l1 = "Jack";
    	}
    	else if(!l1.equals("2")&!l1.equals("3")&!l1.equals("4")&!l1.equals("5")&!l1.equals("6")&!l1.equals("7")&!l1.equals("8")&!l1.equals("9")&!l1.equals("10"))
    	{
    		l1 = "Unknown";
    		l2 = "";
    	}

		if(!l1.equals("Unknown"))
		{
			if(l2.equals("D"))
			{
				l2 = " of Diamonds";
			}
			else if(l2.equals("H"))
			{
				l2 = " of Hearts";
			}
			else if(l2.equals("C"))
			{
				l2 = " of Clubs";
			}
			else if(l2.equals("S"))
			{
				l2 = " of Spades";
			}
			else
			{
				l1 = "Unknown";
				l2 = "";
			}
    	}
    	return l1+l2;
	}
}