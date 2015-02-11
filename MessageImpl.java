// Class Message which calculates the digits and the characters in the user message
// tasks 3.17 + 4.15
// Kristina Gancheva, group 1C

import java.io.*;

public class MessageImpl implements Message, Serializable {
	
	private int digitcount, charactercount;
	
	public void setCounts(String message){
		digitcount = charactercount = 0;
		
		for(int i = 0; i< message.length(); i++){
			
			if(Character.isLetter(message.charAt(i))) {
				charactercount ++;
			}
			if(Character.isDigit(message.charAt(i))){
				digitcount ++;
			}
			
		}
		
	}
	
	public int getDigitCount(){ 
		return digitcount;
	}
	
	public int getCharacterCount(){
		return charactercount;
	}
	
}
