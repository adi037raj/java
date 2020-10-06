package filesystem;

import java.io.File;

public class Program {
	public static void main(String[] args) {

		File file = new File("D:\\");
		// String strs[] = file.list();
		File list[] = file.listFiles();
		for (File f : list) {
			if (f.isFile()) {
				String name = f.getName();
				name = name.toLowerCase();
				if (name.contains("improvement"))
					System.out.println(name);
			}
		}
	}
}
