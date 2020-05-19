package persistencia;

import excepcion.Excepcion;
import handler.Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipo;
import modelo.Genero;
import modelo.Juego;
import modelo.Jugador;
import modelo.Oferta;
import modelo.Pais;
import modelo.Pegi;


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
    public boolean login(String nombre, String tipo, String password)throws SQLException{
        String select = "";
        if(tipo.equalsIgnoreCase("jugador")){
            select = "select * from jugador where alias='" + nombre + "' and password ='" + password + "'";
        }else if(tipo.equalsIgnoreCase("equipo")){
            select = "select * from equipo where nombre='" + nombre + "' and password ='" + password + "'";
        }
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
    //Metodo que devuelve un pais pasado su id
    public Pais returnPaisById(int idpais)throws SQLException, Excepcion{
        String query = "select * from pais where idpais='" + idpais + "'";
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
    //Metodo que devuelve un arrayList con todos los paises ordenados
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
    //Metodo que devuelve el Pegi por su id
    public Pegi returnPegiById(int idpegi)throws SQLException, Excepcion{
        String query = "select * from pegi where idpegi='" + idpegi + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Pegi p = new Pegi();      
        if (rs.next()) {
            p.setIdpegi(rs.getInt("idpegi"));
            p.setPegi(rs.getString("pegi"));
        }
        rs.close();
        st.close();
        return p;
    }
    //Metodo que devuelve el Pegi por su id
    public Genero returnGeneroById(int idgenero)throws SQLException, Excepcion{
        String query = "select * from genero where idgenero='" + idgenero + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Genero g = new Genero();      
        if (rs.next()) {
            g.setIdgenero(rs.getInt("idgenero"));
            g.setGenero(rs.getString("genero"));
        }
        rs.close();
        st.close();
        return g;
    }
    //Metodo que devuelve un juego pasado su nombre
    public Juego returnJuego(String nombre)throws SQLException, Excepcion{
        String query = "select * from juego where nombre='" + nombre + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Juego j = new Juego();      
        if (rs.next()) {
            j.setIdjuego(rs.getInt("idjuego"));
            j.setNombre(rs.getString("nombre"));
            j.setGenero(returnGeneroById(rs.getInt("idgenero")));
            j.setPegi(returnPegiById(rs.getInt("idpegi")));
        }
        rs.close();
        st.close();
        return j;
    }  
    //Metodo que devuelve un arrayList con todos los juegos ordenados
    public ArrayList<Juego> returnJuegos() throws SQLException, Excepcion{
        String query = "select * from juego order by nombre";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Juego> juegos = new ArrayList<>();
        while (rs.next()) {
            Juego j = new Juego();
            j.setIdjuego(rs.getInt("idjuego"));
            j.setNombre(rs.getString("nombre"));
            j.setGenero(returnGeneroById(rs.getInt("idgenero")));
            j.setPegi(returnPegiById(rs.getInt("idpegi")));
            juegos.add(j);
        }
        rs.close();
        st.close();
        return juegos;
    }
    //Metodo que devuelve un equipo pasado su nombre
    public Equipo returnEquipo(String nombre)throws SQLException, Excepcion, ParseException{
        String query = "select * from equipo where nombre='" + nombre + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Equipo e = new Equipo();      
        if (rs.next()) {
            e.setIdequipo(rs.getInt("idequipo"));
            e.setNombre(rs.getString("nombre"));
            e.setPassword(rs.getString("password"));
            e.setFecha(Manager.SqlDateToDate(rs.getString("fecha")));
            e.setPais(returnPaisById(rs.getInt("idpais")));
            e.setEmail(rs.getString("email"));
        }
        rs.close();
        st.close();
        return e;
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
    //Metodo para insertar un equipo
    public void insertOferta(Oferta o) throws SQLException{
        String insert = "insert into oferta values (null, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setInt(1, o.getEquipo().getIdequipo());
        ps.setInt(2, o.getJuego().getIdjuego());
        ps.setString(3, o.getNombre());
        ps.setString(4, o.getDescripcion());
        ps.setInt(5, o.getCandidaturas());
        ps.setInt(6, o.getVacantes());
        ps.executeUpdate();
        ps.close();
    }
    //BLOQUE 4: UPDATES
    //BLOQUE 5: DELETES
    
}
