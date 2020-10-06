package mypack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientProg
{
	public static void main(String[] args)
	{
	
			try {
				String ip= JOptionPane.showInputDialog("Enter Ip address").trim();
				Socket client=new Socket(ip, 5120);
				System.out.println("Connected to Server");
				Scanner sc=new Scanner(System.in);
				System.out.println("Say Hello to Server");
				String str=sc.nextLine();
				OutputStream os= client.getOutputStream();
				InputStream is=client.getInputStream();
				
				PrintWriter pw=new PrintWriter(os);
				pw.println(str);
				pw.flush();
				
				sc=new Scanner(is);
				str=sc.nextLine();
				System.out.println(str);
				pw.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
