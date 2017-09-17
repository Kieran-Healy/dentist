
import java.io.Serializable;

public abstract class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String addr;
	
	public Person(String n, String a) {
		name = n;
		addr = a;
	}
	
	public Person(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
