package modelo;

import excepcion.Excepcion;

public class Pais {
    int idpais;
    String nombre;

    public Pais(int idpais, String nombre) throws Excepcion {
        this.idpais = idpais;
        this.nombre = nombre;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
    }
    //Constructor vacio para el dao
    public Pais(){}

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
