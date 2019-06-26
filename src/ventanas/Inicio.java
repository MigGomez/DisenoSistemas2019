
package ventanas;

import codigo.dashboard_codigo;
import codigo.orden;
import com.sun.imageio.plugins.png.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
       initComponents();
       this.llenar_tabla();
       this.cbx_Filtrar.setSelectedIndex(3);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_imprimir = new javax.swing.JButton();
        btn_nuevaorden = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_cobrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_Filtrar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbx_Filtrar = new javax.swing.JComboBox<>();
        btn_configuraciones = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setAutoscrolls(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/impresora.png"))); // NOI18N
        btn_imprimir.setText("IMPRIMIR");
        btn_imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        btn_nuevaorden.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_nuevaorden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-de-suma.png"))); // NOI18N
        btn_nuevaorden.setText("NUEVA ORDEN");
        btn_nuevaorden.setToolTipText("");
        btn_nuevaorden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn_nuevaorden.setBorderPainted(false);
        btn_nuevaorden.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_nuevaorden.setMaximumSize(new java.awt.Dimension(153, 121));
        btn_nuevaorden.setMinimumSize(new java.awt.Dimension(153, 121));
        btn_nuevaorden.setPreferredSize(new java.awt.Dimension(153, 121));
        btn_nuevaorden.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_nuevaorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaordenActionPerformed(evt);
            }
        });

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nueva orden.png"))); // NOI18N
        btn_modificar.setText("MODIFICAR");
        btn_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_cobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/dinero.png"))); // NOI18N
        btn_cobrar.setText("COBRAR");
        btn_cobrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cobrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_cobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cobrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ORDENES ACTIVAS:");

        txt_Filtrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_Filtrar.setToolTipText("");
        txt_Filtrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_FiltrarKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Filtrar:");

        cbx_Filtrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "orden", "mesero", "mesa", "cliente" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nuevaorden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_imprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cobrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbx_Filtrar)
                            .addComponent(txt_Filtrar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_nuevaorden, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        btn_configuraciones.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_configuraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/desarrollo.png"))); // NOI18N
        btn_configuraciones.setText("CONFIGURACIONES");
        btn_configuraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configuracionesActionPerformed(evt);
            }
        });

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("DASHBOARD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(62, 62, 62)
                        .addComponent(btn_configuraciones)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_configuraciones)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevaordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaordenActionPerformed
        //
        Ordenes a = new Ordenes();
        int x =dashboard_codigo.obtenerID();
        a.nuevaOrden_id(Integer.toString(x));
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_nuevaordenActionPerformed
    
    //*************************************************************************
    //modificar orden activa
    //*************************************************************************
    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        orden x = new orden();
        
        if (this.tabla.getSelectedRow() != -1) {
            x.setId(this.tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            x.setMesero(this.tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            x.setMesa(this.tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            x.setCliente(this.tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
            x.setTotal(this.tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
            
            Ordenes a = new Ordenes();
            
            //envia objeto orden para modificar
            
            a.OrdenMd(x);
            a.tablaMd(x.getId());
            a.setVisible(true);
            
            
        
            dispose();
        }
        
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_configuracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuracionesActionPerformed
        Configuracion a = new Configuracion();
        a.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btn_configuracionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_cobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cobrarActionPerformed
        // TODO add your handling code here:
        if (this.tabla.getSelectedRow() != -1) {
            Cobrar a = new Cobrar();
            a.setVisible(true);
            a.recibirOrden(tabla.getValueAt(tabla.getSelectedRow(), 0).toString(), tabla.getValueAt(tabla.getSelectedRow(), 4).toString());

            dispose();
        }
        
    }//GEN-LAST:event_btn_cobrarActionPerformed

    
    private void txt_FiltrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FiltrarKeyTyped
        // TODO add your handling code here:
        
        TableRowSorter trs = new TableRowSorter(this.tabla.getModel());
        
        this.txt_Filtrar.addKeyListener(new KeyAdapter () {
            @Override
            public void keyReleased(KeyEvent ke) {
                //trs.setRowFilter(RowFilter.regexFilter(txt_Filtrar.getText(), 1) );
                int a = cbx_Filtrar.getSelectedIndex();
                trs.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)"+txt_Filtrar.getText(), a));
                
            }
        
            
            
        });
        tabla.setRowSorter(trs);
    }//GEN-LAST:event_txt_FiltrarKeyTyped

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        // TODO add your handling code here:
        if (this.tabla.getSelectedRow() != -1) {
            imprimir a = new imprimir();
            a.setVisible(true);
            

            dispose();
        }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    public void llenar_tabla() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ORDEN");
        modelo.addColumn("MESERO");
        modelo.addColumn("MESA");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("TOTAL");
        
        modelo = codigo.dashboard_codigo.llenarTabla(modelo);
        this.tabla.setModel(modelo);
    }
    
    
    
    
    
    //*************************************************************************
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cobrar;
    private javax.swing.JButton btn_configuraciones;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevaorden;
    private javax.swing.JComboBox<String> cbx_Filtrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txt_Filtrar;
    // End of variables declaration//GEN-END:variables
}
