// The main class MessageClient (NB: It has to run after the main class MessageServer) 
//tasks 3.17 + 4.15
//Kristina Gancheva, group 1C

import java.net.*;
import java.io.*;

public class MessageClient { 
	
	public static void main (String[] args){
		
		String clientmessage = null;
		System.out.println("Please enter your message.");
		
		//reading the user/client input 
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader1 = new BufferedReader(input);
		try {
			clientmessage = reader1.readLine();
		}
		catch(Exception e){}

		
		try {
			//making a socket to connect with the server
			Socket socket = new Socket("localhost", 6100);
			
			//sending the message to the server; we use the ObjectOutputStream to serialize the message 
			ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
			OOS.writeObject(clientmessage); 
			 
			// sending the message without serializing it 
			/*	PrintStream newPS = new PrintStream(socket.getOutputStream());
			newPS.println(clientmessage);*/
			
			String answer = null;
			
			// reading the serialized message from the server 
	        ObjectInputStream OIS = new ObjectInputStream(socket.getInputStream());
	        answer = (String) OIS.readObject();
	        
	        System.out.println(answer);
	        
	        // reading not serialized message from the server
	        /*	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String answer = reader.readLine();
			
			System.out.println(answer);*/
			
	        
	    } catch(IOException ioe){ 
	    	    System.err.println(ioe); 
	    } catch(ClassNotFoundException cnfe) {
	    		System.err.println(cnfe);
	    }		
	}
}
