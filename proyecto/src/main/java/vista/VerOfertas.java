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

public class VerOfertas extends javax.swing.JDialog {

    int posicion;
    ArrayList<Oferta> ofertasSeleccionadas;
    
    public VerOfertas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        start();
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
        jLabel3 = new javax.swing.JLabel();
        cbJuegos = new javax.swing.JComboBox<>();
        cbEquipos = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblNombreOferta = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNombreEquipo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNombreJuego = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblVacantes = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("FILTROS:");

        jLabel2.setText("Juego:");

        jLabel3.setText("Equipo:");

        cbJuegos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Sin Filtro --" }));

        cbEquipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Sin Filtro --" }));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Oferta:");

        jLabel5.setText("Equipo:");

        jLabel6.setText("Juego:");

        jLabel7.setText("Vacantes:");

        jLabel8.setText("Descripcion:");

        taDescripcion.setEditable(false);
        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        jScrollPane1.setViewportView(taDescripcion);

        btnAnterior.setText("<< Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente>>");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEquipos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbJuegos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVacantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFiltrar)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblNombreJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblVacantes, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        try {
            //Cuando le da al boton de filtrar deshabilitamos los botones
            btnAnterior.setEnabled(false);
            btnSiguiente.setEnabled(false);
            //Comprobamos los filtros selecionados para decidir que mostrar
            String noFiltro = "-- Sin Filtro --";
            String filtroJuego = cbJuegos.getSelectedItem().toString();
            String filtroEquipo = cbEquipos.getSelectedItem().toString();
            int idequipo = -1;
            int idjuego = -1;
            if(!filtroJuego.equalsIgnoreCase(noFiltro)){
                Juego j = Manager.bbdd.returnJuego(filtroJuego);
                idjuego = j.getIdjuego();
            }
            if(!filtroEquipo.equalsIgnoreCase(noFiltro)){
                Equipo e = Manager.bbdd.returnEquipo(filtroEquipo);
                idequipo = e.getIdequipo();
            }
            posicion = 0;
            ofertasSeleccionadas = Manager.bbdd.returnOfertasFiltradas(idequipo, idjuego);
            gestionArrayOfertas();
        } catch (SQLException|Excepcion|ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        //El boton anterior muestra la anterior oferta en el ArrayList y habilita el boton siguiente
        posicion = posicion -1;
        mostrarOfertas(ofertasSeleccionadas.get(posicion));
        if(posicion==0){
            btnAnterior.setEnabled(false);
        }
        btnSiguiente.setEnabled(true);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        //El boton siguiente muestra la siguiente oferta en el ArrayList y habilita el boton anterior
        posicion = posicion +1;
        mostrarOfertas(ofertasSeleccionadas.get(posicion));
        if(posicion==(ofertasSeleccionadas.size()-1)){
            btnSiguiente.setEnabled(false);
        }
        btnAnterior.setEnabled(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void start(){
        //Cargamos los combo box con los juegos y equipos
        try {
            for(Juego j : Manager.bbdd.returnJuegos()){
                cbJuegos.addItem(j.getNombre());
            }
            for(Equipo e : Manager.bbdd.returnEquipos()){
                cbEquipos.addItem(e.getNombre());
            }
            //Al principio deshabilitamos los botones atras y siguiente
            btnAnterior.setEnabled(false);
            btnSiguiente.setEnabled(false);
            posicion = 0;
            ofertasSeleccionadas = Manager.bbdd.returnOfertas();
            gestionArrayOfertas();
        } catch (SQLException|Excepcion|ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Metodo que comprueba si existen resultados con los datos seleccionados por el usuario
    private void gestionArrayOfertas(){
        if(ofertasSeleccionadas.isEmpty()){           
            JOptionPane.showMessageDialog(this, "No existen resultados con estos datos", "Sin Resultados", JOptionPane.WARNING_MESSAGE);
            resetOfertas();
        }else{
            mostrarOfertas(ofertasSeleccionadas.get(0));
            if(ofertasSeleccionadas.size()>1){
                btnSiguiente.setEnabled(true);
            }
        }
    }
    
    //Metodo para mostrar una oferta
    private void mostrarOfertas(Oferta o){
        lblNombreOferta.setText(o.getNombre());
        lblNombreEquipo.setText(o.getEquipo().getNombre());
        lblNombreJuego.setText(o.getJuego().getNombre());
        lblVacantes.setText(String.valueOf(o.getVacantes()));
        taDescripcion.setText(o.getDescripcion());
    }
    
    private void resetOfertas(){
        String guiones = "----------";
        lblNombreOferta.setText(guiones);
        lblNombreEquipo.setText(guiones);
        lblNombreJuego.setText(guiones);
        lblVacantes.setText(guiones);
        taDescripcion.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbEquipos;
    private javax.swing.JComboBox<String> cbJuegos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombreEquipo;
    private javax.swing.JLabel lblNombreJuego;
    private javax.swing.JLabel lblNombreOferta;
    private javax.swing.JLabel lblVacantes;
    private javax.swing.JTextArea taDescripcion;
    // End of variables declaration//GEN-END:variables
}
