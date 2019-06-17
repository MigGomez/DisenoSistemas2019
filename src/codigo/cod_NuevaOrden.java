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
    
    //*************************************************************************
    //Calcular total, recibe el modelo, lo recorre y hace el calculo
    //*************************************************************************
    public static double calcularTotal(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        
        double numero;
        double suma = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            numero = Double.parseDouble(modelo.getValueAt(i, 3).toString());
            suma = numero+suma;    
        }
        
        return suma;
    }
    
    //*************************************************************************
    //guardar nueva orden
    public static void guardarNuevaOrden(orden x){
        x.fecha = conexion.fecha();
        String q= "INSERT INTO ordenes  (id, fecha, mesero, mesa, cliente, estado, total) VALUES ('";
        String q2 = x.getId() +"', '"+ x.getFecha() +"', '"+ x.getMesero() +"', '"+ x.getMesa() +"', '"+ x.getCliente() +"', '"+x.getEstado() +"', '"+x.getTotal() +"') ";
        //System.out.println(q+q2);
        conexion.ejecutar(q+q2);
    }
    
}
