package OtherCodes;

public class Practice6 {
        public static int minimumArea(int[][] grid) { // not solved , week 403

            int maxCol = 0;
            int height = 0;
            int length = 0;
            for (int i = 0; i < grid.length; i++) {
                int heightPrev = 0;
                int minCol = Integer.MAX_VALUE;
                for (int j = length; j < grid[i].length; j++) {

                    if (grid[i][j] == 1) {
                        minCol = Math.min(j,minCol);
                        maxCol = j;
                        heightPrev = 1;
                    }
                }
                if( heightPrev == 1 ) {
                    height += heightPrev;
                }
                length = Math.max( (maxCol-minCol) + 1,length);

            }

            return length * height;

        }

    public static void main(String[] args) {
        int nums[][] = { {1,0,1},{0,1,0} };

        System.out.print( minimumArea(nums));
    }
}
