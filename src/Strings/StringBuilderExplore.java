package Strings;

public class StringBuilderExplore {

    public static void main(String[] args) {

        StringBuilder str=new StringBuilder("Hello");

//        str+="s"; // wrong : incompatible types as can't add string to StringBuilder

//        str.append() : - can append anything, it gets adds at the end of the old string

//        str.append(" rahul");
//        System.out.println(str);

//        str.setCharAt() : - beauty of StringBuilder as it allows to modify the characters individually unlike strings;

//        str.setCharAt(2,'y');
//        System.out.println(str);

//        str.insert(idx,ch); here insert function doesn't replace the indexed character but right shifts the characters which are after the provided index.

//        str.insert(0,'T'); // all the characters from 0 are right shifted and then adds 'T' at 0th index,
//        System.out.println(str);

//        System.out.println(str.deleteCharAt(0));

        str.reverse();
        System.out.println(str); // in place reversing

//        System.out.println(str.substring(0));

        System.out.println(str.substring(5,5));

//        System.out.println(str.delete(0,3));

        // there are no startsWith(), endsWith(), toLowerCase(), toUpperCase() in StringBuilder.



//        note :
//
//    StringBuilder sb1 = new StringBuilder("hello");
//    StringBuilder sb2 = new StringBuilder("hello");
//    System.out.println(sb1.equals(sb2)); // This would return false because for StringBuilders .equals() compares the references,
//    not the content as StringBuilder's .equals() method doesn't override object class's .equals() method.
//    so solution is (str.toString().equals(gtr.toString()) .
//    we convert the str and gtr to strings with toString() method and then use the .equals() method of strings which implements object's .equals() method.


//        StringBuilder s1=new StringBuilder("hello");
//        StringBuilder s2=new StringBuilder("hello");
//
//        System.out.println(s1.equals(s2));
//        System.out.println(s1==s2);

//        str=(StringBuilder) s.substring(i,j);// casting doesn't work as they are inconvertible types

//        StringBuilder gtr = str.reverse(); // here str.reverse() will reverse the string str also, so below while comparing them it will always be true

//        if(str==gtr){ // for comparing if two stringBuilder are pointing to same or not
//            count++;
//        }

//        if(str.toString()==gtr.toString()){ // here for comparing if two stringBuilders content  is same or not.
//            count++;
//        }

//        if(str.equals(gtr)){ // here since str and gtr are StringBuilders not strings , .equals() compares the references of them not the content.
//                    count+=1;
//      }













    }
}
