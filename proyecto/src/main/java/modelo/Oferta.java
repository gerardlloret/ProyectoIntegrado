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

    //Segundo constructor con el id para cuando lea de la bbdd
    public Oferta(int idoferta, Equipo equipo, Juego juego, String nombre, String descripcion, int candidaturas, int vacantes) {
        this.idoferta = idoferta;
        this.equipo = equipo;
        this.juego = juego;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.candidaturas = candidaturas;
        this.vacantes = vacantes;
    }
    
    
    
    
}
