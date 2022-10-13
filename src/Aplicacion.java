import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Aplicacion {
	// atributos clase
	private HashMap<String, Temporada> historialTemporadas;
	private Temporada temporadaActual;
	private static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	private static ArrayList<Participante> participantes = new ArrayList<Participante>();

	public static void CrearUsuario(String nombre, String contrasena, Tipo_Usuario tipo) {
		switch (tipo) {
			case ADMINISTRADOR:
				Administrador Admin = new Administrador(nombre, contrasena);
				administradores.add(Admin);
			case PARTICIPANTE:
				Participante User = new Participante(nombre, contrasena);
				participantes.add(User);
			default:
				break;
		}

	}

	public Temporada getTemporadaActual() {
		return temporadaActual;
	}

	public void setTemporada(Temporada temporada) {
		this.temporadaActual = temporada;
	}

	public void cerrarTemporadaActual(Temporada temporadaNueva) {
		historialTemporadas.put(temporadaActual.getNombreTorneo(), temporadaActual);
		setTemporada(temporadaNueva);
	}

	public ArrayList QueuetoList(PriorityQueue<EquipoFantasia> queue) {
		ArrayList<EquipoFantasia> lista = new ArrayList<EquipoFantasia>(queue.size());
		while (!queue.isEmpty()) {
			lista.add(queue.poll());
		}
		return lista;
	}

	public ArrayList getGanadores() {
		PriorityQueue<EquipoFantasia> ganadores = temporadaActual.getRankingEquipoFantasia();
		ArrayList listaganadores = QueuetoList(ganadores);
		return listaganadores;

	}

	public ArrayList getGanadoresPasados(String nombreTemporada) {
		Temporada temporadavieja = historialTemporadas.get(nombreTemporada);
		PriorityQueue<EquipoFantasia> ganadores = temporadavieja.getRankingEquipoFantasia();
		ArrayList Ganadores = QueuetoList(ganadores);
		return Ganadores;

	}

	public String getHora() {
		String hora = LocalTime.now().toString();
		return hora;
	}

	public String logIn(String nombre, String contrasena, Tipo_Usuario tipo) {
		switch (tipo) {
			case ADMINISTRADOR:
				for (int i = 0; i < administradores.size(); i++) {
					Administrador adminlista = administradores.get(i);
					if (adminlista.getNombre() == nombre && adminlista.getContrasena() == contrasena) {
						return "LogIn Valido";
					}
				}
				return "LogIn NO Valido";
			case PARTICIPANTE:
				for (int i = 0; i < participantes.size(); i++) {
					Participante userlista = participantes.get(i);
					if (userlista.getNombre() == nombre && userlista.getContrasena() == contrasena) {
						return "LogIn Valido";
					}
				}
				return "LogIn NO Valido";
			default:
				return "Ingrese un tipo Valido";
		}
	}

	// public static void no se que iria aca por ahora (●'◡'●)

	public static void main(String[] args) {
		System.out.println("Bienvenido a Equipo de Fantasia V1\n");
		int opcion;
		boolean continuar = true;
		while (continuar) {

			menuOpciones();
			System.out.println("Seleccione una opcion valida");
			opcion = Integer.parseInt(input("Opcion invalida, seleccione una opcion valida"));
			if (opcion > 6 || opcion < 0) {
				System.out.println("Opcion invalida, seleccione una opcion valida");
			}

			else if (opcion == 1) {
				String nombre;
				String contrasena;
				int opcionUsuario;

				nombre = input("Ingrese su nombre de Usuario");
				contrasena = input("Ingrese su constraseña de Usuario");

				System.out.println("\nNombre: " + nombre);
				System.out.println("Contraseña: " + contrasena);

				System.out.println("\nUsted es?");
				opcionUsuario = Integer.parseInt(input("1.Participante\n2.Administrador\n"));
				if (opcionUsuario == 1)
					CrearUsuario(nombre, contrasena, Tipo_Usuario.PARTICIPANTE);
				else if (opcionUsuario == 2)
					CrearUsuario(nombre, contrasena, Tipo_Usuario.ADMINISTRADOR);
			}

			else if (opcion == 6) {
				continuar = false;
				System.out.println("Gracias por usar Equipo de Fantasia V1");

			}

		}
	}

	public static void menuOpciones() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Crear Usuario");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Cerrar programa");
	}

	public static String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}