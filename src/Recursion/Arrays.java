package Recursion;

public class Arrays {

    private static void displayArr(int arr[], int idx){

        if( idx == arr.length ){
            return;
        }

        System.out.println(arr[idx]);

        displayArr(arr,idx + 1);
    }

    private static void displayArrRev(int arr[], int idx){

        if( idx == arr.length ){
            return;
        }
        displayArrRev(arr,idx + 1);
        System.out.println(arr[idx]);
    }

    private static int maxOfArr1(int arr[], int idx){


        if( idx == arr.length - 1 ){
            return arr[idx];
        }

        int prevMax = maxOfArr(arr, idx + 1);

        if( arr[idx] > prevMax ){
            return arr[idx];
        }
        else{
            return prevMax;
        }

    }

    private static int maxOfArr(int arr[], int idx){

        if( idx == arr.length ){
            return 0;
        }

        return Math.max( arr[idx], maxOfArr(arr, idx + 1));
    }

    private static int indexOfFirstOccurrence(int arr[], int idx,int target){ // efficient as it first checks and then goes to next.

        if( idx == arr.length ){
            return -1;
        }

        if( arr[idx] == target ){
            return idx;
        }
        else {

            int ifisa = indexOfFirstOccurrence(arr, idx + 1, target);
            return ifisa;

        }
    }

    private static int indexOfFirstOccurrence1(int arr[], int idx,int target){ // inefficient as it first goes till the last and while coming back it checks.


        if( idx == arr.length ){
            return -1;
        }

        int ifisma = indexOfFirstOccurrence1(arr,idx + 1,target);  // ifisma - index of first occurence in smaller array

        if( arr[idx] == target ){
            return idx;
        }
        else{
            return ifisma;
        }

    }

    private static int indexOfLastOccurrence(int arr[], int idx,int target){ // main logic


        if( idx == arr.length ){
            return -1;
        }

        int ilisma = indexOfLastOccurrence(arr,idx + 1,target);

//        if( arr[idx] == target ){  // if only this piece of code is written then it will keep on updating the index and results in giving ifisma.
//            return idx;
//        }

        if( ilisma == -1 ){ // if target not encountered then check for the target
            if( arr[idx] == target ){  // once target is encountered prev will become idx and further we will not check
                return idx;
            }
            else{
                return ilisma;
            }
        }
        else{
            return ilisma;
        }
    }

    private static int indexOfLastOccurrence1(int arr[], int idx,int target){ // alternative logic


        if( idx < 0  ){
            return -1;
        }

        if( arr[idx] == target ){
            return idx;
        }
        else {
            int ilisma = indexOfLastOccurrence1(arr, idx - 1, target);
            return ilisma;
        }
    }

    private static int[] allIndicesOfOccurrence(int arr[], int idx,int target,int fsf) { // fsf is found so far i.e. count


        if (idx == arr.length) {
            return new int[fsf];
        }

        if (arr[idx] == target) { // alternative logic
            fsf = fsf + 1;
        }

        int solArr[] = allIndicesOfOccurrence(arr, idx + 1, target, fsf);

        if (arr[idx] == target) {

            solArr[fsf - 1] = idx;
            return solArr;
        }
        else {
            return solArr;
        }
    }

    public static void main(String[] args) {

        int arr[] = {3,5,7,9,2,7,6,9,8};

//        displayArr(arr,0);
//        displayArrRev(arr,0);

//        System.out.println(maxOfArr(arr,0));
//        System.out.println(maxOfArr1(arr,0));

       System.out.println( indexOfFirstOccurrence1(arr,0,7));

//        System.out.println( indexOfLastOccurrence(arr,0,7));
//        System.out.println( indexOfLastOccurrence1(arr,arr.length-1,7));

        // int arr2[] = allIndicesOfOccurrence(arr,0,7,0);
        //
        // for( int i = 0; i < arr2.length; i++){
        //     System.out.print(arr2[i]+" ");
        // }
    }

}
