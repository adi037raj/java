package chat;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatClient extends JFrame implements ActionListener
{
	JScrollPane sp_recv,sp_send;
	JTextArea ta_recv,ta_send;
	JButton bSend;
	OutputStream os;
	InputStream is;
	public ChatClient(Socket client)
	{		
		ta_recv=new JTextArea(15,25);
		ta_send=new JTextArea(3,15);
		bSend=new JButton("Send");
		sp_recv=new JScrollPane(ta_recv);
		sp_send=new JScrollPane(ta_send);
		
		add(sp_recv);
		add(sp_send);
		add(bSend);
		
		bSend.addActionListener(this);
		
		ta_recv.setEditable(false);
		
		setSize(300, 400);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		ta_send.requestFocus();
		
		try {
			os=client.getOutputStream();
			is=client.getInputStream();
			ReadInput th_read=new ReadInput();
			th_read.start();
			JOptionPane.showMessageDialog(this, "Connected to server");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.dispose();
		}
	}
	public static void main(String[] args)
	{
		String str_ip;
		do{
		str_ip=JOptionPane.showInputDialog("Enter IP Address").trim();
		}while(str_ip.length()==0 || str_ip==null);
		
		try {
			Socket c_bj=new Socket(str_ip, 4310);
			new ChatClient(c_bj);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String str=ta_send.getText().trim();
		if(str.length()==0)
		{
			JOptionPane.showMessageDialog(this, "Enter Message");
			ta_send.requestFocus();
			return;
		}
		
		PrintWriter pw=new PrintWriter(os);
		pw.println(str);
		pw.flush();
		
		ta_send.setText("");
		ta_send.requestFocus();
	}
	
	class ReadInput extends Thread
	{
		@Override
		public void run()
		{
			Scanner sc=new Scanner(is);
			String msg_recv;
			while(true)
			{
				msg_recv=sc.nextLine();
				ta_recv.append(msg_recv+"\n");
			}
		}
	}
}