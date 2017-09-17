

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import org.joda.time.DateTime;
import org.joda.time.Months;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Controller {
	private login_view x;
   private newDents_view d;
   private addPat_view y;
   private addPro_view t;
   private listPro_view q;
   private removePro_view a;
   private displayPat_view u;
   private removePat_view g;
   private addPay_view p;
   private addInvoice_view k;
   private Stage stage;
   private ArrayList<Dentist> dent;
   private Dentist log = null;
   private Connection conn;
    public Controller(Stage stage,ArrayList<Dentist> dentistList){
    	this.stage = stage;
    	dent = dentistList;
    	try {
			DriverManager.registerDriver( new org.apache.derby.jdbc.EmbeddedDriver());
		//	conn = DriverManager.getConnection("jdbc:derby:database;create=true");
			conn = DriverManager.getConnection("jdbc:derby:database");
			Statement stmt = conn.createStatement();
		      
		      String dentist = "create table dentist (" +
		    		  			"dNo int not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
		    		  			"dName varchar(20) not null," +
		    		  			"password varchar(20) not null)"; 
		      String patient = "create table patient ("+
		    		  			"pNo int not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"+
								"dNo int not null default 1,"+
								"pName varchar(20) not null," +
								"address varchar(30) not null)";
								
		      String procedure = "create table procedures("+
								"proNo int not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"+
								"dNo int not null default 1,"+
								"proName varchar(20) not null,"+
								"proCost double not null)";
		      String payment = "create table payment("+
								"payNo int not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"+
								"invNo int not null default 1,"+
								"payDate date not null,"+
								"payAmt double not null)";
								
		      String invoice = "create table invoice("+
								"invNo int not null GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"+
								"pNo int not null,"+
								"proNo int not null,"+
								"invDate date not null,"+
								"invAmt double not null,"+
								"paid boolean not null default false,"+
								"amtPaid double not null,"+
								"Primary key (invNo, pNo, proNo),"+
								"Foreign Key (pNo) references patient (pNo) on delete restrict,"+
								"Foreign Key (proNo) references procedures (proNo) on delete restrict )";

		  /*   stmt.executeUpdate(dentist);
		      stmt.executeUpdate(patient);
		      stmt.executeUpdate(procedure);
		      stmt.executeUpdate(invoice);
		      stmt.executeUpdate(payment); */
		      
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void setViews(login_view x, newDents_view d,removePro_view a, addPat_view y, addPro_view t, listPro_view q, displayPat_view u,removePat_view g,addPay_view p,addInvoice_view k){
    	this.x =x;
    	this.d =d;
    	this.a =a;
    	this.y = y;
    	this.t= t;
    	this.q = q;
    	this.u = u;
    	this.g = g;
    	this.p = p;
        this.k = k;
    }
    
    public void exit() {
    	stage.close();
    }
	
	public void loginDentist(String name, String pass) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
			stmt.setString(1,name);
			stmt.setString(2, pass);
			ResultSet set = stmt.executeQuery();
			while(set.next()) {
				String n =	set.getString("dName");
					String p = set.getString("password");
					if(n.equals(name) && p.equals(pass)) {
						log = new Dentist(n,p);
						stage.setScene(y.scene);
						break;
					}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void addDentist(ArrayList<Dentist> dent, String name, String pass) {
		stage.setTitle("Create Dentist");
		stage.setResizable(false);
		stage.setScene(d.scene);
	}
	
	public void cancelDent(Scene scene) {
		stage.setResizable(false);
		stage.setScene(x.scene);
	}
	
	public void createDent(String name, String pass) {
        try {
			PreparedStatement stmt = conn.prepareStatement("insert into dentist (dName, password) values (?, ?)");
			stmt.setString(1,name);
			stmt.setString(2, pass);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        stage.setScene(x.scene);
	} 
	
	public void addPat( ArrayList<Dentist> dent ) {
		stage.setTitle("Add Patient");
		stage.setResizable(false);
		stage.setScene(y.scene);
	}
	
	public void removePat( ArrayList<Dentist> dent ) {
		stage.setTitle("Remove Patient");
		stage.setResizable(false);
		stage.setScene(g.scene);
	}
	
	public void displayPat( ArrayList<Dentist> dent) {
		stage.setTitle("Display Patients");
		stage.setResizable(false);
		stage.setScene(u.scene);
	}
	
	public void addPro( ArrayList<Dentist> dent) {
		stage.setTitle("Add Procedure");
		stage.setResizable(false);
		stage.setScene(t.scene);
	}
	
	public void removePro( ArrayList<Dentist> dent) {
		stage.setTitle("Remove Procedure");
		stage.setResizable(false);
		stage.setScene(a.scene);
	}
	
	public void listPro( ArrayList<Dentist> dent) {
		stage.setTitle("List Procedure");
		stage.setResizable(false);
		stage.setScene(q.scene);
	}
	public void addPay(ArrayList<Dentist> dent) {
			stage.setTitle("Add Payment");
			stage.setResizable(false);
			stage.setScene(p.scene);
	}
        
        public void addInv(ArrayList<Dentist> dent) {
            stage.setTitle("Add Invoice");
			stage.setResizable(false);
			ArrayList<String> res = fillCombo();
			k.getCombo().getItems().clear();
		 	for(String n : res) {
		 		k.getCombo().getItems().addAll(n);
		 	}
			stage.setScene(k.scene);
        }
	
	public void addPatient(ArrayList<Dentist> dent, String name, String pass, String addr, String user) {
		 try {
				PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
				stmt.setString(1,log.getName());
				stmt.setString(2, log.getPassword());
				ResultSet set = stmt.executeQuery();
				while(set.next()) {
						String n =	set.getString("dName");
						String p = set.getString("password");
						int number = set.getInt("dNo");
						if(n.equals(user) && p.equals(pass) || log.getName().equals(user) && log.getPassword().equals(pass)) {
							PreparedStatement query = conn.prepareStatement("insert into patient (pName, address, dNo) values (?, ?, ?)");
							query.setString(1,name);
							query.setString(2, addr);
							query.setInt(3, number);
							query.executeUpdate();
							break;
						}
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void removePatient(ArrayList<Dentist> dent, String name, String pass, String addr, String user) {
		 try {
				PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
				stmt.setString(1,log.getName());
				stmt.setString(2, log.getPassword());
				ResultSet set = stmt.executeQuery();
				while(set.next()) {
						String n =	set.getString("dName");
						String p = set.getString("password");
						int number = set.getInt("dNo");
						if(n.equals(user) && p.equals(pass) || log.getName().equals(user) && log.getPassword().equals(pass)) {
							PreparedStatement query = conn.prepareStatement("delete from patient where pName = (?) and address = (?) and dNo = (?)");
							query.setString(1,name);
							query.setString(2, addr);
							query.setInt(3, number);
							query.executeUpdate();
							break;
						}
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public void display(ArrayList<Dentist> dent, String name, String pass, ListView<String> pat) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
			stmt.setString(1,log.getName());
			stmt.setString(2, log.getPassword());
			ResultSet set = stmt.executeQuery();
			while(set.next()) {
					String n =	set.getString("dName");
					String p = set.getString("password");
					int number = set.getInt("dNo");
					if(n.equals(name) && p.equals(pass) || log.getName().equals(name) && log.getPassword().equals(pass)) {
						PreparedStatement query = conn.prepareStatement("select * from patient where dNo = (?)");
						query.setInt(1, number);
						ResultSet result = query.executeQuery();
						pat.getItems().clear();
						while(result.next()) {
							String patientName = result.getString("pName");
							String patientAddress = result.getString("address");
							pat.getItems().add("Patient Name: " + patientName + " " + "Patient Address: " +patientAddress + "\n");
						}
						break;
					}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeProcedure(ArrayList<Dentist> dent, String user, String pass, String proName) {
		 try {
				PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
				stmt.setString(1,log.getName());
				stmt.setString(2, log.getPassword());
				ResultSet set = stmt.executeQuery();
				while(set.next()) {
						String n =	set.getString("dName");
						String p = set.getString("password");
						int number = set.getInt("dNo");
						if(n.equals(user) && p.equals(pass) || log.getName().equals(user) && log.getPassword().equals(pass)) {
							PreparedStatement query = conn.prepareStatement("delete from procedures where proName = (?) and dNo = (?)");
							query.setString(1,proName);
							query.setInt(2, number);
							query.executeUpdate();
							break;
						}
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void listProcedures(ArrayList<Dentist> dent, String user, String pass, ListView<String> pro) {
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
			stmt.setString(1,log.getName());
			stmt.setString(2, log.getPassword());
			ResultSet set = stmt.executeQuery();
			while(set.next()) {
					String n =	set.getString("dName");
					String p = set.getString("password");
					int number = set.getInt("dNo");
					if(n.equals(user) && p.equals(pass) || log.getName().equals(user) && log.getPassword().equals(pass)) {
						PreparedStatement query = conn.prepareStatement("select * from procedures where dNo = (?)");
						query.setInt(1, number);
						ResultSet result = query.executeQuery();
						pro.getItems().clear();
						while(result.next()) {
							String procedureName = result.getString("proName");
							Double procedureCost = result.getDouble("proCost");
							pro.getItems().add("Procedure Name: " + procedureName + " " + "Procedure Cost: " +procedureCost + "\n");
						}
						break;
					}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> fillCombo() {
		PreparedStatement stmt;
		ArrayList<String> res = new ArrayList<String>();
		try {
			 stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
			stmt.setString(1,log.getName());
			stmt.setString(2, log.getPassword());

			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				int number = result.getInt("dNo");
					PreparedStatement query = conn.prepareStatement("select * from procedures where dNo = (?)");
					query.setInt(1, number);
					ResultSet set = query.executeQuery();
					while(set.next()) {
						res.add(set.getString("proName"));
					}
					break;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return res;
	}
	
	public void addProcedure(ArrayList<Dentist> dent, String user, String pass, String proName, String cost) {
		 try {
			 	double realCost = Double.parseDouble(cost);
				PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
				stmt.setString(1,log.getName());
				stmt.setString(2, log.getPassword());
				ResultSet set = stmt.executeQuery();
				while(set.next()) {
						String n =	set.getString("dName");
						String p = set.getString("password");
						int number = set.getInt("dNo");
						if(n.equals(user) && p.equals(pass) || log.getName().equals(user) && log.getPassword().equals(pass)) {
							PreparedStatement query = conn.prepareStatement("insert into procedures (proName, proCost, dNo) values (?, ?, ?)");
							query.setString(1,proName);
							query.setDouble(2, realCost);
							query.setInt(3, number);
							query.executeUpdate();
							break;
						}

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 catch(NumberFormatException e) {
			}
	}
	
	
	public void addPayment(ArrayList<Dentist> dent, String user, String pass, String proName, String cost, String patName) {
		try {
			double realCost = Double.parseDouble(cost);
			PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
			stmt.setString(1,log.getName());
			stmt.setString(2, log.getPassword());
			ResultSet set = stmt.executeQuery();
			while(set.next()) {
				String n =	set.getString("dName");
				String p = set.getString("password");
				int number = set.getInt("dNo");
				if(n.equals(user) && p.equals(pass) || log.getName().equals(user) && log.getPassword().equals(pass)) {
					Calendar calendar = Calendar.getInstance();
					java.sql.Date current = new java.sql.Date(calendar.getTime().getTime());
					PreparedStatement query = conn.prepareStatement("select * from invoice i, procedures pro where pro.proNo = i.proNo and proName = (?) and dNo = (?)");
					query.setString(1, proName);
					query.setInt(2, number);
					ResultSet result = query.executeQuery();
					while(result.next()) {
						int invoiceNumber = result.getInt("invNo");
						PreparedStatement statement = conn.prepareStatement("insert into payment (invNo, payDate, payAmt) values (?, ?, ?)");
						statement.setInt(1, invoiceNumber);
						statement.setDate(2, current);
						statement.setDouble(3, realCost);
						statement.executeUpdate();
					}
					break;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch(NumberFormatException e) {
		}
	
	}
        
        public void addInvoice(ArrayList<Dentist> dent, String patName, String password, String username, String pro) {
        	try {
        		 String value = k.getCombo().getValue();
				PreparedStatement stmt = conn.prepareStatement("select * from dentist where dName = (?) and password = (?)");
				stmt.setString(1,log.getName());
				stmt.setString(2, log.getPassword());
				ResultSet set = stmt.executeQuery();
				while(set.next()) {
						String n =	set.getString("dName");
						String p = set.getString("password");
						if(n.equals(username) && p.equals(password) || log.getName().equals(username) && log.getPassword().equals(password)) {
							Calendar calendar = Calendar.getInstance();
							java.sql.Date current = new java.sql.Date(calendar.getTime().getTime());
							PreparedStatement query = conn.prepareStatement("select * from patient p, procedures pro where pro.dNo = p.dNo and proName = (?) and pName = (?)");
								query.setString(1, value);
								query.setString(2, patName);
							ResultSet result = query.executeQuery();
							while(result.next()) {
								int patientNumber = result.getInt("pNo");
								int proNumber = result.getInt("proNo");
								double proCost = result.getDouble("proCost");
								PreparedStatement statement = conn.prepareStatement("insert into invoice (pNo,proNo,invDate,invAmt,amtPaid) values (?, ?, ?, ?, ?)");
								statement.setInt(1,patientNumber);
								statement.setInt(2, proNumber);
								statement.setDate(3, (java.sql.Date) current);
								statement.setDouble(4, proCost);
								statement.setDouble(5, 0);
								statement.executeUpdate();
							}
							break;
						}
						
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	catch(NumberFormatException e) {
    		}
        }
	
	public void load(String s) {	
		
		try {
		         FileInputStream fileIn = new FileInputStream(s);
		         ObjectInputStream in = new ObjectInputStream(fileIn);

		         while( fileIn.available() > 0) {
		        	 Dentist x = (Dentist) in.readObject();
		        	 dent.add(x);
		         }
		         in.close();
		         fileIn.close();

	      } catch (FileNotFoundException fnf){
				 fnf.printStackTrace();
			 }
		catch(EOFException z) {
			z.printStackTrace();
		}
		catch(IOException i) {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c) {
	         c.printStackTrace();
	      }
	}
	
	public void save(String s) {
			try {
			FileOutputStream fileOut =new FileOutputStream(s);
		    ObjectOutputStream out = new ObjectOutputStream(fileOut);

			         for(Dentist e : dent) 
			         {
					    out.writeObject(e);
			         }
			         out.close();
			         fileOut.close();
			}
			 catch (FileNotFoundException fnf){
				 fnf.printStackTrace();
			 }

			 catch (IOException ioe){
			    ioe.printStackTrace();
			 } 
		}
		
	
	public void generatePaymentReport() {
			try {
				FileWriter fw = new FileWriter("paymentReport.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				DateTime currentDate = new DateTime();
				PreparedStatement stmt = conn.prepareStatement("select * from patient p, invoice i, payment pay where p.pNo = i.pNo and pay.invNo = i.invNo");
				ResultSet set = stmt.executeQuery();
				while(set.next()) {
					DateTime dt = new DateTime(set.getDate("payDate"));
					if(Months.monthsBetween(dt,currentDate).getMonths() > 6){
						String patientName = set.getString("pName");
						String patientAddress = set.getString("address");
						String invoiceDate = set.getString("invDate");
						String paid = set.getString("paid");
						String invAmt = set.getString("invAmt");
						String amtPaid = set.getString("amtPaid");
						bw.write("Patient Name: " + patientName + " Patient Address: " + patientAddress);
						bw.newLine();
						bw.write("Invoice Date: " + invoiceDate + " Invoice Paid: " + paid + " Invoice Amount: " + invAmt + " Amount Paid: " + amtPaid);
						bw.newLine();
					}
				}
				fw.close();
			 	bw.close();
			 }
			 catch (FileNotFoundException fnf){
				fnf.printStackTrace();
			 }
			 catch (IOException ioe){
			    ioe.printStackTrace();
			 } catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void generateReport() {
		try {
			FileWriter fw = new FileWriter("report.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PreparedStatement stmt = conn.prepareStatement("select * from patient p, invoice i where p.pNo = i.pNo");
			ResultSet set = stmt.executeQuery();
			while(set.next()) {
				String patientName = set.getString("pName");
				String patientAddress = set.getString("address");
				String invoiceDate = set.getString("invDate");
				String paid = set.getString("paid");
				String invAmt = set.getString("invAmt");
				String amtPaid = set.getString("amtPaid");
				bw.write("Patient Name: " + patientName + " Patient Address: " + patientAddress);
				bw.newLine();
				bw.write("Invoice Date: " + invoiceDate + " Invoice Paid: " + paid + " Invoice Amount: " + invAmt + " Amount Paid: " + amtPaid);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
