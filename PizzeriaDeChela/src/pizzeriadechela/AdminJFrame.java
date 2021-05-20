/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriadechela;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pizzeriadechela.componentes.Utilidad;
import pizzeriadechela.database.MysqlAction;
import pizzeriadechela.database.data.*;

/**
 *
 * @author Anaiza
 */
public class AdminJFrame extends javax.swing.JFrame {

    private javax.swing.JFrame _principal;
    private MysqlAction _mysqlAction;
    
    private ArrayList<CuentaDto> _trabajadores;
    private DefaultListModel _modeloLista;
    
    private AdminTrabajadoresJFrame _trabajadorFrame;
    private AdminClientesJFrame _clienteFrame;
    
    private Boolean _cargado;
    
    void enableCliente(Boolean valor){
        _registrarCliente.setEnabled(valor);
    }
    
    void enableTrabajdor(Boolean valor){
        _buscarTB.setEnabled(valor);
        _registrarTB.setEnabled(valor);
        _guardarTB.setEnabled(valor);
        _eliminarTB.setEnabled(valor);
    }
    
    /**
     * Creates new form AdminJFrame
     */
    public AdminJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        _modeloLista = new DefaultListModel();
        _cargado = false;
    }
    
    
    public void initializate(MysqlAction mysqlAction, javax.swing.JFrame ventanaPrincipal){
        _mysqlAction = mysqlAction;
        _principal = ventanaPrincipal;
    }
    
    int getIndexCuenta(CuentaDto dto){
        for (int index = 0; index < _modeloLista.size(); index++){
            CuentaDto cuenta = (CuentaDto)_modeloLista.get(index);
            if (cuenta.toString().equals(dto.toString()))
                return index;
        }
        return -1;
    }
    
    CuentaDto getCuentaByIndex(int index){
        if (index < 0)
            return null;
        
        return (CuentaDto)_modeloLista.get(index);
    }
    
    void addElement(Object o){
        _modeloLista.addElement(o);
        _trabajadoresJList.setModel(_modeloLista);
        _trabajadoresJList.updateUI();
    }
    
    void updateElement(Object o){
        int index = getIndexCuenta((CuentaDto)o);
        if (index < 0)
            return;
        
        _modeloLista.setElementAt(o, index);
        _trabajadoresJList.setModel(_modeloLista);
        _trabajadoresJList.updateUI();
    }
    
    void removeElement(Object o){
        int index = getIndexCuenta((CuentaDto)o);
        if (index < 0)
            return;
        
        _modeloLista.removeElementAt(index);
        _trabajadoresJList.setModel(_modeloLista);
        _trabajadoresJList.updateUI();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        _trabajadoresJList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        _menuToolBar = new javax.swing.JMenu();
        _trabajadoresToolBar = new javax.swing.JMenu();
        _buscarTB = new javax.swing.JMenu();
        _registrarTB = new javax.swing.JMenu();
        _guardarTB = new javax.swing.JMenu();
        _eliminarTB = new javax.swing.JMenu();
        _clientesToolBar1 = new javax.swing.JMenu();
        _registrarCliente = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Lista de trabajadores:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        _trabajadoresJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(_trabajadoresJList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 450, 410));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/0.1.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 480));

        _menuToolBar.setLabel("Menu");

        _trabajadoresToolBar.setLabel("Trabajadores");
        _trabajadoresToolBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _trabajadoresToolBarMouseClicked(evt);
            }
        });

        _buscarTB.setText("Buscar");
        _buscarTB.setEnabled(false);
        _buscarTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _buscarTBMouseClicked(evt);
            }
        });
        _trabajadoresToolBar.add(_buscarTB);

        _registrarTB.setActionCommand("Registrar");
        _registrarTB.setEnabled(false);
        _registrarTB.setLabel("Registrar");
        _registrarTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _registrarTBMouseClicked(evt);
            }
        });
        _trabajadoresToolBar.add(_registrarTB);

        _guardarTB.setText("Guardar");
        _guardarTB.setEnabled(false);
        _guardarTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _guardarTBMouseClicked(evt);
            }
        });
        _trabajadoresToolBar.add(_guardarTB);

        _eliminarTB.setText("Elliminar");
        _eliminarTB.setEnabled(false);
        _eliminarTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _eliminarTBMouseClicked(evt);
            }
        });
        _trabajadoresToolBar.add(_eliminarTB);

        _menuToolBar.add(_trabajadoresToolBar);

        _clientesToolBar1.setText("Clientes");
        _clientesToolBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _clientesToolBar1MouseClicked(evt);
            }
        });

        _registrarCliente.setText("Registar");
        _registrarCliente.setEnabled(false);
        _registrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                _registrarClienteMousePressed(evt);
            }
        });
        _clientesToolBar1.add(_registrarCliente);

        _menuToolBar.add(_clientesToolBar1);

        jMenuBar1.add(_menuToolBar);
        _menuToolBar.getAccessibleContext().setAccessibleName("_menuToolBar");

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if (!_cargado){
            _trabajadores = _mysqlAction.getTrabajadores();
            for (int index = 0; index < _trabajadores.size(); index++){
                _modeloLista.addElement(_trabajadores.get(index));
            }
            _trabajadoresJList.setModel(_modeloLista);
            
            _cargado = true;
        }
    }//GEN-LAST:event_formWindowActivated

    private void _trabajadoresToolBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__trabajadoresToolBarMouseClicked
        // TODO add your handling code here:
        
        if (_trabajadorFrame != null){
            _trabajadorFrame.setFocusable(true);
            return;
        }
        
        _trabajadorFrame = new AdminTrabajadoresJFrame(){
            @Override
            public void dispose(){
                _trabajadorFrame = null;
                enableTrabajdor(false);
                super.dispose();
            }
        };
        _trabajadorFrame.initializate(this);
        _trabajadorFrame.setVisible(true);
        enableTrabajdor(true);
    }//GEN-LAST:event__trabajadoresToolBarMouseClicked

    private void _clientesToolBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__clientesToolBar1MouseClicked
        // TODO add your handling code here:

        if (_clienteFrame != null){
            _clienteFrame.setFocusable(true);
            return;
        }
        
        _clienteFrame = new AdminClientesJFrame(){
            @Override
            public void dispose(){
                _clienteFrame = null;
                enableCliente(false);
                super.dispose();
            }
        };
        _clienteFrame.setVisible(true);
        enableCliente(true);
    }//GEN-LAST:event__clientesToolBar1MouseClicked

    private void _buscarTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__buscarTBMouseClicked
        // TODO add your handling code here:
        
        CuentaDto cuentaList = getCuentaByIndex(_trabajadoresJList.getSelectedIndex());
        if (cuentaList != null){
            _trabajadorFrame.actualizarTrabajdor(cuentaList);
            return;
        }
        
        String dni = _trabajadorFrame.getDni();
        if (!Utilidad.validarDNI(dni)){
            JOptionPane.showMessageDialog(null, "El DNI ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CuentaDto cuenta = _mysqlAction.getCuenta(dni);
        if (cuenta == null){
            JOptionPane.showMessageDialog(null, "No encontró al trabajador con el dni ingresado.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        _trabajadorFrame.actualizarTrabajdor(cuenta);
    }//GEN-LAST:event__buscarTBMouseClicked

    private void _registrarTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__registrarTBMouseClicked
        // TODO add your handling code here:
        String dni = _trabajadorFrame.getDni();
        if (!Utilidad.validarDNI(dni)){
            JOptionPane.showMessageDialog(null, "El DNI ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        CuentaDto cuenta = _mysqlAction.getCuenta(dni);
        if (cuenta != null){
            JOptionPane.showMessageDialog(null, "Ya existe un trabajador registrado con el DNI.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarNombres(_trabajadorFrame.getNombres())){
            JOptionPane.showMessageDialog(null, "El Nombre ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarApellido(_trabajadorFrame.getApellidoP())){
            JOptionPane.showMessageDialog(null, "El Apellido Paterno ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarApellido(_trabajadorFrame.getApellidoM())){
            JOptionPane.showMessageDialog(null, "El Apellido Materno ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarDistrito(_trabajadorFrame.getDistrito())){
            JOptionPane.showMessageDialog(null, "El Distrito ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarDireccion(_trabajadorFrame.getDireccion())){
            JOptionPane.showMessageDialog(null, "El Distrito ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarCelular(_trabajadorFrame.getCelular())){
            JOptionPane.showMessageDialog(null, "El Numero de celular ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarContrasenia(_trabajadorFrame.getContrasena())){
            JOptionPane.showMessageDialog(null, "La contraseña ingresado no es válida.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarCargoTrabajador(_trabajadorFrame.getCargo())){
            JOptionPane.showMessageDialog(null, "El Cargo ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        
        cuenta = new CuentaDto();
        cuenta.setDni(dni);
        cuenta.setContrasenia(_trabajadorFrame.getContrasena());
        cuenta.setCargo(Utilidad.toByte(_trabajadorFrame.getCargo()));
        cuenta.setPerfil(new CuentaPerfilDto());
        cuenta.getPerfil().setDniC(dni);
        cuenta.getPerfil().setNombre(_trabajadorFrame.getNombres());
        cuenta.getPerfil().setApellido_paterno(_trabajadorFrame.getApellidoP());
        cuenta.getPerfil().setApellido_materno(_trabajadorFrame.getApellidoM());
        cuenta.getPerfil().setDistrito(_trabajadorFrame.getDistrito());
        cuenta.getPerfil().setDireccion(_trabajadorFrame.getDireccion());
        cuenta.getPerfil().setCelular(_trabajadorFrame.getCelular());
        
        
        if (_mysqlAction.addCuenta(cuenta)){
            JOptionPane.showMessageDialog(null, "El trabajador fue registrado correctamente.", "Ocurrio un error", JOptionPane.INFORMATION_MESSAGE);
            addElement(cuenta);
            _trabajadorFrame.limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo registrar al trabajador.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event__registrarTBMouseClicked

    private void _guardarTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__guardarTBMouseClicked
        // TODO add your handling code here:
        String dni = _trabajadorFrame.getDni();
        if (!Utilidad.validarDNI(dni)){
            JOptionPane.showMessageDialog(null, "El DNI ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CuentaDto cuenta = _mysqlAction.getCuenta(dni);
        if (cuenta == null){
            JOptionPane.showMessageDialog(null, "No encontró al trabajador con el dni ingresado.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarNombres(_trabajadorFrame.getNombres())){
            JOptionPane.showMessageDialog(null, "El Nombre ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarApellido(_trabajadorFrame.getApellidoP())){
            JOptionPane.showMessageDialog(null, "El Apellido Paterno ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarApellido(_trabajadorFrame.getApellidoM())){
            JOptionPane.showMessageDialog(null, "El Apellido Materno ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarDistrito(_trabajadorFrame.getDistrito())){
            JOptionPane.showMessageDialog(null, "El Distrito ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarDireccion(_trabajadorFrame.getDireccion())){
            JOptionPane.showMessageDialog(null, "El Distrito ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarCelular(_trabajadorFrame.getCelular())){
            JOptionPane.showMessageDialog(null, "El Numero de celular ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarContrasenia(_trabajadorFrame.getContrasena())){
            JOptionPane.showMessageDialog(null, "La contraseña ingresado no es válida.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarCargoTrabajador(_trabajadorFrame.getCargo())){
            JOptionPane.showMessageDialog(null, "El Cargo ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        cuenta.setContrasenia(_trabajadorFrame.getContrasena());
        cuenta.setCargo(Utilidad.toByte(_trabajadorFrame.getCargo()));
        cuenta.getPerfil().setDniC(dni);
        cuenta.getPerfil().setNombre(_trabajadorFrame.getNombres());
        cuenta.getPerfil().setApellido_paterno(_trabajadorFrame.getApellidoP());
        cuenta.getPerfil().setApellido_materno(_trabajadorFrame.getApellidoM());
        cuenta.getPerfil().setDistrito(_trabajadorFrame.getDistrito());
        cuenta.getPerfil().setDireccion(_trabajadorFrame.getDireccion());
        cuenta.getPerfil().setCelular(_trabajadorFrame.getCelular());
        
        if (_mysqlAction.updateCuenta(cuenta)){
            JOptionPane.showMessageDialog(null, "Los datos del trabajdor fueron guardados correctamente.", "Ocurrio un error", JOptionPane.INFORMATION_MESSAGE);
            updateElement(cuenta);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos del trabajador.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event__guardarTBMouseClicked

    private void _eliminarTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__eliminarTBMouseClicked
        // TODO add your handling code here:
        
        CuentaDto cuentaList = getCuentaByIndex(_trabajadoresJList.getSelectedIndex());
        if (cuentaList != null){
            JOptionPane.showMessageDialog(null, "El trabajdor fue eliminado", "Ocurrio un error", JOptionPane.INFORMATION_MESSAGE);
            removeElement(cuentaList);
            _trabajadorFrame.limpiar();
            return;
        }
        
        String dni = _trabajadorFrame.getDni();
        if (!Utilidad.validarDNI(dni)){
            JOptionPane.showMessageDialog(null, "El DNI ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        CuentaDto cuenta = _mysqlAction.getCuenta(dni);
        if (cuenta == null){
            JOptionPane.showMessageDialog(null, "No encontró al trabajador con el dni ingresado.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (_mysqlAction.deleteCuenta(cuenta)){
            JOptionPane.showMessageDialog(null, "El trabajdor fue eliminado", "Ocurrio un error", JOptionPane.INFORMATION_MESSAGE);
            removeElement(cuenta);
            _trabajadorFrame.limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo eliminar al trabajador.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event__eliminarTBMouseClicked

    private void _registrarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__registrarClienteMousePressed
        // TODO add your handling code here:
        
        if (!Utilidad.validarDNI(_clienteFrame.getDni())){
            JOptionPane.showMessageDialog(null, "El DNI ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        CuentaDto cuenta = _mysqlAction.getCuenta(_clienteFrame.getDni());
        if (cuenta != null){
            JOptionPane.showMessageDialog(null, "Ya existe un trabajador registrado con el DNI.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarNombres(_clienteFrame.getNombres())){
            JOptionPane.showMessageDialog(null, "El Nombre ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarApellido(_clienteFrame.getApellidoP())){
            JOptionPane.showMessageDialog(null, "El Apellido Paterno ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarApellido(_clienteFrame.getApellidoM())){
            JOptionPane.showMessageDialog(null, "El Apellido Materno ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarDistrito(_clienteFrame.getDistrito())){
            JOptionPane.showMessageDialog(null, "El Distrito ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarDireccion(_clienteFrame.getDireccion())){
            JOptionPane.showMessageDialog(null, "El Distrito ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarCelular(_clienteFrame.getCelular())){
            JOptionPane.showMessageDialog(null, "El Numero de celular ingresado no es válido.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!Utilidad.validarContrasenia(_clienteFrame.getContrasena())){
            JOptionPane.showMessageDialog(null, "La contraseña ingresado no es válida.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        
        cuenta = new CuentaDto();
        cuenta.setDni(_clienteFrame.getDni());
        cuenta.setContrasenia(_clienteFrame.getContrasena());
        cuenta.setCargo((byte)0);
        cuenta.setPerfil(new CuentaPerfilDto());
        cuenta.getPerfil().setDniC(_clienteFrame.getDni());
        cuenta.getPerfil().setNombre(_clienteFrame.getNombres());
        cuenta.getPerfil().setApellido_paterno(_clienteFrame.getApellidoP());
        cuenta.getPerfil().setApellido_materno(_clienteFrame.getApellidoM());
        cuenta.getPerfil().setDistrito(_clienteFrame.getDistrito());
        cuenta.getPerfil().setDireccion(_clienteFrame.getDireccion());
        cuenta.getPerfil().setCelular(_clienteFrame.getCelular());
        
        
        if (_mysqlAction.addCuenta(cuenta)){
            JOptionPane.showMessageDialog(null, "El cliente fue registrado correctamente.", "Ocurrio un error", JOptionPane.INFORMATION_MESSAGE);
            _clienteFrame.limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo registrar al cliente.", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event__registrarClienteMousePressed

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
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu _buscarTB;
    private javax.swing.JMenu _clientesToolBar1;
    private javax.swing.JMenu _eliminarTB;
    private javax.swing.JMenu _guardarTB;
    private javax.swing.JMenu _menuToolBar;
    private javax.swing.JMenu _registrarCliente;
    private javax.swing.JMenu _registrarTB;
    private javax.swing.JList _trabajadoresJList;
    private javax.swing.JMenu _trabajadoresToolBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
