package ParqueTematico;

public class Trabajador extends Persona implements Detallable{
    private String cargo;
    private String turno;

    //Constructor
    public Trabajador(String nombre, String identificacion, String cargo, String turno) {
        super(nombre, identificacion);
        this.cargo = cargo;
        this.turno = turno;
    }

    //Getters
    public String getCargo() {
        return cargo;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public String detalles() {
        return (nombre+"(ID: "+identificacion+", Cargo: "+cargo+", Turno: "+turno+")");
    }
}
