package modelo;

import excepcion.Excepcion;
import handler.Manager;
import java.util.Date;

public class Equipo {
    String nombre;
    Date fecha;
    String ciudad;
    int vacantes;
    String descripcion;
    int miembros;
    String email;
    Cuota cuota;

    public Equipo(String nombre, Date fecha, String ciudad, String email) throws Excepcion {
        this.nombre = nombre;
        if(nombre.length()<1||nombre.length()>20){
            throw new Excepcion(Excepcion.malFormatoNombre);
        }
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.email = email;
        if(email.length()<1||email.length()>50){
            throw new Excepcion(Excepcion.malFormatoEmail);
        }
        if(!Manager.emailValido(email)){
            throw new Excepcion(Excepcion.malFormatoEmail2);
        }
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
    
    
}
