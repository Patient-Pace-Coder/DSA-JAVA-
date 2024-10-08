package Graphs;

import java.util.ArrayList;

// This program is to understand the implementation of graph which is based on Array of ArrayList's.


public class Practice {

    class Names { // Names class

        String fName; // properties
        String lName; // properties

        public Names(String fname, String lname ){ // constructor

            this.fName=fname;
            this.lName=lname;
        }
    }

    public void createBox(ArrayList<Names> box[]){ // behaviour of OtherCodes.Practice class

        for(int i=0;i<box.length;i++){ // if this is not Written, as box is empty (i.e. without any Arraylists ) , we will get NullPointerException.

            box[i] = new ArrayList<>();
        }

/*      after above loop ,

        box would look like :

        [ { } , { } ] , where {} are ArrayList1 and Arraylist2.

 */


        box[0].add(new Names("Rahul","Katteda")); // passing parameters to constructor
        box[0].add(new Names("Rakesh","Katteda"));

        box[1].add(new Names("MadhuPriya","Katteda"));

/*      after Adding ,

        box would look like :

        [ { obj1, obj2 } , { obj3 } ] .

        since we have added 2 elements into AL at box[0] so we will have 2 objects of type Names at index 0.
        since we have added only 1 element into AL at box[1] so we will have 1 object of type Names at index 1.

 */

    }

    public static void main(String[] args) {

        ArrayList<Names> box[]=new ArrayList[2];

        Practice obj=new Practice();


        obj.createBox(box);

        // For displaying graph

//        for(ArrayList<Names> names : box) {
//
////            for(int j=0;j<names.size();j++) { // one way of doing it
////
////                System.out.println("First name : " + names.get(j).fName + " , " + "Last name : " + names.get(j).lName);
////
////            }
//        }

//        for(ArrayList<Names> names : box) {
////            for( Object person : names){ // Doesn't work as when we use Object class as type of variable and assign another variable to it, the compiler only knows the methods and variables defined in the Object class only not the methods and variables of the actual object's class.
////
////                System.out.println("First name : " + person.fName + " , " + "Last name : " + person.lName);
////
//            }
//        }

        for(ArrayList<Names> namesAL : box) {

            for(Names person : namesAL){

                System.out.println("First name : " + person.fName + " , " + "Last name : " + person.lName);

            }
        }

    }
}
