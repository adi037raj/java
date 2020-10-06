package mypack;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Second extends Frame {
	
	
	public Second() {
		setSize(500, 500);
	
		
		Choice choice=new Choice();
		choice.addItem("Dhanbad");
		choice.addItem("Ranchi");
		choice.addItem("Bokaro");
		
		add(choice);
		
		
		Checkbox chA=new Checkbox("OptionA",true);
		Checkbox chB=new Checkbox("OptionB");
		Checkbox chC=new Checkbox("OptionC");
		Checkbox chD=new Checkbox("OptionD");
		
		//chA.setEnabled(false);
		
		add(chA);
		add(chB);
		add(chC);
		add(chD);
		
		CheckboxGroup group=new CheckboxGroup();
	
		
		
		Checkbox chMale=new Checkbox("Male",group,true);
		Checkbox chFemale=new Checkbox("Female",group,false);
		
		
		add(chMale);
		add(chFemale);
		
		
		
		
		
		
		setLayout(new FlowLayout());
		
	
		setVisible(true);
		
		
		
		
		

	}

	public static void main(String[] args) {
		new Second();
	}
}
