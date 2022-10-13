enum Posicion {
	Defensa,
	Mediocampista,
	Arquero,
	Delatero

}

public class Jugador {
	private String nombre;
	private Posicion posicion;
	private Equipo equipo;
	private int valor;
	private int valorVenta;

	public Jugador(String nombre, Posicion posicion, int valor, Equipo equipo) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.equipo = equipo;
		this.valor = valor;
		this.valorVenta = (int) (valor * .9);
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
