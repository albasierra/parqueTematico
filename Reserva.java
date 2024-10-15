package ParqueTematico;

public class Reserva implements Detallable{
    private Visitante visitante;
    private Atraccion atraccion;

    public Reserva(Visitante visitante, Atraccion atraccion) {
        this.visitante = visitante;
        this.atraccion = atraccion;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Atraccion getAtraccion() {
        return atraccion;
    }

    @Override
    public String detalles() {
        return ("Reserva para "+visitante.getNombre()+" en la atracción "+atraccion.getNombre() + " a cargo del trabajador: "+atraccion.getTrabajador().detalles() );
    }
}
