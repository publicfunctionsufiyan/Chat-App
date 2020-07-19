package rmi.server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import rmi.client.*;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF {
	private static final long serialVersionUID = 1L;
	private ArrayList<ChatClientIF> chatClients;
	
	protected ChatServer() throws RemoteException{
		chatClients = new ArrayList<ChatClientIF>();
	}
	
	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException
	{
		 this.chatClients.add(chatClient);
	}

	public synchronized void broadcastMessage(String message) throws RemoteException
	{
		int i=0;
		while (i < chatClients.size())
		{
			chatClients.get(i++).retriveMessage(message);
		}
	}
}





