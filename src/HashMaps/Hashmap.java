package HashMaps;

import java.util.HashMap;

public class Hashmap {

//    private static int countFrequency( int[] arr, int target ){
//
//
//    }


    public static void main(String[] args) {

        HashMap< String , Integer > map = new HashMap<>();

        map.put("Rahul",20);
        map.put("Rakesh",23);
        map.put("Madhu",26);

        System.out.println(map.keySet());
        System.out.println(map.entrySet());
//        System.out.println(map.values());

        
    }
}
