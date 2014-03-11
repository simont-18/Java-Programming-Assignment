public class EmailData {
	//privatE data attributE
	private boolean isUniversityEmail;
	private Email E = null;
	private UniversityEmail UE = null;
	
	//overloaded constructor for Email
	EmailData(Email E) {
		this.E = E;
		this.isUniversityEmail = false;
	}
	
	//overloaded constructor for UniversityEmail
	EmailData(UniversityEmail UE) {
		this.UE = UE;
		this.isUniversityEmail = true;
	}
	
	//getter for isUniversityEmail
	public boolean isUniversityEmail() {
		return isUniversityEmail;
	}

	//getter for Email
	public Email getE() {
		return E;
	}

	//getter for UniversityEmail
	public UniversityEmail getUE() {
		return UE;
	}

}
