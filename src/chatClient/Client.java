package chatClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import chatServer.ServerInterface;

public class Client extends UnicastRemoteObject implements ClientInterface, Runnable {
	private static final long serialVersionUID = 1L;
	private ServerInterface chatServer;
	public String name = null;
	public String x_axis = null;
	public String y_axis = null;
	public String clientAge = null;
	private Scanner scanner;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getX() {
		return x_axis;
	}
	public void setX(String a) {
		this.x_axis = a;
	}
	public String getY() {
		return y_axis;
	}
	public void setY(String b) {
		this.y_axis = b;
	}
	public String getAge() {
		return clientAge;
	}
	public void setAge(String age) {
		this.clientAge = age;
	}
	protected Client(String name, String a, String b,String age, ServerInterface chatServer) throws RemoteException {
	this.name = name;
	this.x_axis = a;
	this.y_axis = b;
	this.clientAge = age;
	this.chatServer = chatServer;
	chatServer.registerChatClient(this);
	}
	public void retrieveMessage(String message, String name) throws RemoteException {
		System.out.println(name+ " : "+ message);
	}
	public void run() {
		scanner = new Scanner(System.in);
		String message;
		while(true){
			message = scanner.nextLine();
			try {
				if(message.startsWith("send"))
				{
					String[] str = message.split (" ");
					String m ="";
					for(int i1=2;i1<str.length;i1++){
						  m+=str[i1]+" ";
						  }
				chatServer.broadcastMessage(m, str[1]);
				}
				else if (message.equals("quit"))
				{
					System.exit(0);
				}
				
				else if(message.startsWith("go"))
				{
					String[] str = message.split (" ");
					x_axis = new Integer(Integer.parseInt(x_axis) + Integer.parseInt(str[1])).toString(); 
					y_axis = new Integer(Integer.parseInt(y_axis) + Integer.parseInt(str[2])).toString();
					chatServer.registerChatClient(this);
				}
								
				else 
				{
					
					chatServer.broadcastMessage(message, name);
				}
			} catch (RemoteException e)
			
			
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}