/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_tercer_trimestre;
import datos.*;
import validar.*;
import java.sql.*;
import javax.swing.JOptionPane;
import metodo.conectar;
/**
 *
 * @author Alex
 */
public class Asiento extends javax.swing.JFrame {

    /**
     * Creates new form Asiento
     */
    public Asiento() {
        initComponents();
        jLabel4.setVisible(false);
        
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_tercer_trimestre/Imagenes/avion.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 50, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "07", "08", "10", "11", "12", "13", "14", "15", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 50, 30));

        jLabel2.setText("Seleccione asiento:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, 30));

        jLabel3.setText("Seleccione la fila:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, 30));

        jButton1.setText("Terminar compra billete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 190, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Atención, esta poniendo un asiento que se encuentra en primera clase,\n tenga en cuenta que habrá un incremento en el precio de 120€.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 740, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        int seleccion = jComboBox2.getSelectedIndex();
        if(seleccion<4){
            jLabel4.setVisible(true);
        }else{
            jLabel4.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    String fila = (String) jComboBox2.getSelectedItem();
    String asiento = (String) jComboBox1.getSelectedItem();
         
    datos da=new datos();
    String DNI=da.getDNI();
   String codigo=da.getCodigo();
    
    
    int seleccion = jComboBox2.getSelectedIndex();
        if(seleccion<4){
            String clase="Bussiness";
            da.setClase(clase);
            int incremento=120;
            String precioini = da.getPrecio();
            String precioremplazado = precioini.replace("€", "");
            int precioinicial=Integer.parseInt(precioremplazado);            
            int preciofinal=incremento+precioinicial;            
            String preciodef=String.valueOf(preciofinal)+"€";            
            da.setPrecio(preciodef);
            
        }else{
            String clase="Turista";
            da.setClase(clase);
        } 
        
        String precio=da.getPrecio();
        String clase=da.getClase();
        
   Connection conn=null;
   conectar con= new conectar(); 
   conn=con.getConnection();
        try{
     Statement st=conn.createStatement();
     String billete="update Billetes set Asiento='"+fila+asiento+"' where DNI='"+DNI+"'";
      String incodigo="update Billetes set Codigo_Vuelo='"+codigo+"' where DNI='"+DNI+"'";
      String inclase="update Billetes set Clase='"+clase+"' where DNI='"+DNI+"'"; 
       String inprecio="update Billetes set Precio_Final='"+precio+"' where DNI='"+DNI+"'";
      st.executeUpdate(billete);
      st.executeUpdate(incodigo);
      st.executeUpdate(inclase);
      st.executeUpdate(inprecio);
      System.out.println("Se ha creado la nueva compra");
        }catch(Exception e){
            System.out.println("Error creando el registro: "+e);
        }
        int numbilletes=da.getnumBilletes();
        
        for(int i=0; numbilletes<i;i++){
            this.setVisible(false);
            Billetes_Personas bill=new Billetes_Personas();
            bill.setVisible(true);
        }
                
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String fila = (String) jComboBox2.getSelectedItem();
        String asiento = (String) jComboBox1.getSelectedItem();
        String asientoesc=fila+asiento;
        
        validar val=new validar();
        val.setValido(asientoesc);
        String validacion=val.getValido();
        System.out.println(validacion);
        while(validacion.equals("Ocupado")){
            
            JOptionPane.showMessageDialog(null,"Asiento ocupado, por favor escoga otro asiento para continuar");
            fila = (String) jComboBox2.getSelectedItem();
         asiento = (String) jComboBox1.getSelectedItem();
        asientoesc=fila+asiento;
            val.setValido(asientoesc);
         validacion=val.getValido();
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
