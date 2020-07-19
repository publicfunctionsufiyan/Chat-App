package rmi.server;

import java.rmi.*;
import rmi.client.*;

public interface ChatServerIF extends Remote{
	
	void registerChatClient(ChatClientIF chatClient) throws RemoteException;
	void broadcastMessage(String message) throws RemoteException;

}
