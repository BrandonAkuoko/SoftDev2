package activities2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Updater implements EventHandler<ActionEvent>{
    private TextField text; // the users name
    private Label name; //

    public Updater(TextField text, Label name){
        this.text = text;
        this.name = name;
    }

    @Override
    public void handle(ActionEvent action) {
        String user = text.getText();
        name.setText(user);
        
    }
    
}
