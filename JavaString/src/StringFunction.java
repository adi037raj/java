
public class StringFunction {

	public static void main(String[] args) {

		String name = "Welcome";
		System.out.println(name.charAt(5));

		System.out.println(name.length());

		name = name.toLowerCase();
		System.out.println(name);
		name = name.toUpperCase();
		System.out.println(name);

		System.out.println(name.concat(" Java"));

		System.out.println("-------------------------------------");

		name = "Welcome";
		int index = name.indexOf('e');
		System.out.println(index);

		index = name.indexOf('e', 2);
		System.out.println(index);

		name = "Welcome to Dhanbad,I am from Dhanbad";
		index = name.indexOf("Dhanbad", 12);
		System.out.println(index);

		System.out.println(name.lastIndexOf("Dhanbad"));

		name = "Raj Kumar";

		System.out.println(name.startsWith("Raj"));
		System.out.println(name.endsWith("Kumar"));

		System.out.println(name.contains("Ku"));
		char ch[] = name.toCharArray();
		System.out.println(name.replace('a', 'b'));

		name = "Amit/Raj";
		System.out.println(name.substring(1));
		System.out.println(name.substring(1,3));//start index is inclusive and lastindex is exclusive
		
		System.out.println(name.substring(name.indexOf('/')+1));

		
		
	}
}
