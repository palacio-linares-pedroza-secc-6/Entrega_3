import java.util.*;

public class Temporada {
	private String nombreTorneo;
	private String fileTemporada;
	private ArrayList<Equipo> equipos;
	private ArrayList<EquipoFantasia> equiposFantasy;
	private PriorityQueue<EquipoFantasia> rankingEquipoFantasia;

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
