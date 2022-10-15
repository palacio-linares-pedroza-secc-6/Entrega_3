import java.util.*;
//import org.javatuples.Pair;
//import org.javatuples.Triplet;

public class Partido {
	private String hora;
	private Equipo local;
	private Equipo visitante;
	private int marcadorLocal;
	private int marcadorVisitante;
	private PriorityQueue<Jugador> rankingJugadores = new PriorityQueue<Jugador>();
	private String fileReporte;

	public Partido(String hora, Equipo local, Equipo visitante) {
		this.hora = hora;
		this.local = local;
		this.visitante = visitante;

	}

	public String getHora() {
		return hora;
	}

	public Equipo getLocal() {
		return local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public Pair getMarcador() {
		return Pair<marcadorLocal,marcadorVisitante>;
	}

	public void setfileReporte(String fileReporte) {
		this.fileReporte = fileReporte;
	}

	public void crearReporteJugadores() {
		ArrayList<Jugador> listajugadorestotales = new ArrayList<Jugador>();
		ArrayList<Jugador> listajugadoreslocal = local.getJugadores();
		ArrayList<Jugador> listajugadoresvisitante = visitante.getJugadores();
		listajugadorestotales.addAll(listajugadoreslocal);
		listajugadorestotales.addAll(listajugadoresvisitante);

	}
}
