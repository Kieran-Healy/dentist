

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.stage.Stage;

public class gui extends Application {
	static ArrayList<Dentist> dentistList = new ArrayList<Dentist>();
	Dentist login = null;
	public static void main(String[] args) {
		 
		launch(args);
	}

	public void start(Stage stage) {
	try {
		
		Controller cont = new Controller(stage,dentistList);
	
	    login_view x = new login_view(cont,dentistList);
	    newDents_view d = new newDents_view(cont,dentistList);
	    removePro_view a = new removePro_view(cont,dentistList);
	    addPat_view y = new addPat_view(cont,dentistList);
	    addPro_view t = new addPro_view(cont,dentistList);
	    listPro_view q = new listPro_view(cont,dentistList);
	    displayPat_view u = new displayPat_view(cont,dentistList);
	    removePat_view g = new removePat_view(cont,dentistList);
	    addPay_view p = new addPay_view(cont,dentistList);
        addInvoice_view k = new addInvoice_view(cont,dentistList);
	    
	  //  cont.load("db.txt");
	    
	    cont.setViews(x,d,a,y,t,q,u,g,p,k);
	    stage.setTitle("Login");
	    stage.setResizable(false);
	    stage.setScene(x.scene);
        stage.show();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	public void stop(){
		try{
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		}catch(SQLException sqle){}
	}
	
	

}
