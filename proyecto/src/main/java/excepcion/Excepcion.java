package excepcion;

//Clase para mostrar nuestras excepciones
public class Excepcion extends Exception {
    private int error = 0;
    //Declaramos estas variables para que al momento de lanzar el error sea mucho mas intuitivo
    public static final int malFormatoNombre = 1;
    public static final int malFormatoPrecio = 2;
    public static final int malFormatoEmail = 3;
    public static final int malFormatoEmail2 = 4;
    public static final int malFormatoPassword = 5;
    public static final int malFormatoAlias = 6;
    public static final int malFormatoDescripcion = 7;
    /*public static final int noHayNingunRegistro = 8;
    public static final int noHayNingunRegistroUsuario = 9;
    public static final int noHayNingunaActividadUsuario = 10;
    public static final int noHayNingunRecordEseDia = 11;*/
        
    public Excepcion(int error) {
        super();
        this.error = error;
    }

    @Override
    public String getMessage() {
        switch(error){
            case 1:
                return "El nombre debe tener de 1 a 20 caracteres";
            case 2:
                return "El precio no puede ser menor a 1 o mas grande de 999";
            case 3:
                return "El email debe tener de 1 a 50 caracteres";
            case 4:
                return "El formato del email no es correcto";
            case 5:
                return "El password debe tener de 1 a 20 caracteres";
            case 6:
                return "El alias debe tener de 1 a 20 caracteres";
            case 7:
                return "La descripcion debe tener de 1 a 200 caracteres";
            /*case 8:
                return "La descripcion debe tener de 1 a 200 caracteres";
            case 9:
                return "Este usuario aun no ha realizado ningun registro";
            case 10:
                return "Este usuario aun no ha creado ninguna actividad";   
            case 11:
                return "Ese dia no realizaste ninguna actividad";*/
        }
        return super.getMessage(); 
    }    
}
