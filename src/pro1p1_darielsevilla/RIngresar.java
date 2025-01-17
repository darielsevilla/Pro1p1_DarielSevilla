/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pro1p1_darielsevilla;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class RIngresar extends javax.swing.JFrame {

    private int opcion;
    //1 - binario a decimal, 2 - decimal a binario
    private String mensaje;

    public RIngresar(int x) {
        setMensaje(x);
        opcion = x;
        initComponents();
        setVisible(true);
    }

    public void setMensaje(int par) {
        if (par == 1) {
            mensaje = "Ingrese numero binario";
        } else if (par == 2) {
            mensaje = "Ingrese numero decimal";
        } else if (par == 3) {
            mensaje = "Ingrese numero de filas";
        } else {
            mensaje = "Ingrese numero de columnas";
        }
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
        parField = new javax.swing.JTextField();
        ingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(mensaje);

        parField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parFieldActionPerformed(evt);
            }
        });

        ingresar.setBackground(new java.awt.Color(0, 153, 153));
        ingresar.setForeground(new java.awt.Color(0, 0, 0));
        ingresar.setText("ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(ingresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(parField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(parField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void parFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parFieldActionPerformed

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        String temp = parField.getText();
        int error = 0;
        if (opcion == 1) {
            //Chequeo de si la string es un numero, y si es de 0s y 1s
            if (checkInt(temp)) {
                int par = Integer.parseInt(temp);
                int tempo = par;

                while (tempo != 0) {
                    if (tempo % 10 != 0 && tempo % 10 != 1) {
                        error++;
                        
                    }
                   
                    tempo /= 10;
                    if (error != 0) {
                        break;
                    }
                }

            } else {
                error++;
            }

            if (error == 0) {
                int enviar = Integer.parseInt(temp);
                RRespuesta ventana = new RRespuesta(1, enviar);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                
            }
        }else if(opcion == 2){
            if(checkInt(temp)){
                int enviar = Integer.parseInt(temp);
                RRespuesta ventana = new RRespuesta(2, enviar);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                
            }
        }else if(opcion == 3){
            if(checkInt(temp)){
                int enviar = Integer.parseInt(temp);
                Storage.addMatrizAtribute(0, enviar);
                if(Storage.matrizSize() == 1){
                    if(Storage.getMatriz(0)[0].length == Storage.matrizAtributos[0]){
                        RIngresar ventana = new RIngresar(4);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(null, "El tamaño de esta fila debe ser el mismo tamaño de la columna de la matriz anterior");
                    }
                }else{
                    RIngresar ventana = new RIngresar(4);
                    dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                
            }
        }else{
            if(checkInt(temp)){
                int enviar = Integer.parseInt(temp);
                Storage.addMatrizAtribute(1, enviar);
                Storage.addMatriz();
                if(Storage.matrizSize() != 2){
                    RIngresar ventana = new RIngresar(3);
                }else{
                    
                    RRespuesta ventana = new RRespuesta(3, 0);
                }
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
                
            }
        }

    }//GEN-LAST:event_ingresarActionPerformed

    public boolean checkInt(String par) {
        try {
            Integer.parseInt(par);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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
            java.util.logging.Logger.getLogger(RIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField parField;
    // End of variables declaration//GEN-END:variables
}
