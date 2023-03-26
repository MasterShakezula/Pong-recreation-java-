import java.awt.*;

import java.util.*;


public class Orb extends Rectangle{
	Random random;
	int xSpeed;
	int ySpeed;
	int intSpeed = 3; //initial speed of orb
	
	Orb(int x, int y, int width, int height) // x, y, width and height. But with a circle width and height are equal.
	
	{
		// Use super class to assign arguments again for convenience.
		super(x, y, width, height);
		random = new Random(); // intialize object random of random class.
		int randomXLocation = random.nextInt(2); // random int will be 0 or 1
		if (randomXLocation == 0)
		{
			randomXLocation -= 1; 
			// if 0 is selected, the ball starts with random movement left.
			
		}
		setXLocation(randomXLocation*intSpeed); 
		int randomYLocation = random.nextInt(2); // random int will be 0 or 1
		if (randomYLocation == 0)
		{
			randomYLocation -= 1; 
			
			
		}
		setYLocation(randomYLocation*intSpeed); 
		
		
		
	}
	public void setXLocation(int randomXLocation)
	{
		xSpeed = randomXLocation;
		
		
		
	}
	public void setYLocation(int randomYLocation)
	{
		ySpeed = randomYLocation;
		
	}
	public void move()
	{
		x += xSpeed; // update coordinate location of the orb
		y += ySpeed;
	}
	public void draw(Graphics g)
	{
		//draw the orb
		g.setColor(Color.BLUE);
		g.fillOval(x, y, height, width); 
		// we use the attributes of Rectangle to put in parameters for orb
		// however, those parameters can be used to form a oval/circle.
		
	}

}
