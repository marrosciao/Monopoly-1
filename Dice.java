import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
public class Dice
{
	private Image dieone;
	private Image dietwo;
	private Image diethree;
	private Image diefour;
	private Image diefive;
	private Image diesix;
	private int rollamount;
	public Dice()
	{
		rollamount=0;
		try
      	{
      		dieone=ImageIO.read(new File("dieone.jpg"));
      		dietwo=ImageIO.read(new File("dietwo.jpg"));
      		diethree=ImageIO.read(new File("diethree.jpg"));
      		diefour=ImageIO.read(new File("diefour.jpg"));
      		diefive=ImageIO.read(new File("diefive.jpg"));
      		diesix=ImageIO.read(new File("diesix.jpg"));

       	}
      	catch (IOException e){}
	}
	public Image [] roll()
	{
		int first=(int)(Math.random()*6+1);
		int second=(int)(Math.random()*6+1);
		Image [] arr=new Image[2];
		if (first==1)
			arr[0]=dieone;
		if (first==2)
			arr[0]=dietwo;
		if (first==3)
			arr[0]=diethree;
		if (first==4)
			arr[0]=diefour;
		if (first==5)
			arr[0]=diefive;
		if (first==6)
			arr[0]=diesix;
		if (second==1)
			arr[1]=dieone;
		if (second==2)
			arr[1]=dietwo;
		if (second==3)
			arr[1]=diethree;
		if (second==4)
			arr[1]=diefour;
		if (second==5)
			arr[1]=diefive;
		if (second==6)
			arr[1]=diesix;
		rollamount=first+second;
		return arr;
	}
	public int getRoll()
	{
		return rollamount;
	}
}
