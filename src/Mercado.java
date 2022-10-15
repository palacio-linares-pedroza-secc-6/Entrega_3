import java.util.*;

public class Mercado {
    private EquipoFantasia equipo;

    public Mercado(EquipoFantasia equipo){
        this.equipo=equipo;
    }
    public HashMap<Posicion, ArrayList<Jugador>> CrearMercado(){
        HashMap<Posicion, ArrayList<Jugador>> hashmercado = new HashMap<Posicion, ArrayList<Jugador>>();
        ArrayList<Jugador> listaequipo = equipo.getJugadores();
        HashMap<String, Equipo> hashequipos =Temporada.getEquipos();
        ArrayList<Equipo> listaequipostotales = new ArrayList<Equipo>();
        listaequipostotales.addAll(hashequipos.values());
        ArrayList<Jugador> jugadorestotales = new ArrayList<Jugador>();
        for (int i=0; i<listaequipostotales.size(); i++){
            ArrayList<Jugador> jugadoresequipo = listaequipostotales.get(i).getJugadores();
            jugadorestotales.addAll(jugadoresequipo);
        }
        ArrayList<Jugador> listamercadoact = removerDuplicados(jugadorestotales, listaequipo);
        for (int i=0; i<listamercadoact.size(); i++){
            Jugador jugadoract = listamercadoact.get(i);
            if (hashmercado.containsKey(jugadoract.getPosicion())){
                ArrayList<Jugador> listaposicion = hashmercado.get(jugadoract.getPosicion());
                listaposicion.add(jugadoract);
            }
            else{
                ArrayList<Jugador> listanuevaposicion = new ArrayList<Jugador>();
                listanuevaposicion.add(jugadoract);
                hashmercado.put(jugadoract.getPosicion(), listanuevaposicion);
            }
        }
        return hashmercado;
    }
    public EquipoFantasia getEquipo(){
        return equipo;
    }
    public ArrayList<Jugador> removerDuplicados(ArrayList<Jugador> listamercadototal, ArrayList<Jugador> listaequipo){
            ArrayList<Jugador> listafinal = new ArrayList<Jugador>();
            listafinal.addAll(listamercadototal);
            listafinal.removeAll(listaequipo);
            return listafinal;
    }
}
