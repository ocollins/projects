package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *@author  Olena Collins
 * Lab JDBC part 2
 */
public class JDBCInsertEmployee {

    public void runSample() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
//            emp_id          int(11) NOT NULL auto_increment,
//                    first_name      varchar(25),
//                    last_name       varchar(30),
//                    ssn             varchar(20),
//                    dept            varchar(10),
//                    room            varchar(10),
//                    phone           varchar(10),

            statement = connection.createStatement();
            int id = 99999;
            String fName = "Donald";
            String lName = "Trump";


            String queryString = "SELECT *"
                    + " FROM employees " + "WHERE last_name like '"
                    + "Smith" + "%'";

            System.out.println("queryString: " + queryString);

            resultSet = statement.executeQuery(queryString);

            System.out.println();

            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String ssn = resultSet.getString("ssn");
                String department = resultSet.getString("dept");
                String room = resultSet.getString("room");
                String phone = resultSet.getString("phone");
                System.out.println(" Id: " + employeeId + " "
                        + firstName + " " + lastName + " " + ssn + " "
                        + department + " " + room + " " + phone);
            }

            System.out.println();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            System.out.println(" Column count before : " + columns);

            System.out.println();

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

    /**
     *  The main program for the JDBCSelectWhereExample class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {

        JDBCSelectEmployees employees = new JDBCSelectEmployees();

        employees.runSample();

    }

}
