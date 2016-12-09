import java.lang.Math;

public class Calc
{
    double sum;
    double dif;
    double mul;
    double quo;
    double avg;
    double dis;
    double maxi;
    double mini;

    public Calc()
    {
    	sum=0;
    	dif=0;
    	mul=0;
    	quo=0;
    	avg=0;
    	dis=0;
    	maxi=0;
    	mini=0;
    }
    public void calculate(double one, double two)
    {
    	sum = one+two;
    	dif=one-two;
    	mul=one*two;
    	quo=one/two;
    	avg=(one+two)/2;
    	dis=abs(dif);
		mini=min(one, two);
		maxi=max(one,two);
    }
    public double getSum()
    {
		return sum;
    }
    public double getDifference()
    {
		return dif;
    }
    public double getProduct()
    {
    	return mul;
    }
    public double getQuotient()
    {
		return quo;
    }
    public double getAverage()
    {
		return avg;
    }
    public double getDistance()
    {
		return dis;
    }
    public double getMaximum()
    {
		return maxi;
    }
    public double getMinimum()
    {
		return mini;
    }
}