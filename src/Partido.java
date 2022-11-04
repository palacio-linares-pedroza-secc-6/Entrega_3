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
	public String getNombre(){
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

	public Pair getMarcador() {
		return Pair <marcadorLocal , marcadorVisitante> sapo;
	}

	public void setfileReporte(String fileReporte) {
		this.fileReporte = fileReporte;
	}

	public ArrayList<Jugador> getJugadores() {
		System.out.println("HPTAAA SAPO"+local.getNombre()+" "+visitante.getNombre());
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

}
