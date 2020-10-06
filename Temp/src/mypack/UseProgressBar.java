package mypack;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class UseProgressBar extends JFrame implements ActionListener
{
	JProgressBar progress;
	JButton bStart;
	Timer timer;
	int val=0;
	public UseProgressBar()
	{
		progress=new JProgressBar();
		bStart=new JButton("Start");
		timer=new Timer(500, this);
		bStart.addActionListener(this);
		add(progress);
		add(bStart);
		
		setLayout(new FlowLayout());
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new UseProgressBar();
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object obj=arg0.getSource();
		if(obj==bStart)
		{
			timer.start();
			bStart.setEnabled(false);
		}
		else if(obj==timer)
		{
			val=val+5;
			progress.setValue(val);
			if(val==100)
				this.dispose();
		}
	}
}
