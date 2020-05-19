package modelo;

public class Juego {
    int idjuego;
    String nombre;
    Genero genero;
    Pegi pegi;

    public Juego(int idjuego, String nombre, Genero genero, Pegi pegi) {
        this.idjuego = idjuego;
        this.nombre = nombre;
        this.genero = genero;
        this.pegi = pegi;
    }
    
    public Juego(){}

    public int getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Pegi getPegi() {
        return pegi;
    }

    public void setPegi(Pegi pegi) {
        this.pegi = pegi;
    }
    
}
