
package conection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Nimrod
 * 
 */

public class Conexion {
    
    private static BasicDataSource dataSource = null;
    private static String url;
    private static String puerto;
    private static String username;
    private static String password;
    private static String serverTimezone; //America/Caracas --- Default
    
    private static void initValues() {
        
        try {
            FileReader entrada = new FileReader("txt/conexion.txt");
            BufferedReader br = new BufferedReader(entrada);
            
            try {
                url = br.readLine();
                puerto = br.readLine();
                username = br.readLine();
                password = br.readLine();
                serverTimezone = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static DataSource getDataSource() {
        
        initValues();
        
        if(dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            //Correcion de Timezone
            dataSource.setUrl("jdbc:mysql://"+url+":"+puerto+"/mail?user=me&pass=secret&useLegacyDatetimeCode=false&serverTimezone="+serverTimezone);
            dataSource.setInitialSize(20);
            dataSource.setMaxIdle(15);
            dataSource.setMaxTotal(20);
            dataSource.setMaxWaitMillis(5000);
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
}