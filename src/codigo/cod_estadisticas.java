
package codigo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class cod_estadisticas {
    
    public static DefaultTableModel obtenerIdsOrdenFecha(DefaultTableModel md){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = md;
        
        String q= "SELECT id FROM ordenes WHERE fecha='2019-06-17'";
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();
        
        lista = conexion.LLenarLista(q);
        
        for (int i = 0; i <lista.size() ; i++) {
            
            lista2 = idProductoDO(lista.get(i));
            
            for (int j = 0; j < lista2.size(); j++) {
                System.out.println("----");
                String a = lista2.get(j);
                
                if (md.getRowCount()==0) {
                    System.out.println("****");
                    md.setValueAt(lista2.get(j), j, 0);
                    md.setValueAt( cantidad(lista.get(i), lista2.get(j)) , j, 1);
                } 
                else if (lista2.get(j).equals( md.getValueAt(j, 0).toString() )) {
                    
                    System.out.println("1111");
                    int s1= Integer.parseInt(md.getValueAt(j, 1).toString());
                    int s2= cantidad(lista.get(i), lista2.get(j));
                    
                    s1 = s1+s2;
                    md.setValueAt(s1, j, 1);
                    
                }else {
                    System.out.println("****");
                    md.setValueAt(lista2.get(j), j, 0);
                    md.setValueAt( cantidad(lista.get(i), lista2.get(j)) , j, 1);
                }
                
                
            }
            
        }
        
        return md;
    }
    
    public static ArrayList<String> idProductoDO(String x){
        String q= "SELECT producto FROM detalleorden WHERE orden='"+x+"'";
        ArrayList<String> lista = new ArrayList<>();
        lista = conexion.LLenarLista(q);
        return lista;
    }
    
    public static int cantidad(String o, String p){
        int cantidad=0;
        String q= "SELECT cantidad FROM detalleorden WHERE orden='"+ o +"' && producto='"+ p +"'" ;
         cantidad = conexion.id(q);
        
        return cantidad;
    }
    
}
