
public class Perfomance {
	public static void main(String[] args) {

		String name = "Hello";
		int max = 2000;
		long s = System.currentTimeMillis();
		for (int i = 1; i <= max; i++) {
			name = name + i;
		}

		long e = System.currentTimeMillis();
		System.out.println(e - s);

		s = System.currentTimeMillis();

		StringBuilder builder = new StringBuilder("Hello");
		for (int i = 1; i <= max; i++) {
			builder.append(i);
		}
		e = System.currentTimeMillis();
		System.out.println(e - s);

	}
}
