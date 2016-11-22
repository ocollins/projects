package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *@author  Olena Collins
 * Lab JDBC part 2
 */
public class JDBCInsertEmployee {
    /**
     *  The main program for the JDBCSelectWhereExample class
     *  @param  args  The command line arguments
     */
    public static void main(String[] args) {
        JDBCInsertEmployee employees = new JDBCInsertEmployee();
        employees.runSample();
    }

    public void runSample() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int id = 151;
        String fName = "Kate";
        String lName = "Coco";
        String ssn = "884-90-8888";
        String dept = "Management";
        String room  = "000";
        String phone = "0000000000";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
            statement = connection.createStatement();
            String insertStatement =
                    "INSERT INTO employees (emp_id,first_name,last_name,ssn,dept,room,phone) " +
                            "VALUES ('"
                            + id + "', '"
                            + fName + "', '"
                            + lName + "', '"
                            + ssn + "', '"
                            + dept + "', '"
                            + room + "', '"
                            + phone + "')";

            System.out.println(insertStatement);

            statement.executeUpdate(insertStatement);

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
