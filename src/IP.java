import java.util.StringTokenizer;

public class IP {
	//private member data attribute for class IP
	private String address = "", port = "", input = "";
	boolean isValidIP = false;
	
	//constructor for class IP
	IP(String ipAddress) {
		this.input = ipAddress;
		isValidIP = checkValidity();
	}
	
	//getter for String address
	public String getAddress() { return address; }

	//getter for String port
	public String getPort() { return port; }

	//getter for String input
	public String getInput() { return input; }

	//getter for boolean isValidIP
	public boolean isValidIP() { return isValidIP; }

	//algorithm to determine if the input is a valid IP address
	private boolean checkValidity() throws NumberFormatException{
		try {
			//declare and define StringTokenizer to split string into parts by "."
			StringTokenizer period = new StringTokenizer(input, ".");
			
			//declare StringTokenizer to split string into parts by ":"
			StringTokenizer colon;
			
			/*
			 * declare and define int size to 0
			 * if the final size == 5 then it is a valid IP
			 * if the final size > 5 then it is not a valid IP
			 * if the final size < 5 then it is not a valid IP
			 */
			int size = 0;
			
			//while loop is use to split the string by period and by colon
			while(period.hasMoreElements()) {
				//declare and define String current to the current element
				String current = (String) period.nextElement();
				
				/*
				 * if current element contain a colon
				 * it will be further split by using a colon StringTokenizer
				 * that is splitting the address and the port part
				 */
				if(current.contains(":")) {
					//define colon with the String current
					colon = new StringTokenizer(current, ":");
					
					//check to make sure there is remaining element to be process
					if(colon.hasMoreElements()) {
						//define the String current according to colon rule
						current = (String) colon.nextElement();
						
						//check to make sure it is a positive number
						if(Integer.parseInt(current) >= 0) {
							address += current;
							size++;
							current = (String) colon.nextElement();
							
							//check to make sure it is a positive number
							if(Integer.parseInt(current) >= 0) {
								port += current;
								size++;
							} else
								return false;
						} else
							return false;
					}
				} else {
					//check to make sure it is a positive number
					if(Integer.parseInt(current) >= 0) {
						address += current + ".";
						size++;
					} else
						return false;
				}
			}
			
			/* if the final size == 5 then it is a valid IP
			 * if the final size > 5 then it is not a valid IP
			 * if the final size < 5 then it is not a valid IP
			 */
			if(size == 5) {
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			//with any NumberFormatException caught, it is not a valid IP
			return false;
		}
	}

	//toString for class IP
	@Override
	public String toString() {
		//if isValidIP is true then it will return the String input and String address and String port
		if(isValidIP == true) {
			return String.format("%s\nAddress: %s Port: %s", getInput(), address, port);
		} else { // if isValidIP is false then it will return String input and an error message
			return String.format("%s\nError in Input Line", getInput());
		}
	}
}