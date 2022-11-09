import java.util.*;

public class Partido {
	private String hora;
	private Equipo local;
	private Equipo visitante;
	private int marcadorLocal;
	private int marcadorVisitante;
	private PriorityQueue<Pair<Integer, Jugador>> rankingJugadores;
	private String fileReporte;

	public Partido(String hora, Equipo local, Equipo visitante) {
		this.hora = hora;
		this.local = local;
		this.visitante = visitante;
		Comparator<Pair<Integer, Object>> comparator = new Comparador();
		this.rankingJugadores = new PriorityQueue<Pair<Integer, Jugador>>(this.getJugadores().size());
		System.out.println(this.rankingJugadores);
	}

	public String getNombre() {
		String nombrelocal = local.getNombreShort();
		String nombrePartido = hora + nombrelocal;
		return nombrePartido;
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

	public PriorityQueue<Pair<Integer, Jugador>> getJugadoresRanking() {
		return rankingJugadores;
	}

	public Pair<Integer, Integer> getMarcador() {
		Pair<Integer, Integer> resultado = new Pair<Integer, Integer>(marcadorLocal, marcadorVisitante);
		return resultado;
	}

	public void setfileReporte(String fileReporte) {
		this.fileReporte = fileReporte;
	}

	public ArrayList<Jugador> getJugadores() {
		System.out.println("HPTAAA SAPO" + local.getNombre() + " " + visitante.getNombre());
		ArrayList<Jugador> listajugadorestotales = new ArrayList<Jugador>();
		ArrayList<Jugador> listajugadoreslocal = local.getJugadores();
		ArrayList<Jugador> listajugadoresvisitante = visitante.getJugadores();
		listajugadorestotales.addAll(listajugadoreslocal);
		listajugadorestotales.addAll(listajugadoresvisitante);
		return listajugadorestotales;
	}

	public ArrayList<Jugador> getJugadoresLocal() {
		ArrayList<Jugador> listajugadoreslocal = local.getJugadores();
		return listajugadoreslocal;
	}

	public ArrayList<Jugador> getJugadoresVisitante() {
		ArrayList<Jugador> listajugadoreslocal = visitante.getJugadores();
		return listajugadoreslocal;

	}

	public void addJugadorRanking(Pair<Integer, Jugador> jugador) {
		rankingJugadores.add(jugador);
	}

}
