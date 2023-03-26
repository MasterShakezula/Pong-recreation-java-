import java.awt.*;

import javax.swing.*;

public class GameWindow extends JFrame {
	GamePanel panel;
	
	GameWindow()
	{
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Ultimate Pong");
		this.setResizable(false); // I will not accommodate for full screen. 
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); //wrap our window around JPanel
		this.setVisible(true); 
		this.setLocationRelativeTo(null);
		
		
	}

}
