package codigo;

import javax.swing.table.DefaultTableModel;

public class dashboard_codigo {
    
    //obtiene el utlimo id registrado en ordenes, y le suma 1 para crear el siguiente id
    public static int obtenerID(){
        int a = conexion.id("SELECT max(id) FROM ordenes");
        a =a+1;
        return a;
    }
    
    //llenar TABLA envia el modelo y la sentencia sql, recibe el modelo lleno*******
    public static DefaultTableModel llenarTabla(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        String q= "SELECT id, mesero, mesa, cliente, total FROM ordenes";
        
        return conexion.llenar_tabla(q, md);
    }
    
}
