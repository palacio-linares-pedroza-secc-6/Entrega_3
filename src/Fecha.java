import java.util.*;

public class Fecha {

    String fecha;
    PriorityQueue<Pair<Integer, Jugador>> rankingJugadores;
    PriorityQueue<Pair<Integer, EquipoFantasia>> rankingEquipoFantasia;
    HashMap<String, Partido> partidos = new HashMap<String, Partido>();

    public Fecha(String fecha) {
        this.fecha = fecha;
    }

    public Partido crearPartido(String hora, Equipo local, Equipo visitante) {
        Partido partido = new Partido(hora, local, visitante);
        return partido;
    }

    public void addPartido(String hora, Equipo local, Equipo visitante) {
        String nombrelocal = local.getNombreShort();
        String nombrePartido = hora + nombrelocal;
        if (!partidos.containsKey(nombrePartido)) {
            Partido partido = crearPartido(hora, local, visitante);
            partidos.put(nombrePartido, partido);
        }
    }

    public Partido getPartido(String nombrePartido) {
        return partidos.get(nombrePartido);
    }

    public Pair<Integer, EquipoFantasia>[] calcularRankingEquipos() {
        ArrayList<EquipoFantasia> equipos = Temporada.getEquiposFantasy();
        Iterable<Pair<Integer, Jugador>> pares = (Iterable<Pair<Integer, Jugador>>) rankingJugadores.iterator();
        for (EquipoFantasia equipo : equipos) {
            int puntosEquipo = 0;
            for (Jugador jugador : equipo.getAlineacion().getJugadores()) {
                while (((Iterator<Pair<Integer, Jugador>>) pares).hasNext()) {
                    if (((Iterator<Pair<Integer, Jugador>>) pares).next().getValue() == jugador) {
                        puntosEquipo += ((Iterator<Pair<Integer, Jugador>>) pares).next().getKey();
                    }
                }
            }

            Pair<Integer, EquipoFantasia> equipoFantasia = new Pair<Integer, EquipoFantasia>(puntosEquipo, equipo);
            rankingEquipoFantasia.add(equipoFantasia);
        }

        return null;
    }

    public void addJugadoresRanking(PriorityQueue<Pair<Integer, Jugador>> jugadores) {
        rankingJugadores.addAll(jugadores);
    }

}
