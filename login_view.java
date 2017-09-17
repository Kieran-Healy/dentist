
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class login_view {
    Scene scene;
    ArrayList<Dentist> dentistList;
    
    public login_view(Controller cont, ArrayList<Dentist> dent) {
        dentistList = dent;
		Button login = new Button("Login");
		Button newDentist = new Button("New Dentist");
        GridPane pane = new GridPane();
        HBox box = new HBox(25);
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
        
        box.getChildren().addAll(login,newDentist);     
        scene = new Scene(pane, 300, 250);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(name, nameInput, pass, passInput, box);
        
        newDentist.setOnAction(e -> cont.addDentist(dentistList, nameInput.getText(), passInput.getText()));
		login.setOnAction(e -> cont.loginDentist(nameInput.getText(), passInput.getText()));
                
       
    }
    
    public Scene getScene() {
        return scene;
    }
}
