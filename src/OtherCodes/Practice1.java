package OtherCodes;

public class Practice1 {

    public static int strStr(String haystack, String needle) {

//        int fEle = 0;
//        for( int i = 0; i < haystack.length(); i++ ){
//            if( haystack.charAt(i) == needle.charAt(0) ){
//                fEle = i;
//                break;
//            }
//        }
//
//        int idx = 0;
//        for( int i = fEle; i < haystack.length();i++){
//
//            if( haystack.charAt(i) == needle.charAt(idx) ){
//                idx++;
//                if( idx == needle.length() ){
//                    return i - (needle.length() - 1);
//                }
//            } else if (idx == needle.length() - 1) {
//                idx = 0;
//                i = i - 2;
//            }
//        }

        String subStr = "";
        for( int i = 0; i < haystack.length(); i++ ){

            for( int j = i + 1; j <= haystack.length(); j++ ){
                subStr = haystack.substring(i,j);
                if( subStr.equals(needle)){
                    return i;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        String haystack = "mississippi";
        String needle = "issip";

//        System.out.println(strStr(haystack,needle));

        int s = 10;
        int l = String.valueOf(s).length();
//        String sLen = String.valueOf(s);

//        System.out.println(sLen);



    }

}
