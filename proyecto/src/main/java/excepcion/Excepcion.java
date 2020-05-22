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
    public static final int esteAliasNoEstaDisponible = 8;
    public static final int esteNombreNoEstaDisponible = 9;
    public static final int noExisteUsuarioConEseNombre = 10;
    public static final int passwordIncorrecto = 11;
    public static final int noHayNingunaOferta = 12;
    public static final int noExisteCorreo = 13;
    public static final int yaExisteCorreo = 14;
    public static final int noHayNingunJugador = 15;
    public static final int noHayNingunJuego = 16;
    public static final int noHayNingunEquipo = 17;
    public static final int noHayPostulaciones = 18;
           
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
                return "La descripcion no puede tener mas de 200 caracteres";
            case 8:
                return "Este alias no esta disponible";
            case 9:
                return "Este nombre no esta disponible";
            case 10:
                return "No existe ningun usuario con ese nombre";   
            case 11:
                return "Password Incorrecto";
            case 12:
                return "No hay ninguna oferta";
            case 13:
                return "No hay ningun usuario con ese email";
            case 14:
                return "ya existe un usuario con ese email";
            case 15:
                return "No hay ningun jugador";
            case 16:
                return "No hay ningun juego";
            case 17:
                return "No hay ningun equipo";
            case 18:
                return "No te has postulado a ninguna oferta";
        }
        return super.getMessage(); 
    }    
}
