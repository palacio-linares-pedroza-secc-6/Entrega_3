import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class DataDam {

    public void archivoParticipantes()

    {

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
