package chatClient;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import chatServer.ServerInterface;

public class ClientMain {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String chatServerURL = "rmi://localhost/RMIChatServer";
		ServerInterface chatServer = (ServerInterface) Naming.lookup(chatServerURL);
		new Thread(new Client(args[0], args[1], args[2], args[3], chatServer)).start();
	}
}
