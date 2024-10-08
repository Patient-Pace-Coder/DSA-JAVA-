package Arrays;

public class Permutation {

    // permutation means if all the elements of 1st array are present in the 2nd array


    public boolean permutation(int arr1[],int arr2[]){


        // brute force solution

//        if(arr1.length==arr2.length) {
//            for (int i = 0; i < arr1.length; i++) {
//                boolean isMatching=false;
//                for (int j = 0; j < arr1.length; j++) {
//                    if (arr1[i] == arr2[j]) {
//                        isMatching = true;
//                        break;
//                    }
//
//                }
//                if(!isMatching){
//                    return false;
//                }
//            }
//
//        } else if (arr1.length!=arr2.length ) {
//            return false;
//        }
//        return true;


        // other logic


        if(arr1.length!=arr2.length){
            return false;
        }

        int sum1=0;
        int prod1=1;
        int sum2=0;
        int prod2=1;
        for(int i=0;i<arr1.length;i++){
            sum1+=arr1[i];
            prod1*=arr1[i];
            sum2+=arr2[i];
            prod2*=arr2[i];
        }

        if(sum1==sum2 && prod1==prod2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Permutation obj=new Permutation();
        int arr1[]={20,30,10,40,50,60};
        int arr2[]={60,40,20,50,10,30};
        System.out.println(obj.permutation(arr1,arr2));
    }
}
