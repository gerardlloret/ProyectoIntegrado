package modelo;

import excepcion.Excepcion;

public class Genero {
    int idgenero;
    String genero;

    public Genero(int idgenero, String genero) throws Excepcion {
        this.idgenero = idgenero;
        this.genero = genero;
        if(genero.length()<1||genero.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
