import java.io.Serializable;

public class ReporteJugador implements Serializable{

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
    private int tiros_libres;
    private int manos;
    private int goles_de_tiro_libre;

    public ReporteJugador(String partidoBus, int minJugados, int minIngresado, int minSalido, int goles,
            int golesPenaltis, int autogoles, int asistencias, int golesRecibidos, int penaltisDetenidos,
            int penaltisErrados, int tarjetasAmarillas, int tarjetasRojas, int tiros_libres, int manos, int goles_de_tiro_libre) {

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
        this.tiros_libres=tiros_libres;
        this.manos=manos;
        this.goles_de_tiro_libre=goles_de_tiro_libre;
    }
/**
 * Retorna el nombre del partido del cual es el reporte
 * @return Nombre del partido relacionado al reporte
 */
public String getNombrePartido(){
    return nombrePartido;
}
/**
 * Retorna los minutos jugados por el jugador asociado
 * @return Numero de minutos jugados por el jugador asociado
 */
public int getminutosJugados(){
    return minutosJugados;
}
/**
 * 
 * @return
 */
public int getminutoIngresado(){
    return minutoIngresado;
}
public int getminutoSalido(){
    return minutoSalido;
}
public int getGoles(){
    return goles;
}
public int getGolesPenaltis(){
    return golesPenlatis;
}
public int getAutogoles(){
    return autogoles;
}
public int getAsistencias(){
    return asistencias;
}
public int getGolesRecibidos(){
    return golesRecibidos;
}
public int getPenaltisDetenidos(){
    return penaltisDetenidos;
}
public int getPenaltisErrados(){
    return penaltisErrados;
}
public int getTarjetasAmarillas(){
    return amarillas;
}
public int getTarjetasRojas(){
    return rojas;
}
public int getTirosLibres(){
    return tiros_libres;
}
public int getManos(){
    return manos;
}
public int getGolesdeTiroLibre(){
    return goles_de_tiro_libre;
}
}