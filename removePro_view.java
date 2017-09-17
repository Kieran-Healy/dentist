

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

public class removePro_view {
	Scene scene;
    ArrayList<Dentist> dentistList;
		public removePro_view(Controller cont,ArrayList<Dentist> dent) {
			GridPane pane = new GridPane();
			Button remove = new Button("Remove Procedure");
			tab_view qq = new tab_view(cont,dent);
			dentistList = dent;
			
			VBox first = new VBox(21);
			VBox second = new VBox(10);
			HBox main1 = new HBox(30);
			
			Label proName = new Label("Procedure Name:");
			//GridPane.setConstraints(proName, 0, 1);
			
			TextField proNameInput = new TextField("");
			proNameInput.setPromptText("name");
			//GridPane.setConstraints(proNameInput, 1, 1);
			
			Label user = new Label("Username:");
			//GridPane.setConstraints(user, 0, 2);
			
			TextField userInput = new TextField();
			userInput.setPromptText("username");
			//GridPane.setConstraints(userInput, 1, 2);
		
			Label pass = new Label("Password:");
			//GridPane.setConstraints(pass, 0, 3);
			
			TextField passInput = new TextField();
			passInput.setPromptText("password");
			//GridPane.setConstraints(passInput, 1, 3);
		//	pane.setAlignment(Pos.CENTER);
			
			first.getChildren().addAll(proName,user,pass);
			second.getChildren().addAll(proNameInput,userInput,passInput);
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
			
			GridPane.setHalignment(remove, HPos.CENTER);
			main1.setAlignment(Pos.CENTER);
			GridPane.setConstraints(main1, 0,1);
			pane.getChildren().addAll(qq.getBox(), main1,remove);	
			
			scene = new Scene(pane, 735,500);
			
			
			remove.setOnAction(e -> cont.removeProcedure(dent, userInput.getText(), passInput.getText(), proNameInput.getText()));
		}
		
		public Scene getScene() {
	        return scene;
	    }
}
