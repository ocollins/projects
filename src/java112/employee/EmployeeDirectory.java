package java112.project4;

/**
 *  This is an Employee Directory class for project 4
 *  @author OCollins
 */

import java.util.*;
import java.sql.*;

public class EmployeeDirectory {

    private Properties properties;
	private Debug debug = new Debug();

	/**
	 * Class empty constructor
	 */
	public EmployeeDirectory () {

	}

	/**
	 * Constructor that takes properties
	 * @param properties Project properties file
	 */
	public EmployeeDirectory (Properties properties) {
		this.properties = properties;

	}

	/**
	 * Establish connection to the DB
	 * @return connection object
	 */
	private Connection createDBConnection() {
		Connection connection = null;
		debug.writeDebug("In the EmployeeDirectory createDBConnection method");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/student", "student", "student");
//			Class.forName(properties.getProperty("driver"));
//			connection = DriverManager.getConnection(properties.getProperty("url"));
		} catch (ClassNotFoundException classNotFound) {
			System.err.println("Cannot find database driver ");
			debug.writeDebug("In the EmployeeDirectory Cannot find DB driver");

			classNotFound.printStackTrace();
		} catch (SQLException sqlException) {
			System.err.println("Error in connection to database "
					+ sqlException);
			sqlException.printStackTrace();
			debug.writeDebug("In the EmployeeDirectory Cannot connect to a DB");
		} catch (Exception exception) {
			System.err.println("General Error");
			debug.writeDebug("In the EmployeeDirectory General error " + exception.getMessage());
			exception.printStackTrace();
		}
		return connection;
	}

	/**
	 * Search for employee by ID
	 * @param search Search object
	 */
	public void searchById(Search search) {
		Statement statement = null;
		ResultSet resultSet = null;

		Connection connection = createDBConnection();

		//Employee ID
		int id = Integer.parseInt(search.getSearchTerm());
		//Create SELECT statement
		String queryString = "SELECT *"
				+ " FROM employees WHERE emp_id = " + id + ";";
		debug.writeDebug("In the EmployeeDirectory query by ID" + queryString );

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryString);
			resultSet.first();

			//Check to see if any employees were found for the ID
			if (resultSet.getInt("emp_id") != 0) {
				search.setEmployeeFound(true);

				//Create a new employee object
				Employee employee = new Employee();

				employee.setEmployeeId(resultSet.getString("emp_id"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDepartment(resultSet.getString("dept"));
				employee.setSSN(resultSet.getString("ssn"));
				employee.setRoom(resultSet.getString("room"));
				employee.setPhone(resultSet.getString("phone"));

				//Add employee info to the ArrayList of employees in the Search bean
				//search.addFoundEmployee(employee);
				debug.writeDebug("Found employee " + employee.toString());

			} else {
				search.setEmployeeFound(false);
			}

		} catch (SQLException sqlException) {
			debug.writeDebug("Error in connection to database "	+ sqlException);
			System.err.println("Error in connection to database "
					+ sqlException);
			sqlException.printStackTrace();

		} catch (Exception exception) {
			debug.writeDebug("General Error " + exception.getMessage());
			System.err.println("General Error");
			exception.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				System.err.println("Error in connection.ecting to database "
						+ sqlException);
				sqlException.printStackTrace();
			} catch (Exception exception) {
				System.err.println("General Error");
				exception.printStackTrace();
			}
		}
	}


}