package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains reusable methods to perform operations on Database connection.
 * @author haris
 *
 */
public class DatabaseUtility {
	private Connection connection;
	/**
	 * This method is used to initialise and establish database connection
	 * @param url
	 * @param user
	 * @param password
	 */
	public void databaseInitialization(String url, String user, String password) {
		Driver dbDriver = null;
		try {
			dbDriver=new Driver();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
				try {
					Connection connection = DriverManager.getConnection(url,user,password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

/**
 * This method is used to fetch data from database
 * @param query
 * @param columnName
 * @return
 * @throws SQLException
 */


public ArrayList readDataFromDatabase(String query, String columnName) throws SQLException{
	Statement statement =null;
	try {
		statement=connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ResultSet result =null;
	try {
		result= statement.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList columnData = new ArrayList<>();
	while(result.next()) {
		columnData.add(result.getString(columnName));
	}
	return columnData;
}

/**
 * This methos is used to modify database
 * @param query
 * @return
 */
public int modifyDatabase(String query) {
	Statement statement=null;
	try {
		statement=connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int result=0;
	try {
		result=statement.executeUpdate(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}
 
/**
 * This method is used to close database connection
 */
public void closeDatabase() {
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

