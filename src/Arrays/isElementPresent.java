package Arrays;

public class isElementPresent {

    private static boolean isPresent( int arr[],int n){

        for( int i = 0; i < arr.length; i++ ){
            if( arr[i] == n ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50};
        int n = 60;
        System.out.println(isPresent(arr,n));
    }
}
