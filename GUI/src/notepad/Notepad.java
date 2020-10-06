package notepad;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener, WindowListener, KeyListener {
	JMenuBar mbar;
	JMenu mFile, mEdit, mFormat, mView, mHelp;
	JTextArea ta;

	JMenuItem iNew, iOpen, iSave, iSaveAs;
	JCheckBoxMenuItem iWordWrap;

	JMenuItem iCopy, iCut, iPaste, iDelete, iSelectAll, iUndo, iGoTo, iFindReplace, iDate;

	JMenuItem iBackground, iForeground;

	JFileChooser fileChooser;

	FileDialog findReplaceDialog;

	private boolean isSaved = true;

	FileWriter writer;

	public Notepad() {
		mbar = new JMenuBar();
		ta = new JTextArea();
		ta.addKeyListener(this);

		fileChooser = new JFileChooser();

		Font font = new Font("Adobe Fangsong Std", Font.BOLD, 18);
		ta.setFont(font);

		JScrollPane scrollPane = new JScrollPane(ta);
		// scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);

		mFile = new JMenu("File");
		mEdit = new JMenu("Edit");
		mFormat = new JMenu("Format");
		mHelp = new JMenu("Help");
		mView = new JMenu("View");

		mbar.add(mFile);
		mbar.add(mEdit);
		mbar.add(mFormat);
		mbar.add(mView);
		mbar.add(mHelp);

		iCut = new JMenuItem("Cut");
		iCopy = new JMenuItem("Copy");
		iPaste = new JMenuItem("Paste");
		iUndo = new JMenuItem("Undo");
		iSelectAll = new JMenuItem("Select All");
		iDelete = new JMenuItem("Delete");

		// edit Menu items start

		iGoTo = new JMenuItem("Go To");
		iFindReplace = new JMenuItem("Find Replace");
		iDate = new JMenuItem("Date/Time");

		mEdit.add(iUndo);
		mEdit.add(iCopy);
		mEdit.add(iCut);
		mEdit.add(iPaste);
		mEdit.add(iDelete);
		mEdit.addSeparator();
		mEdit.add(iSelectAll);
		mEdit.add(iGoTo);
		mEdit.add(iFindReplace);
		mEdit.add(iDate);

		iCopy.addActionListener(this);
		iPaste.addActionListener(this);
		iDelete.addActionListener(this);
		iSelectAll.addActionListener(this);
		iCut.addActionListener(this);
		iGoTo.addActionListener(this);
		iFindReplace.addActionListener(this);
		iDate.addActionListener(this);

		// edit Menu items end

		// Format Menu Start

		iWordWrap = new JCheckBoxMenuItem("Word Wrap");
		iBackground = new JMenuItem("Background");
		iForeground = new JMenuItem("Forground");

		mFormat.add(iWordWrap);
		mFormat.addSeparator();
		mFormat.add(iBackground);
		mFormat.add(iForeground);

		iBackground.addActionListener(this);
		iForeground.addActionListener(this);
		iWordWrap.addActionListener(this);
		// Format Menu End

		// File Menu Start

		iNew = new JMenuItem("New");
		// iNew.setIconTextGap(30);
		iOpen = new JMenuItem("Open");
		iSave = new JMenuItem("Save");
		iSaveAs = new JMenuItem("Save As");

		mFile.add(iNew);
		mFile.add(iOpen);
		mFile.addSeparator();
		mFile.add(iSave);
		mFile.add(iSaveAs);

		iNew.addActionListener(this);
		iOpen.addActionListener(this);
		iSave.addActionListener(this);
		iSaveAs.addActionListener(this);

		// File Menu End

		setJMenuBar(mbar);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == iCut) {

			ta.cut();

		} else if (obj == iCopy) {
			ta.copy();
		} else if (obj == iPaste) {
			ta.paste();

		} else if (obj == iUndo) {

		} else if (obj == iSelectAll) {
			ta.selectAll();
		} else if (obj == iDelete) {

		} else if (obj == iForeground) {

			Color clr = JColorChooser.showDialog(this, "Select Foreground Color", Color.black);
			ta.setForeground(clr);

		} else if (obj == iBackground) {
			Color clr = JColorChooser.showDialog(this, "Select Background Color", Color.white);
			ta.setBackground(clr);
		} else if (obj == iWordWrap) {
			if (iWordWrap.isSelected()) {
				ta.setLineWrap(true);
				iGoTo.setEnabled(false);
			} else {
				ta.setLineWrap(false);
				iGoTo.setEnabled(true);
			}
		}

		else if (obj == iOpen) {
			if (!isSaved) {
				int option = JOptionPane.showConfirmDialog(this, "Do u want to save?", "Confirmation",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					save();
				} else if (option == JOptionPane.CANCEL_OPTION)
					return;
			}
			fileChooser.setDialogTitle("Select A File To Open");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setApproveButtonText("Open File");
			fileChooser.setApproveButtonToolTipText("Click To Open File In Notepad");
			int option = fileChooser.showOpenDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					FileReader r = new FileReader(file);
					ta.read(r, null);

					writer = new FileWriter(file);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (iGoTo == obj) {
			GoToDialog goToDialog = new GoToDialog(this);
		} else if (iFindReplace == obj) {
			if (findReplaceDialog == null) {
				findReplaceDialog = new FileDialog(this);
			} else {
				findReplaceDialog.setVisible(true);
			}
		} else if (iDate == obj) {
			Date date = new Date();
			ta.insert(date.toString(), ta.getCaretPosition());
		} else if (iNew == obj) {
			if (!isSaved) {
				int option = JOptionPane.showConfirmDialog(this, "Do u want to save changes?", "Confirmation",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					return;
				}
				if (option == JOptionPane.NO_OPTION) {
					ta.setText("");
					isSaved = true;
					return;
				}

			} else {
				if (ta.getText().length() == 0) {
					ta.setText("");
				}
			}
		} else if (iSave == obj) {
			save();
		} else if (iSaveAs == obj) {
			saveAs();
		}
	}

	void save() {
		if (!isSaved) {
			if (writer == null) {
				saveAs();
			} else {
				try {
					ta.write(writer);
					writer.flush();
					isSaved = true;
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	void saveAs() {
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			if (file.exists()) {
				option = JOptionPane.showConfirmDialog(this, "File exists,Replace?");
				if (option == JOptionPane.NO_OPTION) {
					return;
				}
			}
			try {
				writer = new FileWriter(file);
				ta.write(writer);
				writer.flush();
				isSaved = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Notepad();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		isSaved = false;
	}
}
