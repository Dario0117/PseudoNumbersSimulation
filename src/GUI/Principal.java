/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LOGICA.Cliente;
import LOGICA.Corrida;
import LOGICA.Distribuciones;
import LOGICA.main;
import static LOGICA.main.cabecera_aleatorios;
import static LOGICA.main.probabilidad_hombre;
import static LOGICA.main.promedio_atencion;
import static LOGICA.main.promedio_llegada;
import static LOGICA.main.promedio_salida;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import numbergenerator.NumberGenerator;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void vacearTabla(javax.swing.JTable Tabla) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    
    public void llenarCorridas() {
        DefaultTableModel model = (DefaultTableModel) this.corridas.getModel();
        Object datos[] = new Object[5];
        
        for (int i = 0; i < main.cantidad_corridas; i++) {
            datos[0] = i+1;
            datos[1] = main.corridas[i].getLongitud();
            datos[2] = sacarPanesVendidos(i);
            datos[3] = sacarBebidasVendidas(i);
            datos[4] = sacarVentasTerminadas(i);
            model.addRow(datos);
        }
        this.corridas.setModel(model);
    }
    
    private int sacarPanesVendidos(int i){
        int cnt=0;
        for (int j = 0; j < main.corridas[i].getLongitud(); j++) {
            cnt += main.corridas[i].getClientes().get(j).getPan().size();
        }
        return cnt;
    }
    
    private int sacarBebidasVendidas(int i){
        int cnt=0;
        for (int j = 0; j < main.corridas[i].getLongitud(); j++) {
            cnt += main.corridas[i].getClientes().get(j).getBebida().size();
        }
        return cnt;
    }
    
    private int sacarVentasTerminadas(int i){
        int cnt=0;
        for (int j = 0; j < main.corridas[i].getLongitud(); j++) {
            if(main.corridas[i].getClientes().get(j).getPan().size()>0 && main.corridas[i].getClientes().get(j).getBebida().size() > 0){
                cnt += 1;
            }
        }
        return cnt;
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        corridas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulación"));

        jLabel1.setText("Numero de corridas a realizar: 50");

        jButton1.setText("Comenzar con la simulación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        corridas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Clientes", "Panes vendidos", "Bebidas vendidas", "Ventas terminadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(corridas);
        if (corridas.getColumnModel().getColumnCount() > 0) {
            corridas.getColumnModel().getColumn(1).setResizable(false);
            corridas.getColumnModel().getColumn(2).setResizable(false);
            corridas.getColumnModel().getColumn(3).setResizable(false);
            corridas.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton2.setText("Detalles de la corrida seleccionada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < main.cantidad_corridas; i++) {
            for (int j = 0; j < main.corridas[i].getLongitud(); j++) {
                // hora_llegada, tiempo_espera, tiempo_atencion, sexo, pan, bebida, edad
                Cliente temp = new Cliente(
                        Distribuciones.generarExponencial(NumberGenerator.getInternList().get(cabecera_aleatorios++), promedio_llegada), // hora llegada
                        Distribuciones.generarExponencial(NumberGenerator.getInternList().get(cabecera_aleatorios++), promedio_atencion), // hora atencion
                        Distribuciones.generarExponencial(NumberGenerator.getInternList().get(cabecera_aleatorios++), promedio_salida), // hora salida
                        (Distribuciones.generarBernoulli(NumberGenerator.getInternList().get(cabecera_aleatorios++), probabilidad_hombre)) ? 'H':'M', // sexo
                        NumberGenerator.getInternList().get(cabecera_aleatorios++), //panes
                        NumberGenerator.getInternList().get(cabecera_aleatorios++), //bebidas
                        NumberGenerator.getInternList().get(cabecera_aleatorios++) // edad
                );
                main.corridas[i].getClientes().add(temp);
            }
        }
        vacearTabla(corridas);
        llenarCorridas();
        this.jButton1.setEnabled(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selected = this.corridas.getSelectedRow();
        if(selected<0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una corrida", "Detalles de la corrida", JOptionPane.WARNING_MESSAGE);
        }else{
            new DetallesCorrida(this, false,Integer.parseInt(""+this.corridas.getValueAt(selected, 0))).setVisible(true);
        }
        //
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable corridas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
