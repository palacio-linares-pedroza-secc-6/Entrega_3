
public class Participante extends Usuario {
    EquipoFantasia equipo;
    public Participante(String nombre, String contrasena) {
        super(nombre, contrasena);

    }
    public EquipoFantasia getEquipo(){
        return equipo;
    }
    public void setEquipo (EquipoFantasia equipo){
        this.equipo=equipo;
    }
    public EquipoFantasia crearEquipoFantasia(String nombreEquipo, Temporada temporadaActual) {

        EquipoFantasia equipoFantasia = new EquipoFantasia(nombreEquipo, temporadaActual);
        setEquipo(equipoFantasia);
        return equipoFantasia;
    }
    public void comprarJugador(Jugador jugador){
        equipo.setPresupuesto(equipo.getPresupuesto()-jugador.getValor());
        equipo.addJugador(jugador);
    }
    public void venderJugador(Jugador jugador){
        equipo.setPresupuesto(equipo.getPresupuesto()+jugador.getValorVenta());
        equipo.removeJugador(jugador);
    }
    
}