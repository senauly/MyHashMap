import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedHashMap Class which is hashing by using linked lists to chain items on the same table slot.
 */

 public class LinkedHashMap<K,V> implements KWHashMap<K,V>{

    private LinkedList<Entry<K,V>>[] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    /**
     * Initialize the table with the initial capacity.
     */
    @SuppressWarnings("unchecked")
    public LinkedHashMap(){
        table = new LinkedList[CAPACITY];
    }

    /** Get value.
     * @param key The key 
     * @return The value of this key if exist; otherwise, null.
    */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) return null;
    
        for (Entry<K,V> nextItem : table[index]) {
            if (nextItem.key.equals(key)) return nextItem.value;
        }

        return null;
    }

    /** Put the key-value pair into the HashMap. If the key is already in the table, its value is changed to the argument value and numKeys is not changed.
     * @param key The key
     * @param value The value for this key
     * @return The value of this key if exist; otherwise, null.
     * @throws NullPointerException if key or value is null.
    */
    @Override
    public V put(K key, V value) {
        if(key == null || value == null) throw new NullPointerException();
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) table[index] = new LinkedList<>();

        for (Entry<K,V> nextItem : table[index]) {
            if (nextItem.key.equals(key)) {
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }

        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) rehash();
        return null;
    }

    /**
     * Remove the entry with the given key
     * @param key to remove
     * @return oldValue if exist, otherwise null.
     */
    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) return null;

        Iterator<Entry<K,V>> it = table[index].iterator();
        while(it.hasNext()){
            Entry<K,V> temp = it.next();
            if (temp.getKey().equals(key)) {
                V oldVal = temp.getValue();
                it.remove();
                if(table[index].isEmpty()) table[index] = null;
                numKeys--;
                return oldVal;
            }
        }

        return null;
    }

    /**
     * Get the size.
     * @return size
     */
    @Override
    public int size() {
        return numKeys;    
    }

    /**
     * Check if hashMap is empty or not.
     * @return true if empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return(numKeys == 0);
    }

    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD.
     */
    @SuppressWarnings("unchecked")
    private void rehash(){
        LinkedList<Entry<K,V>>[] copy = table;
        table = new LinkedList[2*copy.length+1];
        numKeys = 0;
        
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != null) {
                for (Entry<K,V> nextEntry : copy[i]) {
                    put(nextEntry.key, nextEntry.value);
                }
            }
        }
    }

    /** Contains key-value pairs for a hash table. */
    private static class Entry < K, V > {
        private K key;
        private V value;

        /** Creates a new key-value pair.
         * @param key The key
         * @param value The value
        */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         * @return The key
        */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         * @return The value
        */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         * @param val The new value
         * @return The old value
        */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }
    
}
