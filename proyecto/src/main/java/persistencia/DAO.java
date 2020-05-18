package persistencia;

import handler.Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jugador;


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
    //Metodo para insertar un jugador
    public void insertJugador(Jugador j) throws SQLException{
        String insert = "insert into jugador values (null, ?, ?, ?, ?, ?, null);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, j.getNombre());
        ps.setString(2, j.getPassword());
        ps.setString(3, j.getAlias());
        ps.setString(4, Manager.DateToSqlDate(j.getFechanacimiento()));
        ps.setString(5, j.getEmail());
        ps.executeUpdate();
        ps.close();
    }
    //BLOQUE 4: UPDATES
    //BLOQUE 5: DELETES
    
}
