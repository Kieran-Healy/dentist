

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class addPro_view {
	Scene scene;
    ArrayList<Dentist> dentistList;
    ComboBox<String> combo;
		public addPro_view(Controller cont,ArrayList<Dentist> dent) {
			GridPane pane = new GridPane();
			Button add = new Button("Add Procedure");
			 
			dentistList = dent;
			tab_view qq = new tab_view(cont,dent);
			
			VBox first = new VBox(21);
			VBox second = new VBox(10);
			HBox main1 = new HBox(30);
			
			Label proName = new Label("Procedure Name:");
		//	GridPane.setConstraints(proName, 0, 1);
			
			TextField proNameInput = new TextField("");
			proNameInput.setPromptText("name");
		//	GridPane.setConstraints(proNameInput, 1, 1);
			
			Label cost = new Label("Cost:");
		//	GridPane.setConstraints(cost, 0, 2);
			
			TextField costInput = new TextField();
			costInput.setPromptText("cost");
		//	GridPane.setConstraints(costInput, 1, 2);
			
			Label user = new Label("Username:");
			//GridPane.setConstraints(user, 0, 3);
			
			TextField userInput = new TextField();
			userInput.setPromptText("username");
		//	GridPane.setConstraints(userInput, 1, 3);
		
			Label pass = new Label("Password:");
		//	GridPane.setConstraints(pass, 0, 4);
			
			TextField passInput = new TextField();
			passInput.setPromptText("password");
		//	GridPane.setConstraints(passInput, 1, 4);
			
		//	mainVbox.setPadding(new Insets(-170,0,0,-50));
			
			pane.setPadding(new Insets(0, 0, 0, 0));
			pane.setVgap(8);
			pane.setHgap(10);
			
		//	pane.setAlignment(Pos.CENTER);
			
			first.getChildren().addAll(proName,cost,user,pass);
			second.getChildren().addAll(proNameInput, costInput,userInput,passInput);
			main1.getChildren().addAll(first,second);
			
			GridPane.setConstraints(add, 0, 2);
			
			add.setAlignment(Pos.BASELINE_RIGHT);
			main1.setAlignment(Pos.CENTER);
			first.setPadding(new Insets(0,175,0,0));
			first.setAlignment(Pos.CENTER_LEFT);
			second.setPadding(new Insets(0,175,0,0));
			second.setAlignment(Pos.CENTER);
			
			GridPane.setHalignment(add, HPos.CENTER);
			GridPane.setConstraints(main1, 0,1);

			pane.getChildren().addAll(qq.getBox(), main1,add);	
			
			scene = new Scene(pane, 735,500);
		
			add.setOnAction(e -> cont.addProcedure( dent,  userInput.getText(),  passInput.getText(), proNameInput.getText(), costInput.getText()));
		}
		
		public Scene getScene() {
	        return scene;
	    }
		
		
}