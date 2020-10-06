package writing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile3 {
	public static void main(String[] args) {

		FileWriter writer;
		try {
			writer = new FileWriter("file3.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write("Wrting Using BufferWriter");
			bufferedWriter.newLine();
			bufferedWriter.write("Line2");
			bufferedWriter.flush();
			writer.close();
			

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
