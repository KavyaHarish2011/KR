package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToPropertiesFile {
	public static void main(String[] args) throws IOException, InterruptedException  {
		FileInputStream fis= new FileInputStream("./src/test/resources/actitimeData.properties");
		Properties p= new Properties();
        p.load(fis);
        
        //write data into Properties file
        p.put("username", "kavya");
        
        //save data in Properties file
        FileOutputStream fos= new FileOutputStream("./src/test/resources/actitimeData.properties");
        p.store(fos, "Username Modified");
        
        
	}
}
