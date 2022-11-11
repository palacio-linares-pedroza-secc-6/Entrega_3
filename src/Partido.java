import java.util.*;

public class Partido {
	private String hora;
	private Equipo local;
	private Equipo visitante;
	private int marcadorLocal;
	private int marcadorVisitante;
	private PriorityQueue<Pair> rankingJugadores;
	private String fileReporte;

	public Partido(String hora, Equipo local, Equipo visitante) {
		this.hora = hora;
		this.local = local;
		this.visitante = visitante;
		Comparator<Pair> comparator = new Comparador();
		this.rankingJugadores = new PriorityQueue<Pair>(this.getJugadores().size(), comparator);
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

	public PriorityQueue<Pair> getJugadoresRanking() {
		return rankingJugadores;
	}

	public Pair getMarcador() {
		Pair resultado = new Pair(marcadorLocal, marcadorVisitante);
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

	public void addJugadorRanking(Pair jugador) {
		rankingJugadores.add(jugador);
	}

}
