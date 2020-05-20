package vista;

import api.JavaMailUtil;
import handler.Manager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main {
    //private static Login login;
    
    public static void main(String[] args){   
        //Conectamos con la base de datos y abrimos la pantalla del Login
        try{
            //JavaMailUtil.sendMail("gerardlloreteij@gmail.com");
            Manager.connectar();        
            Login login = new Login();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
