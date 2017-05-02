package chatServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import chatClient.ClientInterface;

public interface ServerInterface extends Remote{
	void registerChatClient(ClientInterface chatClient) throws RemoteException;
	void broadcastMessage(String message, String name) throws RemoteException;
}
