
import java.io.Serializable;
import java.util.ArrayList;

public class Patient extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int pat = 0;
	 private int patNo;
	 private ArrayList<Invoice> invoiceList;
         private ArrayList<Payment> paymentList;
 
	 public Patient(String n, String a) {
		 super(n,a);
		 pat++;
		 patNo = pat;
		 invoiceList = new ArrayList<Invoice>();
                 paymentList = new ArrayList<Payment>();
	 }
	 
	 public ArrayList<Invoice> getInvoiceList() {
		 return invoiceList;
	 }
	 
	 public ArrayList<Payment> getPaymentList() {
		 return paymentList;
	 }
	 
	 public void addInvoice(Invoice y) {
		 invoiceList.add(y);
	 }
         
         public void addPayment(Payment e) {
             paymentList.add(e);
         }
	 
	 public void removeInvoice(Invoice y) {
		 invoiceList.remove(y);
	 }
         
         public void removePayment(Payment e) {
             paymentList.remove(e);
         }
	
	public int getPatNo() {
		return patNo;
	}
	
	public void setPatNo(int patNo) {
		this.patNo = patNo;
	}
	
	public Invoice getInvoice(int i) {
		if(invoiceList.get(i) != null) 
		{
		 return invoiceList.get(i);
		}
	 else {
		 	return null;
		 }
	}
        
        public Payment getPayment(int i) {
            	if(paymentList.get(i) != null) 
		{
		 return paymentList.get(i);
		}
	 else {
		 	return null;
		 }
        }
	
	
	public String toString() {
		return "Name: " + getName() + " Address: " + getAddr() + " Patient Number: " + patNo;
	}
	
	public void print() {
		System.out.println(toString());
	}
}
