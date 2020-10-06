
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Puzzle extends JFrame implements ActionListener {
	private JButton btn[][];
	private final int ROWS = 2, COLS = ROWS;
	int arr[] = new int[ROWS * COLS];

	public Puzzle() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		generateNumbers();
		initButton();
		validate();
	}

	private void initButton() {
		btn = new JButton[ROWS][COLS];
		GridLayout grid = new GridLayout(ROWS, COLS);
		setLayout(grid);
		int index = 0;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				int n = arr[index++];
				btn[i][j] = new JButton(n == 0 ? "" : n + "");
				btn[i][j].addActionListener(this);
				// btn[i][j].setFont(new Font("", Font.BOLD, 30));
				add(btn[i][j]);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getText().length() != 0) {
			String text = b.getText();
			int pr = 0, pc = 0;
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLS; j++) {
					if (text.equalsIgnoreCase(btn[i][j].getText())) {
						// System.out.println(i + "," + j);
						pr = i;
						pc = j;
						break;
					}
				}
			}

			// check for up

			if (pr - 1 >= 0 && btn[pr - 1][pc].getText().length() == 0) {

				// System.out.println("up");
				btn[pr - 1][pc].setText(text);
				b.setText("");
			}
			// check for down
			else if (pr + 1 < ROWS && btn[pr + 1][pc].getText().length() == 0) {
				// System.out.println("down");
				btn[pr + 1][pc].setText(text);
				b.setText("");
			}

			// check for left
			else if (pc - 1 >= 0 && btn[pr][pc - 1].getText().length() == 0) {

				// System.out.println("left");
				btn[pr][pc - 1].setText(text);
				b.setText("");
			}
			// check for right
			else if (pc + 1 < ROWS && btn[pr][pc + 1].getText().length() == 0) {
				// System.out.println("right");
				btn[pr][pc + 1].setText(text);
				b.setText("");
			}

		}
		if (checkWin()) {
			JOptionPane.showMessageDialog(this, "You won!", "Win", JOptionPane.INFORMATION_MESSAGE);
			removeListener();
		}

	}

	private boolean checkWin() {
		if (btn[ROWS - 1][COLS - 1].getText().length() != 0)
			return false;
		int count = 1;

		boolean isCorrect = true;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				String text = btn[i][j].getText();
				if (text.length() != 0) {
					int num = Integer.parseInt(text);
					if (num != count) {
						isCorrect = false;
						break;
					}
				}
				count++;
			}
		}
		return isCorrect;
	}

	private void removeListener() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				btn[i][j].removeActionListener(this);
			}
		}
	}

	private void generateNumbers() {
		int count = 0;
		do {
			int n = (int) ((Math.random() * 100) % (ROWS * COLS));
			int i;
			for (i = 0; i < count; i++) {
				if (arr[i] == n) {
					break;
				}
			}
			if (count == arr.length) {
				break;
			}
			if (i == count) {
				arr[count++] = n;
			}
		} while (true);
	}

	public static void main(String[] args) {
		new Puzzle();
	}
}