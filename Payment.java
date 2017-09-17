
import java.util.Date;

public class Payment {
	private static int pay = 0;
	private int paymentNo;
	private double paymentAmt;
	private Date paymentDate;
	
	public Payment(double a, Date d) {
		pay++;
		paymentNo = pay;
		paymentAmt = a;
		paymentDate = d;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public String toString() {
		return "Payment Number: " + paymentNo + " Payment Amount: " + paymentAmt + " Payment Date: " + paymentDate;
	}
	
	public void print() {
		System.out.println(toString());
	}
}
