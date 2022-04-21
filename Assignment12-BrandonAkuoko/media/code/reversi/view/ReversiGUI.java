package code.reversi.view;

import code.reversi.model.Reversi;
import code.reversi.model.ReversiException;
import code.reversi.model.Square;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReversiGUI extends Application {
    private static final Image SQUARE_IMAGE = 
        new Image("file:media/images/square.png"); // test
    private static final Image BLACK_IMAGE = 
        new Image("file:media/images/blackpiece.png");
    private static final Image WHITE_IMAGE = 
        new Image("file:media/images/whitepiece.png");
    private static final Image BLANK_IMAGE = 
        new Image("file:media/images/blank.png");

    private Reversi board;
    private Label status;
    private Label p1Score;
    private Label p2Score;
    @Override
    public void start(Stage stage) throws Exception {
        this.board = new Reversi();

        GridPane gp = new GridPane();
        for (int col = 0; col < Reversi.COLS; col++) {
            for (int row = 0; row < Reversi.ROWS; row++) {
                gp.add(makeButton(col,row),col,row);
            }
        }
        stage.setScene(new Scene(gp));
        stage.setTitle("Reversi");
        stage.show();
        
    }
    private Button makeButton(int col, int row){
        ImageView i = new ImageView(BLANK_IMAGE);
        Button button = new Button("", i);
        button.setPrefSize(72, 72);
        button.setBackground(new Background(
            new BackgroundImage(
                SQUARE_IMAGE,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
        button.setPadding(Insets.EMPTY);
        Square square = board.getSquare(row, col);
        square.register((square)) ->{
            squareUpdate(square, i);
            
        }
        switch(square.getOccupyingColor()){
            case BLACK:
                i.setImage(BLACK_IMAGE);
                break;
            case WHITE:
                i.setImage(WHITE_IMAGE);
                break;
            default:
                i.setImage(BLANK_IMAGE);
        }
        button.setOnAction((e) ->{
            try {
                board.move(row, col);
            }
            catch (ReversiException e) {
               System.out.println(e.getMessage()) 
            }
        );
        return button;
    }
    public void squareUpdate(Square square, ImageView squareView){
        switch
    }
    public static void main(String[] args) {
        launch(args);
    }

}
