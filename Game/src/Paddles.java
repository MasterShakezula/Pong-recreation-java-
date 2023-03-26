import java.awt.*;
import java.awt.event.*;


public class Paddles extends Rectangle{
	int playerNo;
	int ySpeed;
	int speed = 10;
	Paddles(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int playerNo)
	
	{
		// use arguments from the rectangle superclass, our paddle will be like a rectangle.
		super (x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.playerNo = playerNo;
		
	}
	public void keyPressed(KeyEvent e)
	{
		switch(playerNo)
		{
		case 1:
			if (e.getKeyCode()==KeyEvent.VK_W) 
			{
				// for player one, if W is pressed, the paddle will go up.
				setYLocation(-speed); // move 10 pixels up.
				move(); // call move();
				
			}
			if (e.getKeyCode() == KeyEvent.VK_S) // press S, move down.
			{
				
				setYLocation(speed); // move 10 pixels down
				move(); 
				
			}
			break;
		case 2:
			if (e.getKeyCode() == KeyEvent.VK_UP) //up arrow key
			{
				
				setYLocation(-speed); // move 10 pixels up.
				move(); // call move();
				
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) // down arrow key.
			{
				
				setYLocation(speed); // move 10 pixels down
				move(); 
				
			}
			break;
		case 3: 
			if (e.getKeyCode() == KeyEvent.VK_E)
			{
				setYLocation(-speed);
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_D)
			{
				setYLocation(speed);
				move();
			}
			break;
		case 4: 
			if (e.getKeyCode() == KeyEvent.VK_P)
			{
				setYLocation(-speed);
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_L)
			{
				setYLocation(speed);
				move();
			}
			break;
				
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
		switch(playerNo)
		{
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) 
			{
				
				setYLocation(0); //stop movement on release of key.
				move(); // call move();
				
			}
			if (e.getKeyCode() == KeyEvent.VK_S) 
			{
				
				setYLocation(0); 
				move(); 
				
			}
			break;
		case 2:
			if (e.getKeyCode() == KeyEvent.VK_UP) 
			{
				
				setYLocation(0); 
				move(); 
				
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) 
			{
				
				setYLocation(0); 
				move(); 
				
			}
			break;
		case 3:
			if (e.getKeyCode() == KeyEvent.VK_E) 
			{
				
				setYLocation(0); 
				move(); 
				
			}
			if (e.getKeyCode() == KeyEvent.VK_D) 
			{
				
				setYLocation(0); 
				move(); 
				
			}
			break;
		case 4: 
			if (e.getKeyCode() == KeyEvent.VK_P)
			{
				setYLocation(0);
				move();
			}
			if (e.getKeyCode() == KeyEvent.VK_L)
			{
				setYLocation(0);
				move();
			}
			break;
		}
		
	}
	public void setYLocation(int yLocation)
	{
		ySpeed = yLocation; // set y location of paddle depending on our speed.
		
	}
	public void move()
	{
		y = y + ySpeed; 
		
		
		
		
		// using our current y coordinate, update it when speed is not zero.
		// Do the same thing for the x axis if we add this later.
		
	}
	public void draw(Graphics g)
	{
		// draw paddles for our players
		if (playerNo == 1)
		{
			g.setColor(Color.magenta);
		}
		else if (playerNo == 2)
		{
			g.setColor(Color.cyan);
		}
		else if (playerNo == 3)
		{
			g.setColor(Color.blue);
		}
		else if (playerNo == 4)
		{
			g.setColor(Color.red);
		}
		g.fillRect(x, y, width, height);
		
		
	}

}
