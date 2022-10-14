import java.util.PriorityQueue;

import java.util.*;

public class Fecha {

    String fecha;
    PriorityQueue<Jugador> rankingJugadores;
    PriorityQueue<EquipoFantasia> rankingEquipoFantasia;
    HashMap<String, Partido> partidos = new HashMap<>();

    public Fecha(String fecha) {
        this.fecha=fecha;
    }
    public Partido crearPartido(String hora, Equipo local, Equipo visitante){
        Partido partido = new Partido(hora, local, visitante);
        return partido;
    }
    public void addPartido(String hora, Equipo local, Equipo visitante) {
        String nombrePartido = hora + local;
        if (!partidos.containsKey(nombrePartido)) {
            Partido partido = crearPartido(hora, local, visitante);
            partidos.put(nombrePartido, partido);
        }
    }

}
