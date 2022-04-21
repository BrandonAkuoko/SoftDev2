package assignment2;

import java.io.File;


import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class Song {
    private final String description;
    private final Image image;
    private final MediaPlayer mp;

    public Song(String m, String description, String ip){
        Media media = new Media(new File(m).toURI().toString());
        mp = new MediaPlayer(media);
        image = new Image(ip);
        this.description = description;
    
    }
    public String getDescription() {
        return description;
    }
    
    public Image getImage() {
        return image;
    }
    public void togglePause(){
        Status status = mp.getStatus();
        if (status == Status.PAUSED) {
            mp.play();
            
        }
        else if(status == Status.PLAYING) {
            mp.pause();
        }
    }

    public void fastFoward(){
        Duration skip = new Duration(10000);
        Duration current = mp.getCurrentTime();
        mp.seek(current.add(skip));
        mp.play();
    }
    
    public void rewind(){
        Duration rewind = new Duration(10000);
        Duration current = mp.getCurrentTime();
        mp.seek(current.subtract(rewind)); // subtracts 10 seconds
        mp.play();
    }

    public void play(){
        mp.stop();
        mp.play();
    }

    public void stop(){
        mp.stop();
    }
}
