import java.util.PriorityQueue;

import java.util.*;

public class Fecha {

    String fecha;
    PriorityQueue<Jugador> rankingJugadores;
    PriorityQueue<EquipoFantasia> rankingEquipoFantasia;
    HashMap<String, Partido> partidos = new HashMap<>();

    public Fecha() {

    }

    public void addPartido(String hora, String local, String visitante) {
        String nombrePartido = hora + local;
        if (!partidos.containsKey(nombrePartido)) {
            Partido partido = new Partido(hora, local, visitante);
            partidos.put(nombrePartido, partido);
        }
    }

}
