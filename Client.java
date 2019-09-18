import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket echoSocket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	BufferedReader stdIn;

	public static void main(String args[]) {
		String host = "127.0.0.1";
		int port = 8081;
		new Client(host, port);
	}

	public Client(String host, int port) {
		init(host, port);
		
		try {
			System.out.print("Signup or Login (s/l): ");
			String userInput = stdIn.readLine();
			sendData(userInput);
			//System.out.println("server: " + receiveData());

			while (true) {
				//System.out.print("client: ");
				userInput = stdIn.readLine();

				if ("q".equals(userInput)) {
					break;
				}
				out.println(userInput);
				System.out.println("server: " + in.readLine());
				//if()
				//System.out.print("client: ");
				//String userInput = stdIn.readLine();
				/** Exit on 'q' char sent */
			}

			/** Closing all the resources */
			out.close();
			in.close();
			stdIn.close();
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendData(String userInput) {
		// TODO Auto-generated method stub
		out.println(userInput);
		System.out.println("Client sent: " + userInput);
	}
	
	private String receiveData() {
		String temp = null;
		try {
			while ((temp = in.readLine()) != null) {
				System.out.println("Client received: " + temp);
				return temp;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Client received: " + temp);
		return temp;
	}

	private void init(String server, int port) {
		// TODO Auto-generated method stub
		try {
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			echoSocket = new Socket(server, port);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Unknown host: " + server);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Unable to get streams from server");
			System.exit(1);
		}
	}
}
