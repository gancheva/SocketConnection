// The class ClientConnection and thread 
// tasks 3.17 + 4.15
// Kristina Gancheva, group 1C

import java.net.*;
import java.io.*;

public class ClientConnection extends Thread{
	private Socket client;
	
	//the constructor holds the exact user socket
	public ClientConnection(Socket client){
		this.client = client;
	}
	
	//the overriding of the run() method
	public void run(){
		
		try{
			
			//	reading the client message without serialization
			/*	BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String message = reader.readLine();*/
			
			String message;
			
			// reading the user message with the use of serialization
			ObjectInputStream OIS = new ObjectInputStream(client.getInputStream());
			message = (String) OIS.readObject();
		
			
			//calling MessageImpl methods for calculating the digits and the characters
			if (message != null){
				MessageImpl mi = new MessageImpl();
				mi.setCounts(message);
		
				// writing the answer to a string
				String answer = "The characters are " + mi.getCharacterCount() + " and the digits are " + mi.getDigitCount();
			
				// sending the answer to the user/client
			    ObjectOutputStream OOS = new ObjectOutputStream(client.getOutputStream());
			    OOS.writeObject(answer); 
				
				// sending the answer without serialization
			    /*	PrintStream newPS = new PrintStream(client.getOutputStream());
				newPS.println(answer); */
			}
			
		} catch (IOException e){ System.err.println(e); 
		} catch(ClassNotFoundException cnfe){ System.err.println(cnfe); }
		
	}		
		
}


