class Student
{
	String fname;
	String lname;
	
	public Student()
	{
		
	}
	public Student(String fname,String lname)
	{
		this.fname=fname;
		this.lname=lname;	
	}
	public Student(String fname)	
	{
		this.fname=fname;
	}
	public void showName()
	{
		System.out.println("fname:"+fname+" , lname:"+lname);
	}	
		
}
class UseConstructor
{
	public static void main(String arr[])
	{
		Student obj=new Student("Sumit","Kumar");
		obj.showName();
				
		
	}
}

