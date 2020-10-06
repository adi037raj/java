package filesystem;

import java.io.File;

public class TraverseSubDir {
	public static void listFile(File root) {
		File list[] = root.listFiles();
		for (File file : list) {
			System.out.println(file);
			if (file.isDirectory()) {
				listFile(file);
			}
		}
	}

	public static void main(String[] args) {

		File file = new File("D:\\tmp");
		listFile(file);
	}
}
