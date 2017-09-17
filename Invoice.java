
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Invoice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int inv = 0;
	private int invoiceNo;
	private boolean isPaid;
	private Date invoiceDate;
	private double invoiceAmt;
	private ArrayList<Payment> paymentList;
	private ArrayList<Procedure> procedureList;
	private boolean paid = false;
	private double amount;
	
	public Invoice(Date d, boolean p, double a, Payment e, Procedure x,double amt) {
		inv++;
		invoiceDate = d;
		invoiceNo = inv;
		isPaid = p;
		invoiceAmt = a;
		amount = amt;
		 paymentList = new ArrayList<Payment>();
		 procedureList = new ArrayList<Procedure>();
		 if(amount >= invoiceAmt) {
			 paid = true;
		 }
		 else {
			 paid = false;
		 }
	}
	

	public Invoice(Date d, double a, Procedure x, double amt) {
		inv++;
		invoiceDate = d;
		invoiceNo = inv;
		invoiceAmt = a;
		amount = amt;
		if(amount >= invoiceAmt) {
			 paid = true;
		 }
		 else {
			 paid = false;
		 }
	    paymentList = new ArrayList<Payment>();
	    procedureList = new ArrayList<Procedure>();
	}
	
	public Invoice(Date d, double a) {
		inv++;
		invoiceDate = d;
		invoiceNo = inv;
		invoiceAmt = a;
//		amount = amt;
		if(amount >= invoiceAmt) {
			 paid = true;
		 }
		 else {
			 paid = false;
		 }
	    paymentList = new ArrayList<Payment>();
	    procedureList = new ArrayList<Procedure>();
	}
	
	public double intAmt(double a) {
		amount +=a;
		paid = paid(amount);
		return amount;
	}
	
	public boolean paid(double a) {
		if(amount >= a) {
			 paid = true;
		 }
		 else {
			 paid = false;
		 }
		return paid;
	}
	
	public ArrayList<Payment> getPayment() {
		return paymentList;
	}
	
	public ArrayList<Procedure> getProcedure() {
		return procedureList;
	}
	
	public void addPayment(Payment e) {
		paymentList.add(e);
	}
	
	public void addProcedure(Procedure x) {
		procedureList.add(x);
	}
	
	public void removePayment(Payment e) {
		paymentList.remove(e);
	}
	
	public void removeProcedure(Procedure x) {
		procedureList.remove(x);
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(double invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}
	
	public String toString() {
		return "Date: " + invoiceDate + " Invoice Number: " + invoiceNo + " Paid: " + isPaid + " Amount: " + invoiceAmt + " " + getProcedure();
	}
	
	public void print() {
		System.out.println(toString());
	}

}
