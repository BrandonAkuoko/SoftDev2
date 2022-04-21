package code.connectfour.view;

import code.connectfour.model.Checker;
import code.connectfour.model.ConnectFour;
import code.connectfour.model.ConnectFourException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ConnectFourGUI extends Application{
    private static final Image CHECKER = new Image("code/media/images/whitepiece.png");
    private static final Image RED = new Image("media/images/emojis/headyellow.png");
    private static final Image YELLOW = new Image("media/images/emojis/headgreen.png");
    private ImageView checkerView = new ImageView("code/media/images/blank.png");
    private ConnectFour board = new ConnectFour();
    
    @Override
    public void start(Stage stage) throws Exception {
        GridPane checkersEmpty = new GridPane();
        for(int x = 0; x < 6; x ++){
            checkersEmpty.add(makeDropButton(x),x,0);
        }
        for(int x = 0; x < 6 ; x ++){
                for(int y = 1; y < 7 ; y++){
                    checkersEmpty.add(new ImageView(CHECKER), x, y);
            }
        }
        stage.setScene(new Scene(checkersEmpty));
        stage.setTitle("Connect Four");
        stage.show();
        
    }

    private Button makeDropButton(int column){
        Button button = new Button("Drop!");
        button.setFont(new Font(18));
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    
        button.setOnAction((e)->{
            try{
                board.move(column);
                for (int col = 0; col < ConnectFour.COLS; col++) {
                    for (int row = 0; row < ConnectFour.ROWS; row++) {
                        Checker checker = this.board.getChecker(col, row);
                        switch(checker){
                            case RED:
                            checkerView.setImage(RED);
                            break;
                            case BLACK:
                            checkerView.setImage(YELLOW);
                            default:
                            checkerView.setImage(CHECKER);
                        }
                    }
                }
                
            }catch(ConnectFourException cfe){
                cfe.printStackTrace();
            }
        });
    
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}