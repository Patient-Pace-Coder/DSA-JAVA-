package SearchAlgorithms;

public class qtns {

//    find number of elements(numbers) with even number of digits.

//    brute force solution :

    public static int findNumbers(int[] arr){

        int countNumbers=0;

        for(int i=0;i<arr.length;i++){

            int countDigits=0;
            int num=arr[i];

            while(num>0){ // counting digits

                num=num/10;
                countDigits++;

            }

            if(countDigits%2==0){
                countNumbers++;
            }

        }
        return countNumbers;
    }

//    optimized solution :
    public static int findNumbers2(int[] arr){

        int countNumbers=0;

        for(int i=0;i<arr.length;i++){

            int n= (int)Math.log10(arr[i])+1; // alternative and best way to count number of digits.

            if(n%2==0){
                countNumbers++;
            }
        }

        return countNumbers;

    }

    public static void main(String[] args) {

//        System.out.println(findNumbers(new int[] {12,345,34,1234,345678,2,1}));

        System.out.println(findNumbers2(new int[] {12,345,34,1234,345678,2,1}));


    }
}
