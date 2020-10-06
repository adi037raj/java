class Student
{
	int id;
	String name;
	int marks;
	
	public Student(int id,String name,int marks)
	{
		this.id=id;
		this.name=name;
		this.marks=marks;
	}	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Student)
		{
			Student s=(Student)obj;
			if(s.id==this.id)
				return true;
		}
		return false;
	}
}
class CompareTwoObject
{
	public static void main(String arr[])
	{
		Student std=new Student(121,"Amit",43);
		Student std2=new Student(122,"Amit",43);		
		System.out.println(std==std2);
	
		Student std3=std;
		
		System.out.println(std==std3);
	
		boolean result=std.equals(std2);

		System.out.println(result);
		System.out.println(std.equals(std3));
	}
}