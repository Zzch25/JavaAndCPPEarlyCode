import java.util.ArrayList;

public class P7x3
{
    public static void main(String[] args)
    {
    	int low = 0;
    	int high = 0;

    	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

		accounts.add(new BankAccount(5));
		accounts.add(new BankAccount(10));
		accounts.add(new BankAccount(25));
		accounts.add(new BankAccount(15));
		accounts.add(new BankAccount(20));

		for(int i=0; i<accounts.size(); i++)
		{
			if(low == 0 | low > accounts.get(i).getAccountNumber())
			{
				low = accounts.get(i).getAccountNumber();
			}
			if(high == 0 | high < accounts.get(i).getAccountNumber())
			{
				high = accounts.get(i).getAccountNumber();
			}
		}
		System.out.print("The lowest value is ");
		System.out.println(low);
		System.out.print("The highest value is ");
		System.out.println(high);
    }
}
