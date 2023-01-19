package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {
	public static void main(String[] args) throws SQLException {


		//step 1: Create an instance for driver
		//Should be imported from com.mysql.cj.Driver
		Driver dbDriver = new Driver();

		//step 2: Register to the dbDriver
		//DriverManager is in java.sql package
		DriverManager.registerDriver(dbDriver);

		//step 3: Establish database connection
		//connection should be imported from java.sql package
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");

		//step 4: Create Statement
		//statement should be imported from java.sql package
		Statement statement = connect.createStatement();

		//step 5: Execute query to fetch data
		ResultSet result = statement.executeQuery("select * from student;");

		while(result.next()) {
			System.out.println(result.getInt("id")+"\t"+result.getString("name"));
		}

		//step 6: close database
		connect.close();

	}

}
