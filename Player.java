import java.util.ArrayList;
public class Player
{
	private String name;
	private int turn;
	private int money;
	private boolean injail;
	public ArrayList<Card>list;
	private ArrayList<Railroad>rr;
	private ArrayList<Utility>u;
	private int pos;
	private String color;
	public Player(String name,String color)
	{
		this.name=name;
		this.color=color;
		money=1500;
		pos=0;
	}
	public void addMoney(int num)
	{
		money+=num;
	}
	public int getMoney()
	{
		return money;
	}
	public String getName()
	{
		return name;
	}
	public void setTurn(int num)
	{
		turn=num;
	}
	public int getTurn()
	{
		return turn;
	}
	public void addRailroad(Railroad x)
	{
		rr.add(x);
		money-=x.getPrice();
	}
	public void removeRailroad(String s)
	{
		for (int i=0;i<rr.size();i++)
		{
				if (rr.get(i).getName().equals(s))
				{
					money+=list.get(i).getPrice();
					rr.remove(i);
				}
		}
	}
	public void addUtility(Utility x)
	{
		u.add(x);
		money-=x.getPrice();
	}
	public void removeUtility(String s)
	{
		for (int i=0;i<u.size();i++)
		{
				if (u.get(i).getName().equals(s))
				{
					money+=list.get(i).getPrice();
					u.remove(i);
				}
		}
	}
	public void addCard(Card x)
	{
		list.add(x);
		money-=x.getPrice();
	}
	public void removeCard(String s)
	{
		for (int i=0;i<list.size();i++)
		{
				if (list.get(i).getName().equals(s))
				{
					money+=list.get(i).getPrice();
					list.remove(i);
				}
		}
	}
	public void mortgage(String s)
	{
		for (int i=0;i<list.size();i++)
		{
				if (list.get(i).getName().equals(s))
				{
					money+=list.get(i).mortgageValue();
					list.get(i).mortgage(true);
				}
		}
	}
	public void deMortgage(String s)
	{
		for (int i=0;i<list.size();i++)
		{
				if (list.get(i).getName().equals(s))
				{
					money-=list.get(i).mortgageValue();
					list.get(i).mortgage(false);
				}
		}
	}
	public void mortgageRR(String s)
	{
		for (int i=0;i<rr.size();i++)
		{
				if (rr.get(i).getName().equals(s))
				{
					money+=rr.get(i).mortgageValue();
					rr.get(i).mortgage(true);
				}
		}
	}
	public void deMortgageRR(String s)
	{
		for (int i=0;i<rr.size();i++)
		{
				if (rr.get(i).getName().equals(s))
				{
					money-=rr.get(i).mortgageValue();
					rr.get(i).mortgage(false);
				}
		}
	}
	public void mortgageUtility(String s)
	{
		for (int i=0;i<u.size();i++)
		{
				if (u.get(i).getName().equals(s))
				{
					money+=u.get(i).mortgageValue();
					u.get(i).mortgage(true);
				}
		}
	}
	public void deMortgageUtility(String s)
	{
		for (int i=0;i<u.size();i++)
		{
				if (u.get(i).getName().equals(s))
				{
					money-=u.get(i).mortgageValue();
					u.get(i).mortgage(false);
				}
		}
	}
	public void addPos(int num)
	{
		pos+=num;
	}
	public int getPos()
	{
		if(pos>=40)
		{
			pos-=40;
			addMoney(200);
		}
		return pos;
	}
	public void inJail(boolean b)
	{
		injail=b;
	}

}

