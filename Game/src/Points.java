import java.awt.*;


public class Points extends Rectangle  {
	static int SCREEN_WIDTH;
	static int SCREEN_HEIGHT;
	int playerOne;
	int playerTwo;

	
	Points(int SCREEN_WIDTH, int SCREEN_HEIGHT)
	
	{
		Points.SCREEN_WIDTH = SCREEN_WIDTH;
		Points.SCREEN_HEIGHT = SCREEN_HEIGHT;
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.cyan);
		g.setFont(new Font ("Arial", Font.PLAIN, 60));
		
		g.drawLine(SCREEN_WIDTH/2, 0, SCREEN_WIDTH/2, SCREEN_HEIGHT);
		g.drawString(String.valueOf(playerOne/10) + String.valueOf(playerOne%10), (SCREEN_WIDTH/2)-85, 50);
		g.drawString(String.valueOf(playerTwo/10) + String.valueOf(playerTwo%10), (SCREEN_WIDTH/2)+20, 50);
	}
	
}
