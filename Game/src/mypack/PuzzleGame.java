package mypack;

import java.awt.DisplayMode;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PuzzleGame extends JFrame implements ActionListener
{
	static final byte SIZE=3;
	JButton b[][];
	GridLayout grid;
	byte num[];
	byte index;
	int moves;
	public PuzzleGame()
	{
		moves=0;
		b=new JButton[SIZE][SIZE];
		grid=new GridLayout(SIZE, SIZE);
		index=0;
		num=new byte[SIZE*SIZE];
		while(index<SIZE*SIZE)
		{
			byte n=generateNum();
			if(!checkDuplicate(n))
			{
				num[index]=n;
				index++;
			}
		}
		index=0;
		for(byte i=0;i<SIZE;i++)
		{
			for(byte j=0;j<SIZE;j++)
			{
				b[i][j]=new JButton();
				if(num[index]!=0)
					b[i][j].setText(String.valueOf(num[index]));
				else
					b[i][j].setEnabled(false);
				index++;
				b[i][j].addActionListener(this);
				add(b[i][j]);
			}
		}
		
		setLayout(grid);
		setResizable(false);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	byte generateNum()
	{
		byte n;
		Random r=new Random();
		n=(byte) r.nextInt(SIZE*SIZE);
		return n;
	}
	boolean checkDuplicate(byte n)
	{
		for(byte i=0;i<index;i++)
		{
			if(n==num[i])
				return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		new PuzzleGame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		byte r,c=0;
		Object obj=arg0.getSource();
		for(r=0;r<SIZE;r++)
		{
			for(c=0;c<SIZE;c++)
			{
				if(obj==b[r][c])
					break;
			}
			if(c<SIZE)
				break;
		}
		//check for right
		if(c+1<SIZE)
		{
			if(b[r][c+1].getText().length()==0)
			{
				b[r][c+1].setText(b[r][c].getText());
				b[r][c].setText("");
				b[r][c+1].setEnabled(true);
				b[r][c].setEnabled(false);
			}
		}
		
		//check for left
		if(c-1>=0)
		{
			if(b[r][c-1].getText().length()==0)
			{
				b[r][c-1].setText(b[r][c].getText());
				b[r][c].setText("");
				b[r][c-1].setEnabled(true);
				b[r][c].setEnabled(false);
			}
		}
		//check for top
		if(r-1>=0)
		{
			if(b[r-1][c].getText().length()==0)
			{
				b[r-1][c].setText(b[r][c].getText());
				b[r][c].setText("");
				b[r-1][c].setEnabled(true);
				b[r][c].setEnabled(false);
			}
		}
		//check for bottom
		if(r+1<SIZE)
		{
			if(b[r+1][c].getText().length()==0)
			{
				b[r+1][c].setText(b[r][c].getText());
				b[r][c].setText("");
				b[r+1][c].setEnabled(true);
				b[r][c].setEnabled(false);
			}
		}
		
		moves++;
		if(checkWin())
		{
			JOptionPane.showMessageDialog(this, "Win in "+moves+" moves");
			dispose();
		}
	}
	
	boolean checkWin()
	{
		byte i=1;
		for(byte r=0;r<SIZE;r++)
		{
			for(byte c=0;c<SIZE;c++)
			{
				if(b[r][c].getText().length()==0)
					return false;
				else
				{
					byte x=Byte.parseByte(b[r][c].getText());
					if(x!=i)
						return false;
					i++;
					if(i==SIZE*SIZE-1)
						return true;
				}
			}
		}
		return false;
	}
}
