package reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile2 {

	public static void main(String[] args) {

		FileReader fileReader;
		try {
			fileReader = new FileReader("file.txt");
			BufferedReader reader = new BufferedReader(fileReader);
			String txt = "";
			while ((txt = reader.readLine()) != null) {
				String s[] = txt.split("-");
				System.out.println("Name:" + s[0] + " Marks:" + s[1]);
			}
		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
