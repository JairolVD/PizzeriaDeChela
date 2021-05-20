/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriadechela;

import javax.swing.JOptionPane;
import pizzeriadechela.database.*;
import pizzeriadechela.database.data.*;


/**
 *
 * @author Anaiza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MysqlAction mysqlDb = new MysqlAction();
        mysqlDb.setUsername("root")
                .setContrasenia("")
                .setNombreBasedatos("pizzeriadechela");
        
        if (mysqlDb.getConexion() == null){
            JOptionPane.showMessageDialog(null, "No se pudo conectar a mysql.", "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
            return;
        }
        
        // TODO code application logic here
        PizzeriaJFrame pizz = new PizzeriaJFrame();
        pizz.initializate(mysqlDb)
            .setVisible(true);
    }
    
}
