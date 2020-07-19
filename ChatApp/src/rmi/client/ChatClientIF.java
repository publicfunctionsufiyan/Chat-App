package rmi.client;


import java.rmi.*;

public interface ChatClientIF extends Remote{
	void retriveMessage(String Meesage) throws RemoteException;

}
