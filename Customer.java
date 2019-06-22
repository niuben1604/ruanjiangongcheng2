package library;
import java.io.Serializable;

public class Customer implements Serializable{
	private String name ;
	private String passWord;

	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public String getPassWord() {
	return passWord;
	}
	public void setPassWord(String passWord) {
	this.passWord = passWord;
	}
	//带参构造方法
	public Customer(String name, String passWord) {
	super();
	this.name = name;
	this.passWord = passWord;
	}
	public Customer() {
	super();
	}
	}