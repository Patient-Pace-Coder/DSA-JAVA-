package Basic;

public class ExcelSheetColTitle {


    public static String convertToTitle(long columnNumber) { // works only for smaller inputs
        StringBuilder res = new StringBuilder();
        if( columnNumber <= 26 ) {
            long val = columnNumber + 64;
            char ch = (char) val;
            res.append(ch);
        }
        else if( columnNumber % 26 == 0){
            long firstChar = columnNumber/26;
            char fc = (char) (64 + firstChar - 1);
            res.append(fc);
            char sc = 'Z';
            res.append(sc);
        }
        else{
            long firstChar = columnNumber/26;
            char fc = (char) (64 + firstChar);
            res.append(fc);
            long secondChar = columnNumber % 26;
            char sc = (char) (64 + secondChar);
            res.append(sc);
        }

        return res.toString();
    }

    /*

        Approach and Intuition:
        Base-26 Representation:

        The Excel column title can be thought of as a number in base-26 where 'A' corresponds to 1, 'B' to 2, ..., 'Z' to 26.
        For example, the column "AA" can be seen as (1 * 26^1 + 1 * 26^0 = 27)

        Zero-Index Adjustment:

        Since 'A' should correspond to 1 and not 0, we adjust by subtracting 1 from the column number. This helps in handling the conversion correctly.
        For instance, column number 1 corresponds to 'A', but if we directly use modulo 26, it would correspond to 'Z'. Subtracting 1 adjusts the number so that 0 maps to 'A'.
        Character Calculation:

        The formula (columnNumber - 1) % 26 gives the correct position in the alphabet for the current digit, converting it into a character by adding it to 'A'.
        columnNumber = (columnNumber - 1) / 26 reduces the column number for the next iteration, moving to the next "digit" in the base-26 representation.
        Loop Until Completion:

        The loop continues until all "digits" have been processed, ensuring every part of the number is converted into the corresponding character.
        Reverse the Result:

        The digits (characters) are appended from least significant to most significant, which is why the result needs to be reversed at the end.
        Example Walkthrough:
        Let’s consider an example with a smaller number to illustrate:

        Example: Convert column number 701 to a title

        Initial State:

        columnNumber = 701
        Result: ""
        First Iteration:

        Remainder: (701 - 1) % 26 = 700 % 26 = 24 (Corresponds to 'Y')
        Append 'Y' to result.
        Update columnNumber = (701 - 1) / 26 = 700 / 26 = 26
        Result: "Y"
        Second Iteration:

        Remainder: (26 - 1) % 26 = 25 % 26 = 25 (Corresponds to 'Z')
        Append 'Z' to result.
        Update columnNumber = (26 - 1) / 26 = 25 / 26 = 0
        Result: "ZY"
        Loop Ends: columnNumber is now 0.

        Reverse Result:

        Reverse "ZY" to get "YZ".
        The final result is "ZY", which matches the expected column title.

     */

    public static String convertToTitleOptimal(long columnNumber) { // works for larger inputs
        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {
            long remainder = (columnNumber - 1) % 26; // gives the correct position in the alphabet for the current digit, converting it into a character by adding it to 'A'.
            char ch = (char) (remainder + 'A'); // (we calculate title from last (i.e. from right to left)
            res.append(ch);
            columnNumber = (columnNumber - 1) / 26; // reduces the column number for the next iteration, moving to the next "digit" in the base-26 representation.
        }

        res.reverse(); // since we calculate title from left to right we reverse it.
        return res.toString();
    }

    public static void main(String[] args) {

        long columnNumber = 2147483647;
        // columnNumber = 53;
        System.out.println(convertToTitleOptimal(columnNumber));
    }
}
