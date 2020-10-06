package mypack;

import java.io.Serializable;

public class Student implements Serializable
{
	String reg,name,branch;
	transient int marks;
	public Student(String reg, String name, String branch, int marks) {
		super();
		this.reg = reg;
		this.name = name;
		this.branch = branch;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return reg + ", " + name + ", "+ branch+","+ marks + "\n";
	}
}
