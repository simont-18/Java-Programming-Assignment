import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args []) throws FileNotFoundException {
		//ArrayList list to store all email
		ArrayList<EmailData> list = new ArrayList<EmailData>();
		
		//reading email from inputemails.txt
		readEmail(list);
		
		//writing the specific type of email requested to outputemails.txt
		writeEmail(list, getOutputCode());
	}
	
	//read file content and pull out all email address and store it in list
	public static void readEmail(ArrayList<EmailData> list) throws FileNotFoundException{
		//Scanner to read from file
		Scanner in = new Scanner(new FileInputStream("inputemails.txt"));
		
		//split email into userName(us), subDomain(sd), domain(d), extension(e)
		String currentWord, us, sd, d, e;
		
		//while there is content in the file, continue to read
		while(in.hasNext()) {
			currentWord = us = sd = d = e = null;
			currentWord = in.next();			
			//if the current currentWord contain '@', then it is consider as an email
			if(currentWord.contains("@"))
			{
				//assigning userName
				us = currentWord.substring(0, currentWord.indexOf("@"));
				
				//assigning extension
				if(currentWord.endsWith(","))
					e = currentWord.substring(currentWord.lastIndexOf(".") + 1, currentWord.length() - 1);
				else
					e = currentWord.substring(currentWord.lastIndexOf(".") + 1, currentWord.length());
				
				//assigning subDomain & domain 
				int periodCount = 0;
				for(int i = currentWord.indexOf("@"); i < currentWord.length(); i++)
					if(currentWord.charAt(i) == '.')
						periodCount++;
				
				//if there is one period in the currentWord then it is consider as Email, if there is two period in the currentWord then it is consider as UniversityEmail
				if(periodCount == 1) {
					d = currentWord.substring(currentWord.indexOf("@") + 1, currentWord.indexOf('.'));
					list.add(new EmailData(new Email(us, d, e)));
				} else if(periodCount == 2) {
					sd = currentWord.substring(currentWord.indexOf("@") + 1, currentWord.indexOf('.'));
					d = currentWord.substring(currentWord.indexOf('.') + 1, currentWord.lastIndexOf('.'));
					list.add(new EmailData(new UniversityEmail(us, sd, d, e)));
				}
			}
		}
		
		//closing the file
		in.close();
	}
	
	public static void writeEmail(ArrayList<EmailData> list, int code) throws FileNotFoundException {
		//PrintWriter to write to file
		PrintWriter out = new PrintWriter(new FileOutputStream("outputemails.txt"));
		String output = "";
		int num = 0;
		if(code == 0) {
			//find all Email and store the Email content in output
			for(int i = 0; i < list.size(); i++) {
				EmailData temp = list.get(i);
				if(temp.isUniversityEmail() == false) {
					Email te = temp.getE();
					output += te + "\n";
					num++;
				}
			}
			
			//writing to file
			System.out.println(output);
			out.println(num);
			out.println(output);
		} else {
			//find all corresponding department and store the UniversityEmail content in output
			for(int i = 0; i < list.size(); i++) {
				EmailData temp = list.get(i);
				if(temp.isUniversityEmail() == true) {
					UniversityEmail tue = temp.getUE();
					if(tue.getCode() == code) {
						output += tue + "\n";
						num++;
					}
				}
			}
			
			//writing to file
			System.out.println(output);
			out.println(num);
			out.println(output);
		}
		
		//closing the file
		out.close();
		
		System.out.println("Sucessfully written to outputemails.txt");
	}
	
	public static int getOutputCode() {
		//Scanner to get input from user
		Scanner codeInput = new Scanner(System.in);
		int code;
		
		//prompting user to enter a number from 0 to 7 inclusive
		System.out.println("Please enter the type of email to write to the text file. (Range from 0 to 7)");
		code = codeInput.nextInt();
		while(!(code >= 0 && code <= 7)) {
			System.err.println("Invalid input! Please enter a number from 0 to 7.");
			code = codeInput.nextInt();
		}
		return code;
	}
}
