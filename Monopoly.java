import java.util.ArrayList;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
public class Monopoly
{
	public static void main (String args[])
	{
		MonopolyGame myFrame=new MonopolyGame();
		myFrame.setVisible(true);
		myFrame.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
		myFrame.setSize(1200,800);
	}
}
class MonopolyGame extends JFrame implements MouseListener
{
	private int state;
	private int statethreestate;
	private ArrayList<Card>deck;
	private Image monopolylogo;
	private Image startbutton;
	private Image board;
	private int numplayers;
	private ArrayList<Player>players;
	private int statetwostate;
	private Dice d;
	Scanner input;
	private int turn;
	private int position;
	private int position2;
	private int position3;
	private int position4;
	public MonopolyGame()
	{
		super();
		d=new Dice();
		numplayers=4;
		statethreestate=0;
		addMouseListener(this);
		deck=new ArrayList<Card>();
		state=1;
		turn=0;
		try
      	{
      		monopolylogo= ImageIO.read(new File("MONOPOLY LOGO.jpg"));
      		startbutton= ImageIO.read(new File("StartButton.jpg"));
      		board= ImageIO.read(new File("board.jpg"));
      		input=new Scanner(new File("properties.txt"));
		}
      	catch (Exception e){}
      	players=new ArrayList<Player>();
      	ArrayList<String>color=new ArrayList<String>();
      	color.add("BLUE");
      	color.add("RED");
      	color.add("GREEN");
      	color.add("YELLOW");
      	for (int i=1;i<=4;i++)
      	{
      		players.add(new Player("Player "+i,color.get(i-1)));
      	}
      	for (int k=0;k<22;k++)
		{
				String s=input.nextLine();
				int rent=input.nextInt();
				input.nextLine();
				int rent1=input.nextInt();
				input.nextLine();
				int rent2=input.nextInt();
				input.nextLine();
				int rent3=input.nextInt();
				input.nextLine();
				int rent4=input.nextInt();
				input.nextLine();
				int renthotel=input.nextInt();
				input.nextLine();
				int mortgagevalue=input.nextInt();
				input.nextLine();
				int housecost=input.nextInt();
				input.nextLine();
				int place=input.nextInt();
				input.nextLine();
				deck.add(new Card(s,mortgagevalue*2,rent,rent1,rent2,rent3,rent4,renthotel,housecost,place));
		}
      	statetwostate=0;
	}
	public void paint(Graphics g)
	{
		if (state==1)
		{
			startPage(g);
		}
		if (state==2)
		{
			state=3;
		}
		if (state==3)
		{
			drawFirstPart(g);
		}

	}
	public int numPlayers()
	{
		return 5;
	}
	public void drawFirstPart(Graphics g)
	{
			blankScreen(g);
			drawBoard(g);
			g.setColor(Color.RED);
			g.fillRect(25,25,100,75);
			int roll=0;
			g.setColor(Color.GREEN);
			g.fillRect(50,300,125,50);
			g.setColor(Color.RED);
			g.setFont(new Font("Arial Black",12,20));
			g.drawString(players.get(turn).getName(),70,330);
			Font b=new Font("Arial Black",12,25);
			g.setFont(b);
			g.setColor(Color.BLACK);
			g.drawString(players.get(turn).getMoney()+"$",50,400);
			int place=-1;
			if(statetwostate==1)
			{
				Image [] array=d.roll();
				g.setColor(Color.WHITE);
				roll=d.getRoll();
				g.drawString(""+roll,75,175);
				players.get(turn).addPos(roll);
				position=players.get(0).getPos();
				position2=players.get(1).getPos();
				position3=players.get(2).getPos();
				position4=players.get(3).getPos();
				drawPiece(g);
				turn++;
				if (turn==players.size())
				{
					turn=0;
				}
			}
			statetwostate=0;
			statethreestate=0;
			drawPiece(g);
	}
	public void drawPiece(Graphics g)
	{
		if (position<=10)
		{
			g.setColor(Color.BLUE);
			g.drawString("1",940-(position*57),675);
		}
		if (position2<=10)
		{
			g.setColor(Color.RED);
			g.drawString("2",940-(position2*57),675);
		}
		if (position3<=10)
		{
			g.setColor(Color.GREEN);
			g.drawString("3",940-(position3*57),675);
		}
		if (position4<=10)
		{
			g.setColor(Color.YELLOW);
			g.drawString("4",940-(position4*57),675);
		}
		if (position>10&&position<=20)
		{
			g.setColor(Color.BLUE);
			g.drawString("1",370,675-((position-10)*57));
		}
		if (position2>10&&position2<=20)
		{
			g.setColor(Color.RED);
			g.drawString("2",370,675-((position2-10)*57));
		}
		if (position3>10&&position3<=20)
		{
			g.setColor(Color.GREEN);
			g.drawString("3",370,675-((position3-10)*57));
		}
		if (position4>10&&position4<=20)
		{
			g.setColor(Color.YELLOW);
			g.drawString("4",370,675-((position4-10)*57));
		}
		if (position>20&&position<=30)
		{
			g.setColor(Color.BLUE);
			g.drawString("1",370+((position-20)*57),75);
		}
		if (position2>20&&position2<=30)
		{
			g.setColor(Color.RED);
			g.drawString("2",370+((position2-20)*57),75);
		}
		if (position3>20&&position3<=30)
		{
			g.setColor(Color.GREEN);
			g.drawString("3",370+((position3-20)*57),75);
		}
		if (position4>20&&position4<=30)
		{
			g.setColor(Color.YELLOW);
			g.drawString("4",370+((position4-20)*57),75);
		}
		if (position>30&&position<=40)
		{
			g.setColor(Color.BLUE);
			g.drawString("1",940,100+((position-30)*57));
		}
		if (position2>30&&position2<=40)
		{
			g.setColor(Color.RED);
			g.drawString("2",940,100+((position2-30)*57));
		}
		if (position3>30&&position3<=40)
		{
			g.setColor(Color.GREEN);
			g.drawString("3",940,100+((position3-30)*57));
		}
		if (position4>30&&position4<=40)
		{
			g.setColor(Color.YELLOW);
			g.drawString("4",940,100+((position4-30)*57));
		}
	}
	public void drawBoard(Graphics g)
	{
		g.drawImage(board,300,50,this);
	}
	public void startPage(Graphics g)
	{
		g.drawImage(monopolylogo,150,25,this);
		g.drawImage(startbutton,500,500,this);
	}
	public void blankScreen(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1200,800);
	}

	public void mouseEntered(MouseEvent e)
	{

	}
	public void mousePressed(MouseEvent e)
	{

	}
	public void mouseExited(MouseEvent e)
	{}
	public void mouseReleased(MouseEvent e)
	{

	}
	public void mouseClicked(MouseEvent e)
	{
		if (state==1&&e.getXOnScreen()>=500&&e.getXOnScreen()<=763&&e.getYOnScreen()>=500&&e.getYOnScreen()<=605)
		{
			state=2;
			repaint();
		}
		if(state==3&&statetwostate!=2&&e.getXOnScreen()>=25&&e.getXOnScreen()<=125&&e.getYOnScreen()>=25&&e.getYOnScreen()<=100)
		{
			statetwostate=1;
			repaint();
		}
		if(statetwostate==2&&e.getXOnScreen()>=1050&&e.getXOnScreen()<=1150&&e.getYOnScreen()>=650&&e.getYOnScreen()<=710)
		{
			statetwostate=0;
			repaint();
		}
		if(statetwostate==1&&statethreestate==2&&e.getXOnScreen()>=50&&e.getXOnScreen()<=300&&e.getYOnScreen()>=525&&e.getYOnScreen()<=575)
		{
			statethreestate=1;
		}
		else
		{
			repaint();
		}

	}
}
