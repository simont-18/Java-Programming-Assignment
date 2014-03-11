//UniversityEmail inherit from Email
public class UniversityEmail extends Email {
	//private data attribute
	private int code;
	private String department;
	private final String subDomain[] = {"none", "art", "chee", "chem", "coe", "cs", "egr", "polsci"}; 
	
	//default constructor
	UniversityEmail() {
		super();
	}
	
	//overloaded constructor
	UniversityEmail(String userName, String department, String domain, String extension) {
		super(userName, domain, extension);
		setDepartment(department);
	}

	//getter and setter for code
	public int getCode() {
		return code;
	}

	private void setCode(int code) {
		this.code = code;
	}

	//getter and setter for department
	public String getDepartment() {
		return department;
	}

	private void setDepartment(String department) {
		//set department
		this.department = department;
		
		//find corresponding index for the department and assign it to code
		for(int i = 1; i <= 7; i++) {
			if(department.equalsIgnoreCase(subDomain[i])) {
				setCode(i);
				return;
			}else {
				setCode(0);
			}
		}
	}

	@Override
	public String toString() {
		return String.format("%s@%s.%s.%s", super.getUserName(), getDepartment(), super.getDomain(), super.getExtension());
	}
}
