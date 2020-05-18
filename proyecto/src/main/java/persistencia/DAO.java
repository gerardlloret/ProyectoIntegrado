package persistencia;

import excepcion.Excepcion;
import handler.Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Pais;


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
    //Metodo que devuelve true si ya existe un jugador con ese nombre
    public boolean jugadorExist(String alias)throws SQLException{
        String select = "select * from jugador where alias='" + alias + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if(rs.next()){
            rs.close();
            st.close();
            return true;
        }
        rs.close();
        st.close();
        return false;
    }
    //Metodo que devuelve true si ya existe un equipo o usuario con ese nombre
    public boolean equipoExist(String nombre)throws SQLException{
        String select = "select * from equipo where nombre='" + nombre + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if(rs.next()){
            rs.close();
            st.close();
            return true;
        }
        rs.close();
        st.close();
        return false;
    }
    //BLOQUE 2: RETURNS
    //Metodo que devuelve un pais pasado su nombre
    public Pais returnPais(String nombre)throws SQLException, Excepcion{
        String query = "select * from pais where nombre='" + nombre + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Pais p = new Pais();      
        if (rs.next()) {
            p.setIdpais(rs.getInt("idpais"));
            p.setNombre(rs.getString("nombre"));
        }
        rs.close();
        st.close();
        return p;
    }
    
    //Metodo que devuelve un arrayList con todos los paises
    public ArrayList<Pais> returnPaises() throws SQLException, Excepcion{
        String query = "select * from pais order by nombre";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Pais> paises = new ArrayList<>();
        while (rs.next()) {
            Pais p = new Pais();
            p.setIdpais(rs.getInt("idpais"));
            p.setNombre(rs.getString("nombre"));
            paises.add(p);
        }
        rs.close();
        st.close();
        return paises;
    }
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
    //Metodo para insertar un equipo
    public void insertEquipo(Equipo e) throws SQLException{
        String insert = "insert into equipo values (null, ?, ?, ?, ?, null, null, null, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, e.getNombre());
        ps.setString(2, e.getPassword());
        ps.setString(3, Manager.DateToSqlDate(e.getFecha()));
        ps.setInt(4, e.getPais().getIdpais());
        ps.setString(5, e.getEmail());
        ps.executeUpdate();
        ps.close();
    }
    //BLOQUE 4: UPDATES
    //BLOQUE 5: DELETES
    
}
