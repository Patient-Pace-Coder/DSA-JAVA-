package LinkedLists;

import java.util.Arrays;

public class RemoveDuplicates {

    private Node removeDups( Node head ){

        Node temp1 = head;
//        Node temp2 = head;

        while (temp1.next != null ) {
            if (temp1.data == temp1.next.data ) {
                if( temp1.next.next != null ) {
                    temp1.next = temp1.next.next;
                }
                else{
                    temp1.next = null;
                    break;
                }
            }
            temp1 = temp1.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4};

        System.out.println(Arrays.toString(arr));
    }
}
