package Recursion;

import java.util.ArrayList;

public class Find_All_Indexes {

//    java is pass-by-value:
    // when passing the object as parameter, you are passing the value of reference to the object i.e. pass-by-value-of-reference.
    // for primitive types: java is pass-by-value: as it passes the copy of the value of the variable which is being passed in the argument.

    // General and best way:

//    static public ArrayList<Integer> findAllIndex(int[]arr,int index,int target,ArrayList<Integer> list){ // list is being passed in the argument
//
////        ArrayList list1=list; to prove pass-by-value-of-reference
//        if(index==arr.length){ // base case
////            return list1;
//            return list;
//        }
//
//        if(arr[index]==target){
////            list1.add(index);
//            list.add(index); // list gets added.
//        }
//
////        return findAllIndex(arr,index+1,target,list1);
//          return findAllIndex(arr,index+1,target,list); // old list's reference is being passed not the old list i.e. here list points to the same old list and its reference is being passed,no different list is created.
//    }

    // non-optimal way as in every call it creates a arraylist:

    static public ArrayList<Integer> findAllIndex(int[]arr,int index,int target){ // list is not being passed in the argument

        ArrayList<Integer> list=new ArrayList<>();

        if(index==arr.length){ // base case

            return list;
        }

        if(arr[index]==target){
            list.add(index); // list gets added.
        }

        ArrayList<Integer> ansFromBelowCalls = findAllIndex(arr,index+1,target); // answer from below calls is stored here

        list.addAll(ansFromBelowCalls); // answer of previous calls is being added to the answers of current recursion.

        return list; // returning the list
    }


    public static void main(String[] args) {

        int arr[]={1,2,3,4,4,5,6};
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(findAllIndex(arr,0,4)); // here the target will exist at least once.

    }
}
