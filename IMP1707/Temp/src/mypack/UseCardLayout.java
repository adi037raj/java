package mypack;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UseCardLayout extends JFrame implements ActionListener
{
	static final byte SIZE=6;
	JButton b[];
	CardLayout card;
	JPanel pan;
	public UseCardLayout()
	{
		b=new JButton[SIZE];
		//card=new CardLayout();
		card=new CardLayout(20,20);
		pan=new JPanel();
		pan.setLayout(card);
		for(byte i=0;i<SIZE;i++)
		{
			b[i]=new JButton("Button"+(i+1));
			b[i].addActionListener(this);
			pan.add(b[i]);
		}
		add(pan);
		//setSize(400, 300);
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		int h,w;
		h=toolkit.getScreenSize().height;
		w=toolkit.getScreenSize().width;
		setSize(w, h);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new UseCardLayout();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		card.next(pan);
	}
}
