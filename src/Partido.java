import java.util.*;
import org.javatuples.Pair;
import org.javatuples.Triplet;

private class Partido {
	private String hora;
	private Equipo local;
	private Equipo visitante;
	private int marcadorLocal;
	private int marcadorVisitante;

	private PriorityQueue<Jugador>();
	
	public Partido(String hora, String local2, String visitante2) {
		this.hora=hora;
		this.local=local2;
		this.visitante=visitante2;
		
	}

	public String getHora() {
		return hora;
	}

	public Equipo getLocal() {
		return local;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public Pair getMarcador() {
		return Pair<marcadorLocal,marcadorVisitante>;
	}

}
