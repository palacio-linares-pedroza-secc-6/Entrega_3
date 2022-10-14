
public class Usuario {
	protected String nombre;
	protected String contrasena;

	public Usuario(String nombre, String contrasena) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
	}
	public String getNombre(){
		return nombre;
	}
	public String getContrasena(){
		return contrasena;
	}
}
