package mypack;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StartExam extends JFrame implements ActionListener
{
	ArrayList<Question> list_question;
	JTextArea taQuestion,taOptionA,taOptionB,taOptionC,taOptionD;
	JRadioButton rbOptionA,rbOptionB,rbOptionC,rbOptionD;
	JButton bStart,bClear,bNext,bSubmit;
	ButtonGroup grp;
	FlowLayout flow=new FlowLayout();
	byte q_num=0;
	public StartExam()
	{
		list_question=new ArrayList<>();
		addQuestion();
		
		taQuestion=new JTextArea(6, 20);
		taOptionA=new JTextArea(3, 15);
		taOptionB=new JTextArea(3, 15);
		taOptionC=new JTextArea(3, 15);
		taOptionD=new JTextArea(3, 15);
		
		rbOptionA=new JRadioButton();
		rbOptionB=new JRadioButton();
		rbOptionC=new JRadioButton();
		rbOptionD=new JRadioButton();
		
		bStart=new JButton("Start");
		bClear=new JButton("Clear");
		bNext=new JButton("Next");
		bSubmit=new JButton("Submit");
		grp=new ButtonGroup();
		
		addControls();
		
		setSize(230,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void addControls()
	{
		setLayout(flow);
		add(new JScrollPane(taQuestion));
		add(rbOptionA);
		add(new JScrollPane(taOptionA));
		add(rbOptionB);
		add(new JScrollPane(taOptionB));
		add(rbOptionC);
		add(new JScrollPane(taOptionC));
		add(rbOptionD);
		add(new JScrollPane(taOptionD));
		add(bStart);
		add(bNext);
		add(bClear);
		add(bSubmit);
		bNext.setEnabled(false);
		bClear.setEnabled(false);
		bSubmit.setEnabled(false);

		
		taQuestion.setEditable(false);
		taOptionA.setEditable(false);
		taOptionB.setEditable(false);
		taOptionC.setEditable(false);
		taOptionD.setEditable(false);
		
		taQuestion.setLineWrap(true);
		taQuestion.setWrapStyleWord(true);
		taOptionA.setLineWrap(true);
		taOptionA.setWrapStyleWord(true);
		taOptionB.setLineWrap(true);
		taOptionB.setWrapStyleWord(true);
		taOptionC.setLineWrap(true);
		taOptionC.setWrapStyleWord(true);
		taOptionD.setLineWrap(true);
		taOptionD.setWrapStyleWord(true);
		
		grp.add(rbOptionA);
		grp.add(rbOptionB);
		grp.add(rbOptionC);
		grp.add(rbOptionD);		
		
		//register to action listener
		bClear.addActionListener(this);
		rbOptionA.addActionListener(this);
		rbOptionB.addActionListener(this);
		rbOptionC.addActionListener(this);
		rbOptionD.addActionListener(this);
		bStart.addActionListener(this);
		bNext.addActionListener(this);
		bSubmit.addActionListener(this);
	}
	void addQuestion()
	{
		list_question.add(new Question("Who is President of India ?", "Pratibha Singh Patil", "Pranab Mukherjee", "Manmohan Singh", "L.K. Advani", "b"));
		list_question.add(new Question("Chief Minister of Jharkhand ?", "Arjun Munda", "Mahdu Koda", "Babu Lal Marandi", "Hemant Soren", "d"));
		list_question.add(new Question("Who is the chief Minister of Gujrat ?", "Narendra Modi", "Madhusudan Mistri", "Anandi Ben", "Keshu Bhai Patel", "c"));
		list_question.add(new Question("Who is the Governer of Kerala ?", "Sheela Dixit", "Prabhat Kumar", "A.H Ansari", "Saiyed Ahmed", "a"));
	}
	public static void main(String[] args)
	{
		new StartExam();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object obj=arg0.getSource();
		if(obj==bStart)
		{
			bClear.setEnabled(true);
			bNext.setEnabled(true);
			bStart.setEnabled(false);
			bSubmit.setEnabled(true);
			Question ques_obj=list_question.get(q_num);
			setQuestion(ques_obj);
			q_num++;
		}
		else if(obj==bNext)
		{
			Question ques_obj=list_question.get(q_num);
			setQuestion(ques_obj);
			grp.clearSelection();
			if(ques_obj.getAnswer_given().length()>0)
			{
				String ans=ques_obj.getAnswer_given();
				if(ans.compareToIgnoreCase("a")==0)
					rbOptionA.setSelected(true);
				else if(ans.compareToIgnoreCase("b")==0)
					rbOptionB.setSelected(true);
				else if(ans.compareToIgnoreCase("c")==0)
					rbOptionC.setSelected(true);
				else
					rbOptionD.setSelected(true);
			}
			if(q_num==list_question.size()-1)
			{
				bNext.setEnabled(false);
				bSubmit.setEnabled(true);
			}
			q_num++;
		}
		else if(obj==bClear)
		{
			grp.clearSelection();
			list_question.get(q_num-1).setAnswer_given("");
		}
		else if(obj==rbOptionA)
		{
			list_question.get(q_num-1).setAnswer_given("a");
		}
		else if(obj==rbOptionB)
		{
			list_question.get(q_num-1).setAnswer_given("b");
		}
		else if(obj==rbOptionC)
		{
			list_question.get(q_num-1).setAnswer_given("c");
		}
		else if(obj==rbOptionD)
		{
			list_question.get(q_num-1).setAnswer_given("d");
		}
		else if(bSubmit==obj)
		{
			int option=JOptionPane.showConfirmDialog(null, "Are u sure?");
			if(option==JOptionPane.OK_OPTION)
				checkAnswer();
		}
	}
	
	void setQuestion(Question ques_obj)
	{
		taQuestion.setText((q_num+1)+".) "+ques_obj.getQuestion());
		taOptionA.setText(ques_obj.getOption_a());
		taOptionB.setText(ques_obj.getOption_b());
		taOptionC.setText(ques_obj.getOption_c());
		taOptionD.setText(ques_obj.getOption_d());
	}
	
	void checkAnswer()
	{
		byte right,wrong,not_attempt;
		right=wrong=not_attempt=0;
		for(byte i=0;i<list_question.size();i++)
		{
			Question ob=list_question.get(i);
			if(ob.getAnswer_given().length()==0)
				not_attempt++;
			else if(ob.getAnswer().equalsIgnoreCase(ob.getAnswer_given()))
					right++;
			else
				wrong++;
		}
		
		JOptionPane.showMessageDialog(null, "Right "+right+"\nWrong "+wrong+"\nNot Attempt "+not_attempt);
	}
}