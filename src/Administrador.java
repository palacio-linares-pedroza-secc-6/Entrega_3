import java.io.FileNotFoundException;

public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasena) {
		super(nombre, contrasena);
	}

	public void crearTemporada(String nombreTemporada, String fileTemporada, String fileEquipo,
			String nombreFileJugadores) throws FileNotFoundException {

		Temporada temporada = new Temporada(nombreTemporada, fileTemporada, fileEquipo, nombreFileJugadores);

	}

	public void finalizarPartido(Partido partido, String filePartido) {

	}

	public String getFecha() {
		return null;
	}
}
