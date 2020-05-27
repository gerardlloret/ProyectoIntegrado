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
    //Metodo que dependiendo del tipo pasado comprueba las credenciales para el login
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
    //Metodo que devuelve true si un jugador o equipo tiene ese correo
    public boolean correoExist(String email)throws SQLException{
        String select = "select * from jugador where email='" + email + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(select);
        if(rs.next()){
            rs.close();
            st.close();
            return true;
        }
        select = "select * from equipo where email='" + email + "'";
        rs = st.executeQuery(select);
        if(rs.next()){
            rs.close();
            st.close();
            return true;
        }
        rs.close();
        st.close();
        return false;
    }
    //Metodo que devuelve true si ya existe un jugador con ese email
    public boolean jugadorExistEmail(String email)throws SQLException{
        String select = "select * from jugador where email='" + email + "'";
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
    //Metodo que devuelve true si ya existe un jugador con ese email
    public boolean equipoExistEmail(String email)throws SQLException{
        String select = "select * from equipo where email='" + email + "'";
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
    //Metodo que devuelve true si ya existe ese jugador ya tiene ese juego
    public boolean jugadorJuegoExist(int idjugador,int idjuego)throws SQLException{
        String select = "select * from jugador_juego where idjugador='" + idjugador + "' and idjuego='" + idjuego + "'";
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
    //Metodo que devuelve true si ya existe ese jugador ya ha dejado candidatura en esa oferta
    public boolean jugadorOfertaExist(int idjugador,int idoferta)throws SQLException{
        String select = "select * from jugador_oferta where idjugador='" + idjugador + "' and idoferta='" + idoferta + "'";
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
    //Metodo que devuelve true si ya existe una oferta con ese nombre para un mismo equipo
    public boolean nombreOfertaEquipoExist(int idequipo,String nombre)throws SQLException{
        String select = "select * from oferta where idequipo='" + idequipo + "' and nombre='" + nombre + "'";
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
            Pais p = returnPaisById(rs.getInt("idpais"));
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
    //Metodo que devuelve el Genero por su nombre
    public Genero returnGenero(String genero)throws SQLException, Excepcion{
        String query = "select * from genero where genero='" + genero + "'";
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
    //Metodo que devuelve el Genero por su id
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
    //Metodo que devuelve un juego pasado su id
    public Juego returnJuegoById(int idjuego)throws SQLException, Excepcion{
        String query = "select * from juego where idjuego='" + idjuego + "'";
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
            Juego j = returnJuegoById(rs.getInt("idjuego"));
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
            e.setDescripcion(rs.getString("descripcion"));
            e.setMiembros(rs.getInt("miembros"));
            e.setEmail(rs.getString("email"));
        }
        rs.close();
        st.close();
        return e;
    }
    //Metodo que devuelve un equipo pasado su id
    public Equipo returnEquipoById(int idequipo)throws SQLException, Excepcion, ParseException{
        String query = "select * from equipo where idequipo='" + idequipo + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Equipo e = new Equipo();      
        if (rs.next()) {
            e.setIdequipo(rs.getInt("idequipo"));
            e.setNombre(rs.getString("nombre"));
            e.setPassword(rs.getString("password"));
            e.setFecha(Manager.SqlDateToDate(rs.getString("fecha")));
            e.setPais(returnPaisById(rs.getInt("idpais")));
            e.setDescripcion(rs.getString("descripcion"));
            e.setMiembros(rs.getInt("miembros"));
            e.setEmail(rs.getString("email"));
        }
        rs.close();
        st.close();
        return e;
    }
    //Metodo que devuelve un arrayList con todos los equipos ordenados
    public ArrayList<Equipo> returnEquipos() throws SQLException, Excepcion, ParseException{
        String query = "select * from equipo order by nombre";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Equipo> equipos = new ArrayList<>();
        while (rs.next()) {
            Equipo e = returnEquipoById(rs.getInt("idequipo"));
            equipos.add(e);
        }
        rs.close();
        st.close();
        return equipos;
    }
    //Metodo que devuelve una oferta pasado su id
    public Oferta returnOfertaById(int idoferta)throws SQLException, Excepcion, ParseException{
        String query = "select * from oferta where idoferta='" + idoferta + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Oferta o = new Oferta();      
        if (rs.next()) {
            o.setIdoferta(rs.getInt("idoferta"));
            o.setEquipo(returnEquipoById(rs.getInt("idequipo")));
            o.setJuego(returnJuegoById(rs.getInt("idjuego")));
            o.setNombre(rs.getString("nombre"));
            o.setDescripcion(rs.getString("descripcion"));
            o.setCandidaturas(rs.getInt("candidaturas"));
            o.setVacantes(rs.getInt("vacantes"));
        }
        rs.close();
        st.close();
        return o;
    }
    //Metodo que devuelve una oferta pasado su nombre y el id del equipo
    public Oferta returnOfertaByNombreEquipoId(int idequipo, String nombre)throws SQLException, Excepcion, ParseException{
        String query = "select * from oferta where idequipo='" + idequipo + "' and nombre='" + nombre + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Oferta o = new Oferta();      
        if (rs.next()) {
            o = returnOfertaById(rs.getInt("idoferta"));
        }
        rs.close();
        st.close();
        return o;
    }
    //Metodo que devuelve un arrayList con todos las ofertas
    public ArrayList<Oferta> returnOfertas() throws SQLException, Excepcion, ParseException{
        String query = "select * from oferta";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Oferta> ofertas = new ArrayList<>();
        while (rs.next()) {
            Oferta o = returnOfertaById(rs.getInt("idoferta"));
            ofertas.add(o);
        }
        rs.close();
        st.close();
        return ofertas;
    }   
    //Metodo que devuelve una arrayList de ofertas filtranndo dependiendo de los valores pasados
    public ArrayList<Oferta> returnOfertasFiltradas(int idequipo, int idjuego) throws SQLException, Excepcion, ParseException{
        String query;
        if((idequipo!=-1) && (idjuego!=-1)){
            query = "select * from oferta where idequipo='" + idequipo + "' and idjuego='" + idjuego + "'";
        }
        else if((idequipo!=-1) && (idjuego==-1)){
            query = "select * from oferta where idequipo='" + idequipo + "'";
        }
        else if((idequipo==-1) && (idjuego!=-1)){
            query = "select * from oferta where idjuego='" + idjuego + "'";
        }else{
            query = "select * from oferta";
        }       
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Oferta> ofertas = new ArrayList<>();
        while (rs.next()) {
            Oferta o = returnOfertaById(rs.getInt("idoferta"));
            ofertas.add(o);
        }
        rs.close();
        st.close();
        return ofertas;
    }
    //Metodo que devuelve un jugador pasado su nombre
    public Jugador returnJugador(String alias)throws SQLException, Excepcion, ParseException{
        String query = "select * from jugador where alias='" + alias + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        Jugador j = new Jugador();      
        if (rs.next()) {
            j.setIdjugador(rs.getInt("idjugador"));
            j.setNombre(rs.getString("nombre"));
            j.setPassword(rs.getString("password"));
            j.setAlias(rs.getString("alias"));
            j.setFechanacimiento(Manager.SqlDateToDate(rs.getString("fechanacimiento")));
            j.setEmail(rs.getString("email"));
            j.setEquipo(returnEquipoById(rs.getInt("idequipo")));
            j.setJuegos(returnJuegosByJugadorId(rs.getInt("idjugador")));
            j.setOfertas(returnOfertasByJugadorId(rs.getInt("idjugador")));
        }
        rs.close();
        st.close();
        return j;
    }
    //Metodo que devuelve un arrayList con todos los jugadores
    public ArrayList<Jugador> returnJugadores() throws SQLException, Excepcion, ParseException{
        String query = "select * from jugador";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        while (rs.next()) {
            Jugador j = returnJugador(rs.getString("alias"));
            jugadores.add(j);
        }
        rs.close();
        st.close();
        return jugadores;
    }   
    //Metodo que devuelve un arrayList con todos los jugadores que juegan a un juego
    public ArrayList<Jugador> returnJugadoresByJuegoId(int idjuego) throws SQLException, Excepcion, ParseException{
        String query = "SELECT * FROM jugador INNER JOIN jugador_juego ON jugador.idjugador=jugador_juego.idjugador WHERE jugador_juego.idjuego='" + idjuego + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        while (rs.next()) {
            Jugador j = returnJugador(rs.getString("alias"));
            jugadores.add(j);
        }
        rs.close();
        st.close();
        return jugadores;
    }
    //Metodo que devuelve un arrayList con todos los jugadores que se han postulado en una oferta
    public ArrayList<Jugador> returnJugadoresByOfertaId(int idoferta) throws SQLException, Excepcion, ParseException{
        String query = "SELECT * FROM jugador INNER JOIN jugador_oferta ON jugador.idjugador=jugador_oferta.idjugador WHERE jugador_oferta.idoferta='" + idoferta + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        while (rs.next()) {
            Jugador j = returnJugador(rs.getString("alias"));
            jugadores.add(j);
        }
        rs.close();
        st.close();
        return jugadores;
    }
    //Metodo que devuelve un ArrayList de los juegos de un jugador pasando su id
    public ArrayList<Juego> returnJuegosByJugadorId(int idjugador)throws SQLException, Excepcion, ParseException{
        String query = "select * from jugador_juego where idjugador='" + idjugador + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Juego> juegos = new ArrayList<>();             
        while (rs.next()) {
            Juego j = returnJuegoById(rs.getInt("idjuego"));
            juegos.add(j);
        }
        rs.close();
        st.close();
        return juegos;
    }
    //Metodo que devuelve un ArrayList de las ofertas de un jugador pasando su id
    public ArrayList<Oferta> returnOfertasByJugadorId(int idjugador)throws SQLException, Excepcion, ParseException{
        String query = "select * from jugador_oferta where idjugador='" + idjugador + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Oferta> ofertas = new ArrayList<>();             
        while (rs.next()) {
            Oferta o = returnOfertaById(rs.getInt("idoferta"));
            ofertas.add(o);
        }
        rs.close();
        st.close();
        return ofertas;
    }
    //Metodo que devuelve un ArrayList de los juegos de un jugador pasando su id
    public ArrayList<Juego> returnJuegosByGeneroId(int idgenero)throws SQLException, Excepcion, ParseException{
        String query = "select * from juego where idgenero='" + idgenero + "'";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Juego> juegos = new ArrayList<>();             
        while (rs.next()) {
            Juego j = returnJuegoById(rs.getInt("idjuego"));
            juegos.add(j);
        }
        rs.close();
        st.close();
        return juegos;
    }
    //Metodo que devuelve un arrayList con todos los generos ordenados
    public ArrayList<Genero> returnGeneros() throws SQLException, Excepcion{
        String query = "select * from genero order by genero";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Genero> generos = new ArrayList<>();
        while (rs.next()) {
            Genero g = returnGeneroById(rs.getInt("idgenero"));
            generos.add(g);
        }
        rs.close();
        st.close();
        return generos;
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
    //Metodo para insertar una oferta
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
    //Metodo para insertar un juego de un jugador
    public void insertJugadorJuego(int idjugador, int idjuego) throws SQLException{
        String insert = "insert into jugador_juego values (?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setInt(1, idjugador);
        ps.setInt(2, idjuego);
        ps.executeUpdate();
        ps.close();
    }
    //Metodo para insertar una oferta en un jugador
    public void insertJugadorOferta(int idjugador, int idoferta) throws SQLException{
        String insert = "insert into jugador_oferta values (?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setInt(1, idjugador);
        ps.setInt(2, idoferta);
        ps.executeUpdate();
        ps.close();
    }
    //BLOQUE 4: UPDATES
    //Metodo para modificar el password de un jugador
    public void updateJugadorPassword(String password, String email) throws SQLException {
        String update = "update jugador set password=? where email=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setString(1, password);
        ps.setString(2, email);
        ps.executeUpdate();
        ps.close();        
    }
    //Metodo para modificar el password de un equipo
    public void updateEquipoPassword(String password, String email) throws SQLException {
        String update = "update equipo set password=? where email=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setString(1, password);
        ps.setString(2, email);
        ps.executeUpdate();
        ps.close();        
    }
    //Metodo para modificar un jugador
    public void updateJugador(Jugador j) throws SQLException {
        String update = "update jugador set nombre=?,password=?,alias=?,fechanacimiento=?,email=? where idjugador=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setString(1, j.getNombre());
        ps.setString(2, j.getPassword());
        ps.setString(3, j.getAlias());
        ps.setString(4, Manager.DateToSqlDate(j.getFechanacimiento()));
        ps.setString(5, j.getEmail());
        ps.setInt(6, j.getIdjugador());
        ps.executeUpdate();
        ps.close();        
    }
    //Metodo para modificar un equipo
    public void updateEquipo(Equipo e) throws SQLException {
        String update = "update equipo set nombre=?,password=?,fecha=?,idpais=?,descripcion=?,email=? where idequipo=?";
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setString(1, e.getNombre());
        ps.setString(2, e.getPassword());
        ps.setString(3, Manager.DateToSqlDate(e.getFecha()));
        ps.setInt(4, e.getPais().getIdpais());
        ps.setString(5, e.getDescripcion());
        ps.setString(6, e.getEmail());
        ps.setInt(7, e.getIdequipo());
        ps.executeUpdate();
        ps.close();        
    }
    //BLOQUE 5: DELETES
    //Metodo para borrar un juego de un jugador
    public void deleteJuegoJugador(int idjugador, int idjuego ) throws SQLException, Excepcion {
        String delete = "delete from jugador_juego where idjugador='" + idjugador + "' and idjuego='" + idjuego + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }
    //Metodo para borrar una oferta de un jugador
    public void deleteOfertaJugador(int idjugador, int idoferta ) throws SQLException, Excepcion {
        String delete = "delete from jugador_oferta where idjugador='" + idjugador + "' and idoferta='" + idoferta + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }
    //Metodo para borrar una oferta
    public void deleteOferta(int idoferta) throws SQLException, Excepcion {
        String delete = "delete from oferta where idoferta='" + idoferta + "'";
        Statement st = conexion.createStatement();
        st.executeUpdate(delete);
        st.close();
    }
    
}
