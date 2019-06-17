package codigo;

public class dashboard_codigo {
    
    //obtiene el utlimo id registrado en ordenes, y le suma 1 para crear el siguiente id
    public static int obtenerID(){
        int a = conexion.id("SELECT max(id) FROM ordenes");
        a =a+1;
        return a;
    }
    
    
}
