import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Aplicacion {
	// atributos clase
	private HashMap<String, Temporada> historialTemporadas;
	private static Temporada temporadaActual = null;
	private static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	private static ArrayList<Participante> participantes = new ArrayList<Participante>();
	private static HashMap<String, Administrador> findAdministrador = new HashMap<>();
	private static HashMap<String, Participante> findParticipantes = new HashMap<>();

	public static String CrearUsuario(String nombre, String contrasena, Tipo_Usuario tipo) {
		String respuesta;

		switch (tipo) {

			case ADMINISTRADOR:
				for (int i = 0; i < administradores.size(); i++) {
					Administrador adminlista = administradores.get(i);
					if (adminlista.getNombre().equals(nombre)) {
						respuesta = "Ese nombre de usuario ya existe";
						return respuesta;
					}
				}
				Administrador Admin = new Administrador(nombre, contrasena);
				administradores.add(Admin);
				findAdministrador.put(nombre, Admin);

				respuesta = "Se ha creado con exito";
				return respuesta;

			case PARTICIPANTE:
				for (int i = 0; i < participantes.size(); i++) {
					Participante userlista = participantes.get(i);
					if (userlista.getNombre().equals(nombre)) {
						respuesta = "Ese nombre de usuario ya existe";
						return respuesta;
					}
				}
				Participante User = new Participante(nombre, contrasena);
				participantes.add(User);
				findParticipantes.put(nombre, User);

				respuesta = "Se ha creado con exito";
				return respuesta;

			default:
				return null;
		}
	}

	public static Temporada getTemporadaActual() {
		return temporadaActual;
	}

	public static void setTemporada(Temporada temporada) {
		temporadaActual = temporada;
	}

	public void cerrarTemporadaActual(Temporada temporadaNueva) {
		historialTemporadas.put(temporadaActual.getNombreTemporada(), temporadaActual);
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

	public ArrayList<String> getGanadoresPasados(String nombreTemporada) {
		Temporada temporadavieja = historialTemporadas.get(nombreTemporada);
		PriorityQueue<EquipoFantasia> ganadores = temporadavieja.getRankingEquipoFantasia();
		ArrayList Ganadores = QueuetoList(ganadores);
		return Ganadores;

	}

	public String getHora() {
		String hora = LocalTime.now().toString();
		return hora;
	}

	public static String logIn(String nombre, String contrasena, Tipo_Usuario tipo) {
		switch (tipo) {
			case ADMINISTRADOR:
				for (int i = 0; i < administradores.size(); i++) {
					Administrador adminlista = administradores.get(i);

					if (adminlista.getNombre().equals(nombre) && adminlista.getContrasena().equals(contrasena)) {
						return "LogIn Valido";
					}
				}
				return "LogIn NO Valido";
			case PARTICIPANTE:
				for (int i = 0; i < participantes.size(); i++) {
					Participante userlista = participantes.get(i);

					if (userlista.getNombre().equals(nombre) && userlista.getContrasena().equals(contrasena)) {
						return "LogIn Valido";
					}
				}
				return "LogIn NO Valido";
			default:
				return "Ingrese un tipo Valido";
		}
	}

	// public static void no se que iria aca por ahora (●'◡'●)

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Bienvenido a Equipo de Fantasia V1\n");
		int opcion;
		boolean continuar = true;
		while (continuar) {

			menuInicial();
			opcion = Integer.parseInt(input("Seleccione una opcion valida"));
			if (opcion > 3 || opcion < 0) {
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
					System.out.println(CrearUsuario(nombre, contrasena, Tipo_Usuario.PARTICIPANTE));
				else if (opcionUsuario == 2)
					System.out.println(CrearUsuario(nombre, contrasena, Tipo_Usuario.ADMINISTRADOR));
			}

			else if (opcion == 2) {

				String nombre;
				String contrasena;
				int opcionUsuario;
				String resultado;

				nombre = input("Ingrese su nombre de Usuario");
				contrasena = input("Ingrese su constraseña de Usuario");

				System.out.println("\nUsted es?");
				opcionUsuario = Integer.parseInt(input("1.Participante\n2.Administrador\n"));
				if (opcionUsuario == 1) {
					resultado = logIn(nombre, contrasena, Tipo_Usuario.PARTICIPANTE);
					System.out.println(resultado);
					if (resultado.equals("LogIn Valido")) {

						// Menu para el participante
						System.out.println("\nBienvenido " + nombre);
						Participante user = findParticipantes.get(nombre);
						boolean continuarParticipante = true;

						while (continuarParticipante) {
							menuParticipante();
							opcion = Integer.parseInt(input("Seleccione una opcion valida"));
							if (opcion > 3 || opcion < 0) {
								System.out.println("Opcion invalida, seleccione una opcion valida");
							}

							else if (opcion == 1) {

								if (temporadaActual == null) {
									System.out.println("No existe una tempoarada actual para jugar");
								}

								else {
									String nombreEquipo = input("Ingrese el nombre de su equipo:");
									EquipoFantasia equipoFantasia = user.crearEquipoFantasia(nombreEquipo,
											temporadaActual);
									System.out.println("Se ha creado con exito el equipo: " + nombreEquipo);

								}
							} else if (opcion == 2) {
								if (user.equipoFantansia == null) {
									System.out.println(
											"No tiene un equipos de fantsia por favor cree uno antes de ir al mercado");
								} else {
									System.out.println("Bienvenido al Mercado de jugadores");
									int posicion = Integer.parseInt(input(
											"Que posicion le gustaria revisar: 1.Portero 2.Defensa 3.MedioCampista 4.Delantero"));

									if (posicion == 1) {
										Mercado mercado = temporadaActual.getMercado();
										mercado.mostrarJugadores(Posicion.PORTERO);

									} else if (posicion == 2) {
										Mercado mercado = temporadaActual.getMercado();
										mercado.mostrarJugadores(Posicion.PORTERO);
									}

									else if (posicion == 3) {
										Mercado mercado = temporadaActual.getMercado();
										mercado.mostrarJugadores(Posicion.PORTERO);
									}

									else if (posicion == 4) {
										Mercado mercado = temporadaActual.getMercado();
										mercado.mostrarJugadores(Posicion.PORTERO);
									}

								}
							}

							else if (opcion == 3) {
								continuarParticipante = false;
								System.out.println("Se ha cerrado sesion\n");
							}

						}
					}

				} else if (opcionUsuario == 2) {
					resultado = logIn(nombre, contrasena, Tipo_Usuario.ADMINISTRADOR);
					System.out.println(resultado);
					if (resultado.equals("LogIn Valido")) {

						// Menu para el administrador
						System.out.println("\nBienvenido administrador " + nombre);
						Administrador admin = findAdministrador.get(nombre);
						boolean continuarAdministrador = true;

						while (continuarAdministrador) {
							menuAdministrador();
							opcion = Integer.parseInt(input("Seleccione una opcion valida"));
							if (opcion > 3 || opcion < 0) {
								System.out.println("Opcion invalida, seleccione una opcion valida");
							}

							else if (opcion == 1) {
								String nombreTemp = input("Ingrese el nombre de la temporada");
								String filePartidos = input("Ingrese el nombre de el archivo de la temporada");
								String fileEquipos = input(
										"Ingrese el nombre de el archivo de los equipos de la temporada");
								String fileJugadores = input(
										"Ingrese el nombre de el archivo de los jugadores de la temporada");
								Temporada temporada = admin.crearTemporada(nombreTemp, filePartidos, fileEquipos,
										fileJugadores);
								setTemporada(temporada);

								temporada.crearMercado();

							}

							else if (opcion == 2) {
								String fechapartido = input("Ingrese la fecha en la que desea buscar el partido");
								String localpartido = input(
										"Ingrese la abreviacion de el equipo local que juega en esa fecha");
								String horaPartido = input("Ingrese la hora a la que inicia el partido");
								String nombreFilePartido = input("Ingrese el nombre de el archivo del partido");
								String nombrePartido = horaPartido + localpartido;
								admin.finalizarPartido(fechapartido, nombrePartido, nombreFilePartido);
							}

							else if (opcion == 3) {
								continuarAdministrador = false;
								System.out.println("Se ha cerrado sesion\n");
							}

						}
					}
					// FINAL DE MENU
				}
			}

			else if (opcion == 3) {
				continuar = false;
				System.out.println("Gracias por usar Fantasia V1");

			}
		} // acaba el while aca

	}

	private static void menuAdministrador() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Crear temporada");
		System.out.println("2. Cerrar Partido");
		System.out.println("3. Cerrar programa");

	}

	private static void menuParticipante() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Crear Equipo de Fantasia");
		System.out.println("2. Comprar Jugadores");
		System.out.println("3. Cerrar programa");
	}

	public static void menuInicial() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Crear Usuario");
		System.out.println("2. Iniciar sesion");
		System.out.println("3. Cerrar programa");
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