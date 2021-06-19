import java.util.HashMap;
import java.util.Set;
/**
 * MyHashMap class extends HashMap and has a custom iterator class MapIterator to iterate through the keys in a HashMap.
 * @author Sena Ulukaya
 */

 public class MyHashMap<K,V> extends HashMap<K,V>{
    
    /**
     * Creates a new map iterator object.
     * @return the new map iteator.
     */
    public MapIterator mapIterator(K key){
        return new MapIterator(key);
    }

    public MapIterator mapIterator(){
        return new MapIterator();
    }
    
    /**
     * Inner private class for the custom HashMap iterator.
     */
    private class MapIterator implements MyMapIterator<K>{
        private K nextKey = null;
        private K prevKey = null;
        private Set<K> keys = keySet();
        private K firstKey = null;
        private K lastKey = null;
        private K[] arr = null;
        int index = 0;
        int count = 0;
        
        /**
         * The iterator starts from any key in the Map when the starting key is not specified.
         */

        @SuppressWarnings("unchecked")
        public MapIterator(){
            nextKey = null;
            prevKey = null;
            arr = (K[]) keys.toArray();
            firstKey = arr[0];
            lastKey = arr[size()-1];
        }

        /**
         * The iterator starts from the given key and iterates through all the keys in the Map.
         * @param key is starting key.
         */
        public MapIterator(K key){
            this();
            
            int temp = -1;
            for (int i = 0; i < size(); i++){
                if(arr[i] == key){
                    temp = i;
                    break;
                }
            }

            if(temp != -1){
                firstKey = arr[temp];
                lastKey = arr[temp-1];
                index = temp;
            }
        }
        
        /**
         * The function returns the next key in the Map. It returns the first key when there is no not-iterated key in the Map.
         * @return next key
         */
        public K next(){
            
            if(count >= size()){
                nextKey = firstKey;
            }
            
            else{
                index = index % size();
                nextKey = arr[index];
                index++;
                count++;
            }
            
            return(nextKey);
        }

        /**
         * The iterator points to the previous key in the Map. It returns the last key when the iterator is at the first key.
         * @return previous key
         */
        public K prev(){
            if(count < 1){
                prevKey = lastKey;
            }
            
            else{
                index--;
                count--;
                if(index < 0) index = size() -1;
                prevKey = arr[index];
            }

            return(prevKey);
        }

        /**
         * Checks if there's a next key.
         * @return True if there are still not-iterated keys in the Map, otherwise returns False.
         */
        public boolean hasNext(){
            return(count < size());
        }
    }
}