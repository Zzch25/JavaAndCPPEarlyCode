public class Paycheck
{
	double hours;
	double pph;

    public Paycheck(double hourw, double payperhour)
    {
    	hours = hourw;
    	pph = payperhour;
    }
    public double getPay()
    {
    	int pay;

    	if(hours>40)
    	{
    		return (40*pph)+((hours-40)*pph*1.5);
    	}
    	else
    	{
    		return 40*pph;
    	}
    }
}