

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.VBox;

public class tab_view {
	Scene scene;
    ArrayList<Dentist> dentistList;
    VBox mainVbox = new VBox();
    TabPane tab = new TabPane();
	public tab_view(Controller cont,ArrayList<Dentist> dent) {
		Menu fileMenu = new Menu("File");
		Menu exitMenu = new Menu("Exit");
		Menu reportMenu = new Menu("Report");
		MenuBar menuBar = new MenuBar();
		

		MenuItem save = new MenuItem("Save");
		MenuItem load = new MenuItem("Load");
		MenuItem exit = new MenuItem("Exit");
		MenuItem payReport = new MenuItem("Payment Report");
		MenuItem report = new MenuItem("Report");
		fileMenu.getItems().addAll(save,load);
		reportMenu.getItems().addAll(payReport,report);
		exitMenu.getItems().addAll(exit);
		menuBar.getMenus().addAll(fileMenu,reportMenu,exitMenu);
		
		dentistList = dent;
		Tab addPat = new Tab();
		addPat.setText("Add Patient");
		Tab removePat = new Tab();
		removePat.setText("Delete Patient");
		Tab displayPat = new Tab();
		displayPat.setText("Display Patients");
		Tab addPro = new Tab();
		addPro.setText("Add Procedure");
		Tab removePro = new Tab();
		removePro.setText("Remove Procedure");
		Tab listPro = new Tab();
		listPro.setText("List Procedure");
		Tab addPay = new Tab();
		addPay.setText("Add Payment");
                Tab addInv = new Tab();
                addInv.setText("Add Invoice");
		
		tab.getTabs().add(addPat);
		tab.getTabs().add(removePat);
		tab.getTabs().add(displayPat);
		tab.getTabs().add(addPro);
		tab.getTabs().add(removePro);
		tab.getTabs().add(listPro);
		tab.getTabs().add(addPay);
                tab.getTabs().add(addInv);
		tab.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
	//	tab.getSelectionModel().select(addPat);
		
		save.setOnAction(e -> cont.save("db.txt"));
		load.setOnAction(e -> cont.load("db.txt"));
		exit.setOnAction(e -> cont.exit());
		payReport.setOnAction(e -> cont.generatePaymentReport());
		report.setOnAction(e -> cont.generateReport());
		addPat.setOnSelectionChanged(e -> cont.addPat(dentistList));
		removePat.setOnSelectionChanged( e -> cont.removePat(dentistList));
		displayPat.setOnSelectionChanged(e -> cont.displayPat(dentistList));
		addPro.setOnSelectionChanged(e -> cont.addPro(dentistList));
		removePro.setOnSelectionChanged(e -> cont.removePro(dentistList));
		listPro.setOnSelectionChanged(e -> cont.listPro(dentistList));
		addPay.setOnSelectionChanged(e -> cont.addPay(dentistList));
                addInv.setOnSelectionChanged(e -> cont.addInv(dentistList));
		//mainVbox.setPadding(new Insets(-170,0,0,-50));
		mainVbox.setAlignment(Pos.TOP_CENTER);
		mainVbox.getChildren().addAll(menuBar,tab);
		
	
	}
	
	public VBox getBox() {
		return mainVbox;
	}
	
	public TabPane getTab() {
		return tab;
	}
}
