package mypack;

import java.io.IOException;
import java.sql.SQLException;

class A {
	public void show() throws IOException, SQLException {

	}
}
class B extends A {
	@Override
	public void show() {

	}
}

public class ThrowsException {

	public static void main(String[] args) {
		A obj = new A();
		try {
			obj.show();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
