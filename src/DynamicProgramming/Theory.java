package DynamicProgramming;

public class Theory {

    /*

    Dynamic programming is an approach which solves the problem of recursion i.e. time complexity of recursive codes

    There are two approaches of dynamic programming :

    goal of dynamic programming is to eliminate the problem of overlapping sub-problems.

    This can be achieved in two ways :

    1. Memoization - ALso known as top-down approach
    2. Tabulation - Also known as bottom-up approach

    Memoization :

    it refers to storing the values of recursive calls ( in dp[] array ) for later use, so that the function need not calculate the value
    of same function twice which happens in recursion.

    - so when the function is called for some parameter, it first checks in the dp array[]
    if the value of that function call is calculated previously or not.
    if the value of the function call is calculated then it doesn't compute the value of that function call
    instead utilizes the value stored in that array.

    The dimension of dp[] array depends on the number of parameters present in the function call.
    for example :
    In fibonocci the parameter is a single parameter i.e. n fibo(n)

    Here the dp[] array will be a single dimension array.

    steps for memoization :
     1. declaring an array based on the parameters in the function call, ex : dp[n + 1], initially all the elements will be -1.
     2. calculating the values for the current function call with the help of the recurrence relation.
     3. checking if the value of the current function call is already calculated and stored in the dp[n].
        - if yes then return the value of dp[n]
        - else : perform step 2.

     Time and Space complexities :
     Space complexity : O(N) + O(N) : Stack space + Array space
     Time complexity : O(N) ( as function is being called only once for every n i.e. linear )

     Tabulation :

     It refers to storing the values in dp[] array similar to memoization, but here the difference is we do not use
     recursion to compute the values , instead we use iterative approach.

     it is more efficient as it eliminates the stack space which can be seen in memoization as it doesn't use recursion

     Three steps to solve using tabulation :
     1. Storage and meaning
     - understand the meaning of what you store in each cell

     2. analyze the direction of solving
     - The direction of solving the problem should be from easiest to difficult,
     ex : in fibonacci we know that dp[0] = 0, dp[1] = 1, so here the direction fo solving means
     to find fibonacci(8) we have to know dp[8], so we have to start solving the problem from dp[0] to dp[8].
     i.e. the direction should be from known to unknown.

     3. Travel and solve

     Time and space complexities :
     Space complexity : O(N) : Array space
     Time complexity : O(N) ( as we use array for calculating ), can be optimized to O(1) ( only for some problems )


     */
}
