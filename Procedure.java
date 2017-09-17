

import java.io.Serializable;

public class Procedure implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int pro = 0;
	private int proNo;
	private String proName;
	private double proCost;
	
	public Procedure(String n, double c) {
		pro++;
		proName = n;
		proCost = c;
		proNo = pro;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public double getProCost() {
		return proCost;
	}

	public void setProCost(double proCost) {
		this.proCost = proCost;
	}
	
	public String toString() {
		return "Procedure Name: " + proName + " Procedure Number: " + proNo + " Procedure Cost: " + proCost;
	}
	
	public void print() {
		System.out.println(toString());
	}
}
