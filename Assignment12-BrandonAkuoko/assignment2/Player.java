package assignment2;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Player extends Application{
    private List<Song> songsList = new ArrayList<>();
    public static ImageView temp;
    public static int counter = 1;
    
    
    public ImageView imagechanger(Song song){
        ImageView image = new ImageView(song.getImage());
        return image;
    }


    @Override
    public void start(Stage arg0) throws Exception {
        
        //Button button = new Button(text, new ImageView(new Image("file:Unit12/assignment-12-a1484414286/media/images/square.png")));
        
        songsList.add(new Song("music/Adagio in C major, K. 356 [Solo Guitar arr. - Alink].mp3", "Adagio in C major, K. 356 ", "images/bach.png"));
        songsList.add(new Song("music/Brandenburg Concerto no. 1 in F major, BWV. 1046 - I. Allegro.mp3", "Brandenburg Concerto no. 1 in F major", "images/bach.png"));
        songsList.add(new Song("music/March in D major, K. 215.mp3", "March in D major", "images/bach.png"));
        songsList.add(new Song("music/Piano Sonata no. 10 Op. 14-2 - III. Scherzo, Allegro assai.mp3", "Piano Sonata no. 10 Op. 14-2 - III. Scherzo","images/beethoven.png"));
        songsList.add(new Song("music/Sonata No. 12 in A Flat Major, Op. 26 - II. Scherzo (Allegro molto).mp3", "Sonata No. 12 in A Flat Major", "images/mozart.png"));

        temp = imagechanger(songsList.get(1));


        //adding songs
        Song song1 = songsList.get(0);
        Button button = new Button(song1.getDescription());
        button.setPadding(new Insets(30));
        button.setAlignment(Pos.CENTER_RIGHT);
        button.setOnAction((e)->{
            for(Song i: songsList){
                i.stop();
            }
            song1.play();
            temp.setImage(song1.getImage());
            System.out.println("Playing Song");
        });




        Song song2 = songsList.get(1);
        Button button1 = new Button(songsList.get(1).getDescription());
        button1.setPadding(new Insets(30));
        button1.setAlignment(Pos.CENTER_RIGHT);
        button1.setOnAction((e)->{
            for(Song x : songsList){
                x.stop();
            }
            song2.play();
            temp.setImage(song2.getImage());
            System.out.println("Playing Song");
        });

        Song song3 = songsList.get(2);
        Button button2 = new Button(songsList.get(2).getDescription());
        button2.setPadding(new Insets(30));
        button2.setAlignment(Pos.CENTER_RIGHT);
        button2.setOnAction((e)->{
            for(Song y: songsList){
                y.stop();
            }
            song3.play();
            temp.setImage(song3.getImage());
            counter = 3;
            System.out.println("Playing Song");
        });
        
        Song song4 = songsList.get(3);
        Button button3 = new Button(songsList.get(3).getDescription());
        button3.setPadding(new Insets(30));
        button3.setAlignment(Pos.CENTER_RIGHT);
        button3.setOnAction((e)->{
            for(Song y: songsList){
                y.stop();
            }
            song4.play();
            temp.setImage(song4.getImage());
            counter = 4;
            System.out.println("Playing Song");
        });
        Song song5 = songsList.get(4);
        Button button4 = new Button(songsList.get(4).getDescription());
        button4.setPadding(new Insets(30));
        button4.setAlignment(Pos.CENTER_RIGHT);
        button4.setOnAction((e)->{
            for(Song y: songsList){
                y.stop();
            }
            song5.play();
            temp.setImage(song3.getImage());
            counter = 5;
            System.out.println("Playing Song");
        });

        for(Song song : songsList){
            Button play = new Button("Play");
            play.setPadding(new Insets(10));
            play.setOnAction((e)->{
                song.play();
            });
            
            Button pause = new Button("Pause");
            pause.setPadding(new Insets(10));
            pause.setOnAction((e)->{
                song.togglePause();
            });
    
    
            Button rewind = new Button("Rewind");
            rewind.setPadding(new Insets(10));
            rewind.setOnAction((e)->{
                song.rewind();
            });
    
            Button forward = new Button("Forward");
            forward.setPadding(new Insets(10));
            forward.setOnAction((e)->{
                song.fastFoward();
            });
    
            Button stop = new Button("Stop");
            stop.setPadding(new Insets(10));
            stop.setOnAction((e)->{
                song.stop();
            });
            
            HBox box = new HBox();
            box.getChildren().addAll(
                rewind,
                pause,
                play,
                stop,
                forward
                );
    
            box.setAlignment(Pos.BASELINE_RIGHT);       
            box.setPadding(new Insets(100));
            
            VBox songs = new VBox();
            songs.getChildren().addAll(
                button,
                button1,
                button2,
                button3,
                button4,
                box);
        
            HBox pictures = new HBox();
            pictures.getChildren().addAll(
                temp
            );

            HBox all = new HBox();
            all.getChildren().addAll(
                pictures,
                songs
            );
            arg0.setTitle("Music Player");
            arg0.setScene(new Scene(all));
            arg0.show();
        }
        }
        

    public static void main(String[] args) {
        launch(args);
    }
}
