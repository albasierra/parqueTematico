package ParqueTematico;

public class Persona {
    protected String nombre;
    protected String identificacion;

    //Constructor
    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    //Getter

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
