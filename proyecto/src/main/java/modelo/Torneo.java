package modelo;

import excepcion.Excepcion;
import java.util.Date;

public class Torneo {
    int idtorneo;
    String nombre;
    Date fecha;
    Pais pais;

    public Torneo(int idtorneo, String nombre, Date fecha, Pais pais) throws Excepcion {
        this.idtorneo = idtorneo;
        this.nombre = nombre;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
        this.fecha = fecha;
        this.pais = pais;
    }

    public int getIdtorneo() {
        return idtorneo;
    }

    public void setIdtorneo(int idtorneo) {
        this.idtorneo = idtorneo;
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
    
    
    
}
