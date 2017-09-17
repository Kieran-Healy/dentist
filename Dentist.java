

import java.io.Serializable;
import java.util.ArrayList;

public class Dentist extends Person implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String password;
		private ArrayList<Patient> patientList;
		private ArrayList<Procedure> procedureList;
		private int pNo;
		private int proNo;
		
		public Dentist(String n, String a, String p) {
			super(n,a);
			password = p;
			 patientList = new ArrayList<Patient>();
			 procedureList = new ArrayList<Procedure>();
			 pNo=0;
			 proNo =0;
			 
		}
		
		public Dentist(String n, String p) {
			super(n);
			password = p;
			 patientList = new ArrayList<Patient>();
			 procedureList = new ArrayList<Procedure>();
			 pNo=0;
			 proNo=0;
		}
		
		public Dentist(String n, String p, int patNo, int procedureNo) {
			super(n);
			password = p;
			 patientList = new ArrayList<Patient>();
			 procedureList = new ArrayList<Procedure>();
			 pNo= patNo;
			 proNo= procedureNo;
		} 
		
		public void removePat(String name, String addr) {
			for(Patient y : patientList) {
				if(y.getName().equals(name) && y.getAddr().equals(addr)) {
					patientList.remove(y);
					pNo--;
				}
			}
		}
		
		public void addInvoice(Patient x,Invoice v) {
			for(Patient y : patientList) {
				if(x.getName().equals(y.getName())) {
					y.addInvoice(v);
				}
			}
		}
		
		public void addProcedure(Procedure e) {
			System.out.println(procedureList);
			procedureList.add(e);
			proNo++;
		}
		
		public void removeProcedure(String n) {
			for(Procedure x : procedureList) {
				if(x.getProName().equals(n)) {
					procedureList.remove(x);
					proNo--;
				}
			}
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public void addPat(Patient x) {
			patientList.add(x);
			pNo++;
		}
		
		public int getPno() {
			return pNo;
		}
		
		public int getProNo() {
			return proNo;
		}
		
		public ArrayList<Patient> getPatientList() {
			return patientList;
		}
		
		public ArrayList<Procedure> getProcedureList() {
			return procedureList;
		}
		
		public Procedure getProcedure(int i) {
			if(procedureList.get(i) != null) 
			{
				return procedureList.get(i);
			}
			else {
				return null;
			}
		}
		
		public Patient getPatient(int i) {
			if(patientList.get(i) != null) 
			{
				return patientList.get(i);
			}
			else {
				return null;
			}
		}

		public void setPatientList(ArrayList<Patient> patientList) {
			this.patientList = patientList;
		}

		public String toString() {
			return "Name: " + getName() + " Address: " + getAddr() + " Password: " + password;
		}
		
		public void print() {
			System.out.println(toString());
		}
}
