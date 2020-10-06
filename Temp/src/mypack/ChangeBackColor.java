package mypack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeBackColor extends JFrame implements ChangeListener,ActionListener
{
	JPanel pan;
	JButton bColor;
	JSlider slider_red,slider_green,slider_blue;
	JSpinner spin_red;
	public ChangeBackColor()
	{
		pan=new JPanel();
		slider_blue=new JSlider(0, 255);
		slider_green=new JSlider(0, 255);
		slider_red=new JSlider(0, 255);
		spin_red=new JSpinner();
		bColor=new JButton("ChooseColor");
		
		slider_blue.setBackground(Color.blue);
		slider_red.setBackground(Color.red);
		slider_green.setBackground(Color.green);
		slider_blue.setValue(50);
		slider_red.setValue(100);
		slider_green.setValue(0);
		
		pan.add(slider_red);
		pan.add(spin_red);
		pan.add(slider_green);
		pan.add(slider_blue);
		pan.add(bColor);
		
		add(pan);
		
		slider_blue.addChangeListener(this);
		slider_red.addChangeListener(this);
		slider_green.addChangeListener(this);
		bColor.addActionListener(this);
		
		spin_red.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				slider_red.setValue(Integer.parseInt(spin_red.getValue().toString()));
			}
		});
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		stateChanged(null);
	}
	public static void main(String[] args)
	{
		new ChangeBackColor();
	}
	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		int r,g,b;
		r=slider_red.getValue();
		g=slider_green.getValue();
		b=slider_blue.getValue();
		Color clr=new Color(r, g, b);
		pan.setBackground(clr);
		spin_red.setValue(r);
		//slider_blue.setToolTipText(String.valueOf(b));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Color clr= JColorChooser.showDialog(this, "Back Color", pan.getBackground());
		if(clr!=null)
		{
			slider_blue.setValue(clr.getBlue());
			slider_green.setValue(clr.getGreen());
			slider_red.setValue(clr.getRed());
			pan.setBackground(clr);
		}
	}
}
