import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class CreateSplitPane extends JFrame {

	JPanel leftPanel,rightPanel;
	public CreateSplitPane() {

		
		
		
		JSplitPane pane=new JSplitPane();
		
		leftPanel=new JPanel();
		rightPanel=new JPanel();
		
		leftPanel.setBackground(Color.red);
		rightPanel.setBackground(Color.cyan);
		
		pane.setLeftComponent(leftPanel);
		pane.setRightComponent(rightPanel);
		
		
//		pane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pane.setOneTouchExpandable(true);
		pane.setDividerSize(35);
		
		
		add(pane);
		setSize(700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
		
		
	}

	public static void main(String[] args) {
		new CreateSplitPane();
	}
}
