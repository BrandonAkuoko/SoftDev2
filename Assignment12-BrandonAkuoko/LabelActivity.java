import javax.swing.border.Border;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane bp = new GridPane();
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button ("C" + col+ ", R" + row);
            }
            
        }
        Label l = makeLabel("top", Color.BEIGE, Color.FORESTGREEN);
        bp.setTop(l);

        Label q = makeLabel("me", Color.YELLOWGREEN, Color.CORNSILK);
        bp.setCenter(q);

        Label w = makeLabel("off", Color.VIOLET, Color.FORESTGREEN);
        bp.setBottom(w);

        
        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Label Activity");
        primaryStage.show();
        

    }
    private Label makeLabel(String text, Color color, Color background){
        
        Label label2 = new Label(text);
        label2.setFont(new Font("Courier New", 20));
        label2.setTextFill(color);
        label2.setPadding(new Insets(100));
        label2.setBackground(new Background(new BackgroundFill(background,CornerRadii.EMPTY, Insets.EMPTY)));
        label2.setAlignment(Pos.BOTTOM_LEFT);
        label2.setMaxWidth(Double.MAX_VALUE);
        label2.setMinWidth(500);
        label2.setBorder(new javafx.scene.layout.Border((new BorderStroke(Color.BLANCHEDALMOND, BorderStrokeStyle.DASHED, new CornerRadii(20), BorderStroke.THICK))));
        return label2;

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
