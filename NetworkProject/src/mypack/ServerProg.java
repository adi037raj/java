package mypack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProg
{
	public static void main(String[] args)
	{
		try {
			ServerSocket server=new ServerSocket(5120);
			System.out.println("Server Created");
			System.out.println("Wait for client");
			Socket client= server.accept();
			System.out.println("Connected to Client");
			
			OutputStream os=client.getOutputStream();
			InputStream is=client.getInputStream();
			
			Scanner sc=new Scanner(is);
			String str=sc.nextLine();
			System.out.println(str);
			
			sc=new Scanner(System.in);
			System.out.println("Say hello to client");
			str=sc.nextLine();
			
			PrintWriter pw=new PrintWriter(os);
			pw.println(str);
			pw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
