package codigo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class cod_NuevaOrden {
    
    //LLenar jcbx
    public static ArrayList<String> llenarJcbx(){
        ArrayList<String> lista = new ArrayList<>();
        String q = "SELECT nombre FROM categoria";
        lista = conexion.LLenarLista(q);
        return lista;
    }
    
    //LLenar jcbx de parametros
    public static ArrayList<String> llenarJcbxParametros(String parametro){
        ArrayList<String> lista = new ArrayList<>();
        String q = "SELECT valor FROM parametros WHERE nombre = '"+ parametro +"'";
        lista = conexion.LLenarLista(q);
        return lista;
    }
    
    
    public static DefaultListModel<String> llenar_jListP(String x){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        String c= "SELECT id FROM categoria WHERE nombre='"+x +"'";
        int id = conexion.id(c);
        
        String q = "SELECT nombre FROM productos WHERE categoria= '"+ id + "' " ;
        modelo = conexion.llenar_modlista(q);
        return modelo;
    }
    
    
    public static Object[] llenarFila(String p){
        String q= "SELECT id FROM productos WHERE nombre='"+p +"'";
        double x = conexion.precioProducto(conexion.id(q));
        String a = Double.toString(x);
        Object[] prod = new Object[4];
        prod[0]="1";
        prod[1]=p;
        prod[2]=Double.toString(x);
        prod[3]=Double.toString(x);
        
        return prod;
    }
    
    
    
}
