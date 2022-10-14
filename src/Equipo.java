import java.util.*;

public class Equipo {
	private String nombre;
	private String nombreShort;
	private HashMap<Posicion, ArrayList<Jugador>> Jugadores;

	public Equipo(String nombre, String nombreShort) {
		this.nombre = nombre;
		this.nombreShort = nombreShort;
		this.Jugadores = new HashMap<Posicion, ArrayList<Jugador>>();

	}

	public void addJugador(Jugador player) {
		Posicion position = player.getPosicion();
		if (Jugadores.containsKey(position)) {
			ArrayList<Jugador> listajug = Jugadores.get(position);
			listajug.add(player);
			Jugadores.put(position, listajug);
		} else {
			ArrayList<Jugador> listajug = new ArrayList<Jugador>();
			listajug.add(player);
			Jugadores.put(position, listajug);
		}

	}

}
