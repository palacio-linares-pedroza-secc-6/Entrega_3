import java.util.*;

public class Equipo {
	private String nombre;
	private HashMap<Posicion, ArrayList<Jugador>> Jugadores;

	public Equipo(ArrayList<Jugador> Jugadores) {
		this.Jugadores = new HashMap<Posicion, ArrayList<Jugador>>();
		for (Jugador jug : Jugadores) {
			addJugador(jug);

		}

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
