import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
public class Card
{
private Image img;
private String name;
private boolean allcardsarecontained;
private boolean isMortgaged;
private int value;
private int numhouses;
private int housecost;
private int mortgagevalue;
private int rent;
private int rentwithonehouse;
private int rentwithtwohouse;
private int rentwiththreehouse;
private int rentwithfourhouse;
private int rentwithhotel;
private boolean ishotel;
public static boolean isowned;
private int position;
public Card(String str,int value,int rent, int rentwithonehouse,int rentwithtwohouse,int rentwiththreehouse,int rentwithfourhouse,int rentwithhotel,int housecost,int position)
{
		name=str;
		numhouses=0;
		this.value=value;
		this.rent=rent;
		this.rentwithonehouse=rentwithonehouse;
		this.rentwithtwohouse=rentwithtwohouse;
		this.rentwiththreehouse=rentwiththreehouse;
		this.rentwithfourhouse=rentwithfourhouse;
		this.rentwithhotel=rentwithhotel;
		isowned=false;
		this.housecost=housecost;
		this.position=position;
}
public int getPosition()
{
	return position;
}
public void addhouse(int number)
{
	if (numhouses==4)
		addHotel();
	if(numhouses<4)
		numhouses++;
}
public void addHotel()
{
		ishotel=true;
}
public int rent()
{
	if (ishotel)
	{
		return rentwithhotel;
	}
	else if(numhouses==1)
	{
		return rentwithonehouse;
	}
	else if(numhouses==2)
	{
		return rentwithtwohouse;
	}
	else if(numhouses==3)
	{
		return rentwiththreehouse;
	}
	else if(numhouses==4)
	{
		return rentwithfourhouse;
	}
	else if(allcardsarecontained)
	{
		return rent*2;
	}
	else
		return rent;
}
public void areCards(boolean b)
{
	allcardsarecontained=b;
}
public int mortgageValue()
{
	return mortgagevalue;
}

public int getPrice()
{
	return value;
}
public String getName()
{
	return name;
}
public void mortgage(boolean b)
{
	isMortgaged=b;
}
public void isOwned(boolean b)
{
	isowned=b;
}
public boolean itisOwned()
{
	return isowned;
}
}
