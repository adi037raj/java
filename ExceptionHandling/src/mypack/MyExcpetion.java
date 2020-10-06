package mypack;

class InvalidMarksException extends RuntimeException {

	public InvalidMarksException(String message) {
		super(message);
	}

	public InvalidMarksException() {
		super("Invalid marks marks must be between [0-100]");
	}
}

class Student {
	private String name;
	private int marks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		if (marks >= 0 && marks <= 100)
			this.marks = marks;
		else
			throw new InvalidMarksException();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}

}

public class MyExcpetion {

	public static void main(String[] args) {

		Student obj = new Student();
		obj.setName("Raj");
		
		obj.setMarks(-8);

		System.out.println(obj);

	}

}
