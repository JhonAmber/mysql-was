package app.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Conexion {
	
	public MysqlDataSource getConexion(){
		
		Properties props = new Properties();
		
		String fileName = "src/main/resources/db.properties";

        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
        } catch (IOException ex) {
            Logger lgr = Logger.getLogger(Conexion.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(props.getProperty("mysql.url"));
        ds.setUser(props.getProperty("mysql.username"));
        ds.setPassword(props.getProperty("mysql.password"));

        return ds;
		
	
	}

}
