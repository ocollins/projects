package java112.project4;

/**
 *  This is a JavaBean for Employee search application.
 *  @author   OCollins
 */

import java.util.ArrayList;
import java.sql.*;

public class Search extends java.lang.Object {

    private String searchType;
    private String searchTerm;
    private ArrayList<Employee> employees;
	private boolean employeeFound;

	/**
	 * Constructor for the Search object
	 */
	public Search() {

		employees = new ArrayList<Employee>();
	}

	/**
	 * Returns the value of employeeFound.
	 */
	public boolean isEmployeeFound() {

		return employeeFound;
	}

	/**
	 * Sets the value of employeeFound.
	 * @param employeeFound The value to assign employeeFound.
	 */
	public void setEmployeeFound(boolean employeeFound) {

		this.employeeFound = employeeFound;
	}

	/**
	 * Returns the value of searchResults.
	 * @return searchResulst
	 */
	public ArrayList<Employee> getEmployees() {

		return employees;
	}

	/**
	 * Sets the value of searchResults.
	 * @param searchResults The value to assign searchResults.
	 */
	public void setEmployees(ArrayList<Employee> employees) {

		this.employees = employees;
	}

	/**
	 * Returns the value of searchTerm.
	 * @return searchTerm
	 */
	public String getSearchTerm() {

		return searchTerm;
	}

	/**
	 * Sets the value of searchTerm.
	 * @param searchTerm The value to assign searchTerm.
	 */
	public void setSearchTerm(String searchTerm) {

		this.searchTerm = searchTerm;
	}

	/**
	 * Returns the value of searchType.
	 * @return searchType
	 */
	public String getSearchType() {

		return searchType;
	}

	/**
	 * Sets the value of searchType.
	 * @param searchType The value to assign searchType.
	 */
	public void setSearchType(String searchType) {

		this.searchType = searchType;
	}

	/**
	 * Adds the employee information
	 * @param employee Employee object
	 */
	public void addFoundEmployee (Employee employee) {

		employees.add(employee);
	}

}