//Mon Feb 25 14:33:22 PST 2013
//Trail.java
//This program will utilize the key listener in java.awt.event in order to create a game
//where the user uses keys to guide a "snake". The snake leaves a trail, and over time, some
//of the trail fades.

//Class variables:

//Methods:

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Trail
{
  JFrame frame;
	TrailPanel tp;
	public static void main ( String [] args )
	{
		Trail oregon = new Trail();
		oregon.start();
	}//end main
	public void start()
	{
		frame = new JFrame ( "Trail Game" );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize( 500 , 500 );
		frame.setLocation(500,100);
		frame.setVisible(true);
		tp = new TrailPanel();
		tp.setSize(500,500);
		frame.addKeyListener(tp);
		frame.getContentPane().add(tp, BorderLayout.CENTER);
	}
}//end class
class TrailPanel extends JPanel implements KeyListener
{
	int [] xcoordinates;
	int [] ycoordinates;
	int [] color = new int [101];
	int xloc;
	int yloc;
	int counter;
	int colorCounter;
	public TrailPanel()
	{
		counter = 0;
		colorCounter = 0;
		xloc = 248;
		yloc = 248;
		xcoordinates = new int [ 5000 ];
		ycoordinates = new int [ 5000 ];
		xcoordinates[counter] = xloc;
		ycoordinates[counter] = yloc;
		for ( int i = 0; i < 100; i++ )
		{
			color[i] = (100 - i) * 2;
		}
	}
	public void paintComponent(Graphics g )
	{
		super.paintComponent(g);
		setBackground(Color.white);
		g.setColor(Color.black);
		if ( counter <= 100 )
		{
			for ( int i = 0; i < counter + 1; i++ )
			{
				g.setColor(new Color((counter-i) * 2,(counter-i) * 2,(counter-i) * 2));
				g.fillRect(xcoordinates[i],ycoordinates[i],5,5);
			}
		}
		else
		{
			for ( int i = counter - 100; i < counter + 1; i++ )
			{
				g.setColor(new Color(color[colorCounter],color[colorCounter],color[colorCounter]));
				g.fillRect(xcoordinates[i],ycoordinates[i],5,5);
				colorCounter++;
			}
			colorCounter = 0;
		}
	}
	public void keyPressed ( KeyEvent e )
	{
		char key = e.getKeyChar();
		if ( key == 'w')
		{
			yloc-=5;
			if ( yloc >= 0 )
				counter++;
			else
				yloc = yloc + 5;
				
		}
		else if ( key == 'a')
		{
			xloc-=5;
			if ( xloc >= 0 )
				counter++;
			else
				xloc = xloc + 5;
		}
		else if ( key == 'x')
		{
			yloc+=5;
			if ( yloc <= 500 )
				counter++;
			else
				yloc = yloc - 5;
		}
		else if ( key == 'd')
		{
			xloc+=5;
			if ( xloc <= 500 )
				counter++;
			else
				xloc = xloc - 5;
		}
		else if ( key == 'q')
		{
			xloc-=5;
			yloc-=5;
			if ( xloc >= 0 && yloc >= 0 )
				counter++;
			else
			{
				xloc = xloc + 5;
				yloc = yloc + 5;
			}
		}
		else if ( key == 'e')
		{
			xloc+=5;
			yloc-=5;
			if ( xloc <= 500 && yloc >= 0 )
				counter++;
			else
			{
				xloc = xloc - 5;
				yloc = yloc + 5;
			}
		}
		else if ( key == 'z')
		{
			xloc-=5;
			yloc+=5;
			if ( xloc >= 0 && yloc <= 500 )
				counter++;
			else
			{
				xloc = xloc + 5;
				yloc = yloc - 5;
			}
		}
		else if ( key == 'c')
		{
			xloc+=5;
			yloc+=5;
			if ( xloc <= 500 && yloc <= 500 )
				counter++;
			else
			{
				xloc = xloc - 5;
				yloc = yloc - 5;
			}
		}
		xcoordinates[counter] = xloc;
		ycoordinates[counter] = yloc;
		repaint();
	}
	public void keyReleased ( KeyEvent e )
	{
		
	}
	public void keyTyped ( KeyEvent e )
	{
		
	}
}
