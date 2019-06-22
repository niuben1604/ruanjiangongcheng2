package library;

public class BookTwo {
	private String bname;
	private String btype;
	private double bprice;
	private String bnum;
	private int bleft;

	public String getBname() {
	return bname;
	}
	public void setBname(String bname) {
	this.bname = bname;
	}
	public String getBtype() {
	return btype;
	}
	public void setBtype(String btype) {
	this.btype = btype;
	}
	public double getBprice() {
	return bprice;
	}
	public void setBprice(double bprice) {
	this.bprice = bprice;
	}
	public String getBnum() {
	return bnum;
	}
	public void setBnum(String bnum) {
	this.bnum = bnum;
	}
	public int getBleft() {
	return bleft;
	}
	public void setBleft(int bleft) {
	this.bleft = bleft;
	}
	public BookTwo( String bnum,String bname, String btype, double bprice,
	int bleft) {
	super();
	this.bname = bname;
	this.btype = btype;
	this.bprice = bprice;
	this.bnum = bnum;
	this.bleft = bleft;
	}
	
	public BookTwo() {
	super();
	}
	}
