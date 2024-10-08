package Recursion;

public class PatternQtns {

//    1]

    /*

    * * * *
    * * *
    * *
    *

     */

    public static void printPattern(int row,int col) { // since i general we have used 2 nested for loops we are using 2 variables as parameters

        // using nested for loops

//        for(int i=0;i<4;i++){
//            for(int j=0;j<4-i;j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }



        if(row==0){ // base condition
            return;
        }

        if(col<row){
            System.out.print("* ");
            printPattern(row,col+1); // col will go from 0 to row number, ie 4 times for row=4 :- (0,1,2,3);
        }
        else{
            System.out.println();
            printPattern(row-1,0); // for printing next row pattern
        }

    }

    public static void main(String[] args) {
        printPattern(4,0);
    }
}
