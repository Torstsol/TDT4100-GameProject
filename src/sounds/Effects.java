package sounds;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Effects {
	
	AudioStream audioStream;
	
	public void playSound(String songName){ 
		
		File file = new File("res/sounds");
		String path = file.getAbsolutePath();
		String gongFile = path + "/" + songName + ".wav";
		
	    try{
	    	InputStream in = new FileInputStream(gongFile);

	    	audioStream = new AudioStream(in);

		    AudioPlayer.player.start(audioStream);
	    }
	    catch(IOException e){
	    	System.out.println(e);
	    }   
	}
	
	public void stopSound() throws IOException{
		
		AudioPlayer.player.stop(audioStream);
		
	}
}
