import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerDemo extends JFrame implements ActionListener {
	JLabel label;
	Date date;
	Timer timer;
	
	public TimerDemo() 
	{
		label = new JLabel();
		setLayout(new FlowLayout());
		add(label);

		timer = new Timer(1000, this);
		timer.start();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		date = new Date();
		label.setText(date.toString());
	}
	public static void main(String[] args) {
		new TimerDemo();
	}
}

