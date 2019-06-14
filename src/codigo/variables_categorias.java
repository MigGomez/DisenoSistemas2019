
package codigo;

import javax.swing.table.DefaultTableModel;


public class variables_categorias {
    int id;
    String nombre;
    
    /***********************************************************************/
    //llenar TABLA envia el modelo y la sentencia sql, recibe el modelo lleno*******
    public static DefaultTableModel llenar_tablaC(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        String q= "SELECT * FROM categoria";
        
        return conexion.llenar_tabla(q, md);
    }
    
    public static void agregar_categoria(String x){
        String q = "INSERT INTO categoria (nombre) VALUES ('"+ x +"') ";
        conexion.ejecutar(q); 
    }
    
    public static void eliminar_categoria(String x){
        
        String q = "DELETE FROM categoria WHERE id=('"+ x +"') ";
        conexion.ejecutar(q);
    }
    
    

    public variables_categorias(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public variables_categorias(String nombre) {
        this.nombre = nombre;
    }
    
    
}
