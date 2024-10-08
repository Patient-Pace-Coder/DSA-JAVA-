package Basic;
import java.util.HashMap;

public class CountSetBits {

    public static int hammingWeight(int n) { // best approach
        int countBits = 0;
        while( n > 0 ){
            int rem = n % 2;
            if( rem == 1 ){
                countBits++;
            }
            n = n/2;
        }
        return countBits;
    }

    public static int hammingWeightAlt(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();

        while( n > 0 ){
            int rem = n % 2;
            if( rem == 1 ){
                if( map.containsKey(1)){
                    int freq = map.get(1);
                    map.put(1,freq + 1);
                }
                else{
                    map.put(1,1);
                }
            }
            n = n / 2;
        }
        return map.get(1);
    }

    public static void main(String[] args) {

        int n = 128;
        System.out.println(hammingWeight(n));
    }
}
