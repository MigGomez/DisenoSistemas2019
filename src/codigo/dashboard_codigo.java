package codigo;

public class dashboard_codigo {
    public static int obtenerID(){
        int a = conexion.id("SELECT max(id) FROM ordenes");
        a =a+1;
        return a;
    }
    
}
