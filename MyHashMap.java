import java.util.HashMap;
/**
 * MyHashMap class extends HashMap and has a custom iterator class MapIterator to iterate through the keys in a HashMap.
 * @author Sena Ulukaya
 */

 public class MyHashMap<K,V> extends HashMap<K,V>{
    
    /**
     * Creates a new map iterator object.
     * @return the new map iteator.
     */
    public MapIterator mapIterator(){
        return new MapIterator();
    }
    
    /**
     * Inner private class for the custom HashMap iterator.
     */
    private class MapIterator{
        
        /**
         * The iterator starts from any key in the Map when the starting key is not specified.
         */
        public MapIterator(){
            //TODO
        }

        /**
         * The iterator starts from the given key and iterates through all the keys in the Map.
         * @param key is starting key.
         */
        public MapIterator(K key){
            //TODO
        }
        
        /**
         * The function returns the next key in the Map. It returns the first key when there is no not-iterated key in the Map.
         * @return next key
         */
        public K next(){
            //TODO
        }

        /**
         * The iterator points to the previous key in the Map. It returns the last key when the iterator is at the first key.
         * @return previous key
         */
        public K prev(){
            //TODO
        }

        /**
         * Checks if there's a next key.
         * @return True if there are still not-iterated keys in the Map, otherwise returns False.
         */
        public boolean hasNext(){

        }
        
        /**
         * Checks if there's a previous key.
         * @return True if there are still not-iterated keys in the Map, otherwise returns False.
         */
        public boolean hasPrev(){

        }


    }

    
}