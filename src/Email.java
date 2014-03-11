public class Email {
	//private data attribute
	private String userName, domain, extension;
	
	//default constructor
	Email() {
		setUserName("default");
		setDomain("email");
		setExtension("com");
	}
	
	//overloaded constructor
	Email(String userName, String domain, String extension) {
		setUserName(userName);
		setDomain(domain);
		setExtension(extension);
	}

	//getter and setter for userName
	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	//getter and setter for domain
	public String getDomain() {
		return domain;
	}

	private void setDomain(String domain) {
		this.domain = domain;
	}
	
	//getter and setter 
	public String getExtension() {
		return extension;
	}

	private void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return String.format("%s@%s.%s", getUserName(), getDomain(), getExtension());
	}
}
