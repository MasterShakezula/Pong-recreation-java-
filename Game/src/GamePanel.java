import java.awt.*;
import java.awt.event.*;

import java.util.*;
import javax.swing.*;


public class GamePanel extends JPanel implements Runnable{
	static final int SCREEN_WIDTH = 1000;
	static final int SCREEN_HEIGHT = (int)(SCREEN_WIDTH*(0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
	static final int ORB_SIZE = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	Thread thread;
	Image image; 
	Graphics graphics;
	Random random;
	Paddles paddleOne, paddleTwo, paddleThree, paddleFour;
	
	Orb orb;
	Points points;
	
	
	
	GamePanel()
	
	{
		spawnPaddles();
		spawnOrb();
		points = new Points(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setFocusable(true); // focus on key presses
		this.addKeyListener(new actionListener());
		this.setPreferredSize(SCREEN_SIZE);
		thread = new Thread(this); //this as in, passing in the runnable interface.
		thread.start();
		//Use thread to run operations on a java thread, allowing for multitasking.
		
		
	}
	
	public void spawnOrb()
	// here, we will use RNG. To determine ball movement.
	// That way our games will be unpredictable.
	{
		random = new Random();
		orb = new Orb(random.nextInt(SCREEN_WIDTH/2)-(ORB_SIZE/2), random.nextInt(SCREEN_HEIGHT-ORB_SIZE), ORB_SIZE, ORB_SIZE);
		//randomize how the orb can spawn x and y axis wise.
	}
	
	public void spawnPaddles()
	
	{
		paddleOne = new Paddles(0, (SCREEN_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddleTwo = new Paddles(SCREEN_WIDTH-PADDLE_WIDTH, (SCREEN_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
		paddleThree = new Paddles(250, (SCREEN_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 3);
		paddleFour = new Paddles(750, (SCREEN_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 4);
	}
	
	
	public void paint(Graphics g)
	
	{
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics); // pass in graphics to our draw function
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g)
	
	{
		paddleOne.draw(g);
		paddleTwo.draw(g);
		paddleThree.draw(g);
		paddleFour.draw(g);
		orb.draw(g);
		points.draw(g);
		
	}
	public void move()
	
	{
		// improve movement of paddles. 
		paddleOne.move();
		paddleTwo.move();
		paddleThree.move();
		paddleFour.move();
		// now, movement of paddle one is synced with our delta time system.
		// We can allow allow for smooth movement of our orb.
		orb.move();
		
	}
	public void collision()
	{
		//checks for when the paddles hit the top and bottom window borders
		// evaluation check if the paddle is at the last pixel of the frame. if so, stop further movement.
		// add similar system for x axis later. 
		// use this to stop the ball as well
		//paddle check below
		if (paddleOne.y <= 0)
		{
			paddleOne.y = 0;
			
		}
		if (paddleOne.y >= SCREEN_HEIGHT-PADDLE_HEIGHT)
		{
			paddleOne.y = SCREEN_HEIGHT-PADDLE_HEIGHT;
		}
		if (paddleTwo.y <= 0)
		{
			paddleTwo.y = 0;
			
		}
		if (paddleTwo.y >= SCREEN_HEIGHT-PADDLE_HEIGHT)
		{
			paddleTwo.y = SCREEN_HEIGHT-PADDLE_HEIGHT;
		}
		if (paddleThree.y <= 0)
		{
			paddleThree.y = 0;
			
		}
		if (paddleThree.y >= SCREEN_HEIGHT-PADDLE_HEIGHT)
		{
			paddleThree.y = SCREEN_HEIGHT-PADDLE_HEIGHT;
		}
		if (paddleFour.y <= 0)
		{
			paddleFour.y = 0;
			
		}
		if (paddleFour.y >= SCREEN_HEIGHT-PADDLE_HEIGHT)
		{
			paddleFour.y = SCREEN_HEIGHT-PADDLE_HEIGHT;
		}
		// orb check below.
		
		if(orb.y <= 0)
		{
			orb.setYLocation(-orb.ySpeed); // with reversed velocity, ball goes the other way.
		}
		if (orb.y >= SCREEN_HEIGHT-ORB_SIZE)
		{
			orb.setYLocation(-orb.ySpeed); //ditto
		}
		
		//check collision of orb against paddles.
		// use attributes from superclass rectangle to help.
		// such as .intersects();
		if (orb.intersects(paddleOne)) //if a collision happens...
		{
			orb.xSpeed = (orb.xSpeed*-1); 
			orb.xSpeed += 2; // with each collision, the ball gets faster
			if(orb.ySpeed > 0)
			{
				orb.ySpeed++; 
				
				
			}
			else
			{
				orb.ySpeed--;
			}
			orb.setXLocation(orb.xSpeed); // set location based on speed
			orb.setYLocation(orb.ySpeed);
		}
		if (orb.intersects(paddleTwo)) 
		{
			orb.xSpeed = (orb.xSpeed*-1); 
			orb.xSpeed += 2; 
			if(orb.ySpeed > 0)
			{
				orb.ySpeed++; 
				
				
			}
			else
			{
				orb.ySpeed--;
			}
			orb.setXLocation(-orb.xSpeed); //set negative. to flip orb trajectory.
			orb.setYLocation(orb.ySpeed);
		}
		if (orb.intersects(paddleThree)) //if a collision happens...
		{
			orb.xSpeed = (orb.xSpeed*-1); 
			orb.xSpeed += 2; // with each collision, the ball gets faster
			if(orb.ySpeed > 0)
			{
				orb.ySpeed++; 
				
				
			}
			else
			{
				orb.ySpeed--;
			}
			orb.setXLocation(orb.xSpeed);
			orb.setYLocation(orb.ySpeed);
		}
		if (orb.intersects(paddleFour)) 
		{
			orb.xSpeed = (orb.xSpeed*-1); 
			orb.xSpeed += 2; 
			if(orb.ySpeed > 0)
			{
				orb.ySpeed++; 
				
				
			}
			else
			{
				orb.ySpeed--;
			}
			orb.setXLocation(orb.xSpeed); // set location based on speed
			orb.setYLocation(orb.ySpeed);
		}
		//update scoreboard, reset paddles and ball if a players goal is crossed
		if (orb.x >=SCREEN_WIDTH-ORB_SIZE)
		{
			points.playerOne++;
			if (points.playerOne == 5)
			{
				System.out.println("Team One: " + points.playerOne);
				System.out.println("Team One wins!");
				System.exit(0);
			}
			spawnPaddles();
			spawnOrb();
			System.out.println("Team One: " + points.playerOne);
		}
		if (orb.x <=0)
		{
			points.playerTwo++;
			if (points.playerTwo == 5)
			{
				
				System.out.println("Team Two: " + points.playerTwo);
				System.out.println("Team Two wins!");
				System.exit(0);
			}
			spawnPaddles();
			spawnOrb();
			System.out.println("Team Two: " + points.playerTwo);
		}
		// Team one consists of player one and three.
		// Team two consists of player two and four
		//For ease, teams ones points will be player ones points
		// team twos points will be player twos points
		
		
		
		
	}
	public void run()
	{
		//run the game constantly until we close the game. Set tick rate.
		// set delta time.
		long runTime = System.nanoTime();
		double tickNo = 60.0; //number of ticks
		double ns = 1000000000/(tickNo); // nanoseconds, to help with our delta time system.
		double delta = 0;
		while (true)
		{
			long now = System.nanoTime();
			delta += (now - runTime)/(ns);
			runTime = now;
			if (delta >= 1)
			{
				move(); // each tick, call movement to the paddles for smoother controlling. 
				collision();
				repaint();
				delta -= 1;
				
			}
		}
		
	}
	public class actionListener extends KeyAdapter{
		
		// before we move ingame, the program must listen to key presses.
		public void keyPressed(KeyEvent e) 
		// for ease, use preset methods keyPressed and keyReleased, from the keyAdapter class.
		
		{
			paddleOne.keyPressed(e);
			paddleTwo.keyPressed(e);
			paddleThree.keyPressed(e);
			paddleFour.keyPressed(e);
			
			
			//Paddles werent moving at first.
			// keys were read, but i used the wrong function.
			// my test print showed this. 
			
		}
		
		public void keyReleased(KeyEvent e)
		{
			paddleOne.keyReleased(e);
			paddleTwo.keyReleased(e);
			paddleThree.keyReleased(e);
			paddleFour.keyReleased(e);
			
			
			
			
		}
	}

}
