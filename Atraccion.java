package ParqueTematico;


public class Atraccion implements Detallable{
    public Trabajador trabajador;
    private String nombre;
    private int capacidadMaxima;
    private int edadMinima;

    // Constructor
    public Atraccion(String nombre, int capacidadMaxima, int edadMinima, Trabajador trabajador) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.edadMinima = edadMinima;
        this.trabajador = trabajador;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    // Sobreescribimos metodo de la interfaz detallable
    @Override
    public String detalles(){
        return ("Atracción: "+nombre+"\nCapacidad máxima: "+capacidadMaxima+"\nEdad mínima: "+edadMinima);
    }
}
