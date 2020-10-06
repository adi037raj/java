class UseThis
{
	String fname;
	String lname;

	void setName(String fname,String lname)
	{
		this.fname=fname;
		this.lname=lname;
		this.showFullName();
	}
	void showFullName()
	{
		System.out.println("FName:"+this.fname+",LName:"+this.lname);
		System.out.println("___________________________");
	}	

	public static void main(String arr[])
	{
		UseThis obj=new UseThis();
		obj.setName("Amit","Kumar");
		//obj.showFullName();

		
											
	}
}