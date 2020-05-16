package handler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import persistencia.DAO;


public class Manager {
    public static DAO bbdd;
    private static String usuario;
    
    //Set usuario logueado
    public static void setUsuario(String loginUser){
        usuario = loginUser;
    }
    
    //Get usuario logueado
    public static String getUsuario(){
        return usuario;
    }
    
    //Metodo para crear la instancia de la clase DAO y conectar
    public static void connectar() throws SQLException{
            bbdd = new DAO();
            bbdd.conectar();   
    }
    
    //Metodo para desconectar
    public static void desconectar() throws SQLException{
            bbdd.desconectar();
    }
       
    //Recibe un date y devuelve un String con el formato HH:mm:ss
    public static String DateToTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(date);
        return time;
    } 
    
    //Recibe un date y devuelve un String con el formato YYYY-MM-dd
    public static String DateToSqlDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String sqlDate = sdf.format(date);
        return sqlDate;
    }
}