package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *@author  Olena Collins
 * Lab JDBC part 3 Prepared statements
 */
public class JDBCPreparedStatement {
    /**
     *  The main program for the JDBCSelectWhereExample class
     *  @param  args  The command line arguments
     */
    public static void main(String[] args) {
        JDBCPreparedStatement employees = new JDBCPreparedStatement();
        employees.runSample(args);
    }

    public void runSample(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String fName = args[0];
        String lName = args[1];
        String ssn = args[2];
        String dept = args[3];
        String room  = args[4];
        String phone = args[5];

        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");

            //Create Prepared Statement
            PreparedStatement insertStatement =
                    connection.prepareStatement("INSERT INTO employees " +
                            "(first_name,last_name,ssn,dept,room,phone) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            //Populate parameters
            insertStatement.setString(1, fName);
            insertStatement.setString(2, lName);
            insertStatement.setString(3, ssn);
            insertStatement.setString(4, dept);
            insertStatement.setString(5, room);
            insertStatement.setString(6, phone);

            System.out.println(insertStatement);
            insertStatement.executeUpdate();

            String selectStatemet = "SELECT * FROM employees WHERE last_name = '"
                    + args[1] + "'";
            //Create Statement object
            statement = connection.createStatement();
            System.out.println(selectStatemet);
            //Execute select statement
            resultSet = statement.executeQuery(selectStatemet);
            //Display results of the isert
            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                        + firstName + " " + lastName);
            }

        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
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
