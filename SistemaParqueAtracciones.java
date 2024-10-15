package ParqueTematico;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaParqueAtracciones {

    private List<Atraccion> atraccionesDisponibles;
    private List<Reserva> reservas;
    private List<Visitante> visitantes;

    public SistemaParqueAtracciones() {
        this.atraccionesDisponibles = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.visitantes = new ArrayList<>();
    }

    public List<Atraccion> getAtraccionesDisponibles() {
        return atraccionesDisponibles;
    }

    //Metodo para agregar una atracción
    public void agregarAtraccion(Atraccion atraccion) {
        atraccionesDisponibles.add(atraccion);
        System.out.println(atraccion.detalles());
    }

    //Metodo para mostrar todas las atracciones disponibles
    public void mostrarAtracciones() {
        StringBuilder sb = new StringBuilder();
        if (atraccionesDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay atracciones dsiponibles. ");
            return;
        }
        for (Atraccion atraccion : atraccionesDisponibles) {
            sb.append(atraccion.detalles()+ "\n-----------------------\n");
        }
        String detalles = sb.toString();
        System.out.println(detalles);
        JOptionPane.showMessageDialog(null,detalles);
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    //Metodo para agregar un visitante
    public void agregarVisitante(Visitante visitante){
        visitantes.add(visitante);
    }

    //Metodo para mostrar todaos los visitantes registrados
    public void mostrarVisitantes() {
        StringBuilder sb = new StringBuilder();
        if (visitantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay visitantes dsiponibles. ");
            return;
        }
        for (Visitante visitante : visitantes) {
            sb.append(visitante.detalles()+ "\n-----------------------\n");
        }
        String detalles = sb.toString();
        JOptionPane.showMessageDialog(null,detalles);
    }

    //Metodo para reservar una atracción
    public void reservarAtraccion(Visitante visitante, Atraccion atraccion) {
        if(visitante != null && atraccion != null){
            Reserva nuevaReserva = new Reserva(visitante, atraccion);
            if(visitante.getEdad() >= atraccion.getEdadMinima() && atraccion.getCapacidadMaxima()>0) {
                reservas.add(nuevaReserva);
                System.out.println("Detalles de la reserva registrada: \n" + nuevaReserva.detalles());
                atraccion.setCapacidadMaxima(atraccion.getCapacidadMaxima()-1);
            }else if(visitante.getEdad() < atraccion.getEdadMinima()) {
                JOptionPane.showMessageDialog(null,"El visitante no tiene la edad mínima para subir a la atracción.");
            }else{
                JOptionPane.showMessageDialog(null,"No hay huecos disponibles en la atracción");
            }
        }

    }

    //Mostrar reservas de un visitante
    public void mostrarReservasPorVisitante(Visitante visitante) {
        if(visitante != null){
            boolean tieneReservas = false;
            for (Reserva reserva : reservas) {
                if (reserva.getVisitante().getIdentificacion().equals(visitante.getIdentificacion())) {
                    System.out.println(reserva.detalles());
                    tieneReservas = true;
                }
            }
            if (!tieneReservas) {
                JOptionPane.showMessageDialog(null, "No hay reservas para el visitante: " + visitante.getNombre());
            }
        }

    }

    //Cancelar una reserva
    public void cancelarReserva(Visitante visitante, Atraccion atraccion) {
        if(visitante != null && atraccion != null) {
            Reserva reservaACancelar = null;
            for (Reserva reserva : reservas) {
                if (reserva.getVisitante().equals(visitante) && reserva.getAtraccion().equals(atraccion)) {
                    reservaACancelar = reserva;
                    break;
                }
            }
            if (reservaACancelar != null) {
                reservas.remove(reservaACancelar);
                reservaACancelar.getAtraccion().setCapacidadMaxima(reservaACancelar.getAtraccion().getCapacidadMaxima()+1);
                JOptionPane.showMessageDialog(null,"Reserva de " + visitante.getNombre() + " cancelada para la atracción: " + atraccion.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna reserva para esa atracción");
            }
        }
    }

    //Metodo para obtener un visitante segun su id
    public Visitante hayVisitante(){
        Visitante persona = null;
        boolean hayVisitante = false;

        String ide = JOptionPane.showInputDialog("Introduzca la id del visitante: ");

        if(!visitantes.isEmpty()){
            for (Visitante visit : visitantes){
                if (visit.getIdentificacion().equals(ide)){
                    persona = visit;
                    hayVisitante = true;
                }
            }
        }
        if(!hayVisitante) {
            JOptionPane.showMessageDialog(null,"No hay ningun visitante registrado con esa ID");
            return null;
        }
        return persona;
    }

    //Metodo para obtener una atraccion segun su nombre
    public Atraccion hayAtraccion(){
        Atraccion atraccion = null;
        boolean hayAtraccion = false;

        String name = JOptionPane.showInputDialog("Introduzca el nombre de la atracción: ");

        if(!atraccionesDisponibles.isEmpty()){
            for (Atraccion at : atraccionesDisponibles){
                if (at.getNombre().equalsIgnoreCase(name)){
                    atraccion = at;
                    hayAtraccion = true;
                }
            }
        }
        if(!hayAtraccion) {
            JOptionPane.showMessageDialog(null,"No hay ninguna atracción con ese nombre");
            return null;
        }

        return atraccion;
    }

    //Metodo principal
    public static void main(String[] args) {
        SistemaParqueAtracciones sistema = new SistemaParqueAtracciones();

        //Agregar trabajadores al sistema
        Trabajador trabajador1 = new Trabajador("María Pérez", "1234", "Operaria", "Mañana");
        Trabajador trabajador2 = new Trabajador("Pepe Sánchez", "5678", "Operario", "Tarde");

        //Agregar atracciones al sistema
        Atraccion montanaRusa = new Atraccion("Montaña Rusa", 10, 10, trabajador1);
        sistema.agregarAtraccion(montanaRusa);
        Atraccion noria = new Atraccion("Noria", 10, 0, trabajador1);
        sistema.agregarAtraccion(noria);
        Atraccion casaTerror = new Atraccion("Casa del Terror", 6, 15, trabajador2);
        sistema.agregarAtraccion(casaTerror);
        Atraccion lanzadera = new Atraccion("Lanzadera", 8, 10, trabajador2);
        sistema.agregarAtraccion(lanzadera);

        //Simulación de reservas
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "Menu\n" +
                            "1. Agregar visitante\n" +
                            "2. Mostrar visitantes\n" +
                            "3. Mostrar atracciones\n" +
                            "4. Realizar reserva\n" +
                            "5. Cancelar reserva\n" +
                            "6. Mostrar reservas de un visitante\n" +
                            "7. Salir\n" +
                            "Selecciona una opción: "
            );

            switch (opcion) {
                case "1":
                    boolean idOcupada=false;
                    String nombre = JOptionPane.showInputDialog("Introduce el nombre del visitante: ");
                    String id = JOptionPane.showInputDialog("Introduce el ID del visitante: ");
                    if(!sistema.getVisitantes().isEmpty()){
                        for (Visitante visitante : sistema.getVisitantes()){
                            if (visitante.getIdentificacion().equals(id)){
                                JOptionPane.showMessageDialog(null,"Ya hay un visitante registrado con esa ID");
                                idOcupada = true;
                                break;
                            }
                        }
                    }
                    if(!idOcupada){
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la edad del visitante: "));
                        Visitante visitante = new Visitante(nombre,id,edad);
                        sistema.agregarVisitante(visitante);
                        sistema.mostrarVisitantes();
                    }
                    break;
                case "2":
                    sistema.mostrarVisitantes();
                    break;
                case "3":
                    sistema.mostrarAtracciones();
                    break;
                case "4":
                    sistema.mostrarVisitantes();
                    Visitante persona = sistema.hayVisitante();
                    sistema.mostrarAtracciones();
                    Atraccion atraccion = sistema.hayAtraccion();
                    sistema.reservarAtraccion(persona, atraccion);
                    break;
                case "5":
                    sistema.cancelarReserva(sistema.hayVisitante(),sistema.hayAtraccion());
                    break;
                case "6":
                    sistema.mostrarVisitantes();
                    sistema.mostrarReservasPorVisitante(sistema.hayVisitante());
                    break;
                case "7":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no disponible.");
                    break;

            }


        }
    }
}
