
package ventanas;

import java.sql.*;


public class conexion {
    Connection con;
    
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpos","sistemaPOS","POS2019sis");
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }
    

}
