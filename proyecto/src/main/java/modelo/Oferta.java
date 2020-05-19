package modelo;

import excepcion.Excepcion;

public class Oferta {
    int idoferta;
    Equipo equipo;
    Juego juego;
    String nombre;
    String descripcion;
    int candidaturas;
    int vacantes;

    public Oferta(Equipo equipo, Juego juego, String nombre, String descripcion, int vacantes) throws Excepcion {
        this.equipo = equipo;
        this.juego = juego;
        this.nombre = nombre;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
        this.descripcion = descripcion;
        if(descripcion.length()<1||descripcion.length()>200){
            throw new Excepcion(Excepcion.malFormatoDescripcion);
        }
        this.candidaturas = 0;
        this.vacantes = vacantes;
    }

    public Oferta() {}

    public int getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(int idoferta) {
        this.idoferta = idoferta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCandidaturas() {
        return candidaturas;
    }

    public void setCandidaturas(int candidaturas) {
        this.candidaturas = candidaturas;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }
    
   
    
    
    
    
}
