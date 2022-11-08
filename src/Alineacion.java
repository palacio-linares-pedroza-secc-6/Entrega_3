import java.util.*;

public class Alineacion {
    private HashMap<Posicion, ArrayList<Jugador>> jugadores = new HashMap<Posicion, ArrayList<Jugador>>();
    private EquipoFantasia equipo;
    private Jugador capitan;

    public Alineacion(ArrayList<Jugador> listajugadores, EquipoFantasia equipo) {
        Aplicacion.crearMapa(jugadores, listajugadores);
        this.equipo = equipo;
    }

    public Boolean checkAlineacioncompleta() {
        Object[] posiciones = jugadores.keySet().toArray();
        for (int i = 0; i < 4; i++) {
            Posicion posicion = (Posicion) posiciones[i];
            ArrayList<Jugador> listaporposicion = jugadores.get(posicion);
            switch (posicion) {
                case PORTERO:
                    if (listaporposicion.size() != 1) {
                        System.out.println("PORTERO "+ listaporposicion.size());
                        return false;
                    }
                case DELANTERO:
                    if (listaporposicion.size() != 2) {
                        System.out.println("DELANTERO"+ listaporposicion.size());
                        return false;
                    }
                default:
                    if (listaporposicion.size() != 4) {
                        System.out.println("SAPOOO " + listaporposicion.size()+" "+posicion);
                        return false;
                    }
            }
        }
        return true;
    }

    public void jugarPartido(Partido partido) {

        Object[] posiciones = jugadores.keySet().toArray();
        HashMap<Posicion, Integer> sustituciones = new HashMap<Posicion, Integer>();
        for (int i = 0; i < 4; i++) {
            Posicion posicion = (Posicion) posiciones[i];
            sustituciones.put(posicion, 0);
            ArrayList<Jugador> listaporposicion = jugadores.get(posicion);
            for (int j = 0; j < listaporposicion.size(); i++) {
                Jugador jugadoractual = listaporposicion.get(j);
                ReporteJugador reporte = jugadoractual.getReporte(partido.getNombre());
                int minutosJugados = reporte.getminutosJugados();
                int numsustituciones = sustituciones.get(posicion);
                if (minutosJugados == 0 && numsustituciones < 1) {
                    Sustituir(jugadoractual);
                    numsustituciones++;
                }

            }
        }
        calcularPuntos(partido);
    }

    public void Sustituir(Jugador jugadoractual) {
        Posicion posicion = jugadoractual.getPosicion();
        ArrayList<Jugador> players = jugadores.get(posicion);
        if (posicion == Posicion.PORTERO) {
            Jugador sustituto = equipo.getSusArquero();
            equipo.setSusArquero(jugadoractual);
            players.remove(jugadoractual);
            if (sustituto != null) {
                players.add(sustituto);
            }
        } else if (posicion == Posicion.DEFENSA) {
            Jugador sustituto = equipo.getSusDefensa();
            equipo.setSusDefensa(jugadoractual);
            players.remove(jugadoractual);
            if (sustituto != null) {
                players.add(sustituto);
            }
        } else if (posicion == Posicion.MEDIOCAMPISTA) {
            Jugador sustituto = equipo.getSusMedio();
            equipo.setSusMedio(jugadoractual);
            players.remove(jugadoractual);
            if (sustituto != null) {
                players.add(sustituto);
            }
        } else {
            Jugador sustituto = equipo.getSusDelantero();
            equipo.setSusDelantero(jugadoractual);
            players.remove(jugadoractual);
            if (sustituto != null) {
                players.add(sustituto);
            }
        }
    }
    public void calcularPuntos(Partido partido){
        if (checkAlineacioncompleta()) {
            int puntospartido = 0;
            Object[] posiciones = jugadores.keySet().toArray();
            for(int i=0; i<posiciones.length; i++){
                for (Jugador jugador : jugadores.get(posiciones[i])) {
                   int puntos =0;
                   ReporteJugador reporte = jugador.getReporte(partido.getNombre());
                if (reporte.getminutosJugados()>0){
                   if(jugador ==capitan && reporte.getGoles()>reporte.getGolesRecibidos()){
                      puntos+=5;
                   }
                   puntos = puntos + reporte.getAsistencias()*3;
                   puntos = puntos - reporte.getAutogoles()*2;
                   puntos = puntos - reporte.getPenaltisErrados()*2;
                   puntos = puntos - reporte.getTarjetasRojas()*3;
                   puntos = puntos - reporte.getTarjetasAmarillas();
                   if(reporte.getminutosJugados()<=60){
                        puntos+=1;
                   }
                   else{
                        puntos+=2;
                    }
                   if (jugador.getPosicion()==Posicion.DELANTERO){
                    puntos= puntos + reporte.getGoles()*4;
                   }
                   else if (jugador.getPosicion()==Posicion.MEDIOCAMPISTA){
                    puntos = puntos + reporte.getGoles()*5;
                   }
                   else{
                    puntos = puntos + reporte.getGoles()*6;
                    if (reporte.getGolesRecibidos() ==0){
                        puntos += 4;
                    }
                    if (jugador.getPosicion()==Posicion.PORTERO){
                        puntos = puntos + reporte.getPenaltisDetenidos()*5;
                    }
                   }
                   Pair<Jugador, Integer> playerpuntos = new Pair<>(jugador, puntos);
                   puntospartido+=puntos;
                }
            } 
        }
        }

}

    public Object getCapitan() {
        return capitan;
    }

    public void setCapitan(Jugador capitan) {
        this.capitan= capitan;
    }
}
