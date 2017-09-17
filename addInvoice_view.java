

import java.util.ArrayList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class addInvoice_view {
    Scene scene;
    ArrayList<Dentist> dentistList;
    ComboBox<String> combo;
    public addInvoice_view(Controller cont, ArrayList<Dentist> dent) {
                	GridPane pane = new GridPane();
			VBox first = new VBox(21);
			VBox second = new VBox(10);
			combo = new ComboBox<String>();
			tab_view qq = new tab_view(cont,dent);
			
			dentistList = dent;

			HBox main1 = new HBox(30);
			
			Button create = new Button("Add Invoice");
			
			Label name = new Label("Name:");
		
			
			TextField nameInput = new TextField("");
			nameInput.setPromptText("name");
                        
                        Label user = new Label("Username:");
	
			
			TextField userInput = new TextField();
			userInput.setPromptText("username");
		
		
			Label pass = new Label("Password:");
		
			
			TextField passInput = new TextField();
			passInput.setPromptText("password");
                        
                        Label pro = new Label("Procedures:");
	
			
			TextField proInput = new TextField();
			proInput.setPromptText("procedure number");
		
			
			first.getChildren().addAll(name,user,pass,pro);
			second.getChildren().addAll(nameInput,userInput,passInput,combo);

			main1.getChildren().addAll(first,second);
			
			first.setPadding(new Insets(0,175,0,0));
		//	first.setAlignment(Pos.CENTER_LEFT);
			second.setPadding(new Insets(0,175,0,0));
			//second.setAlignment(Pos.CENTER);
			
			//pane.setAlignment(Pos.CENTER);
			
			GridPane.setConstraints(main1, 0,1);
			pane.setPadding(new Insets(0, 0, 0, 0));
			pane.setVgap(8);
			pane.setHgap(10);
			GridPane.setConstraints(create, 0, 2);

			//create.setAlignment(Pos.BASELINE_RIGHT);
			
			GridPane.setHalignment(create, HPos.CENTER);
			
                        main1.setAlignment(Pos.CENTER);
		//	mainVbox.setPadding(new Insets(-170,0,0,-50));
			
			pane.getChildren().addAll(qq.getBox(), main1,create);
			
			scene = new Scene(pane,735,500);
			create.setOnAction(e -> cont.addInvoice(dent, nameInput.getText(), passInput.getText(), userInput.getText(), proInput.getText()));
}
    	public Scene getScene() {
	        return scene;
	    }
    	public ComboBox<String> getCombo() {
			return combo;
		}
    
}
