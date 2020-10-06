package filesystem;

import java.io.File;

public class DriveList {

	public static void main(String[] args) {

		File list[] = File.listRoots();
		// System.out.println(System.currentTimeMillis());
		// System.out.println(Long.MAX_VALUE - System.currentTimeMillis());

		for (File file : list) {
			if (file.canRead()) {
				System.out.println("________________"+file+"_____________");
				File fileList[]=file.listFiles();
				for (File f: fileList) {
					System.out.println(f);
				}
			}
		}
	}
}
