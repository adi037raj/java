package mypack;

public class Student
{
	private String reg,name,branch;
	private int marks;
	
	public Student(String reg) {
		super();
		this.reg = reg;
	}
	public Student(String reg, String name, String branch, int marks) {
		super();
		this.reg = reg;
		this.name = name;
		this.branch = branch;
		this.marks = marks;
	}
	public String getReg() {
		return reg;
	}
	public String getName() {
		return name;
	}
	public String getBranch() {
		return branch;
	}
	public int getMarks() {
		return marks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [reg=" + reg + ", name=" + name + ", branch=" + branch
				+ ", marks=" + marks + "]";
	}
	
	
}
