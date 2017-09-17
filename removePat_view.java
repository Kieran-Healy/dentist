

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class removePat_view {
	Scene scene;
    ArrayList<Dentist> dentistList;
	public removePat_view(Controller cont,ArrayList<Dentist> dent) {
		GridPane pane = new GridPane();
		
		Button remove = new Button("Remove Patient");
		tab_view qq = new tab_view(cont,dent);
	
		VBox first = new VBox(21);
		VBox second = new VBox(10);
		HBox main1 = new HBox(30);
		
		Label name = new Label("Name:");
	//	GridPane.setConstraints(name, 0, 1);
		
		TextField nameInput = new TextField("");
		nameInput.setPromptText("name");
	//	GridPane.setConstraints(nameInput, 1, 1);
		
		Label address = new Label("Address:");
	//	GridPane.setConstraints(address, 0, 2);
		
		TextField addressInput = new TextField();
		addressInput.setPromptText("address");
	//	GridPane.setConstraints(addressInput, 1, 2);
		
		Label user = new Label("Username:");
	//	GridPane.setConstraints(user, 0, 3);
		
		TextField userInput = new TextField();
		userInput.setPromptText("username");
	//	GridPane.setConstraints(userInput, 1, 3);
	
		Label pass = new Label("Password:");
		//GridPane.setConstraints(pass, 0, 4);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
	//	GridPane.setConstraints(passInput, 1, 4);
		
		
		dentistList = dent;
		

		
		first.getChildren().addAll(name,address,user,pass);
		second.getChildren().addAll(nameInput,addressInput,userInput,passInput);
		main1.getChildren().addAll(first,second);
		
		
		pane.setPadding(new Insets(0, 0, 0, 0));
		pane.setVgap(8);
		pane.setHgap(10);
		GridPane.setConstraints(remove, 0, 2);
		
		remove.setAlignment(Pos.BASELINE_RIGHT);
		
		first.setPadding(new Insets(0,175,0,0));
		first.setAlignment(Pos.CENTER_LEFT);
		second.setPadding(new Insets(0,175,0,0));
		second.setAlignment(Pos.CENTER);
		
		//pane.setAlignment(Pos.CENTER);
		GridPane.setHalignment(remove, HPos.CENTER);
		
		GridPane.setConstraints(main1, 0,1);
                
        main1.setAlignment(Pos.CENTER);
                
		pane.getChildren().addAll(qq.getBox(), main1,remove);
               
		scene = new Scene(pane, 735,500);
		
	
		remove.setOnAction(e -> cont.removePatient(dent, nameInput.getText(), passInput.getText(),addressInput.getText(), userInput.getText()));
	}
	
	public Scene getScene() {
        return scene;
    }
}
