import java.util.*;

public class EquipoFantasia extends Equipo {
	private String nombre;
	private int presupuesto;
	private Alineacion alineacionpasada;
	private ArrayList<Fecha> fechasJugadas;
	private ArrayList<Alineacion> alineacionesPasadas;
	private HashMap<Posicion, ArrayList<Jugador>> Jugadores;
	private Jugador susMedio;
	private Jugador susDelantero;
	private Jugador susArquero;
	private Jugador susDefensa;

	public EquipoFantasia(String nombre, Temporada temporada) {
		super(nombre, temporada);
		this.presupuesto = temporada.getPresupuesto();
		this.Jugadores = new HashMap<Posicion, ArrayList<Jugador>>();
		this.fechasJugadas = new ArrayList<Fecha>();
		this.alineacionesPasadas = new ArrayList<Alineacion>();

	}

	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}
	public HashMap<Posicion, ArrayList<Jugador>> getMapa(){
		return Jugadores;
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
	public Alineacion getAlineacion(){
		return alineacionpasada;
	}
	public Mercado crearMercado(){
		Mercado mercado = new Mercado();
		return mercado;
	}
	@Override
	public void addJugador(Jugador jugador){
		ArrayList<Jugador> players = Jugadores.get(jugador.getPosicion());
		setPresupuesto(presupuesto-jugador.getValor());

	}
	public void removeJugador(Jugador jugador){
		Posicion pos = jugador.getPosicion();
		ArrayList<Jugador> players = Jugadores.get(pos);
		setPresupuesto(presupuesto+jugador.getValorVenta());
		players.remove(jugador);
	}

}
