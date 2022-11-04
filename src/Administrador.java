import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasena) {
		super(nombre, contrasena);
	}

	public Temporada crearTemporada(String nombreTemporada, int presupuesto, String fileTemporada, String fileEquipo,
			String fileJugadores) throws FileNotFoundException {

		Temporada temporada = new Temporada(nombreTemporada, presupuesto, fileTemporada, fileEquipo, fileJugadores);
		return temporada;
	}

	public void finalizarPartido(Partido partido, String partidoBus, String filePartido) throws FileNotFoundException {
		partido.setfileReporte(filePartido);
		ArrayList<Jugador> jugadoresTotal = partido.getJugadores();
		for (int i=0; i<jugadoresTotal.size(); i++){
			System.out.println(jugadoresTotal.get(i).getNombre()+" "+jugadoresTotal.get(i).getEquipo().getNombre());
		}
		// local
		Scanner scanner = new Scanner(
				new FileReader(System.getProperty("user.dir") + "/data/partidos/" + filePartido
						+ ".csv"));
		String linea = scanner.nextLine();
		while (scanner.hasNextLine()) {
			linea = scanner.nextLine();
			String[] info = linea.split(";");
			String nombreJugador = info[0];

			for (int i = 0; i < jugadoresTotal.size(); i++) {
				Jugador jugador = jugadoresTotal.get(i);
				if (jugador.getNombre().equals(nombreJugador)) {
					int minJugados = Integer.parseInt(info[2]);
					int minIngresado = Integer.parseInt(info[3]);
					int minSalido = Integer.parseInt(info[4]);
					int goles = Integer.parseInt(info[5]);
					int golesPenaltis = Integer.parseInt(info[6]);
					int autogoles = Integer.parseInt(info[7]);
					int asistencias = Integer.parseInt(info[8]);
					int golesRecibidos = Integer.parseInt(info[9]);
					int penaltisDetenidos = Integer.parseInt(info[10]);
					int penaltisErrados = Integer.parseInt(info[11]);
					int tarjetasAmarillas = Integer.parseInt(info[12]);
					int tarjetasRojas = Integer.parseInt(info[13]);

					ReporteJugador reporte = new ReporteJugador(partidoBus, minJugados, minIngresado, minSalido, goles,
							golesPenaltis, autogoles, asistencias, golesRecibidos, penaltisDetenidos, penaltisErrados,
							tarjetasAmarillas, tarjetasRojas);
					jugador.addReporte(reporte, partidoBus);
				}
			}
		}
	}
}
		
	


