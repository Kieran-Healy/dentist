

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class displayPat_view {
	Scene scene;
    ArrayList<Dentist> dentistList;
	public displayPat_view(Controller cont,ArrayList<Dentist> dent) {
		GridPane pane = new GridPane();
		Button button = new Button("Display Patients");
		ListView<String> patient = new ListView<String>();
		tab_view qq = new tab_view(cont,dent);
		
		dentistList = dent;
		
		VBox first = new VBox(21);
		VBox second = new VBox(10);
		HBox main1 = new HBox(30);
		
		Label user = new Label("Username:");
	//	GridPane.setConstraints(user, 0, 0);
		
		TextField userInput = new TextField();
		userInput.setPromptText("username");
	//	GridPane.setConstraints(userInput, 1, 0);
	
		Label pass = new Label("Password:");
	//	GridPane.setConstraints(pass, 0, 1);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
	//	GridPane.setConstraints(passInput, 1, 1);
		
		first.getChildren().addAll(user,pass);
		second.getChildren().addAll(userInput,passInput);
		main1.getChildren().addAll(first,second);
		
		pane.setPadding(new Insets(0, 0, 0, 0));
		pane.setVgap(8);
		pane.setHgap(10);
	//	GridPane.setConstraints(button, 1, 2);
		GridPane.setConstraints(patient, 0,3);
		
		GridPane.setConstraints(button, 0, 2);
		
		button.setAlignment(Pos.BASELINE_RIGHT);
		
	//	mainVbox.setPadding(new Insets(-189,0,0,-50));
		
		first.setPadding(new Insets(0,175,0,0));
		first.setAlignment(Pos.CENTER_LEFT);
		second.setPadding(new Insets(0,175,0,0));
		second.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(button, HPos.CENTER);
		GridPane.setHalignment(patient, HPos.CENTER);
		main1.setAlignment(Pos.CENTER);
	//	pane.setAlignment(Pos.CENTER);
		
		
		GridPane.setConstraints(main1, 0,1);

		pane.getChildren().addAll(qq.getBox(), main1,button,patient);	
		scene = new Scene(pane, 735,500);
		patient.setPrefHeight(scene.getHeight() / 1.48);
		button.setOnAction(e -> cont.display( dent,  userInput.getText(),  passInput.getText(),  patient));
	}
	
	public Scene getScene() {
        return scene;
    }
}
