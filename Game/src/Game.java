
import java.io.File;
import java.util.*;


import java.io.IOException;
import javax.sound.sampled.*;

public class Game {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		// TODO Auto-generated method stub
		
		
		GameWindow playTime = new GameWindow();
		Scanner scanner = new Scanner(System.in);
		File file = new File("Ping Pong Ball Hit.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
		
		
		

	}

}
