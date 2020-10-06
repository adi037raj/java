class Student
{
	String name;
	int marks;

	public Student(String name,int marks)
	{
		this.name=name;
		this.marks=marks;
	}
	public String toString()
	{
		return "Name:"+name+",Marks:"+marks;
	}	
}
class UseToString
{
	public static void main(String arr[])
	{
		Student std=new Student("Raj",78);

		System.out.println(std.getClass());
		System.out.println(std.hashCode());
		System.out.println(std.toString());
		System.out.println(std);//println() method internally call toString() method

		Student std2=new Student("Sumit",50);
		System.out.println(std2);		
	}
}