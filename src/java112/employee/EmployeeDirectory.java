package java112.project4;

/**
 *  This is an Employee Directory class for project 4
 *  @author OCollins
 */

import java.util.*;
import java.sql.*;

public class EmployeeDirectory {

    private Properties properties;

	/**
	 * Class empty constructor
	 */
//	public EmployeeDirectory () {
//
//	}

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

		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection(
//					"jdbc:mysql://localhost/student", "student", "student");
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("url"));
		} catch (ClassNotFoundException classNotFound) {
			System.err.println("Cannot find database driver ");
			classNotFound.printStackTrace();
		} catch (SQLException sqlException) {
			System.err.println("Error in connection to database "
					+ sqlException);
			sqlException.printStackTrace();
		} catch (Exception exception) {
			System.err.println("General Error");
			exception.printStackTrace();
		}
		return connection;
	}

	/**
	 * Establish connection to the DB
	 * @param search Search object
	 */
	private void searchById(Search search) {
		Statement statement = null;
		ResultSet resultSet = null;

		Connection connection = createDBConnection();

		int id = Integer.parseInt(search.getSearchTerm());
		Debug debug = new Debug();
		String queryString = "SELECT *"
				+ " FROM employees WHERE emp_id = ?";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryString);
			while (resultSet.next()) {
				String employeeId = resultSet.getString("emp_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				debug.writeDebug(" Row: " + employeeId + " "
						+ firstName + " " + lastName);
			}


		} catch (SQLException sqlException) {
			System.err.println("Error in connection to database "
					+ sqlException);
			sqlException.printStackTrace();
		} catch (Exception exception) {
			System.err.println("General Error");
			exception.printStackTrace();
		}
	}

}