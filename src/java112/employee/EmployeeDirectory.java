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
	 * Add a new employee information
	 * @param
	 */
	public boolean addNewEmployee(String fName, String lName, String sSN, String dept, String room,
							   String phone) {
		Statement statement = null;
		ResultSet resultSet = null;
		boolean success = false;

		//Call Create connection method
		Connection connection = createDBConnection();

		try {
			//Create the INSERT statement
			PreparedStatement insertStatement =
					connection.prepareStatement("INSERT INTO employees " +
							"(first_name,last_name,ssn,dept,room,phone) " +
							"VALUES (?, ?, ?, ?, ?, ?)");


			//Populate parameters
			insertStatement.setString(1, fName);
			insertStatement.setString(2, lName);
			insertStatement.setString(3, sSN);
			insertStatement.setString(4, dept);
			insertStatement.setString(5, room);
			insertStatement.setString(6, phone);
			debug.writeDebug("In the EmployeeDirectory Insert " + insertStatement );

			//Execute the INSERT statement
			insertStatement.executeUpdate();

			success = true;
		} catch (SQLException sqlException) {
			debug.writeDebug("Error in connection to database "	+ sqlException);
			System.err.println("Error in connection to database "
					+ sqlException);
			success = false;
			sqlException.printStackTrace();
			debug.writeDebug("Returning false");

		} catch (Exception exception) {
			debug.writeDebug("General Error " + exception.getMessage());
			System.err.println("General Error");
			success = false;
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
				success = false;
				sqlException.printStackTrace();

			} catch (Exception exception) {
				System.err.println("General Error");
				success = false;
				exception.printStackTrace();
			}
		}
		debug.writeDebug("Returning success value " + success);
		return success;
	}

	/**
	 * Search for employee by ID
	 * @param search Search object
	 */
	public void searchById(Search search) {
		Statement statement = null;
		ResultSet resultSet = null;
		String formatString = null;

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
				employee.setSocNumber
						       (resultSet.getString("ssn"));
				employee.setRoom(resultSet.getString("room"));
				employee.setPhone(resultSet.getString("phone"));

				//Add employee info to the ArrayList of employees in the Search bean
				search.addFoundEmployee(employee);
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

	/**
	 * Search for employee by last name
	 * @param search Search object
	 */
	public void searchByLastName(Search search) {
		Statement statement = null;
		ResultSet resultSet = null;

		Connection connection = createDBConnection();

		//Employee last name
		String lName = search.getSearchTerm();

		//Create SELECT statement
		String queryString = "SELECT *"
				+ " FROM employees WHERE last_name = \"" + lName + "\";";
		debug.writeDebug("In the EmployeeDirectory query by last name " + queryString );

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryString);
			//resultSet.first();

			while (resultSet.next()) {
				search.setEmployeeFound(true);

				//Create a new employee object
				Employee employee = new Employee();

				employee.setEmployeeId(resultSet.getString("emp_id"));
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setDepartment(resultSet.getString("dept"));
				employee.setSocNumber(resultSet.getString("ssn"));
				employee.setRoom(resultSet.getString("room"));
				employee.setPhone(resultSet.getString("phone"));

				//Add employee info to the ArrayList of employees in the Search bean
				search.addFoundEmployee(employee);
				debug.writeDebug("Found employee " + employee.toString());
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