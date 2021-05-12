import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Test{
    public static void part1(){
        String value = "value";
        Random rand = new Random();
        MyHashMap<Integer,String> hashMap = new MyHashMap<>();
        System.out.println("Adding keys between 0-10: \n");

        for (int i = 0; i < 10; i++) {
            System.out.println("Key " + i + " added.");
            hashMap.put(i, value);
        }

        System.out.println("\nIterating through all elements with next(). (zero-parameter iterator constructor):");
        
        MyMapIterator<Integer> it = hashMap.mapIterator();
        while(it.hasNext()){
            System.out.print(it.next() + "\t");
        }

        System.out.println("\n\nprev:\t" + it.prev());
        for (int i = 0; i < 20; i++){
            if(i < 3) System.out.println("next:\t" + it.next());
            if(i > 3 && i < 18) System.out.println("prev:\t" + it.prev());
            if(i > 18 && i < 20 ) System.out.println("next:\t" + it.next());
        }

        System.out.println("\nIterating through all elements with next() starting from 3 (one parameter iterator constructor):");
        MyMapIterator<Integer> it2 = hashMap.mapIterator(3);
        while(it2.hasNext()){
            System.out.print(it2.next() + "\t");
        }

        System.out.println("\n\nprev:\t" + it2.prev());
        for (int i = 0; i < 20; i++){
            if(i < 3) System.out.println("next:\t" + it2.next());
            if(i > 3 && i < 18) System.out.println("prev:\t" + it2.prev());
            if(i > 18 && i < 20 ) System.out.println("next:\t" + it2.next());
        }

        System.out.println("\nIterating through all elements with next() starting from 12 (non-existing key):");
        MyMapIterator<Integer> it3 = hashMap.mapIterator(12);
        while(it3.hasNext()){
            System.out.print(it3.next() + "\t");
        }

        System.out.println("\n\nprev:\t" + it3.prev());
        for (int i = 0; i < 20; i++){
            if(i < 3) System.out.println("next:\t" + it3.next());
            if(i > 3 && i < 18) System.out.println("prev:\t" + it3.prev());
            if(i > 18 && i < 20 ) System.out.println("next:\t" + it3.next());
        }

        MyHashMap<Integer,String> hashMap2 = new MyHashMap<>();
        System.out.println("\n\nAdding 50 keys randomly between 0-250 to a new HashMap: \n");
        
        for (int i = 0; i < 50; i++) {
            int temp = rand.nextInt(250);
            //System.out.println("Key " + temp + " added.");
            hashMap2.put(temp, value);
        }

        System.out.println("\nIterating through all elements with next(). (zero-parameter iterator constructor):");
        
        it = hashMap2.mapIterator();
        while(it.hasNext()){
            System.out.print(it.next() + "\t");
        }

        System.out.println("\n\nprev:\t" + it.prev());
        for (int i = 0; i < 80; i++){
            if(i < 10) System.out.println("next:\t" + it.next());
            if(i > 10 && i < 58) System.out.println("prev:\t" + it.prev());
            if(i > 58 && i < 70 ) System.out.println("next:\t" + it.next());
        }

        Set<Integer> set = hashMap2.keySet();
        Integer[] arr = set.toArray(new Integer[0]);
        System.out.println("\nIterating through all elements with next() starting from " + arr[10]);
        it2 = hashMap2.mapIterator(arr[10]);
        while(it2.hasNext()){
            System.out.print(it2.next() + "\t");
        }

        System.out.println("\n\nprev:\t" + it2.prev());
        for (int i = 0; i < 80; i++){
            if(i < 10) System.out.println("next:\t" + it2.next());
            if(i > 10 && i < 58) System.out.println("prev:\t" + it2.prev());
            if(i > 58 && i < 70) System.out.println("next:\t" + it2.next());
        }

        System.out.println("\nIterating through all elements with next() starting from 500.(non-existing key)");
        it2 = hashMap2.mapIterator(500);
        while(it2.hasNext()){
            System.out.print(it2.next() + "\t");
        }

        System.out.println("\n\nprev:\t" + it2.prev());
        for (int i = 0; i < 80; i++){
            if(i < 10) System.out.println("next:\t" + it2.next());
            if(i > 10 && i < 58) System.out.println("prev:\t" + it2.prev());
            if(i > 58 && i < 70) System.out.println("next:\t" + it2.next());
        }
    }

    public static void part2(){
        CoalescedHashMap<Integer,String> coalesced = new CoalescedHashMap<>();
        String value = "value";
        
        System.out.println("\nDemonstration of how CoalescedHashMap works:");
        System.out.println("\nIs empty?\t" + coalesced.isEmpty());
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(12);
        temp.add(3);
        temp.add(2);
        temp.add(13);
        temp.add(24);
        System.out.println();
        
        for (int i = 0; i < temp.size(); i++) {
            try{
                System.out.println("Add " + temp.get(i));
                System.out.println("oldValue: " + coalesced.put(temp.get(i),value));
                System.out.println(coalesced.toString());
                System.out.println("size: " + coalesced.size() + "\n");
            }
            catch(NullPointerException e){
                System.err.println("Key or value can't be null.");
            }
        }

        try{
            System.out.println("Add 2: ");
            System.out.println("oldValue: " + coalesced.put(2,value));
            System.out.println(coalesced.toString());
            System.out.println("size: " + coalesced.size() + "\n");
            System.out.println("Add null: ");
            System.out.println("oldValue: " + coalesced.put(null,value));
            System.out.println(coalesced.toString());
            System.out.println("size: " + coalesced.size() + "\n");
        }
        catch(NullPointerException e){
            System.err.println("Key or value can't be null.\n");
        }

        coalesced.remove(13);
        System.out.println("Remove 13:");
        System.out.println(coalesced.toString());
        System.out.println("size: " + coalesced.size() + "\n");
        coalesced.remove(12);
        System.out.println("Remove 12:");
        System.out.println(coalesced.toString());
        System.out.println("size: " + coalesced.size() + "\n");
        System.out.println("Is empty?\t" + coalesced.isEmpty() + "\n");

        for (int i = 0; i < temp.size(); i++){
            System.out.println("Get value of key " + temp.get(i) + ":\t" + coalesced.get(temp.get(i)));
        }
        
        System.out.println("Get value of key 15:\t" + coalesced.get(15));
        System.out.println("Get value of key 7:\t" + coalesced.get(7));

        CoalescedHashMap<Integer,String> coalescedHash = new CoalescedHashMap<>();
        LinkedHashMap<Integer,String> linkedHash = new LinkedHashMap<>();
        TreeHashMap<Integer,String> treeHash = new TreeHashMap<>();
        ArrayList<Integer> keysListC = new ArrayList<>();
        ArrayList<Integer> keysListL = new ArrayList<>();
        ArrayList<Integer> keysListT = new ArrayList<>();
        
        System.out.println("\n\nRUNTIME COMPARISONS OF HASHMAPS WITH 1000 DATA\n\n");
        System.out.println("\nIs Empty?:\n\nLinkedHashMap: " + linkedHash.isEmpty() + "\nTreeHashMap: " + treeHash.isEmpty() + "\nCoalescedHashMap: " + coalescedHash.isEmpty());
        Random rand = new Random();
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            int key = rand.nextInt(50000);
            linkedHash.put(key, value);
            keysListL.add(key);
        }

        long end = System.currentTimeMillis();
        long linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            int key = rand.nextInt(50000);
            treeHash.put(key, value);
            keysListT.add(key);
        }

        end = System.currentTimeMillis();
        long treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            int key = rand.nextInt(50000);
            coalescedHash.put(key, value);
            keysListC.add(key);
        }

        end = System.currentTimeMillis();
        long coalTime = end-start;

        System.out.println("\nPut method results(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);
        System.out.println("\n\nSize:\nLinkedHashMap: " + linkedHash.size() + "\nTreeHashMap: " + treeHash.size() + "\nCoalescedHashMap: " + coalescedHash.size());
        System.out.println("\n\nIs Empty?:\nLinkedHashMap: " + linkedHash.isEmpty() + "\nTreeHashMap: " + treeHash.isEmpty() + "\nCoalescedHashMap: " + coalescedHash.isEmpty());
        
        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            linkedHash.get(keysListL.get(i));
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            treeHash.get(keysListT.get(i));
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            coalescedHash.get(keysListC.get(i));
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nGet method results with existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        start = System.currentTimeMillis();
        
        for (int i = 50000; i < 51000; i++) {
            linkedHash.get(i);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 50000; i < 51000; i++) {
            treeHash.get(i);
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 50000; i < 51000; i++) {
            coalescedHash.get(i);
        }


        end = System.currentTimeMillis();
        coalTime = end-start;

        System.out.println("\n\nGet method results with non-existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);
        
        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            linkedHash.remove(keysListL.get(i));
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            treeHash.remove(keysListT.get(i));
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 1000; i++) {
            coalescedHash.remove(keysListC.get(i));
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nRemove method results with existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        start = System.currentTimeMillis();
        
        for (int i = 50000; i < 51000; i++) {
            linkedHash.remove(i);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 50000; i < 51000; i++) {
            treeHash.remove(i);
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 50000; i < 51000; i++) {
            coalescedHash.remove(i);
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nRemove method results with non-existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        CoalescedHashMap<Integer,String> coalescedHash2 = new CoalescedHashMap<>();
        LinkedHashMap<Integer,String> linkedHash2 = new LinkedHashMap<>();
        TreeHashMap<Integer,String> treeHash2 = new TreeHashMap<>();
        ArrayList<Integer> keysListC2 = new ArrayList<>();
        ArrayList<Integer> keysListL2 = new ArrayList<>();
        ArrayList<Integer> keysListT2 = new ArrayList<>();
        System.out.println("\n\nRUNTIME COMPARISONS OF HASHMAPS WITH 10000 DATA\n\n");
        System.out.println("\nIs Empty?:\n\nLinkedHashMap: " + linkedHash2.isEmpty() + "\nTreeHashMap: " + treeHash2.isEmpty() + "\nCoalescedHashMap: " + coalescedHash2.isEmpty());
        rand = new Random();

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            int key = rand.nextInt(500000);
            linkedHash2.put(key, value);
            keysListL2.add(key);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            int key = rand.nextInt(500000);
            treeHash2.put(key, value);
            keysListT2.add(key);
        }

        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            int key = rand.nextInt(500000);
            coalescedHash2.put(key, value);
            keysListC2.add(key);
        }

        end = System.currentTimeMillis();
        coalTime = end-start;

        System.out.println("\nPut method results(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);
        System.out.println("\n\nSize:\nLinkedHashMap: " + linkedHash2.size() + "\nTreeHashMap: " + treeHash2.size() + "\nCoalescedHashMap: " + coalescedHash2.size());
        System.out.println("\n\nIs Empty?:\nLinkedHashMap: " + linkedHash2.isEmpty() + "\nTreeHashMap: " + treeHash2.isEmpty() + "\nCoalescedHashMap: " + coalescedHash2.isEmpty());
        
        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            linkedHash2.get(keysListL2.get(i));
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            treeHash2.get(keysListT2.get(i));
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            coalescedHash2.get(keysListC2.get(i));
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nGet method results with existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        start = System.currentTimeMillis();
        
        for (int i = 500000; i < 510000; i++) {
            linkedHash2.get(i);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 500000; i < 510000; i++) {
            treeHash2.get(i);
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 500000; i < 510000; i++) {
            coalescedHash2.get(i);
        }


        end = System.currentTimeMillis();
        coalTime = end-start;

        System.out.println("\n\nGet method results with non-existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);
        
        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            linkedHash2.remove(keysListL2.get(i));
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            treeHash2.remove(keysListT2.get(i));
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 10000; i++) {
            coalescedHash2.remove(keysListC2.get(i));
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nRemove method results with existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        start = System.currentTimeMillis();
        
        for (int i = 500000; i < 510000; i++) {
            linkedHash2.remove(i);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 500000; i < 510000; i++) {
            treeHash2.remove(i);
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 500000; i < 510000; i++) {
            coalescedHash2.remove(i);
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nRemove method results with non-existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        CoalescedHashMap<Integer,String> coalescedHash3 = new CoalescedHashMap<>();
        LinkedHashMap<Integer,String> linkedHash3 = new LinkedHashMap<>();
        TreeHashMap<Integer,String> treeHash3 = new TreeHashMap<>();
        ArrayList<Integer> keysListC3 = new ArrayList<>();
        ArrayList<Integer> keysListL3 = new ArrayList<>();
        ArrayList<Integer> keysListT3 = new ArrayList<>();
        System.out.println("\n\nRUNTIME COMPARISONS OF HASHMAPS WITH 100000 DATA\n\n");
        System.out.println("\nIs Empty?:\n\nLinkedHashMap: " + linkedHash3.isEmpty() + "\nTreeHashMap: " + treeHash3.isEmpty() + "\nCoalescedHashMap: " + coalescedHash3.isEmpty());
        rand = new Random();

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            int key = rand.nextInt(5000000);
            linkedHash3.put(key, value);
            keysListL3.add(key);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            int key = rand.nextInt(5000000);
            treeHash3.put(key, value);
            keysListT3.add(key);
        }

        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            int key = rand.nextInt(5000000);
            coalescedHash3.put(key, value);
            keysListC3.add(key);
        }

        end = System.currentTimeMillis();
        coalTime = end-start;

        System.out.println("\nPut method results(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);
        System.out.println("\n\nSize:\nLinkedHashMap: " + linkedHash3.size() + "\nTreeHashMap: " + treeHash3.size() + "\nCoalescedHashMap: " + coalescedHash3.size());
        System.out.println("\n\nIs Empty?:\nLinkedHashMap: " + linkedHash3.isEmpty() + "\nTreeHashMap: " + treeHash3.isEmpty() + "\nCoalescedHashMap: " + coalescedHash3.isEmpty());
        
        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            linkedHash3.get(keysListL3.get(i));
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            treeHash3.get(keysListT3.get(i));
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            coalescedHash3.get(keysListC3.get(i));
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nGet method results with existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        start = System.currentTimeMillis();
        
        for (int i = 5000000; i < 5100000; i++) {
            linkedHash3.get(i);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 5000000; i < 5100000; i++) {
            treeHash3.get(i);
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 5000000; i < 5100000; i++) {
            coalescedHash3.get(i);
        }


        end = System.currentTimeMillis();
        coalTime = end-start;

        System.out.println("\n\nGet method results with non-existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);
        
        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            linkedHash3.remove(keysListL3.get(i));
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            treeHash3.remove(keysListT3.get(i));
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) {
            coalescedHash3.remove(keysListC3.get(i));
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nRemove method results with existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);

        start = System.currentTimeMillis();
        
        for (int i = 5000000; i < 5100000; i++) {
            linkedHash3.remove(i);
        }

        end = System.currentTimeMillis();
        linkedTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 5000000; i < 5100000; i++) {
            treeHash3.remove(i);
        }


        end = System.currentTimeMillis();
        treeTime = end-start;

        start = System.currentTimeMillis();
        
        for (int i = 5000000; i < 5100000; i++) {
            coalescedHash3.remove(i);
        }


        end = System.currentTimeMillis();
        coalTime = end-start;
        
        System.out.println("\n\nRemove method results with non-existing values(ms):\n\nLinkedHashMap: " + linkedTime + "\nTreeHashMap: " + treeTime + "\nCoalescedHashMap: " + coalTime);
    }
    public static void main(String[] args) {
        System.out.println("\n\n----------PART1----------\n\n");
        part1();
        System.out.println("\n\n----------PART2----------\n\n");
        part2();
    }
}
