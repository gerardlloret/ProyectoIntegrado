package modelo;

import excepcion.Excepcion;
import java.util.Date;

public class Cuota {
    String nombre;
    double precio;
    int renovacion;
    Date fechainicio;
    Date fechafin;

    public Cuota(String nombre, double precio, int renovacion, Date fechainicio, Date fechafin) throws Excepcion {
        this.nombre = nombre;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
        this.precio = precio;
        if(precio<1||precio>999){
            throw new Excepcion(Excepcion.malFormatoPrecio);
        }
        this.renovacion = renovacion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getRenovacion() {
        return renovacion;
    }

    public void setRenovacion(int renovacion) {
        this.renovacion = renovacion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
    
}
