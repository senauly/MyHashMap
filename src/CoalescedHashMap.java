/**
 * CoalescedHashMap Class which is using Coalesced hashing technique.
 * @author Sena Ulukaya
 */
public class CoalescedHashMap<K,V> implements KWHashMap<K,V>{

    private Entry<K,V>[] table;
    private int numKeys;
    private static final int CAPACITY = 11;
    private static final double LOAD_THRESHOLD = 0.5;
    
    /**
     * Initialize the table with the initial capacity.
     */
    @SuppressWarnings("unchecked")
    public CoalescedHashMap(){
        table = new Entry[CAPACITY];
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

        while(table[index] != null){
            if(table[index].getKey().equals(key)) return table[index].getValue();
            if(table[index].nextIndex != null) index = table[index].nextIndex;
            else if(table[index].nextIndex == null) break;
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
        if (table[index] != null){
            int oldIndex = index;
            int k = -1;
            while(table[index] != null){
                k+=2;
                index = (index + k) % table.length;
            }

            while(table[oldIndex] != null){
                if(table[oldIndex].getKey().equals(key)){
                    V oldVal = table[oldIndex].getValue();
                    table[oldIndex].setValue(value);
                    return oldVal;
                }

                if(table[oldIndex].nextIndex != null){
                    oldIndex = table[oldIndex].nextIndex;
                }
                
                else if(table[oldIndex].nextIndex == null) break;
            }
            
            table[index] = new Entry<>(key, value);
            table[oldIndex].nextIndex = Integer.valueOf(index);
        }
        
        else table[index] = new Entry<>(key, value);
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
        
        int removed = -1;
        int prev = -1;

        while(table[index] != null){
            if(table[index].getKey().equals(key)) {
                removed = index;
            }
            if(table[index].nextIndex != null){
                prev = index;
                index = table[index].nextIndex;
            }
            else if(table[index].nextIndex == null) break;
        }
        
        V oldVal = null;
        if(removed == -1) return null;
        
                
        if(table[removed].nextIndex == null){
            oldVal = table[removed].getValue();
            table[removed] = null;
            if(prev != -1) table[prev].nextIndex = null;
        }
        
        else{
            oldVal = table[removed].getValue();
            Entry<K,V> temp = table[table[removed].nextIndex];
            table[table[removed].nextIndex] = null;
            table[removed] = temp;
        }
        
        numKeys--;
        return oldVal;
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
        Entry<K,V>[] copy = table;
        table = new Entry[2*copy.length+1];
        numKeys = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != null) {
                this.put(copy[i].key, copy[i].value);
            }
        }
    }

    /**
     * Displays table index no, key and next.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
           if(table[i] != null) sb.append(i + ") " + table[i].toString() + "\n");
        }

        return sb.toString();
    }

    /** Contains key-value pairs for a hash table. */
    private static class Entry<K,V> {
        private K key;
        private V value;
        private Integer nextIndex = null;

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

        /**
         * Displays key and next.
         */
        @Override
        public String toString(){
            return("Key: " + getKey() + "\tNext: " + nextIndex);
        }
    }
}
