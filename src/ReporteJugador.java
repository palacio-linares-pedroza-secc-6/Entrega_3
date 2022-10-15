
public class ReporteJugador {

    private String nombrePartido;
    private int minutosJugados;
    private int minutoIngresado;
    private int minutoSalido;
    private int goles;
    private int golesPenlatis;
    private int autogoles;
    private int asistencias;
    private int golesRecibidos;
    private int penaltisDetenidos;
    private int penaltisErrados;
    private int amarillas;
    private int rojas;

    public ReporteJugador(String partidoBus, int minJugados, int minIngresado, int minSalido, int goles,
            int golesPenaltis, int autogoles, int asistencias, int golesRecibidos, int penaltisDetenidos,
            int penaltisErrados, int tarjetasAmarillas, int tarjetasRojas) {

        this.nombrePartido = partidoBus;
        this.minutosJugados = minJugados;
        this.minutoIngresado = minIngresado;
        this.minutoSalido = minSalido;
        this.goles = goles;
        this.golesPenlatis = golesPenaltis;
        this.autogoles = autogoles;
        this.asistencias = asistencias;
        this.golesRecibidos = golesRecibidos;
        this.penaltisDetenidos = penaltisDetenidos;
        this.penaltisErrados = penaltisErrados;
        this.amarillas = tarjetasAmarillas;
        this.rojas = tarjetasRojas;

    }
}
