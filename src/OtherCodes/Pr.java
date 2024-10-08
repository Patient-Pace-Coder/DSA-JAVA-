package OtherCodes;

import java.util.*;

public class Pr {

    public static long nearlySimilarRectangles(List<List<Long>> sides) {
        // Write your code here

        int count = 0;
        for( int i = 0; i < sides.size(); i++ ){
            for( int j = i + 1; j < sides.size(); j++ ){
                // if( (sides.get(i).get(0)/sides.get(j).get(0)) == (sides.get(i).get(1)/sides.get(j).get(1)) ){ // it will loose precision
                //     count++;
                // }
                if (sides.get(i).get(0) * sides.get(j).get(1) == sides.get(i).get(1) * sides.get(j).get(0)) { // this will work i.e. instead of checking a/b == c/d we check for a*d = c*b
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {

        List<List<Long>> sides = new ArrayList<>();
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(1L);
        List<Long> list1 = new ArrayList<>();
        list1.add(10L);
        list1.add(7L);
        List<Long> list3 = new ArrayList<>();
        list3.add(9L);
        list3.add(6L);
        List<Long> list4 = new ArrayList<>();
        list4.add(6L);
        list4.add(9L);
        List<Long> list5 = new ArrayList<>();
        list5.add(7L);
        list5.add(3L);
        sides.add(list);
        sides.add(list1);
        sides.add(list3);
        sides.add(list4);
        sides.add(list5);
        System.out.println(nearlySimilarRectangles(sides));
    }
}
