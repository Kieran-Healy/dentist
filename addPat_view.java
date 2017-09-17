

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

public class addPat_view {
	Scene scene;
    ArrayList<Dentist> dentistList;
		public addPat_view(Controller cont,ArrayList<Dentist> dent) {

			GridPane pane = new GridPane();
			VBox first = new VBox(21);
			VBox second = new VBox(10);

			tab_view qq = new tab_view(cont,dent);
			dentistList = dent;
			HBox main1 = new HBox(30);
			Button create = new Button("Create Patient");
			
			Label name = new Label("Name:");
			TextField nameInput = new TextField("");
			nameInput.setPromptText("name");
			
			Label address = new Label("Address:");
			TextField addressInput = new TextField();
			addressInput.setPromptText("address");
			
			Label user = new Label("Username:");
			TextField userInput = new TextField();
			userInput.setPromptText("username");
		
			Label pass = new Label("Password:");
			TextField passInput = new TextField();
			passInput.setPromptText("password");
			
			first.getChildren().addAll(name,address,user,pass);
			second.getChildren().addAll(nameInput,addressInput,userInput,passInput);

			main1.getChildren().addAll(first,second);
			
			first.setPadding(new Insets(0,175,0,0));
			second.setPadding(new Insets(0,175,0,0));
			
			GridPane.setConstraints(main1, 0,1);
			pane.setPadding(new Insets(0, 0, 0, 0));
			pane.setVgap(8);
			pane.setHgap(10);
			GridPane.setConstraints(create, 0, 2);

			GridPane.setHalignment(create, HPos.CENTER);
			
             main1.setAlignment(Pos.CENTER);
			pane.getChildren().addAll(qq.getBox(), main1,create);
			
			scene = new Scene(pane,735,500);
			create.setOnAction(e -> cont.addPatient(dent, nameInput.getText(), passInput.getText(),addressInput.getText(), userInput.getText()));
		}
		
		public Scene getScene() {
	        return scene;
	    }
}
