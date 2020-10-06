package notepad;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FindReplaceDialog extends JDialog implements ActionListener {
	private Notepad notepad;
	private JLabel lblFind, lblReplace;
	private JButton btnFind, btnFindReplace, btnReplaceAll, btnClose;
	JTextField txtFind, txtReplace;

	public FindReplaceDialog(Notepad notepad) {
		super(notepad);

		this.notepad = notepad;
		setLayout(new FlowLayout());
		lblFind = new JLabel("Find");
		lblReplace = new JLabel("Replace With");

		txtFind = new JTextField(20);
		txtReplace = new JTextField(20);

		btnFind = new JButton("Find");
		btnFindReplace = new JButton("Find Replace");
		btnReplaceAll = new JButton("ReplaceAll");
		btnClose = new JButton("Close");

		add(lblFind);
		add(txtFind);
		add(btnFind);
		add(lblReplace);
		add(txtReplace);
		add(btnFindReplace);
		add(btnReplaceAll);
		add(btnClose);

		btnClose.addActionListener(this);
		btnFind.addActionListener(this);
		btnReplaceAll.addActionListener(this);
		btnFindReplace.addActionListener(this);

		setSize(400, 200);
		setResizable(false);
		setLocationRelativeTo(notepad);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object btn = e.getSource();
		if (btn == btnFind) {
			boolean found = find();
			if (!found) {
				JOptionPane.showMessageDialog(this, "Not Found");
			}

		} else if (btn == btnFindReplace) {

			String text = notepad.ta.getSelectedText();
			if (text != null) {
				notepad.ta.replaceSelection(txtReplace.getText());
			}
			boolean found = find();
			if (!found) {
				JOptionPane.showMessageDialog(this, "Not Found");
			}
		} else if (btn == btnReplaceAll) {
			while (find()) {
				String text = notepad.ta.getSelectedText();
				if (text != null) {
					notepad.ta.replaceSelection(txtReplace.getText());
				}
			}
		} else if (btn == btnClose) {
			setVisible(false);
		}
	}

	private boolean find() {
		String findText = txtFind.getText();
		int fromIndex = notepad.ta.getCaretPosition();
		String text = notepad.ta.getText();
		int index = text.indexOf(findText, fromIndex);
		if (index != -1) {
			int length = findText.length();
			notepad.ta.select(index, index + length);
			return true;
		}
		return false;
	}
}
