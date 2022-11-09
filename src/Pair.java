public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    /**
     * Retorna el primer valor de la pareja
     * @return El primer valor de la pareja, null si no hay nada
     */
    public K getKey() {
        return key;
    }
    /**
     * Retorna el segundo valor de la pareja
     * @return El segundo valor de la pareja, null si no hay nada
     */
    public V getValue() {
        return value;
    }
}
