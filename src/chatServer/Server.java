package chatServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Set;
import chatClient.ClientInterface;

public class Server extends UnicastRemoteObject implements ServerInterface {
	private static final long serialVersionUID = 1L;
	private HashMap <String, ClientInterface > chatClients;
	protected Server() throws RemoteException {
		chatClients = new HashMap<String, ClientInterface>();
	}
	public synchronized void registerChatClient(ClientInterface chatClient)
			throws RemoteException {
		this.chatClients.put(chatClient.getName(), chatClient);
	}
	public synchronized void broadcastMessage(String message, String name) throws RemoteException {
		if(message.equals("get location"))
	 	{
	 	 message= chatClients.get(name).getX() +","+ chatClients.get(name).getY();
	 	}
		else if(message.equals("list 30")){
		 	Set<String> key = chatClients.keySet();
		 	String mess="List of users : \n";
		  int p=Integer.parseInt(chatClients.get(name).getX());
		 	int q=Integer.parseInt(chatClients.get(name).getY());
		 	int r=0;
		 	int s=0;
		  for(String name2 : key){
		  r=Integer.parseInt(chatClients.get(name2).getX());
		  s=Integer.parseInt(chatClients.get(name2).getY());
		 	 if((((r-p)^2 + (s-q)^2)^1/2)<= 30){
		 	 mess+=name2+"\n";
		 	 }
		  }
		  message = mess;
		  }
		
		chatClients.get(name).retrieveMessage(message,name);
	}
}