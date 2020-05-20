package vista;

import excepcion.Excepcion;
import handler.Manager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfAlias = new javax.swing.JTextField();
        btnValidar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        jpPassword = new javax.swing.JPasswordField();
        lblPasswordRecover = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Alias:");

        jLabel2.setText("Password:");

        btnValidar.setText("Validar");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        jLabel3.setText("¿No tienes cuenta?");

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        lblPasswordRecover.setForeground(new java.awt.Color(0, 0, 255));
        lblPasswordRecover.setText("¿Has olvidado tu Password?");
        lblPasswordRecover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPasswordRecoverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPasswordRecover, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnValidar)
                .addGap(18, 18, 18)
                .addComponent(lblPasswordRecover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnRegistrarse))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        RegisterType registerType = new RegisterType(this, true);
        registerType.setLocationRelativeTo(null);
        registerType.setVisible(true);
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        String tipo = "";
        try {
            if(Manager.bbdd.jugadorExist(tfAlias.getText())){
                tipo = "jugador";
            } else if (Manager.bbdd.equipoExist(tfAlias.getText())){
                tipo = "equipo";
            }
            if(tipo.equalsIgnoreCase("")){
                throw new Excepcion(Excepcion.noExisteUsuarioConEseNombre);
            }    
            if(!Manager.bbdd.login(tfAlias.getText(), tipo, String.valueOf(jpPassword.getPassword()))){
                throw new Excepcion(Excepcion.passwordIncorrecto);
            }
            Manager.setUsuario(tfAlias.getText());
            if(tipo.equalsIgnoreCase("jugador")){
                abrirMenuJugador();
            }else if(tipo.equalsIgnoreCase("equipo")){
                abrirMenuEquipo();
            }
        } catch (SQLException|Excepcion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnValidarActionPerformed

    private void lblPasswordRecoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordRecoverMouseClicked
        RecoverPassword recoverPassword = new RecoverPassword(this, true);
        recoverPassword.setLocationRelativeTo(null);
        recoverPassword.setVisible(true);
    }//GEN-LAST:event_lblPasswordRecoverMouseClicked

    public void abrirMenuJugador(){
        MenuJugador menuJugador = new MenuJugador();
        menuJugador.setTitle("Menu Jugador");
        menuJugador.setLocationRelativeTo(null);
        menuJugador.setVisible(true);
        dispose();
    }
    
    public void abrirMenuEquipo(){
        MenuEquipo menuEquipo = new MenuEquipo();
        menuEquipo.setTitle("Menu Equipo");
        menuEquipo.setLocationRelativeTo(null);
        menuEquipo.setVisible(true);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jpPassword;
    private javax.swing.JLabel lblPasswordRecover;
    private javax.swing.JTextField tfAlias;
    // End of variables declaration//GEN-END:variables
}
