package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ServerChat
{
	static ArrayList<Socket> list_clients;
	public static void main(String[] args)
	{
		try {
			ServerSocket server=new ServerSocket(4310);
			System.out.println("Server Started\n");
			list_clients=new ArrayList<>();
			while(true)
			{
				System.out.println("Wait for new client");
				Socket client=server.accept();
				list_clients.add(client);
				new HandleClient(client);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class HandleClient extends Thread
{
	Socket client;
	public HandleClient(Socket client)
	{
		this.client=client;
		start();
	}
	
	@Override
	public void run()
	{	
		try {
			InputStream is=client.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader buff=new BufferedReader(isr);
			String str;
			while(true)
			{
				str=buff.readLine();
				Iterator<Socket> iterator=ServerChat.list_clients.iterator();
				while(iterator.hasNext())
				{
					OutputStream os=iterator.next().getOutputStream();
					PrintWriter pw=new PrintWriter(os);
					pw.println(str);
					pw.flush();
				}
			}
		}
		catch(SocketException e)
		{
			ServerChat.list_clients.remove(client);
			System.out.println("Client closed");
		}
		catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
