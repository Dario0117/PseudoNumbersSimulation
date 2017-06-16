/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGICA.main;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Consejo Ing.Software
 */
public class DetallesCorrida extends javax.swing.JDialog {

    /**
     * Creates new form DetallesCorrida
     */
    
    private int corrida;
    private int cantidad_hombres = 0;
    private int cantidad_mujeres = 0;
    private double media_llegada = 0;
    private double media_atencion = 0;
    private double media_salida = 0;
    private int edad_concurrente = 0;
    
    public DetallesCorrida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DetallesCorrida(java.awt.Frame parent, boolean modal, int corrida) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Detalles de la corrida: "+corrida);
        this.corrida = corrida-1;
        llenarClientes();
    }
    
    public void vacearTabla(javax.swing.JTable Tabla) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    
    public void llenarClientes() {
        DefaultTableModel model = (DefaultTableModel) this.detalles.getModel();
        Object datos[] = new Object[6];
        
        int ed_1 = 0;
        int ed_2 = 0;
        int ed_3 = 0;
        int ed_4 = 0;
        int ed_5 = 0;
        
        int p300=0;
        int p600=0;
        int p1200=0;
        int p2000=0;
        
        for (int i = 0; i < main.corridas[corrida].getLongitud(); i++) {
            datos[0] = main.corridas[corrida].getClientes().get(i).getSexo();
            datos[1] = main.rango_edades[main.corridas[corrida].getClientes().get(i).getEdad()];
            datos[2] = main.corridas[corrida].getClientes().get(i).getHora_llegada();
            datos[3] = main.corridas[corrida].getClientes().get(i).getHora_espera();
            datos[4] = main.corridas[corrida].getClientes().get(i).getHora_salida();
            datos[5] = generarCompras(i);
            model.addRow(datos);
            
            if(main.corridas[corrida].getClientes().get(i).getSexo()=='H'){
                cantidad_hombres++;
            }else{
                cantidad_mujeres++;
            }
            
            media_llegada += main.corridas[corrida].getClientes().get(i).getHora_llegada();
            media_atencion += main.corridas[corrida].getClientes().get(i).getHora_espera();
            media_salida += main.corridas[corrida].getClientes().get(i).getHora_salida();
            
            switch(main.corridas[corrida].getClientes().get(i).getEdad()){
                case 1: ed_1++; break;
                case 2: ed_2++; break;
                case 3: ed_3++; break;
                case 4: ed_4++; break;
                case 5: ed_5++; break;
            }
            
            if(main.corridas[corrida].getClientes().get(i).getPan().contains("P300")) p300++;
            if(main.corridas[corrida].getClientes().get(i).getPan().contains("P600")) p600++;
            if(main.corridas[corrida].getClientes().get(i).getPan().contains("P1200")) p1200++;
            if(main.corridas[corrida].getClientes().get(i).getPan().contains("P2000")) p2000++;
        }
        this.detalles.setModel(model);
        
        media_llegada /= main.corridas[corrida].getLongitud();
        media_atencion /= main.corridas[corrida].getLongitud();
        media_salida /= main.corridas[corrida].getLongitud();
        
        int[] listaNumeros = {0,ed_1,ed_2,ed_3,ed_4,ed_5};
        int numMayor = 0;
        for (int i = 1; i < listaNumeros.length; i++) {
            if(listaNumeros[i]>numMayor){
                edad_concurrente = i;
                numMayor = listaNumeros[i];
            }
        }
//        System.out.println(pos);
//        for (int i = 0; i < listaNumeros.length; i++) {
//            System.out.print(listaNumeros[i]+" ");
//        }
//        System.out.println("");

        
        this.lbl_cantidad_clientes.setText(String.format("%dH %dM", cantidad_hombres, cantidad_mujeres));
        this.lbl_media_llegada.setText(String.format("%.4f", media_llegada));
        this.lbl_media_espera.setText(String.format("%.4f", media_atencion));
        this.lbl_media_salida.setText(String.format("%.4f", media_salida));
        this.lbl_rango_edad.setText(String.format("%s", main.rango_edades[edad_concurrente]));
        this.lbl_p300.setText(""+p300);
        this.lbl_p600.setText(""+p600);
        this.lbl_p1200.setText(""+p1200);
        this.lbl_p2000.setText(""+p2000);
    }

    
    private String generarCompras(int cliente){
        String compras="";
        for (int i = 0; i < main.corridas[corrida].getClientes().get(cliente).getPan().size(); i++) {
            compras += main.corridas[corrida].getClientes().get(cliente).getPan().get(i)+", ";
        }
        
        for (int i = 0; i < main.corridas[corrida].getClientes().get(cliente).getBebida().size(); i++) {
            compras += main.corridas[corrida].getClientes().get(cliente).getBebida().get(i)+", ";
        }
        
        return (compras.length()>0) ? compras.substring(0, compras.length()-2): null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalles = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_cantidad_clientes = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_media_llegada = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_media_espera = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_media_salida = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_rango_edad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbl_p300 = new javax.swing.JLabel();
        lbl_p600 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_p1200 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_p2000 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_ventas_terminadas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de los clientes"));

        detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sexo", "Rango de edad", "Tmp. entre llegada", "Tmp. de espera", "Tmp. de salida", "Compras"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(detalles);
        if (detalles.getColumnModel().getColumnCount() > 0) {
            detalles.getColumnModel().getColumn(0).setMinWidth(35);
            detalles.getColumnModel().getColumn(0).setMaxWidth(35);
            detalles.getColumnModel().getColumn(1).setResizable(false);
            detalles.getColumnModel().getColumn(2).setResizable(false);
            detalles.getColumnModel().getColumn(3).setResizable(false);
            detalles.getColumnModel().getColumn(4).setResizable(false);
            detalles.getColumnModel().getColumn(5).setMinWidth(400);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la corrida"));

        jLabel1.setText("Cantidad de clientes:");

        lbl_cantidad_clientes.setText("CLIENTES");

        jLabel5.setText("Media tiempos de llegada:");

        lbl_media_llegada.setText("MEDIA1");

        jLabel6.setText("Media tiempos de espera:");

        lbl_media_espera.setText("MEDIA2");

        jLabel7.setText("Media tiempos de salida:");

        lbl_media_salida.setText("MEDIA3");

        jLabel8.setText("Rango de edad concurrente:");

        lbl_rango_edad.setText("EDAD");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles Ventas"));

        jLabel9.setText("P300:");

        lbl_p300.setText("CANT");

        lbl_p600.setText("CANT");

        jLabel12.setText("P600:");

        lbl_p1200.setText("CANT");

        jLabel14.setText("P1200:");

        lbl_p2000.setText("CANT");

        jLabel16.setText("P2000:");

        jLabel17.setText("CANT");

        jLabel18.setText("AVENA:");

        jLabel19.setText("CANT");

        jLabel20.setText("REFRE.:");

        jLabel21.setText("CANT");

        jLabel22.setText("GASE.:");

        jLabel23.setText("CANT");

        jLabel24.setText("NATU.:");

        jLabel25.setText("CANT");

        jLabel26.setText("AG. OT.:");

        jLabel4.setText("Ventas terminadas:");

        lbl_ventas_terminadas.setText("VENTAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_p300))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_p600))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_p1200))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_p2000)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_ventas_terminadas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbl_p300)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbl_p600)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbl_p1200)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbl_p2000)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_ventas_terminadas)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_cantidad_clientes))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_media_llegada)
                            .addComponent(lbl_rango_edad)
                            .addComponent(lbl_media_salida)
                            .addComponent(lbl_media_espera))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbl_cantidad_clientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbl_media_llegada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbl_media_espera))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbl_media_salida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbl_rango_edad)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DetallesCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesCorrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallesCorrida dialog = new DetallesCorrida(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable detalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cantidad_clientes;
    private javax.swing.JLabel lbl_media_espera;
    private javax.swing.JLabel lbl_media_llegada;
    private javax.swing.JLabel lbl_media_salida;
    private javax.swing.JLabel lbl_p1200;
    private javax.swing.JLabel lbl_p2000;
    private javax.swing.JLabel lbl_p300;
    private javax.swing.JLabel lbl_p600;
    private javax.swing.JLabel lbl_rango_edad;
    private javax.swing.JLabel lbl_ventas_terminadas;
    // End of variables declaration//GEN-END:variables
}
