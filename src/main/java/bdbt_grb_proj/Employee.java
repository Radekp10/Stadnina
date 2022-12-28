package bdbt_grb_proj;

public class Employee {
	
	/* Fields */
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String pesel;
	private String sex;
	private String phoneNumber;
	private String email;
	private String hireDate;
	private String accountNumber;
	private int studFarmId;
	private int addressId;
	private int positionId;
	
	
	/* Default constructor */
	public Employee() {
	}


	/* Constructor */
	public Employee(int id, String firstName, String lastName, String dateOfBirth, String pesel, String sex,
			String phoneNumber, String email, String hireDate, String accountNumber, int studFarmId, int addressId,
			int positionId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.pesel = pesel;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.hireDate = hireDate;
		this.accountNumber = accountNumber;
		this.studFarmId = studFarmId;
		this.addressId = addressId;
		this.positionId = positionId;
	}


	/* Getters and setters */
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPesel() {
		return pesel;
	}


	public void setPesel(String pesel) {
		this.pesel = pesel;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getStudFarmId() {
		return studFarmId;
	}


	public void setStudFarmId(int studFarmId) {
		this.studFarmId = studFarmId;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public int getPositionId() {
		return positionId;
	}


	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}


	/* toString() */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", pesel=" + pesel + ", sex=" + sex + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", hireDate=" + hireDate + ", accountNumber=" + accountNumber + ", studFarmId=" + studFarmId
				+ ", addressId=" + addressId + ", positionId=" + positionId + "]";
	}
	
	

}
