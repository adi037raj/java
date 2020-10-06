package notepad;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class GoToDialog extends JDialog implements ActionListener {

	private JTextField txtLineNumber;
	private JLabel lblLineNumber;
	private JButton btnGo, btnCancel;
	Notepad notepad;

	public GoToDialog(Notepad notepad) {
		super(notepad, true);
		this.notepad = notepad;

		lblLineNumber = new JLabel("Line Number:");
		txtLineNumber = new JTextField(10);
		btnCancel = new JButton("Cancel");
		btnGo = new JButton("GoTo");
		add(lblLineNumber);
		add(txtLineNumber);
		add(btnGo);
		add(btnCancel);

		btnGo.addActionListener(this);
		btnCancel.addActionListener(this);

		Point point = notepad.ta.getLocationOnScreen();
		setLocation(point);

		int position = notepad.ta.getCaretPosition();
		try {
			int line = notepad.ta.getLineOfOffset(position);
			line++;
			txtLineNumber.setText(line + "");

		} catch (BadLocationException ex) {
		}
		txtLineNumber.selectAll();

		setTitle("Go To Line Number");
		setResizable(false);
		setLayout(new FlowLayout());
		setSize(250, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = (JButton) e.getSource();
		if (obj == btnGo) {
			int lineNumber = 0;
			try {
				lineNumber = Integer.parseInt(txtLineNumber.getText());
			} catch (NumberFormatException ex) {

				JOptionPane.showMessageDialog(this, "Invalid line number", "Invalid Number", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int total = notepad.ta.getLineCount();
			if (lineNumber > total || lineNumber < 1) {
				JOptionPane.showMessageDialog(this, "Line number the beyond the total number of line",
						"Number Out of Range", JOptionPane.ERROR_MESSAGE);
				return;
			}

			try {
				int index = notepad.ta.getLineStartOffset(lineNumber - 1);
				notepad.ta.setCaretPosition(index);
				this.dispose();

			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			dispose();
		}
	}
}
