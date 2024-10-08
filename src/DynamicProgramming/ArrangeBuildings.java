package DynamicProgramming;

public class ArrangeBuildings {

    /*

    You are given a number n which  represents the length of a road. the road has n plots on its each side
    the road is to be so planned that there should not be consecutive buildings on either side of the road
    you are required to find and print the number of ways in which the building can be built on both side of roads

    this question is similar to previous question of binary strings in which we have to return the total number of binary
    strings of length n are possible such that there are no consecutive zeroes.


    Diagram : the below diagram represents the plot of length 5.

    S | B | S | S | B               B : building
    -----------------
    ------ ROAD -----               S : space
    -----------------
    B | S | B | S | B

    the above diagram just represents one valid way to construct the site as there are no consecutive buildings in the plan.
    there can be consecutive spaces.

    Approach :
    1] we use two 1D arrays of size n + 1, 1 array for storing the number of combinations( of buildings and spaces ) of length index, ending with space
    and 2nd array for storing the number of combinations( of buildings and spaces ) of length index,ends with building
    finally the total number of combinations will be the sum of element at n-1 th index.

    here we follow the same approach as followed in the binary strings question

    working :

    for n = 4, the output is 3 + 5 = 8. i.e. we can have totally 8 binary strings of length 4 in which consecutive zeroes doesn't exist.

    This array stores total number of binary strings of length index,and ends with 0 :

    Buildings[] :
            index :   0  1  2    3    4
                    [ 0, 1, 1  , 2  , 3   ]
    representation       B  SB  BSB  SBSB
                                SSB  BSSB
                                     SSSB

    This array stores total number of binary strings of length index,and ends with 1 :

    spaces[] :
            index :   0  1  2   3     4
                    [ 0, 1, 2 , 3   , 5   ]
    representation       S  BS  SBS  BSBS
                            SS  BSS  SSBS
                                SSS  SBSS
                                     BSSS
                                     SSSS

    Logic :
    spaces[i] = buildings[i - 1] + spaces[i - 1]
    buildings[i] = spaces[i - 1]

    for representation :
    spaces[i] = for each element at buildings[i - 1] + 'S', for each element as buildings[i - 1] + 'S'
    buildings[i] = for each element at spaces[i - 1] + 'B'

    since in the given question it is mentioned that plots are there on the either side of the road,
    and all the above calculations is only for one side we need to calculate for two sides we will return the square of ( buildings[n] + spaces[n] )

    it is because, consider for n = 3
    there are total 3 + 2 = 5 combinations of length 3, now since we have 2 plots and we have to arrange them in the 2 plots the total ways will be 5 * 5 = 25
    5 ways to set a plot in 1st plot and another 5 ways to set a plot in 2nd plot so totally 5 * 5 = 25 ways.

     */

    private static int arrangeBuildings( int n ){

        int spaces[] = new int[n + 1];
        int buildings[] = new int[n + 1];
        spaces[0] = 0;
        spaces[1] = 1;

        for( int i = 1; i <= n; i++ ){

            if( i == 1 ){
                spaces[i] = 1;
                buildings[i] = 1;
            }
            else{
                int temp = spaces[i - 1];
                spaces[i] = spaces[i - 1] + buildings[i - 1];
                buildings[i] = temp;
            }
        }

        int total = buildings[n] + spaces[n];

        return total * total;

    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(arrangeBuildings(n));
    }
}
