
public class Participante extends Usuario {

    EquipoFantasia equipoFantansia;

    public Participante(String nombre, String contrasena) {
        super(nombre, contrasena);

    }

    public EquipoFantasia crearEquipoFantasia(String nombreEquipo, Temporada temporadaActual) {

        EquipoFantasia equipoFantasia = new EquipoFantasia(nombreEquipo, temporadaActual);
        setEquipoFantasia(equipoFantasia);
        return equipoFantasia;
    }

    private void setEquipoFantasia(EquipoFantasia equipoFantasia) {
        this.equipoFantansia = equipoFantasia;
    }
}