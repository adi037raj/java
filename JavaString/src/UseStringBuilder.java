
public class UseStringBuilder 
{
	public static void main(String[] args) {
		
		
		StringBuilder builder=new StringBuilder("Hello");
//		StringBuilder builder2=new StringBuilder("Hello");
		
//		System.out.println(builder==builder2);
		
	
		builder.append(true);
		System.out.println(builder);
		builder.append("JAVA");
		System.out.println(builder);
		
		
		
	}
}
