import java.util.ArrayList;
public class Utility
{
	private String name;
	private static boolean bothowned;
	private boolean isMortgaged;
	private int mortgagevalue;
	public Utility(String name)
	{
		this.name=name;
		bothowned=false;
		mortgagevalue=75;
		isMortgaged=false;
	}
	public int rent(int num)
	{
		if (bothowned==true)
		{
			return (num*10);
		}
		else
			return (num*4);
	}
	public static void bothOwned(boolean b)
	{
		bothowned=b;
	}
	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return 150;
	}

	public int mortgageValue()
	{
		return mortgagevalue;
	}
	public void mortgage(boolean b)
	{
		isMortgaged=b;
	}

}