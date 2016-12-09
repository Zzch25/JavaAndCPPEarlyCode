import java.util.Random;

public class Dice
{
	private int roll;
	private int rollamount;

	public Dice()
	{
		rollamount = 6;
	}
	public Dice(int range)
	{
		rollamount = range;
	}
	public void roll()
	{
		Random generator = new Random();

		roll = generator.nextInt(rollamount);
		roll = roll+1;
	}
	public int getRoll()
	{
		return roll;
	}
}
