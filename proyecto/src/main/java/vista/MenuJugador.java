package vista;

import excepcion.Excepcion;
import handler.Manager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Equipo;
import modelo.Juego;
import modelo.Oferta;

public class MenuJugador extends javax.swing.JFrame {

    public MenuJugador() {
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
        jButton1 = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnVerJuegos = new javax.swing.JButton();
        btnVerEquipos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU JUGADOR");

        jButton1.setText("Ver Ofertas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnPerfil.setText("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnVerJuegos.setText("Ver Juegos");
        btnVerJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerJuegosActionPerformed(evt);
            }
        });

        btnVerEquipos.setText("Ver Equipos");
        btnVerEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEquiposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addGap(217, 217, 217))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                            .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnVerEquipos)
                .addGap(18, 18, 18)
                .addComponent(btnVerJuegos)
                .addGap(18, 18, 18)
                .addComponent(btnPerfil)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Comprobamos que exista alguna oferta
        try{
            ArrayList<Oferta> ofertas = Manager.bbdd.returnOfertas();
            if(ofertas.isEmpty()){
                throw new Excepcion(Excepcion.noHayNingunaOferta);
            }
            VerOfertas verOfertas = new VerOfertas(this, true);
            verOfertas.setLocationRelativeTo(null);
            verOfertas.setVisible(true);
        }catch (SQLException|Excepcion|ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        PerfilJugador perfilJugador = new PerfilJugador(this, true);
        perfilJugador.setLocationRelativeTo(null);
        perfilJugador.setVisible(true);
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnVerJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerJuegosActionPerformed
        //Comprobamos que exista alguna oferta
        try{
            ArrayList<Juego> juegos = Manager.bbdd.returnJuegos();
            if(juegos.isEmpty()){
                throw new Excepcion(Excepcion.noHayNingunJuego);
            }
            VerJuegos verJuegos = new VerJuegos(this, true);
            verJuegos.setLocationRelativeTo(null);
            verJuegos.setVisible(true);
        }catch (SQLException|Excepcion ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerJuegosActionPerformed

    private void btnVerEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEquiposActionPerformed
        //Comprobamos que exista alguna oferta
        try{
            ArrayList<Equipo> equipos = Manager.bbdd.returnEquipos();
            if(equipos.isEmpty()){
                throw new Excepcion(Excepcion.noHayNingunEquipo);
            }
            VerEquipos verEquipos = new VerEquipos(this, true);
            verEquipos.setLocationRelativeTo(null);
            verEquipos.setVisible(true);
        }catch (SQLException|Excepcion|ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerEquiposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnVerEquipos;
    private javax.swing.JButton btnVerJuegos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
