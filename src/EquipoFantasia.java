import java.util.*;

public class EquipoFantasia extends Equipo {
	private String nombre;
	private int presupuesto;
	private ArrayList<Fecha> fechasJugadas;
	private ArrayList<Alineacion> alineacionesPasadas;
	private Jugador susMedio;
	private Jugador susDelantero;
	private Jugador susArquero;
	private Jugador susDefensa;

	public EquipoFantasia(String nombre, Temporada temporada) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public ArrayList<Fecha> getFechasJugadas() {
		return fechasJugadas;
	}

	public void addFechaJugadas(Fecha fechajugada) {
		fechasJugadas.add(fechajugada);
	}

	public ArrayList<Alineacion> getAlineacionesPasadas() {
		return alineacionesPasadas;
	}

	public void addAlineacionPasada(Alineacion alineacionpasada) {
		alineacionesPasadas.add(alineacionpasada);
	}

	public Jugador getSusMedio() {
		return susMedio;
	}

	public void setSusMedio(Jugador susMedio) {
		this.susMedio = susMedio;
	}

	public Jugador getSusDelantero() {
		return susDelantero;
	}

	public void setSusDelantero(Jugador susDelantero) {
		this.susDelantero = susDelantero;
	}

	public Jugador getSusArquero() {
		return susArquero;
	}

	public void setSusArquero(Jugador susArquero) {
		this.susArquero = susArquero;
	}

	public Jugador getSusDefensa() {
		return susDefensa;
	}

	public void setSusDefensa(Jugador susDefensa) {
		this.susDefensa = susDefensa;
	}

}
