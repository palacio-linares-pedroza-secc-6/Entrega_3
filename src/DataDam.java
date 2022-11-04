import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class DataDam {

    public void creatFilesUsuarios() throws FileNotFoundException {

        File fileParticipantes = new File(System.getProperty("user.dir") + "/data/usuarios/participantes.csv");
        File fielAdmin = new File(System.getProperty("user.dir") + "/data/usuarios/administradores.csv");

        if (!fileParticipantes.exists()) {

            PrintWriter out = new PrintWriter(fileParticipantes);
            out.printf("%s,%s\n", "Nombre", "Contrasena");
            out.close();
        }

        if (!fielAdmin.exists()) {

            PrintWriter out = new PrintWriter(fielAdmin);
            out.printf("%s,%s\n", "Nombre", "Contrasena");
            out.close();
        }

    }

    public void addParticipante(String nombre, String contrasena) throws IOException {
        File fileParticipantes = new File(System.getProperty("user.dir") + "/data/usuarios/participantes.csv");

        Writer out = new BufferedWriter(new FileWriter(fileParticipantes, true));
        out.append(nombre + "," + contrasena + "\n");
        out.close();
    }

    public void addAdministrador(String nombre, String contrasena) throws IOException {
        File fileAdministrador = new File(System.getProperty("user.dir") + "/data/usuarios/administradores.csv");

        Writer out = new BufferedWriter(new FileWriter(fileAdministrador, true));
        out.append(nombre + "," + contrasena + "\n");
        out.close();
    }

    public void loadUsuarios() throws IOException {

        Scanner scanner = new Scanner(
                new FileReader(System.getProperty("user.dir") + "/data/usuarios/participantes.csv"));
        String linea = scanner.nextLine();
        while (scanner.hasNextLine()) {
            linea = scanner.nextLine();
            String[] info = linea.split(",");
            Aplicacion.reCrearUsuarios(info[0], info[1], Tipo_Usuario.PARTICIPANTE);
        }
        scanner = new Scanner(
                new FileReader(System.getProperty("user.dir") + "/data/usuarios/administradores.csv"));
        linea = scanner.nextLine();
        while (scanner.hasNextLine()) {
            linea = scanner.nextLine();
            String[] info = linea.split(",");
            Aplicacion.reCrearUsuarios(info[0], info[1], Tipo_Usuario.ADMINISTRADOR);
        }

    }

    public void cargarTemporada(String fileTemporada) throws FileNotFoundException {
        Scanner scanner = new Scanner(
                new FileReader(System.getProperty("user.dir") + "/Entrega_3/data/" + fileTemporada + ".csv"));
        String linea = scanner.nextLine();
        while (scanner.hasNextLine()) {
            linea = scanner.nextLine();
            String[] info = linea.split(";");
            String fecha = info[0];
        }

    }

}
