import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread {
	//setting up port number for the server
	public static final int PORT_NUMBER = 8081;

	protected Socket socket;

	//constructor to initialize the server socket. Will be called everytime a client connects with server
	private SocketServer(Socket socket) {
		this.socket = socket;
		System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
		start();
	}


	//overrides the run() method (from Thread class)

	public void run() {
		//InputStream is for message coming from the client and OutputStream is to send a message to the client
		InputStream in = null;
		OutputStream out = null;

		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String request;
			//These strings are for user data
			String fname = "", lname = "", username = "", email = "", passwd = "";
			String temp = "";

			//waits for the reply from the client. The 1st reply will be for signup/login selection which is 's' or 'l'
			while ((request = br.readLine()) != null) {
				System.out.println("Message received:" + request);
				request += '\n';

				//if s - signup, ask for client details like name, username, email and password.
				//if l - login, ask for username and password
				if(request.equals("s\n"))
				{	
					temp = "Enter first name:";
					temp += '\n';
					//sends the message stored in temp variable
					out.write(temp.getBytes());
					//wait for message from the client
					while ((request = br.readLine()) != null)
					{
						fname = request;
						break;
					}

					temp = "Enter last name:";
					temp += '\n';
					out.write(temp.getBytes());
					while ((request = br.readLine()) != null)
					{
						lname = request;
						break;
					}

					temp = "Enter username:";
					temp += '\n';
					out.write(temp.getBytes());
					while ((request = br.readLine()) != null)
					{
						username = request;
						break;
					}
					
					temp = "Enter email:";
					temp += '\n';
					out.write(temp.getBytes());
					while ((request = br.readLine()) != null)
					{
						email = request;
						break;
					}

					temp = "Enter password:";
					temp += '\n';
					out.write(temp.getBytes());
					while ((request = br.readLine()) != null)
					{
						passwd = request;
						break;
					}

					signup sup = new signup(fname, lname, username, email, passwd);
					boolean signup_status = sup.createAcc();

					if(signup_status)
					{
						temp = "Signup successful!";
						temp += '\n';
						out.write(temp.getBytes());
					}
					else
					{
						temp = "Signup unsuccessful";
						temp += '\n';
						out.write(temp.getBytes());
					}
				}
				else if(request.equals("l\n"))
				{
					temp = "Enter username:";
					temp += '\n';
					out.write(temp.getBytes());
					while ((request = br.readLine()) != null)
					{
						username = request;
						break;
					}

					temp = "Enter password:";
					temp += '\n';
					out.write(temp.getBytes());
					while ((request = br.readLine()) != null)
					{
						passwd = request;
						break;
					}
					login log = new login(username, passwd);
					boolean login_status = log.loginAcc();

					if(login_status)
					{
						temp = "Login successful!";
						temp += '\n';
						out.write(temp.getBytes());
					}
					else
					{
						temp = "Login unsuccessful";
						temp += '\n';
						out.write(temp.getBytes());
					}
				}
			}

		} catch (IOException ex) {
			System.out.println("Unable to get streams from client");
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("SocketServer Example");
		ServerSocket server = null;
		try {
			server = new ServerSocket(PORT_NUMBER);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection
				 * this will allow multiple client connections
				 */
				new SocketServer(server.accept());
			}
		} catch (IOException ex) {
			System.out.println("Unable to start server.");
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}