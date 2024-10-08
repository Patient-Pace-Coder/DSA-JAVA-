package Arrays;


//Given two arrays of ints sorted in increasing order, outer and inner,
// return true if all of the numbers in inner appear in outer.
// The best solution makes only a single "linear" pass of both arrays,
// taking advantage of the fact that both arrays are already in sorted order.
//
//
//        linearIn([1, 2, 4, 6], [2, 4]) → true
//        linearIn([1, 2, 4, 6], [2, 3, 4]) → false
//        linearIn([1, 2, 4, 4, 6], [2, 4]) → true

public class LinearIn {

    public boolean linearIn(int[] outer, int[] inner){
        for(int i=0;i<inner.length;i++){
            boolean isPresent=false;
            for(int j=0;j<outer.length;j++){
                if(inner[i]==outer[j]){
                    isPresent=true;
                    break;
                }

            }
            if(!isPresent){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        LinearIn obj=new LinearIn();
        int outer[]={1,2,4,4,6};
        int inner[]={2,4};
        System.out.println(obj.linearIn(outer, inner));
    }
}
