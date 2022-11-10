package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana {

    // public static void main(String[] args) {

    public void MiVentana() {

        JFrame frame = new JFrame();
        frame.setTitle("Prueba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.getContentPane().setBackground(new Color(16, 254, 146)); // 10fe92
        ImageIcon logo = new ImageIcon(System.getProperty("user.dir") + "/data/Fotos/logoPrueba.png");
        frame.setIconImage(logo.getImage());

    }

}
