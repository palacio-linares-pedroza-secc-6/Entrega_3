import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Temporada {
	private String nombreTemporada;
	private String fileTemporada;
	private HashMap<String, Equipo> equipos;
	private ArrayList<EquipoFantasia> equiposFantasy;
	private PriorityQueue<EquipoFantasia> rankingEquipoFantasia;
	private HashMap<String, Fecha> fechas;

	public Temporada(String nombreTemporada, String fileTemporada, String fileEquipo,
			String fileJugadores) throws FileNotFoundException {
		Scanner scanner;
		this.nombreTemporada = nombreTemporada;
		this.fileTemporada = fileTemporada;

		// Generador de Equipos
		scanner = new Scanner(
				new FileReader(System.getProperty("user.dir") + "/Entrega_3/data/" + fileEquipo + ".csv"));
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
				new FileReader(System.getProperty("user.dir") + "/Entrega_3/data/" + fileJugadores + ".csv"));
		linea = scanner.nextLine();
		while (scanner.hasNextLine()) {
			linea = scanner.nextLine();
			String[] info = linea.split(";");
			String nombreJug = info[1];
			String shortEquipo = info[2];

			if (info[3].toUpperCase().equals(Posicion.PORTERO)) {
				Posicion posicion = Posicion.PORTERO;
			} else if (info[3].toUpperCase().equals(Posicion.DEFENSA)) {
				Posicion posicion = Posicion.DEFENSA;
			}
			else if (info[3].toUpperCase().equals(Posicion.DEFENSA))
			String precio = info[4];
			Equipo equipo = equipos.get(shortEquipo);
			Jugador jugador = new Jugador(nombreJug, equipo, posicion, Integer.parseInt(precio));
		}
		// Generador de fechas
		scanner = new Scanner(
				new FileReader(System.getProperty("user.dir") + "/Entrega_3/data/" + fileTemporada + ".csv"));
		linea = scanner.nextLine();
		while (scanner.hasNextLine()) {
			linea = scanner.nextLine();
			String[] info = linea.split(";");
			String fecha = info[0];
			if (fechas.containsKey(fecha)) {
				Fecha fechaMod = fechas.get(fecha);
				fechaMod.addPartido(info[1], info[2], info[3]);
			}

		}

	}

	}

	public String getNombreTorneo() {
		return nombreTorneo;
	}

	public String getFileTemporada() {
		return fileTemporada;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public ArrayList<EquipoFantasia> getEquiposFantasy() {
		return equiposFantasy;
	}

	public PriorityQueue<EquipoFantasia> getRankingEquipoFantasia() {
		return rankingEquipoFantasia;
	}

}
