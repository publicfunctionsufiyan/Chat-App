package rmi.client;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import rmi.server.*;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable {

	private static final long serialVersionUID = 1L;
	private ChatServerIF chatServer;
	private String name = null;
	boolean chekExit = true;
	protected ChatClient(String name, ChatServerIF chatServer) throws RemoteException
	{
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerChatClient(this);
	}
	
	public void retriveMessage(String message) throws RemoteException
	{
		
		System.out.println(message);
	}
	
	
	
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		
		String message;
		
		
		while(chekExit)
		{
			message = scanner.nextLine();
			String endprog = "bye";
		
			if(message.equals(endprog))
			{
				chekExit = false;
				System.out.println("Chat Ended");
				try {
					chatServer.broadcastMessage(name + " : " +"chat ended");
					
				}
				catch(RemoteException e)
				{
					e.printStackTrace();
				}
				System.exit(0);
				
			}else {
			
				try {
					chatServer.broadcastMessage(name + " : " +message);
					
				}
				catch(RemoteException e)
				{
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
		}
		
	}
	
}
