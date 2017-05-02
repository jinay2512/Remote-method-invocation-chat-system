package chatClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
	void retrieveMessage(String message, String name)throws RemoteException;
	public String getName() throws RemoteException;
	public String getX() throws RemoteException;
	public String getY() throws RemoteException;
	public void setX(String a) throws RemoteException;
	public void setY(String b) throws RemoteException;
}
