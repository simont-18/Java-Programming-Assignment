import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
	//declare variable for I/O operations
	private Scanner in;
	private PrintWriter out;
	
	//constructor for FileIO class
	FileIO(String inFileName, String outFileName) throws IOException {
		//define variable for I/O operations
		in = new Scanner(new File(inFileName));
		out = new PrintWriter(new File(outFileName));
		
	}
	
	//return true if there is still remaining content in the file
	public boolean hasNext() {
		return in.hasNext();
	}
	
	//read from input.txt and return as a String
	public String read() {
		if(in.hasNext())
			return in.next();
		else
			return null;
	}
	
	//write String output to output.txt
	public void write(String output) {
		out.println(output);
	}
	
	//closing the I/O operations
	public void closeFileIO() throws IOException{
		in.close();
		out.close();
	}
}
