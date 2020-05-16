package modelo;

import excepcion.Excepcion;
import handler.Manager;
import java.util.ArrayList;
import java.util.Date;

public class Equipo {
    int idequipo;
    String nombre;
    Date fecha;
    Pais pais;
    int vacantes;
    String descripcion;
    int miembros;
    String email;
    Cuota cuota;
    ArrayList<Juego> juegos = new ArrayList<>();

    public Equipo(String nombre, Date fecha, Pais pais, String email) throws Excepcion {
        this.nombre = nombre;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
        this.fecha = fecha;
        this.pais = pais;
        this.email = email;
        if(email.length()<1||email.length()>50){
            throw new Excepcion(Excepcion.malFormatoEmail);
        }
        if(!Manager.emailValido(email)){
            throw new Excepcion(Excepcion.malFormatoEmail2);
        }
    }

    //Segundo constructor con el id para cuando lea de la bbdd
    public Equipo(int idequipo, String nombre, Date fecha, Pais pais, String email) throws Excepcion {
        this.idequipo = idequipo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.pais = pais;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMiembros() {
        return miembros;
    }

    public void setMiembros(int miembros) {
        this.miembros = miembros;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }
      
}
