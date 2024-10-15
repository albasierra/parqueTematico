package ParqueTematico;

public class Visitante extends Persona implements Detallable{
    private int edad;

    //Constructor

    public Visitante(String nombre, String identificacion, int edad) {
        super(nombre, identificacion);
        this.edad = edad;
    }

    //Getter para la edad del visitante
    public int getEdad() {
        return edad;
    }

    @Override
    public String detalles() {
        return ("Visitante: "+nombre+" (ID: "+identificacion+", Edad:"+edad+")");
    }
}
