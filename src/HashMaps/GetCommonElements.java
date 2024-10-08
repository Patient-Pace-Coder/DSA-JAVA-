package HashMaps;

import java.util.HashMap;

public class GetCommonElements {

    /*

    we are given two arrays a1,a2 . we have to print common elements
    which are in both arrays and the order of the elements should be in the order of appearing of elements in a2,

    Approach :

    1] we first create a frequency map for elements in array1
    2] then we compare the elements in array2 with that of in map :
            if element exist in map :
                print it, and remove the element from map.
            else :
                ignore it.
    */

    private static void getCommonElement( int arr1[], int arr2[] ){

        HashMap< Integer , Integer > map = new HashMap<>();

        for( int i = 0; i < arr1.length ; i++ ){

            if( map.containsKey(arr1[i]) ){
                int ch = map.get(arr1[i]);
                map.put(arr1[i],ch + 1);
            }
            else{
                map.put(arr1[i],1);
            }
        }

        for( int i = 0; i < arr2.length; i++ ){

            if( map.containsKey(arr2[i]) ){
                System.out.print(arr2[i]+" ");
                map.remove(arr2[i]);
            }
        }
    }

    public static void main(String[] args) {

        int arr1[] = {1,1,2,3,4,4,6,6};
        int arr2[] = {1,2,3,4,5,6,7};

        getCommonElement(arr1,arr2);
    }
}
