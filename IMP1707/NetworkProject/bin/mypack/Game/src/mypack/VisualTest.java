package mypack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class VisualTest extends JFrame implements ActionListener
{
	static final byte TOTAL=4;
	static final short TIME=700;
	static final byte COL=4;
	JPanel pan1,pan2;
	GridLayout grid;
	JLabel lblImage;
	JButton btnImages[];
	byte images[],rand_show[],img_index;
	Timer timer,timer_count;
	byte check,row,count;
	public VisualTest()
	{
		pan1=new JPanel();
		pan2=new JPanel();
		lblImage=new JLabel();
		btnImages=new JButton[TOTAL];
		if(TOTAL%COL==0)
			grid=new GridLayout(TOTAL/COL, COL);
		else
			grid=new GridLayout(TOTAL/COL+1, COL);
		
		for(byte i=0;i<TOTAL;i++)
		{
			btnImages[i]=new JButton();
			pan2.add(btnImages[i]);
		}
		
		timer=new Timer(TIME, this);
		timer_count=new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				count++;
				if(count==10)
				{
					JOptionPane.showMessageDialog(VisualTest.this, "Time Over");
					System.exit(0);
				}
			}
		});
		
		pan2.setLayout(grid);
		pan1.add(lblImage);
		
		images=new byte[TOTAL];
		rand_show=new byte[TOTAL];
		initialize();
		
		setSize(400, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void initialize()
	{
		img_index=0;
		count=0;
		while(img_index<TOTAL)
		{
			byte n=generateNum(13);
			if(!isDuplicate(images,n))
			{
				images[img_index]=n;
				img_index++;
			}
		}
		remove(pan2);
		repaint();
		add(pan1);
		img_index=0;
		check=0;
		
		timer.start();
	}
	byte generateNum(int max)
	{
		Random r=new Random();
		byte i=(byte) r.nextInt(max);
		return i;
	}
	boolean isDuplicate(byte data[],byte num)
	{
		for(byte i=0;i<img_index;i++)
		{
			if(data[i]==num)
				return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		new VisualTest();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(img_index==TOTAL)
		{
			timer.stop();
			lblImage.setIcon(null);
			img_index=0;
			while(img_index<TOTAL)
			{
				byte n=generateNum(TOTAL);
				if(!isDuplicate(rand_show,n))
				{
					rand_show[img_index]=n;
					img_index++;
				}
			}
			
			CheckClick obj=new CheckClick();
			for(byte i=0;i<img_index;i++)
			{
				Icon img_btn=new ImageIcon("images/"+images[rand_show[i]]+".jpg");
				btnImages[i].setIcon(img_btn);
				btnImages[i].addActionListener(obj);
				pan2.add(btnImages[i]);
			}
			remove(pan1);
			repaint();
			add(pan2);
			timer_count.start();
			return;
		}
		Icon img=new ImageIcon("images/"+images[img_index]+".jpg");
		lblImage.setIcon(img);
		img_index++;
	}
	class CheckClick implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Object obj=arg0.getSource();
			if(obj instanceof JButton)
			{
				byte i;
				for(i=0;i<img_index;i++)
				{
					if(obj==btnImages[i])
						break;
				}
				
				if(check!=rand_show[i])
				{
					JOptionPane.showMessageDialog(null, "You Lost");
					System.exit(0);
				}
				btnImages[i].removeActionListener(this);
				btnImages[i].setEnabled(false);
				check++;
				if(check==TOTAL)
				{
					timer_count.stop();
					JOptionPane.showMessageDialog(null, "You Win");
					for(i=0;i<TOTAL;i++)
						btnImages[i].setEnabled(true);
					initialize();
					check=0;
				}
			}
		}
	}
}