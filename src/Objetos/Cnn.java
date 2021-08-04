
package Objetos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class Cnn {
    
   
  
    private static final String user="root";
    private static final String pass="123";
    private static final String url="jdbc:mysql://localhost:3306/dreamgifts";
    
    public static Connection getConnection(){
        Connection cnn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnn = (Connection) DriverManager.getConnection(url,user,pass);
            
        }catch(Exception e){
            System.out.println("Error al crear la conexion");
        }
        return cnn;
    }
}
