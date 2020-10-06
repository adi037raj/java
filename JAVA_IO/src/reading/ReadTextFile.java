package reading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
	public static void main(String[] args) {

		try {
			FileReader reader = new FileReader("file.txt");
			int i = 0;
			char ch[] = new char[20];
			// reader.read(ch);
			// System.out.println(ch[1]);
			
			while ((i = reader.read()) != -1) {
				System.out.print((char) i);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
