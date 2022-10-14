
public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasena) {
		super(nombre, contrasena);
	}

	public void crearTemporada(String nombreTemporada, String fileTemporada, String fileEquipo,
			String nombreFileJugadores) {

		Temporada temporada = new Temporada(nombreTemporada, fileTemporada);

	}

	public void finalizarPartido(Partido partido, String filePartido) {

	}

	public String getContrasena() {
		return null;
	}

	public String getNombre() {
		return null;
	}

	public String getFecha() {
		return null;
	}
}
