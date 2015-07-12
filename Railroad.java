import java.util.ArrayList;
public class Railroad
{
	private String name;
	private int price;
	private int mortgagevalue;
	private boolean isMortgaged;
	public Railroad(String name)
	{
		this.name=name;
		price=200;
		mortgagevalue=100;
		isMortgaged=false;
	}
	public int getPrice()
	{
		return 200;
	}
	public int getRentOne()
	{
		return 25;
	}
	public int getRentTwo()
	{
		return 50;
	}
	public int getRentThree()
	{
		return 100;
	}
	public int getRentFour()
	{
		return 200;
	}
	public void mortgage(boolean b)
	{
		isMortgaged=b;
	}
	public String getName()
	{
		return name;
	}
	public int mortgageValue()
	{
		return mortgagevalue;
	}

}