package activities;
import org.graalvm.compiler.phases.common.NodeCounterPhase.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import jdk.internal.org.jline.terminal.MouseEvent.Button;

public class ClickCounter extends Application {

    @Override
    public void start(Stage stage){//} throws Exception {
 
        Label label1; 
        Label label2; 
        Button clicker = new Button("Click Me!");

        VBox box = new VBox();
        

        stage.setScene(new Scene(box));
        stage.setTitle("Click Counter");    
        stage.show();
        
    }
    private static Label makeLabel(String text, Font font, Color fill) {
        Label label = new Label(text);
        label.setFont(font);
        label.setBackground(new Background(new BackgroundFill(fill, 
            CornerRadii.EMPTY, Insets.EMPTY)));
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(20));
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(label, Priority.ALWAYS);

        return label;
    }

    public static void main(String[] args) {
        launch(args);   
    }
}

