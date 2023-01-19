package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyingDatabase {
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
				ResultSet res0 = statement.executeQuery("select * from student;");

				while(res0.next()) {
					System.out.println(res0.getInt("id")+"\t"+res0.getString("name"));
				}

				int result = statement.executeUpdate("insert into student(id,name,address) values(150,'Shravya','Mangalore');");

				if(result==1) {
					System.out.println("DB Updated Successfully");
				}
				else {
					System.out.println("DB Not Updated");
				}
				
				ResultSet res = statement.executeQuery("select * from student;");

				while(res.next()) {
					System.out.println(res.getInt("id")+"\t"+res.getString("name"));
				}

				//step 6: close database
				connect.close();
		
	}	

}
