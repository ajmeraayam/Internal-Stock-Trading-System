import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread {
	// setting up port number for the server
	public static final int PORT_NUMBER = 8081;
	BufferedReader br;
	PrintWriter out;
	InputStream in;

	protected Socket socket;

	// constructor to initialize the server socket. Will be called everytime a
	// client connects with server
	private SocketServer(Socket socket) {
		this.socket = socket;
		System.out.println(
				"New client connected from " + socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort());
		start();
	}

	private void init() {
		// TODO Auto-generated method stub
		try {
			in = socket.getInputStream();
			out = new PrintWriter(socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(in));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// overrides the run() method (from Thread class)
	public void run() {
		init();
		String request;
		// String temp = "";

		while ((request = receiveData().trim()) != "\\q") {
			System.out.println("Message received:" + request);

			// s = signup , l = login
			if (request.equals("s")) {
				if (signup()) {
					sendData("Signup successful.");
				} else {
					sendData("Signup Failed!");
				}
			} else if (request.equals("l")) {

				if (login()) {
					sendData("Login successful.");
				} else {
					sendData("Login failed!");
				}
			} else if (request.equals("\\SHUTDOWN")) {
				sendData("Server shutting down...");
				shutdown();
			} else {
				sendData("Wrong Choice!");
			}
		}

	}

	void shutdown() {
		try {
			in.close();
			out.close();
			socket.close();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String receiveData() {
		String request;
		try {
			while ((request = br.readLine()) != null) {
				System.out.println("Server received: " + request);
				return request;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	void sendData(String s) {
		out.println(s);
		System.out.println("Server sent: " + s);
	}

	private boolean login() {
		String temp, username, passwd;
		temp = "Enter username: ";
		sendData(temp);
		username = receiveData();

		temp = "Enter password: ";
		sendData(temp);
		passwd = receiveData();

		login log = new login(username, passwd);
		boolean login_status = log.loginAcc();
		return login_status;
	}

	private boolean signup() {
		String temp;
		String fname = "", lname = "", username = "", email = "", passwd = "";

		temp = "Enter first name: ";
		sendData(temp);
		fname = receiveData();

		temp = "Enter last name: ";
		sendData(temp);
		lname = receiveData();

		temp = "Enter username: ";
		sendData(temp);
		username = receiveData();

		temp = "Enter email: ";
		sendData(temp);
		email = receiveData();

		temp = "Enter password:";
		sendData(temp);
		passwd = receiveData();

		signup sup = new signup(fname, lname, username, email, passwd);
		boolean signup_status = sup.createAcc();
		return signup_status;
	}

	public static void main(String[] args) {
		System.out.println("SocketServer Example");
		ServerSocket server = null;
		try {
			server = new ServerSocket(PORT_NUMBER);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection this will allow
				 * multiple client connections
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
