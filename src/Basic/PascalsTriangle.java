package Basic;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /*

               1
              1 1
             1 2 1
            1 3 3 1
           1 4 6 4 1
     */

    private static List<Integer> pascalsTriangle(int num ){

        ArrayList<ArrayList<Integer>> allRows = new ArrayList<>();
        for( int i = 0; i < num; i++ ){
            ArrayList<Integer> currRow = new ArrayList<>();
            for( int j = 1; j <= i + 1; j++ ){
                if( i == 0 ){
                    currRow.add(1);
                    break;
                }
                if( j == 1 ){
                    currRow.add(1);
                }
                else if( j == i + 1 ){
                    currRow.add(1);
                }
                else{
                    ArrayList<Integer> prevRow = allRows.get(i - 1);
                    currRow.add( prevRow.get(j - 2) + prevRow.get(j - 1) );
                }
            }
            allRows.add(currRow);
        }

        System.out.println(allRows); //debugging

        return allRows.get(num - 1);
    }

    public static void main(String[] args) {

        int num = 5;

        List<Integer> res = pascalsTriangle(num);
        System.out.println(res);
    }
}
