public class UseStringClass {
	public static void main(String[] args) {

		String str="Hello";
		String str2="World";
		
		System.out.println(str==str2);
		String str3="World";
		System.out.println(str2==str3);

		str3="Java";
		
		String str4=str2+str3;

		String name=new String("Ajay");
		String name2=new String("Ajay");
		
		
		
		System.out.println(name==name2);
	
		
	}
}
