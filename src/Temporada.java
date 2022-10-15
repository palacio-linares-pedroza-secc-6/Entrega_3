import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Temporada {
	private String nombreTemporada;
	private String fileTemporada;
	private HashMap<String, Equipo> equipos = new HashMap<>();
	private HashMap<String, Fecha> fechas = new HashMap<>();
	private ArrayList<EquipoFantasia> equiposFantasy;
	private PriorityQueue<EquipoFantasia> rankingEquipoFantasia;

	public Temporada(String nombreTemporada, String fileTemporada, String fileEquipo,
			String fileJugadores) throws FileNotFoundException {
		Scanner scanner;
		this.nombreTemporada = nombreTemporada;
		this.fileTemporada = fileTemporada;

		// Generador de Equipos
		scanner = new Scanner(
				new FileReader(System.getProperty("user.dir") + "/data/" + fileEquipo + ".csv"));
		String linea = scanner.nextLine();
		while (scanner.hasNextLine()) {
			linea = scanner.nextLine();
			String[] info = linea.split(";");
			String nombre = info[0];
			String nombreShort = info[1];
			Equipo equipo = new Equipo(nombre, nombreShort);
			equipos.put(nombreShort, equipo);
		}
		// Generador de jugadores
		scanner = new Scanner(
				new FileReader(System.getProperty("user.dir") + "/data/" + fileJugadores + ".csv"));
		linea = scanner.nextLine();
		while (scanner.hasNextLine()) {
			linea = scanner.nextLine();
			String[] info = linea.split(";");
			String nombreJug = info[1];
			String shortEquipo = info[2];
			String precio = info[4];
			Equipo equipo = equipos.get(shortEquipo);

			if (info[3].toUpperCase().equals("PORTERO")) {

				Posicion posicion = Posicion.PORTERO;
				Jugador jugador = new Jugador(nombreJug, equipo, posicion, Integer.parseInt(precio));
				equipo.addJugador(jugador);
			} else if (info[3].toUpperCase().equals("DEFENSA")) {
				Posicion posicion = Posicion.DEFENSA;
				Jugador jugador = new Jugador(nombreJug, equipo, posicion, Integer.parseInt(precio));
				equipo.addJugador(jugador);
			} else if (info[3].toUpperCase().equals("MEDIOCAMPISTA")) {
				Posicion posicion = Posicion.MEDIOCAMPISTA;
				Jugador jugador = new Jugador(nombreJug, equipo, posicion, Integer.parseInt(precio));
				equipo.addJugador(jugador);
			} else {
				Posicion posicion = Posicion.DELANTERO;
				Jugador jugador = new Jugador(nombreJug, equipo, posicion, Integer.parseInt(precio));
				equipo.addJugador(jugador);
			}

		}
		// Generador de fechas
		scanner = new Scanner(
				new FileReader(System.getProperty("user.dir") + "/data/" + fileTemporada + ".csv"));
		linea = scanner.nextLine();
		while (scanner.hasNextLine()) {
			linea = scanner.nextLine();
			String[] info = linea.split(";");
			String date = info[0];
			String hora = info[1];
			System.out.print(hora);
			Equipo local = equipos.get(info[2]);
			Equipo visitante = equipos.get(info[3]);
			if (fechas.containsKey(date)) {
				Fecha fechaMod = fechas.get(date);
				fechaMod.addPartido(hora, local, visitante);
			} else {
				Fecha fecha = new Fecha(date);
				fecha.addPartido(hora, local, visitante);
				fechas.put(date, fecha);
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

	public HashMap<String, Equipo> getEquipos() {
		return equipos;
	}

	public Equipo getEquipo(String equipo) {
		return equipos.get(equipo);
	}

	public ArrayList<EquipoFantasia> getEquiposFantasy() {
		return equiposFantasy;
	}

	public PriorityQueue<EquipoFantasia> getRankingEquipoFantasia() {
		return rankingEquipoFantasia;
	}

}
