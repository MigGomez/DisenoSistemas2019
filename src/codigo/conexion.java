package codigo;

import java.sql.*;
import javax.swing.DefaultListModel;


public class conexion {
    static Connection con=null;
    static Statement sentencia;
    static ResultSet resultado;
    
    public static void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpos","sistemaPOS","POS2019sis");
            sentencia = con.createStatement();
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }
    
    public static void ejecutar(String q){
        conectar();
        try {
            sentencia.executeUpdate(q);
            System.out.println("correcto");
        } catch (Exception e) {
            System.out.println("error");
        } 
    }
    
    
//Metodos para manejar categorias
    public static void guardar_categoria(variables_categorias x){
        String q = "INSERT INTO categoria (nombre) VALUES ('"+ x.getNombre() +"') ";
        ejecutar(q);           
    }
    
    public static DefaultListModel<String> llenar_lista(){
        conectar();
        DefaultListModel<String> modelo = new DefaultListModel<>();
        String q = "SELECT nombre FROM categoria";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("correcto");
        } catch (Exception e) {
        }
        try {           
            while(resultado.next()){
                modelo.addElement(resultado.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return modelo;
    }

    public static void eliminar_categoria(String x){
        conectar();
        String q = "DELETE FROM categoria WHERE nombre=('"+ x +"') ";
        ejecutar(q);
    }
}