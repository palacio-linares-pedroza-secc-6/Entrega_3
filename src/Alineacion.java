import java.util.*;
public class Alineacion {
    private HashMap<Posicion, ArrayList<Jugador>> jugadores = new HashMap<Posicion, ArrayList<Jugador>>();
    private EquipoFantasia equipo;
    public Alineacion(ArrayList<Jugador> listajugadores, EquipoFantasia equipo){
       Aplicacion.crearMapa(jugadores, listajugadores);
       this.equipo=equipo;
    }
    public Boolean checkAlineacioncompleta(){
        Object[] posiciones = jugadores.keySet().toArray();
        for(int i=0; i<4; i++){
            Posicion posicion = (Posicion) posiciones[i];
            ArrayList<Jugador> listaporposicion = jugadores.get(posicion);
            switch(posicion){
                case PORTERO:
                if (listaporposicion.size()!=1){
                    return false;
                }
                case DELANTERO:
                if (listaporposicion.size()!=2){
                    return false;
                }
                default:
                if (listaporposicion.size()!=4){
                    return false;
                }
            }
        }
        return true;
    }

    public void jugarPartido(Partido partido){

        Object[] posiciones = jugadores.keySet().toArray();
        HashMap<Posicion,Integer> sustituciones = new HashMap<Posicion,Integer>();
        for(int i=0; i<4; i++){
            Posicion posicion = (Posicion) posiciones[i];
            sustituciones.put(posicion, 0);
            ArrayList<Jugador> listaporposicion = jugadores.get(posicion);
            for (int j=0; j<listaporposicion.size(); i++){
                Jugador jugadoractual = listaporposicion.get(j);
                ReporteJugador reporte = jugadoractual.getReporte(partido.getNombre());
                int minutosJugados = reporte.getminutosJugados();
                int numsustituciones = sustituciones.get(posicion);
                if (minutosJugados==0 && numsustituciones<1){
                    Sustituir(jugadoractual);
                    numsustituciones++;
                }

            }
    }


}
    private void Sustituir(Jugador jugadoractual) {
        Posicion posicion = jugadoractual.getPosicion();
        ArrayList<Jugador> players = jugadores.get(posicion);
        switch(posicion){
            case PORTERO:
                Jugador sustituto = equipo.getSusArquero();
                equipo.setSusArquero(jugadoractual);
                players.remove(jugadoractual);
                players.add(sustituto);
            case DEFENSA:
                Jugador sustituto = equipo.getSusDefensa();
                equipo.setSusDefensa(jugadoractual);
                players.remove(jugadoractual);
                players.add(sustituto);
            case MEDIOCAMPISTA:
                Jugador sustituto = equipo.getSusMedio();
                equipo.setSusMedio(jugadoractual);
                players.remove(jugadoractual);
            players.add(sustituto);
            case DELANTERO:
                Jugador sustituto = equipo.getSusDelantero();
                equipo.setSusDelantero(jugadoractual); 
                players.remove(jugadoractual);
                players.add(sustituto); 
        }

        
    }}
