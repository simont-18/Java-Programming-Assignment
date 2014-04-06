import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException {
		//declare int lines and errors to be use as a counter variable
		int lines = 0, errors = 0;
		
		//declare and define a FileIO variable to handle all I/O operations
		FileIO a = new FileIO("input.txt", "output.txt");
		a.write("Name: Duy Ta\nPeoplesoft #: 1225688");
		
		//declare a temp IP variable to check IP validity and writing to output.txt
		IP temp;
		
		//loop to read through output.txt
		while(a.hasNext()) {
			//define variable temp
			temp = new IP(a.read());
			
			//increase lines by 1
			lines++;
			
			//if temp is not a valid IP then the increase errors by 1
			if(temp.isValidIP() == false)
				errors++;
			
			//write variable temp to output.txt
			a.write(temp.toString());
		}
		
		//writing summary to output.txt and closing all I/O operations
		a.write("\n\nSummary:\nLines read: " + lines + "\nNumber of Errors: " + errors);
		a.closeFileIO();
	}
}