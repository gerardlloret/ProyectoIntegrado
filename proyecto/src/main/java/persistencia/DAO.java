
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAO {
    Connection conexion;
    //Metodo para conectar con la base de datos
    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String pass = "";
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo para desconectar de la base de datos
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
    //He dividido los metodos de esta clase en 5 bloques, EXIST, RETURNS, INSERTS, UPDATES y DELETES
    
    //BLOQUE 1: EXISTS
    //BLOQUE 2: RETURNS
    //BLOQUE 3: INSERTS
    //BLOQUE 4: UPDATES
    //BLOQUE 5: DELETES
    
}
