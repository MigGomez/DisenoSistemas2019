package codigo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class cod_Ordenes {
    
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
    
    
    //*************************************************************************
    //metodo para guardar detalle orden
    //*************************************************************************
    public static void detalleOrde(DefaultTableModel md, String orden){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        detalleOrden x = new detalleOrden();
        String q;
        String q2;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            x.setCantidad(modelo.getValueAt(i, 0).toString() );
            
            q = modelo.getValueAt(i, 1).toString();
            String c= "SELECT id FROM productos WHERE nombre='"+q +"'";
            int id = conexion.id(c);
            x.setId(orden);
            x.setProducto(Integer.toString(id));
            x.setPrecio(modelo.getValueAt(i, 2).toString());
            //x.semodelo.getValueAt(i, 3).toString();
            q = "INSERT INTO detalleorden (orden, producto, cantidad, precio) VALUES (' ";
            q2 = x.getId() +"', '"+ x.getProducto() +"', '"+ x.getCantidad() +"', '"+ x.getPrecio() + "')";
            
            //System.out.println(q+q2);
            conexion.ejecutar(q+q2);
        }
        
    }
    
    //************************************************************************
    //
    //************************************************************************
    public static DefaultTableModel llenarTabla(DefaultTableModel md, String orden){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        String q= "SELECT cantidad, producto, precio FROM detalleorden WHERE orden='"+orden+"'";
        
        md = conexion.llenar_tabla(q, md);
        md = llenarTabla2(md);
        md = calcularTotalfila(md);
        return md;
    }
    
    public static DefaultTableModel llenarTabla2(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        String x;
        String c;
        
        for (int i = 0; i < md.getRowCount(); i++) {
            x= md.getValueAt(i, 1).toString();
            c = conexion.nombreProducto(x);
            md.setValueAt(c, i, 1);
        }

        return md;
    }
    
    public static DefaultTableModel calcularTotalfila(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        double suma = 0;
        double precio;
        double cantidad;
        String x;
        String c;
        
        for (int i = 0; i < md.getRowCount(); i++) {
            precio = Double.parseDouble(md.getValueAt(i, 2).toString() );
            cantidad= Double.parseDouble(md.getValueAt(i, 0).toString());
            suma= precio * cantidad;
            
            md.setValueAt(suma, i, 3);
        }

        return md;
    }
    
    
    
    //**********************************************************************
    // para modificar orden existente
    //**********************************************************************
    
    public static void agregarPoducto_do (String id_or, String prod){
        String q= "SELECT id FROM productos WHERE nombre='"+prod +"'";
        int x = conexion.id(q);
        double p = conexion.precioProducto(x);
        //
        q = "INSERT INTO detalleorden (orden, producto, cantidad, precio) VALUES (' ";
        String q2 = id_or +"', '"+ x +"', '"+ "1" +"', '"+ p + "')";
            
        //System.out.println(q+q2);
        conexion.ejecutar(q+q2);
    }
    
    
    public static void modificarProducto_do(String id, String prod, int cant){
        String q= "SELECT id FROM productos WHERE nombre='"+prod +"'";
        int x = conexion.id(q);
        
        q = "UPDATE detalleorden SET cantidad ='"+ cant +"'" ;
        String q2 = "WHERE orden='" + id +"' and producto='"+ x +"'";
        
        //System.out.println(q+q2);
        conexion.ejecutar(q+q2);
    }
        
    public static void actualizarTotal(double x, String id){
        String q =  "UPDATE ordenes SET total ='"+ x +"' WHERE id ='" + id +"'";
        //System.out.println(q);
        conexion.ejecutar(q);
    }
    
    public static void eliminarFila(String id, String prod){
        String q= "SELECT id FROM productos WHERE nombre='"+prod +"'";
        int x = conexion.id(q);
        q =  "DELETE FROM detalleorden WHERE orden='"+ id+ "' AND producto='"+ x +"'";
        //System.out.println(q);
        conexion.ejecutar(q);
    }
    
    
    
    
}
