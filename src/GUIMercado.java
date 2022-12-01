import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class GUIMercado extends JFrame implements ActionListener {
    Ventana frame;
    JScrollPane mostron;
    JButton volver;
    JButton comprar;
    JLabel presupuesto;
    JLabel delanteros;
    JLabel medioCampos;
    JLabel defensas;
    JLabel porteros;
    JComboBox posiciones;
    JList playerList;
    Mercado mercado = Aplicacion.temporadaActual.getMercado();
    JPanel jugadoresMenu;
    JScrollPane jcp = new JScrollPane();
    EquipoFantasia equipoFantasia = Aplicacion.user.getEquipo();

    public GUIMercado() {

        JPanel titulo = new JPanel();
        titulo.setBackground(new Color(25, 24, 55, 255));
        titulo.setPreferredSize(new Dimension(0, 85));
        titulo.setBorder(BorderFactory.createEtchedBorder());

        JPanel menu = new JPanel();
        menu.setBackground(new Color(25, 24, 55, 255));
        menu.setLayout(new GridLayout(4, 3, 20, 20));
        menu.setBorder(BorderFactory.createEtchedBorder());

        jugadoresMenu = new JPanel();
        jugadoresMenu.setBackground(new Color(25, 24, 55, 255));
        jugadoresMenu.setPreferredSize(new Dimension(450, 100));
        jugadoresMenu.setLayout(new GridLayout(1, 1));

        JPanel menuOpciones = new JPanel();
        menuOpciones.setBackground(new Color(25, 24, 55, 255));
        menuOpciones.setPreferredSize(new Dimension(350, 100));
        menuOpciones.setLayout(new GridLayout(7, 1, 5, 5));

        JPanel vacioS = new JPanel();
        vacioS.setBackground(new Color(7, 7, 33, 255));
        vacioS.setPreferredSize(new Dimension(0, 65));

        // Creacion de texto

        JLabel tituloTxt = new JLabel();
        tituloTxt.setText("Mercado");
        tituloTxt.setFont(new Font("Times New Roman", Font.PLAIN, 55));
        tituloTxt.setForeground(Color.WHITE);
        tituloTxt.setAlignmentX(Component.CENTER_ALIGNMENT);

        presupuesto = new JLabel();
        presupuesto.setText("Faltan : " + Integer.toString(equipoFantasia.getPresupuesto()) + "$");
        presupuesto.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        presupuesto.setForeground(Color.WHITE);
        presupuesto.setAlignmentX(Component.CENTER_ALIGNMENT);

        delanteros = new JLabel();
        String cantidadDelantero = new String();
        try {
            cantidadDelantero = Integer
                    .toString(2 - equipoFantasia.getJugadoresPosicion(Posicion.DELANTERO).size());
        } catch (Exception e) {

            cantidadDelantero = "3";

        }
        delanteros.setText("Delanteros que faltan : " + cantidadDelantero);
        delanteros.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        delanteros.setForeground(Color.WHITE);

        medioCampos = new JLabel();
        String cantidadMedioCampos = new String();
        try {
            cantidadMedioCampos = Integer
                    .toString(2 - equipoFantasia.getJugadoresPosicion(Posicion.MEDIOCAMPISTA).size());
        } catch (Exception e) {

            cantidadMedioCampos = "5";

        }
        medioCampos.setText("Medios que faltan : " + cantidadMedioCampos);
        medioCampos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        medioCampos.setForeground(Color.WHITE);

        defensas = new JLabel();
        String cantidadDefensas = new String();
        try {
            cantidadDefensas = Integer
                    .toString(2 - equipoFantasia.getJugadoresPosicion(Posicion.DEFENSA).size());
        } catch (Exception e) {

            cantidadDefensas = "5";

        }
        defensas.setText("Defensas que faltan : " + cantidadDefensas);
        defensas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        defensas.setForeground(Color.WHITE);

        porteros = new JLabel();
        String cantidadPortero = new String();
        try {
            cantidadDefensas = Integer
                    .toString(2 - equipoFantasia.getJugadoresPosicion(Posicion.PORTERO).size());
        } catch (Exception e) {

            cantidadPortero = "2";

        }
        porteros.setText("Porteros que faltan : " + cantidadPortero);
        porteros.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        porteros.setForeground(Color.WHITE);

        // JComboBox

        Posicion[] posicionesList = { Posicion.PORTERO, Posicion.DEFENSA, Posicion.MEDIOCAMPISTA, Posicion.DELANTERO };
        posiciones = new JComboBox(posicionesList);
        posiciones.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Jugador> jugadores = mercado.getJugadoresporPosicion((Posicion) posiciones.getSelectedItem());
                String[] list = new String[jugadores.size()];

                for (int a = 0; a < jugadores.size(); a++) {
                    Jugador jugador = jugadores.get(a);
                    String nombre = jugador.getNombre();
                    String equipoShort = jugador.getEquipo().getNombreShort();
                    int valor = jugador.getValor();
                    list[a] = (nombre + "/" + equipoShort + "/" + valor);
                }

                playerList = new JList<String>(list);
                playerList.setVisibleRowCount(12);
                jugadoresMenu.remove(jcp);
                jcp = new JScrollPane(playerList);
                jugadoresMenu.add(jcp);

            }
        });

        comprar = new JButton("Comprar");
        comprar.setFocusable(false);
        comprar.setBackground(new Color(37, 32, 70, 255));
        comprar.setBorder(BorderFactory.createEtchedBorder());
        comprar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        comprar.setForeground(Color.WHITE);
        comprar.addActionListener(this);
        comprar.setPreferredSize(new Dimension(85, 35));

        volver = new JButton("Volver");
        volver.setFocusable(false);
        volver.setBackground(new Color(37, 32, 70, 255));
        volver.setBorder(BorderFactory.createEtchedBorder());
        volver.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        volver.setForeground(Color.WHITE);
        volver.addActionListener(this);
        volver.setPreferredSize(new Dimension(100, 50));

        frame = new Ventana();

        titulo.add(tituloTxt);
        menuOpciones.add(presupuesto);
        menuOpciones.add(posiciones);
        menuOpciones.add(comprar);
        menuOpciones.add(delanteros);
        menuOpciones.add(medioCampos);
        menuOpciones.add(defensas);
        menuOpciones.add(porteros);

        vacioS.add(volver);
        jugadoresMenu.add(jcp);

        frame.add(titulo, BorderLayout.NORTH);
        frame.add(jugadoresMenu, BorderLayout.WEST);
        frame.add(menuOpciones, BorderLayout.EAST);
        frame.add(vacioS, BorderLayout.SOUTH);

        // frame.add(menu, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == comprar) {

            int index = playerList.getSelectedIndex();
            String jugador = (String) playerList.getSelectedValue();
            jugador = jugador.split("/")[0];
            Posicion pos = (Posicion) posiciones.getSelectedItem();
            Jugador jugadorCompra = mercado.getJugadoresporPosicion(pos).get(index);

            if (equipoFantasia.getJugadores().contains(jugadorCompra)) {
                JOptionPane.showMessageDialog(null, "Ya contiene ese jugador en su equipo", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else if (equipoFantasia.getPresupuesto() < jugadorCompra.getValor()) {
                JOptionPane.showMessageDialog(null, "No tiene el presupuesto para comprar ese jugador", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else if (pos.equals(Posicion.PORTERO)) {
                if (equipoFantasia.getJugadoresPosicion(Posicion.PORTERO).isEmpty()) {
                    System.out.println(pos);
                }

            } else if (equipoFantasia.getJugadoresPosicion(Posicion.PORTERO).size() == 2) {
                JOptionPane.showMessageDialog(null, "No puede tener mas de dos porteros en tu equipo",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                Aplicacion.user.comprarJugador(jugadorCompra);
                presupuesto.setText("Faltan : " + Integer.toString(equipoFantasia.getPresupuesto()) + "$");
                System.out.println(pos);
                if (pos.equals(Posicion.PORTERO)) {
                    System.out.println(equipoFantasia.getJugadoresPosicion(Posicion.PORTERO).size() + "Antes del if");
                    if (equipoFantasia.getJugadoresPosicion(Posicion.PORTERO).size() <= 2) {
                        System.out.println(equipoFantasia.getJugadoresPosicion(Posicion.PORTERO).size());
                        porteros.setText("Porteros que faltan : " + Integer
                                .toString(2 - equipoFantasia.getJugadoresPosicion(Posicion.PORTERO).size()));

                    }
                }

            }
        }

        else if (e.getSource() == volver) {
            frame.dispose();
            new GUIParticipante(Aplicacion.user.getNombre());
        }

    }

}
