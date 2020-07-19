package rmi.server;

import java.net.MalformedURLException;
import java.rmi.*;


public class ChatServerDriver {
	public static void main(String[] args) throws RemoteException, MalformedURLException
	{
		Naming.rebind("RMIChatServer", new ChatServer());
	}

}
