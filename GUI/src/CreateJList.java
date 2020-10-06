import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CreateJList extends JFrame implements ListSelectionListener {

	JList<String> list;
	JScrollPane scrollPane;

	public CreateJList() {

		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fonts[] = graphicsEnvironment.getAvailableFontFamilyNames();

		list = new JList<>(fonts);
		// list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		list.addListSelectionListener(this);

		scrollPane = new JScrollPane(list);

		add(scrollPane);

		setSize(400, 400);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new CreateJList();

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

//		System.out.println("First:" + e.getFirstIndex());
//		System.out.println("Last:" + e.getLastIndex());
//		int index=e.getLastIndex();
		System.out.println(list.getSelectedValue());		
	}
}
