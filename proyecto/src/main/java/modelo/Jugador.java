package modelo;

import excepcion.Excepcion;
import handler.Manager;
import java.util.ArrayList;
import java.util.Date;

public class Jugador {
    int idjugador;
    String nombre;
    String password;
    String alias;
    Date fechanacimiento;
    String email;
    Equipo equipo;
    ArrayList<Juego> juegos = new ArrayList<>();
    ArrayList<Oferta> ofertas = new ArrayList<>();
    ArrayList<Torneo> Torneos = new ArrayList<>();

    public Jugador(String nombre, String password, String alias, Date fechanacimiento, String email) throws Excepcion {
        this.nombre = nombre;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
        this.password = password;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoPassword);
        }
        this.alias = alias;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoAlias);
        }
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        if(email.length()<1||email.length()>50){
            throw new Excepcion(Excepcion.malFormatoEmail);
        }
        if(!Manager.emailValido(email)){
            throw new Excepcion(Excepcion.malFormatoEmail2);
        }
    }
    
    //Segundo constructor con el id para cuando lea de la bbdd
    public Jugador(int idjugador, String nombre, String password, String alias, Date fechanacimiento, String email) throws Excepcion {
        this.idjugador = idjugador;
        this.nombre = nombre;
        this.password = password;
        this.alias = alias;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
    }    

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public ArrayList<Torneo> getTorneos() {
        return Torneos;
    }

    public void setTorneos(ArrayList<Torneo> Torneos) {
        this.Torneos = Torneos;
    }
    
    
}
