class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        // Declare a local copy and pass
        List<Integer> possibleCand = new ArrayList();
        List<List<Integer>> result = new ArrayList<>();
        /// Most important variable: start
        int start = 0;
        return helper(0,possibleCand,candidates,target,result,start);
        // ******* We start from 0 zero sum
    }


    public List<List<Integer>> helper(int sum,List<Integer> possibleCand, int[] candidates, int target, List<List<Integer>> result,
    int start){
        
        // Base conditions for nodes
        if(sum > target) // at any node, the value will either be less or greater. Pruning condition: we dont need to expand
            return new ArrayList<>();   //*** 

        if(sum == target){ // !!!!!!!!! ONLY EQUAL
            // need to save the combination
            //System.out.println("Saving this comb: "+possibleCand);
            result.add(new ArrayList<>(possibleCand)); // and not result.add(possibleCand); It was giving [[]]
        }

        // Most SILLY condition, eg. [2,3,5], target=8, we can have a case: [2,2,2,2] but this condition was stoppping it 
        // if(possibleCand.size() > candidates.length)
        //     return;

        // Iterate through my choices
        for(int c=start; c<candidates.length; c++){ //// ****** c=start and NOT, c=0

            // There could be multiple variables we treat like backtrack, increase and decrease
            sum+= candidates[c];
            possibleCand.add(candidates[c]);

            //System.out.println("Inside choices, sum: "+sum+" possibleCand: "+possibleCand);
            helper(sum,possibleCand,candidates,target,result,c); // ****** pass c so it will start the dfs of next from next cand, not current
            
            sum-= candidates[c];
            possibleCand.remove(possibleCand.size()-1);
        }

        return result;

    }


}

/**

💡 How to Spot the Need for start in New Problems

Ask yourself:

Can I reuse elements?

If yes → you might want to pass the same index again

Do I care about order?

If no (combinations, not permutations) → use start to avoid duplicates

Am I pruning the search space?

If yes → start helps you make the space smaller and avoid cycles



Also refer to the code for 77.Combinations where we use the same start variable
Combination sum - 
start in param; 
i=start; i< n; i++; used in the for loop
helper(...., i) => in the recursion call - we have i 
// only i because we can re-use elements - next recursion call can make use of same element i


Combination - 
start in param; 
i=start; i< n; i++; used in the for loop
helper(...., i) => in the recursion call - we have i + 1 // ****
// i+1 because we cannot have duplicates, so next recursion call must be starting from next element 

*/

// Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
// Time Complexity: Usually exponential for backtracking, O(n^[H+1]) -> n = fan-out = no of choices, H = T/M = height of the tree
// Space Complexity: O(H) , height of tree: T/M in our case =>>>> O(T/M)

// Why minimal value? Target=7, minimal val=2
// The lesser value we have, for that value - the branch of tree will be deeper - Draw the tree and see that for 2,
// the tree goes deeper and deeper, doesnt terminate easily. S, minimal value will give the max height.
// For other high values in the array, we will reach target=7 soon - so tree height is less

The above logic holds true only if the fan out remains constant through the course of tree expansion
The fan-out is decreasing at every level with every choice, so we cannot consider the complexity to be nⁿ.
When the choices are decreasing - we consider the overall bound

/*
Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.

Time Complexity: O(N 
M
T
​
 +1
 )

As we illustrated before, the execution of the backtracking is unfolded as a DFS traversal in a n-ary tree.
The total number of steps during the backtracking would be the number of nodes in the tree.

At each node, it takes a constant time to process, except the leaf nodes which could take a linear time to make a copy of
combination. So we can say that the time complexity is linear to the number of nodes of the execution tree.

Here we provide a loose upper bound on the number of nodes.

First of all, the fan-out of each node would be bounded to N, i.e. the total number of candidates.

The maximal depth of the tree, would be  H where we keep on adding the smallest element to the combination.

As we know, the maximal number of nodes in N-ary tree of  H height would be N^(h+1)

First of all, the fan-out of each node would be bounded to N, i.e. the total number of candidates.
(fan-out)^(height+1)


Note that, the actual number of nodes in the execution tree would be much smaller than the upper bound, since the fan-out of the nodes are decreasing level by level.
*/

// Time complexity from a previous example:
/**
// Referring back to old formula:
// (Time at every node) * (fan-out)^(height+1)
// Fan-out => no of expansion nodes for every nodes // no of choices => 3 for letter '2' [a,b,c] and 4 for letter '7' = 4
// m^(height+1)
// Height is no of nodes of tree , in worst case is n, good case - logn
// m^(n+1) ~ = m^(n)
// We iterate through all digits, array size is n
// (n) * m^(n+1) OR (n) * m^(n)
 */


// Space Complexity: O(H) , height of tree: T/M in our case =>>>> O(T/M)
// Also, O(n) => Input array size



// Eg. [2,3,6,7], target = 7
// Expected: [[2,2,3],[7]]

// Without start:
// [[2,2,3],[2,3,2],[3,2,2],[7]] , it was giving duplicates