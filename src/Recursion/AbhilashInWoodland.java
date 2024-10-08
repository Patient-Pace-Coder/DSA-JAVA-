package Recursion;

public class AbhilashInWoodland { // not solved completely

    static int countLandWithTrees = 0;
    private static void numberOfSquares( int row, int col,int k, String woodland[][] ){


        for( int i = 0; i < woodland.length; i++ ) { // for k =1
            for( int j = 0; j < woodland.length; j++ ) {
                if (woodland[i][j].equals("*")) {
                    countLandWithTrees++;
                }
            }
        }
        boolean isTree = true;
        int rowIdx = 0;
        int colIdx = 0;
        while( rowIdx < woodland.length && rowIdx != woodland.length - 1) {
            int i = rowIdx;
            int j = rowIdx;
            while (i < rowIdx + k) {
                while (j < rowIdx + k) {
                    if (!woodland[i][j].equals("*")) {
                        isTree = false;
                    }
                    j++;
                }
                i++;
                j = k - i -1;
            }
            if (isTree) {
                countLandWithTrees++;
            }
            rowIdx++;
        }


        numberOfSquares(row,col + k,k,woodland);
        numberOfSquares(row + k,col,k,woodland);


    }

    public static void main(String[] args) {

    }
}
