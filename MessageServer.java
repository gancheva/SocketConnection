// The main class MessageServer which make a server socket to listen on a port.
// When there is a client, it makes a thread (one for each client). 
// tasks 3.17 + 4.15
// Kristina Gancheva, group 1C

import java.net.*;
import java.io.*;

public class MessageServer {
	
	public static void main (String[] args){
		
		// making a server socket
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(6100);
		} catch (IOException e){ System.err.println(e); }
		
		// waiting for user's socket
		Socket client = null;
		while(true){
			try{
			client = socket.accept();
			} catch (IOException e){ System.err.println(e); }
			
			// makes a thread and starts it
			ClientConnection CC = new ClientConnection(client);
            CC.start();
		
		}
	}
}
		
		