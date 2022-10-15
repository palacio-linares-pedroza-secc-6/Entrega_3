import java.io.FileNotFoundException;

public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasena) {
		super(nombre, contrasena);
	}

	public void crearTemporada(String nombreTemporada, String fileTemporada, String fileEquipo,
			String fileJugadores) throws FileNotFoundException {

		Temporada temporada = new Temporada(nombreTemporada, fileTemporada, fileEquipo, fileJugadores);

	}

	public void finalizarPartido(String fechaBus, String partidoBus, String filePartido) {
		Partido partido = getPartido(fechaBus, partidoBus);
		partido.setfileReporte(filePartido);

	}

	public Partido getPartido(String fechaBus, String partidoBus) {
		Temporada tempo = Aplicacion.getTemporadaActual();
		Fecha fecha = tempo.getFecha(fechaBus);
		Partido partido = fecha.getPartido(partidoBus);
		return partido;

	}
}
