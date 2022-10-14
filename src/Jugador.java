public class Jugador {
	private String nombre;
	private Posicion posicion;
	private Equipo equipo;
	private int valor;
	private int valorVenta;

	public Jugador(String nombre, Equipo shortEquipo, Posicion posicion, int precio) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.equipo = shortEquipo;
		this.valor = precio;
		this.valorVenta = (int) (precio * .9);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public int getValor() {
		return valor;
	}

	public int getValorVenta() {
		return valorVenta;
	}

	public Equipo getEquipo() {
		return equipo;
	}

}
