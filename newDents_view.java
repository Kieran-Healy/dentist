
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class newDents_view {
    Scene scene;
    ArrayList<Dentist> dentistList;
    public newDents_view(Controller cont,ArrayList<Dentist> dent) {
        dentistList = dent;
        HBox box = new HBox(45);
		Button cancel = new Button("Cancel");
		Button create = new Button("Create");
        GridPane pane = new GridPane();
                
        Label name = new Label("Username:");
		GridPane.setConstraints(name, 0, 0);
		
		TextField nameInput = new TextField("");
		nameInput.setPromptText("username");
		GridPane.setConstraints(nameInput, 1, 0);
                
        Label pass = new Label("Password:");
		GridPane.setConstraints(pass, 0, 1);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);
                
		pane.setVgap(3);
        GridPane.setConstraints(box, 1, 2);
        box.getChildren().addAll(create,cancel);     
       pane.setAlignment(Pos.CENTER);
        scene = new Scene (pane, 300, 250);
                
        pane.getChildren().addAll(name, nameInput, pass, passInput,box);
        cancel.setOnAction(e -> cont.cancelDent(scene));
   
		create.setOnAction(e -> cont.createDent(nameInput.getText(), passInput.getText()));
        
                
       
    }
    
    public Scene getScene() {
        return scene;
    }
}
