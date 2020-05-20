package handler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
    public static Date SqlDateToDate(String sqlDate) throws ParseException{
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(sqlDate); 
        return date;
    }
    
    public static boolean emailValido(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            return true;
        }
        return false;
    }
    
    public static String generateRandomPassword() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
