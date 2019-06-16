package codigo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class conexion {
    static Connection con=null;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData rsMetaData;
//metodos para conectar, ejecutar y obtener valores ****************************   
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
    
    
    public static ResultSet obtenerValores(String q){
        conectar();
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("correcto");
        } catch (Exception e) {
        }
        return resultado;
    }
    
  
    //LLENAR LISTA DE LA COLUMNA numero 1***************************************
    //para llenar un jcbx
    public static ArrayList<String> LLenarLista(String x){
        resultado = obtenerValores(x);
        ArrayList<String> lista = new ArrayList<>();

        try {
            while(resultado.next() ){
            lista.add(resultado.getString(1));
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    //LLENAR TABLA*************************************************************
    //recibe la sentencia sql y el modelo creado*******************************
    public static DefaultTableModel llenar_tabla(String x, DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        resultado = obtenerValores(x);
         
        try {
            rsMetaData = resultado.getMetaData();
            int nc = rsMetaData.getColumnCount();
            
            while(resultado.next()){
                Object[] fila = new Object[nc];
                for (int j = 0; j < nc; j++) {
                    fila[j] = resultado.getObject(j+1);
                }
                modelo.addRow(fila);
        }
        }catch (Exception e) {
        }
        
        return modelo;
    }
    
    
    //OBTENER ID DE CATEGORIA
    public static int id(String x){
        
        resultado = obtenerValores(x);
        int id_ob =0;
        try {
            resultado.first();
            id_ob = resultado.getInt(1);
        } catch (Exception e) { }
        
        return id_ob;
    }

    public static double precioProducto(int x){
        String q= "SELECT precio FROM producto WHERE id='"+x +"'";
        resultado = obtenerValores(q);
        double id_ob =0;
        
        try {
            resultado.first();
            id_ob = resultado.getDouble(1) ;
        } catch (Exception e) { }
        return id_ob;
    }    
    
    
    /************************************************************************/
    //Metodos para manejar categorias***********************************************
    public static DefaultListModel<String> llenar_modlista(String x){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        resultado = obtenerValores(x);
        try {           
            while(resultado.next()){
                modelo.addElement(resultado.getString(1));
            }
        } catch (Exception e) {
        }
        return modelo;
    }
    //*************************************************************************


}