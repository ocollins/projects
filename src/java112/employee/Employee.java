package java112.project4;

/**
 *  This is an Employee class for project 4
 *  @author OCollins
 */
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String socNumber;
    private String department;
    private String room;
    private String phone;

	/**
	 * Returns the value of phone.
	 * @return phone
	 */
	public String getPhone() {

		return phone;
	}

	/**
	 * Sets the value of phone.
	 * @param phone The value to assign phone.
	 */
	public void setPhone(String phone) {

		this.phone = phone;
	}

	/**
	 * Returns the value of room.
	 * @return room
	 */
	public String getRoom() {

		return room;
	}

	/**
	 * Sets the value of room.
	 * @param room The value to assign room.
	 */
	public void setRoom(String room) {

		this.room = room;
	}

	/**
	 * Returns the value of department.
	 * @return department
	 */
	public String getDepartment() {

		return department;
	}

	/**
	 * Sets the value of department.
	 * @param department The value to assign department.
	 */
	public void setDepartment(String department) {

		this.department = department;
	}

	/**
	 * Returns the value of sSN.
	 * @return sSN
	 */
	public String getSocNumber() {

		return socNumber;
	}

	/**
	 * Sets the value of sSN.
	 * @param sSN The value to assign sSN.
	 */
	public void setSocNumber(String socNumber) {

		this.socNumber = socNumber;
	}
    
	/**
	 * Returns the value of lastName.
	 * @return lastName
	 */
	public String getLastName() {

		return lastName;
	}

	/**
	 * Sets the value of lastName.
	 * @param lastName The value to assign lastName.
	 */
	public void setLastName(String lastName) {

		this.lastName = lastName;
	}
    
	/**
	 * Returns the value of firstName.
	 * @firstName
	 */
	public String getFirstName() {

		return firstName;
	}

	/**
	 * Sets the value of firstName.
	 * @param firstName The value to assign firstName.
	 */
	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}
    
	/**
	 * Returns the value of employeeId.
	 * @return employeeId
	 */
	public String getEmployeeId() {

		return employeeId;
	}

	/**
	 * Sets the value of employeeId.
	 * @param employeeId The value to assign employeeId.
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

    /**
	 * ToString method
     * @return employeeInfo   
	 */

     public String toString() {
		 return "Employee Id " + getEmployeeId() +
				 " First Name " + getFirstName() +
				 " Last Name " + getLastName() +
				 " Department " + getDepartment() +
				 " SSN " + getSocNumber() +
				 " Room Number " + getRoom() +
				 " Phone Number " + getPhone();
	 }



}