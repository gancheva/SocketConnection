//interface Message ( NB: not in use in the program solution)
//tasks 3.17 + 4.15
//Kristina Gancheva, group 1C

public interface Message {

	//set the counts for characters and digits
	public void setCounts(String message);
	
	//return the number of characters
	public int getCharacterCount();
	
	//return the number of digits
	public int getDigitCount();
	
}
