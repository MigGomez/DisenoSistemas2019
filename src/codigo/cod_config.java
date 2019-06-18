
package codigo;

import javax.swing.DefaultListModel;


public class cod_config {
    
    public static DefaultListModel<String> llenar_Lista(String x){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        
        String q = "SELECT valor FROM parametros WHERE nombre= '"+ x + "' " ;
        modelo = conexion.llenar_modlista(q);
        return modelo;
    }
    
    public static void agregarParamtero(String n, String v){
        String q = "INSERT INTO parametros (nombre, valor) VALUES ('"+n+"', '"+ v +"')" ;
        conexion.ejecutar(q);
    }
    
    public static void eliminarParametro(String n, String v){
        String q = "DELETE FROM parametros WHERE nombre= '"+n+"' && valor= '"+ v +"'" ;
        conexion.ejecutar(q);
    }
    
    
}
