package modelo;

import excepcion.Excepcion;

public class Pegi {
    int idpegi;
    String pegi;

    public Pegi(int idpegi, String pegi) throws Excepcion {
        this.idpegi = idpegi;
        this.pegi = pegi;
        if(pegi.length()<1||pegi.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
    }        
    
    public Pegi(){}

    public int getIdpegi() {
        return idpegi;
    }

    public void setIdpegi(int idpegi) {
        this.idpegi = idpegi;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }
    
    
}
