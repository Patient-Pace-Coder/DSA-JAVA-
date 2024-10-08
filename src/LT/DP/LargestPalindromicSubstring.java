package LT.DP;

import java.util.Arrays;

public class LargestPalindromicSubstring {

    private static String palindromicSubstring( String s ){ // TLE

        String dp[][] = new String[s.length()][s.length()];
        String res = ""+s.charAt(0);
        dp[0][0] = ""+s.charAt(0);

        for( int i = 1; i < s.length(); i++ ){

            for( int j = 0; j <= i; j++ ){

                if( dp[i - 1][j] != null ){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    StringBuilder currSbstr = new StringBuilder(s.substring(i - j,i + 1));
                    StringBuilder strRev = new StringBuilder(currSbstr);
                    if( !currSbstr.isEmpty() && (currSbstr.toString().equals(strRev.reverse().toString())) ){
                        dp[i][j] = ""+currSbstr;
                        if( currSbstr.length() > res.length() ){
                            res = ""+currSbstr;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        // for( int i = dp.length - 1; i >= 0; i-- ){
        //     if( dp[dp.length - 1][i] != null ){
        //         return dp[dp.length - 1][i];
        //     }
        // }

        return res;
    }

    private static String palindromicSubstringOpt( String s ){
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        StringBuilder res = new StringBuilder();
        dp[0][0] = true;
        int resStartIdx = Integer.MAX_VALUE; // to get the start index of palindromic substring
        int resStartIdxJ = 0; // if there is larger palindromic substring only then resStartIdx should be changed so this is used as checker

        for( int i = 1; i < s.length(); i++ ){
            for( int j = 0; j <= i; j++ ){
                if( dp[i - 1][j] ){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    int startIdx = i - j; // this will give the start index of the substring of length (i - j)+i
                    int endIdx = i;
                    boolean isValid = true;
                    while ( startIdx >= 0 && startIdx < endIdx ){
                        char chStart = s.charAt(startIdx);
                        char chEnd = s.charAt(endIdx);
                        if( chStart == chEnd ){
                            startIdx++;
                            endIdx--;
                        }else{
                            isValid = false;
                            break;
                        }
                    }
                    if( isValid){
                        if( j > resStartIdxJ ){ // if the new palidromic string's length is greater than old palidromic substring
                            resStartIdxJ = j;
                            resStartIdx = i - j; // only then update the starting index of resultant palindromic substring
                        }
                        dp[i][j] = true;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        if( resStartIdx != Integer.MAX_VALUE ) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[dp.length - 1][i]) {
                    return s.substring(resStartIdx, resStartIdx + i + 1);
                }
            }
        }
        return ""+s.charAt(0);
    }
    public static void main(String[] args) {
        String str = "malayalam";
        // str = "eabcb";
        // str = "aacabdkacaa";
        // String str = "vvgogaewginhopuxzwyryobjjpieyhwfopiowxmyylvcgsnhfcnogpqpukzmnpewavoutbloyrrhatimmxfqmcwgfebuoqbbgvubbkjfvxivjfijlpvtsnhagzfptahhyojwzamayoiegkenycnkxzkambimhdykdcxyyfjnvztzypmfczdhhnkmfuvgkhzbwmjznykkagqdrueohgcmeidjqsvfugcioeduohprjtfdmtzosnhoiganffarokxjifzzxhixdzycwfheqqegduzwtiacmdhqfmxhazcxsqyrvrihfqzjxvawdeandnwgjlquvzadruiqmcsgibglhicsvzqknztqpkiihdoisxipkourentfvrltieihiktgzswtgcmmlfrjifqinhrbplbsgswqlbjkyxjwoshsvxlhlpgzwbmxzwaemtowcxwourjwmmwjruowxcwotmeawzxmbwzgplhlxvshsowjxykjblqwsgsblpbrhniqfijrflmmcgtwszgtkihieitlrvftneruokpixsiodhiikpqtznkqzvscihlgbigscmqiurdazvuqljgwndnaedwavxjzqfhirvryqsxczahxmfqhdmcaitwzudgeqqehfwcyzdxihxzzfijxkoraffnagiohnsoztmdftjrphoudeoicgufvsqjdiemcghoeurdqgakkynzjmwbzhkgvufmknhhdzcfmpyztzvnjfyyxcdkydhmibmakzxkncynekgeioyamazwjoyhhatpfzgahnstvpljifjvixvfjkbbuvgbbqoubefgwcmqfxmmitahrryolbtuovawepnmzkupqpgoncfhnsgcvlyymxwoipofwhyeipjjboyrywzxupohnigweagogvv";
        // System.out.println(palindromicSubstring(str));
        System.out.println(palindromicSubstringOpt(str));
    }
}
