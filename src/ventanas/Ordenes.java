package ventanas;

import codigo.cod_NuevaOrden;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class NuevaOrden extends javax.swing.JFrame {

    public NuevaOrden() {
        initComponents();
        llenar_jCbx();
        this.llenar_listaC();
        this.llenarMesa();
        this.llenarMesero();

    }

    public void prueba(String q) {
        this.txt_orden.setText(q);
    }

    /**
     * **********************************************************************
     */
    //Metodos para llenar las categorias y productos**************************
    public void llenar_jCbx() {
        this.cbx_categoria.removeAllItems();
        ArrayList<String> lista = new ArrayList<>();
        lista = cod_NuevaOrden.llenarJcbx();
        for (int i = 0; i < lista.size(); i++) {
            this.cbx_categoria.addItem(lista.get(i));
        }
    }
    
        
    public void llenar_listaC() {
        String categ = this.cbx_categoria.getSelectedItem().toString();
        this.jlist_productos.setModel(cod_NuevaOrden.llenar_jListP(categ));
    }
    
    
    //**llenar parametros
    public void llenarMesa(){
        this.CB_mesa.removeAllItems();
        ArrayList<String> lista = new ArrayList<>();
        lista = cod_NuevaOrden.llenarJcbxParametros("mesa");
        for (int i = 0; i < lista.size(); i++) {
            this.CB_mesa.addItem(lista.get(i));
        }
        //this.CB_mesa.setSelectedIndex(-1);
    }
    
    public void llenarMesero(){
        this.CB_mesero.removeAllItems();
        ArrayList<String> lista = new ArrayList<>();
        lista = cod_NuevaOrden.llenarJcbxParametros("mesero");
        for (int i = 0; i < lista.size(); i++) {
            this.CB_mesero.addItem(lista.get(i));
        }
    }



    //establece el modelo de la tabla
    public void llenar_tabla(String p) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("cnt");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        modelo.addColumn("total");

        //modelo=cod_NuevaOrden.llenarTabla(modelo, p);
        this.tabla.setModel(modelo);

        //this.tabla_categoria.setModel(modelo);
    }

    //Agrega una fila recibe un objeto lleno de los datos de la fila**********
    public void agregarFila(Object[] x) {
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        modelo.addRow(x);
    }
    

    //***********************************************************************
    //BUSCAR EL PRODCUTO PARA INCREMENTAR LA CANTIDAD
    //***********************************************************************
    public int buscarProductoTabla(String q) {
        //Object[] rowcol;
        //= new Object[2];
        int fila = -1;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (this.tabla.getValueAt(i, 1).toString().equals(q)) {
                System.out.println("existo");
                fila = i;
            }
        }

        return fila;
    }

    //*************************************************************************
    //eliminar fila seleccionada
    //*************************************************************************
    public void eliminarFila() {
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        if (this.tabla.getSelectedRow() != -1) {
            modelo.removeRow(this.tabla.getSelectedRow());
        }
    }

    //************************************************************************
    //Sumar - Restar cantidad y precio total
    //************************************************************************
    public void modificarCantidad(int s) {
        if (this.tabla.getSelectedRow() != -1) {
            int fila = this.tabla.getSelectedRow();
            String pr = this.tabla.getValueAt(fila, 0).toString();
            int cantidad = Integer.parseInt(pr) + s;
            double precioU = Double.parseDouble(this.tabla.getValueAt(fila, 2).toString()) * s;
            double precioT = Double.parseDouble(this.tabla.getValueAt(fila, 3).toString());
            precioT = precioT + precioU;
            this.tabla.setValueAt(precioT, fila, 3);
            //System.out.println(cantidad);
            this.tabla.setValueAt(cantidad, fila, 0);
        }
    }
    
    //

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbx_categoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlist_productos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_sumarCantidad = new javax.swing.JButton();
        btn_restarCantidad = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_agregarProducto = new javax.swing.JButton();
        btn_eliminarfila = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_orden = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        CB_mesa = new javax.swing.JComboBox<>();
        CB_mesero = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 768));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("AGREGAR PRODUCTOS");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("CATEGORIA:");

        cbx_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_categoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_categoriaItemStateChanged(evt);
            }
        });
        cbx_categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_categoriaMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("LISTA: ");

        jlist_productos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlist_productos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlist_productosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlist_productos);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Producto", "P/U", "SubTotal"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        btn_sumarCantidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_sumarCantidad.setText("+");
        btn_sumarCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_sumarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sumarCantidadActionPerformed(evt);
            }
        });

        btn_restarCantidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_restarCantidad.setText("-");
        btn_restarCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_restarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restarCantidadActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("PRODUCTOS AGREGADOS: ");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        jButton5.setText("CANCELAR");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        jButton3.setText("GUARDAR");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/dinero.png"))); // NOI18N
        jButton4.setText("COBRAR");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btn_agregarProducto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_agregarProducto.setText("->");
        btn_agregarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarProductoActionPerformed(evt);
            }
        });

        btn_eliminarfila.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminarfila.setText("x");
        btn_eliminarfila.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminarfila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarfilaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(9, 9, 9)
                        .addComponent(cbx_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_agregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(250, 250, 250))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_sumarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_restarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btn_eliminarfila, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbx_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_agregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn_sumarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btn_restarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_eliminarfila, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(jButton5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ORDEN:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("MESA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("MESERO:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CLIENTE:");

        txt_orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ordenActionPerformed(evt);
            }
        });

        CB_mesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CB_mesero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_orden, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_mesero, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CB_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(CB_mesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setText("NUEVA ORDEN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ordenActionPerformed


    private void cbx_categoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_categoriaItemStateChanged
        //si cambia el valor del jcombobox actuliza la lista de productos
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            //Object item = evt.getItem();
            this.llenar_listaC();
            // do something with object

        }
    }//GEN-LAST:event_cbx_categoriaItemStateChanged

    private void cbx_categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_categoriaMouseClicked

    }//GEN-LAST:event_cbx_categoriaMouseClicked

    private void jlist_productosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlist_productosValueChanged
        //
        /*String x = this.jlist_productos.getSelectedValue();
        System.out.println(x);*/
    }//GEN-LAST:event_jlist_productosValueChanged

    //*************************************************************************
    //Agrega un producto de la lista a la tabla
    private void btn_agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarProductoActionPerformed
        String p = this.jlist_productos.getSelectedValue();
        int fila = this.buscarProductoTabla(p);

        if (fila == -1) {
            this.agregarFila(cod_NuevaOrden.llenarFila(p));
        } else {
            String pr = this.tabla.getValueAt(fila, 0).toString();
            int cantidad = Integer.parseInt(pr) + 1;
            double precioU = Double.parseDouble(this.tabla.getValueAt(fila, 2).toString());
            double precioT = Double.parseDouble(this.tabla.getValueAt(fila, 3).toString());
            precioT = precioT + precioU;
            this.tabla.setValueAt(precioT, fila, 3);
            this.tabla.setValueAt(cantidad, fila, 0);
            //System.out.println(pr);
            //System.out.println(cantidad);
        }

    }//GEN-LAST:event_btn_agregarProductoActionPerformed

    private void btn_eliminarfilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarfilaActionPerformed
        // TODO add your handling code here:
        this.eliminarFila();
    }//GEN-LAST:event_btn_eliminarfilaActionPerformed

    private void btn_sumarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sumarCantidadActionPerformed
        // TODO add your handling code here:
        this.modificarCantidad(1);
    }//GEN-LAST:event_btn_sumarCantidadActionPerformed

    private void btn_restarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restarCantidadActionPerformed
        // TODO add your handling code here:
        this.modificarCantidad(-1);
    }//GEN-LAST:event_btn_restarCantidadActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_mesa;
    private javax.swing.JComboBox<String> CB_mesero;
    private javax.swing.JButton btn_agregarProducto;
    private javax.swing.JButton btn_eliminarfila;
    private javax.swing.JButton btn_restarCantidad;
    private javax.swing.JButton btn_sumarCantidad;
    private javax.swing.JComboBox<String> cbx_categoria;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JList<String> jlist_productos;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txt_orden;
    // End of variables declaration//GEN-END:variables
}
