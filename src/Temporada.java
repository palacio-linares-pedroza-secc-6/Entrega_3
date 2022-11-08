import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Temporada {
	private String nombreTemporada;
	private String fileTemporada;
	private Mercado mercado;
	private int presupuesto;
	private static HashMap<String, Equipo> equipos;
	private HashMap<String, Fecha> fechas;
	private static ArrayList<EquipoFantasia> equiposFantasy;
	private PriorityQueue<EquipoFantasia> rankingEquipoFantasia;

	public Temporada(String nombreTemporada, int presupuesto, String fileTemporada, String fileEquipo,
			String fileJugadores) throws FileNotFoundException {

		this.nombreTemporada = nombreTemporada;
		this.presupuesto = presupuesto;
		this.fileTemporada = fileTemporada;

		equipos = DataDam.cargarEquipos(fileEquipo, this);
		DataDam.cargarJugadores(fileJugadores, this);
		fechas = DataDam.cargarFechas(fileTemporada, this);

	}

	public void crearMercado() {
		this.mercado = new Mercado();
		Object[] listaEquipos = equipos.keySet().toArray();
		for (int i = 0; i < listaEquipos.length; i++) {
			Equipo equipo = equipos.get(listaEquipos[i]);
			ArrayList<Jugador> jugadoresPosi = equipo.getJugadoresPosicion(Posicion.PORTERO);

			if (mercado.mercadoPosiciones.get(Posicion.PORTERO) == null) {

				mercado.mercadoPosiciones.put(Posicion.PORTERO, jugadoresPosi);
			}

			else {
				ArrayList<Jugador> listaJugadores = mercado.mercadoPosiciones.get(Posicion.PORTERO);
				listaJugadores.addAll(jugadoresPosi);
				mercado.mercadoPosiciones.put(Posicion.PORTERO, listaJugadores);

			}

			jugadoresPosi = equipo.getJugadoresPosicion(Posicion.DEFENSA);

			if (mercado.mercadoPosiciones.get(Posicion.DEFENSA) == null) {

				mercado.mercadoPosiciones.put(Posicion.DEFENSA, jugadoresPosi);
			}

			else {
				ArrayList<Jugador> listaJugadores = mercado.mercadoPosiciones.get(Posicion.DEFENSA);
				listaJugadores.addAll(jugadoresPosi);
				mercado.mercadoPosiciones.put(Posicion.PORTERO, listaJugadores);

			}

			jugadoresPosi = equipo.getJugadoresPosicion(Posicion.MEDIOCAMPISTA);

			if (mercado.mercadoPosiciones.get(Posicion.MEDIOCAMPISTA) == null) {

				mercado.mercadoPosiciones.put(Posicion.MEDIOCAMPISTA, jugadoresPosi);
			}

			else {
				ArrayList<Jugador> listaJugadores = mercado.mercadoPosiciones.get(Posicion.MEDIOCAMPISTA);
				listaJugadores.addAll(jugadoresPosi);
				mercado.mercadoPosiciones.put(Posicion.PORTERO, listaJugadores);

			}

			jugadoresPosi = equipo.getJugadoresPosicion(Posicion.DELANTERO);

			if (mercado.mercadoPosiciones.get(Posicion.DELANTERO) == null) {

				mercado.mercadoPosiciones.put(Posicion.DELANTERO, jugadoresPosi);
			}

			else {
				ArrayList<Jugador> listaJugadores = mercado.mercadoPosiciones.get(Posicion.DELANTERO);
				listaJugadores.addAll(jugadoresPosi);
				mercado.mercadoPosiciones.put(Posicion.PORTERO, listaJugadores);

			}

			ArrayList<Jugador> jugadores = equipo.getJugadores();
			for (int a = 0; a < jugadores.size(); a++) {
				Jugador jugador = jugadores.get(a);
				String nombre = jugador.getNombre();
				mercado.mercadoJugadores.put(nombre, jugador);

			}
		}

	}

	// Funciones de busqueda

	public Fecha getFecha(String fecha) {
		return fechas.get(fecha);
	}

	public String getNombreTemporada() {
		return nombreTemporada;
	}

	public String getFileTemporada() {
		return fileTemporada;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public ArrayList<Equipo> getEquipos() {
		Object[] listallaves = equipos.keySet().toArray();
		ArrayList<Equipo> EQUIPOS = new ArrayList<Equipo>();
		for (int i = 0; i < listallaves.length; i++) {
			Equipo equipo = equipos.get(listallaves[i]);
			EQUIPOS.add(equipo);
		}
		return EQUIPOS;
	}

	public HashMap<String, Equipo> getEquiposMap() {
		return equipos;
	}

	public Equipo getEquipo(String equipo) {
		return equipos.get(equipo);
	}

	public static ArrayList<EquipoFantasia> getEquiposFantasy() {
		return equiposFantasy;
	}

	public PriorityQueue<EquipoFantasia> getRankingEquipoFantasia() {
		return rankingEquipoFantasia;
	}

	public Mercado getMercado() {
		return mercado;
	}

}
