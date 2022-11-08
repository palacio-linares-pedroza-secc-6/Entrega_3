import java.util.Comparator;

public class Comparador implements Comparator<Pair<Integer, Object>> {

    @Override
    public int compare(Pair<Integer, Object> jug1, Pair<Integer, Object> jug2) {

        if (jug1.getKey() < jug2.getKey()) {
            return 1;
        }

        else if (jug1.getKey() > jug2.getKey()) {
            return -1;
        }
        return 0;
    }

}
