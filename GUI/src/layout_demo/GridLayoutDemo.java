package layout_demo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo extends JFrame implements ActionListener {
	GridLayout gridLayout;

	JButton btn[][];

	final int ROW = 5, COLUMN = 5;

	public GridLayoutDemo() {

		gridLayout = new GridLayout(ROW, COLUMN);
		setLayout(gridLayout);

		btn = new JButton[ROW][COLUMN];
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COLUMN; c++) {
				btn[r][c] = new JButton("[" + r + "][" + c + "]");
				add(btn[r][c]);
				btn[r][c].addActionListener(this);
			}
		}
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn=(JButton)e.getSource();
		System.out.println(btn.getText()+" clicled");
	}

	public static void main(String[] args) {
		new GridLayoutDemo();
	}
}
