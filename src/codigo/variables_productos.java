package codigo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class variables_productos {
    int id;
    String nombre;
    Double precio;
    String categoria;
    boolean espreparado;


    //metodos para llamar a conexion************************************************
    public static ArrayList<String> llenarJcbx(){
        ArrayList<String> lista = new ArrayList<>();
        String q = "SELECT nombre FROM categoria";
        lista = conexion.LLenarLista(q);
        return lista;
    }
    
    //llenar TABLA envia el modelo y la sentencia sql, recibe el modelo lleno*******
    public static DefaultTableModel llenar_tablaP(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        String q= "SELECT * FROM productos";
        md =conexion.llenar_tabla(q, md);
        md = llenarTabla2(md);
        return md;
    }
    
    //guardar productos
    public static void guardar_producto(variables_productos x){
        String q= "SELECT id FROM categoria WHERE nombre='"+x.getCategoria() +"'";
        int idC = conexion.id(q);

        int pre;
        if (x.getEspreparado()== false){
            pre=0;
        } else {
            pre=1;
        }
        
        String q2= "INSERT INTO productos  (nombre, precio, categoria, espreparado) VALUES ('"+ x.getNombre() +"' , '"+x.getPrecio().toString()+ "', '"+ idC +"', '"+ pre +"') ";
        conexion.ejecutar(q2);
    } 
    //**************************************************************************
    //llenar la tabla con los nombres de la categoria
    //**************************************************************************
    public static DefaultTableModel llenarTabla2(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        String x;
        String c;
        
        for (int i = 0; i < md.getRowCount(); i++) {
            x= md.getValueAt(i, 3).toString();
            c = conexion.nombreCategoria(x);
            md.setValueAt(c, i, 3);
        }

        return md;
    }
        
        
          
        
    //codigo generado*************************************************************
    public variables_productos(String nombre, Double precio, String categoria, boolean espreparado) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.espreparado = espreparado;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean getEspreparado() {
        return espreparado;
    }

    public void setEspreparado(boolean espreparado) {
        this.espreparado = espreparado;
    }
    
}
