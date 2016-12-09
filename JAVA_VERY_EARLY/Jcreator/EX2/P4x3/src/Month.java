
public class Month
{
	String error = "Please input a whole number 1-12";
	String feb = "Febuary";
	String jan = "January";
	String mar = "March";
	String apr = "April";
	String may = "May";
	String jun = "June";
	String jul = "July";
	String aug = "August";
	String sep = "September";
	String oct = "October";
	String nov = "November";
	String dec = "December";
    int mn;

    public Month(int month)
    {
		mn = month;
    }
    public String getMonth()
    {
    	if(mn>=1&mn<=12){
    		if(mn==1)
    		{
    			return jan;
    		}
    		if(mn==3)
    		{
    			return mar;
    		}
    		if(mn==4)
    		{
    			return apr;
    		}
    		if(mn==5)
    		{
    			return may;
    		}
    		if(mn==6)
    		{
    			return jun;
    		}
    		if(mn==7)
    		{
    			return jul;
    		}
    		if(mn==8)
    		{
    			return aug;
    		}
    		if(mn==9)
    		{
    			return sep;
    		}
    		if(mn==11)
    		{
    			return nov;
    		}
    		if(mn==12)
    		{
    			return dec;
    		}
    		if(mn==10)
    		{
    			return oct;
    		}
    		if(mn==2)
    		{
    			return feb;
    		}
    	}
    	else
    	{
    		return error;
    	}
    }
}