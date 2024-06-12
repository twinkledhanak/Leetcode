// Similar to ReturnAllSubsets.java , case of backtracking and exploration 
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, candidates, target, list);
        return ans;
    }

// LEETCODE
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> results = new ArrayList<List<Integer>>();
    //     LinkedList<Integer> comb = new LinkedList<Integer>();

    //     this.backtrack(target, comb, 0, candidates, results);
    //     return results;
    // }

    // public void helper(List<List<Integer>> ans, int start, int[] candidates, int target, List<Integer> list) {

    // }

    class Solution {

    protected void backtrack(int remain, LinkedList<Integer> comb,int start, int[] candidates,List<List<Integer>> results) {

        // END CONDITION / PRUNING CONDITONS 
        // CAN BE ONE OR MANY
        if (remain == 0) { // target is reached
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }


        // DECISION LOGIC AT EACH STEP
        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);


            // backtrack, remove the number from the combination
            comb.removeLast(); // since it is a LL, use method removeLast()

            // ******* WHY NO BACKTRACK CALL AFTER REMOVING?
            // IF WE ADD, IT WILL RESEMBLE THE PROBLEM WHERE WE ARE RETURNING ALL SUBSETS IN LEAF NODE, EVEN WHEN SUM != TARGET
            // RETURNS: [[2,2,3],[2,2],[2,3],[2],[2,3],[2],[3],[],[7],[]] for [2,3,6,7] and Target: 7
            // EXPECTED: [[2,2,3],[7]]

            // *** MAY BE:
            // FROM THE DECISION TREE DIAGRAM, IT APPEARED LEFT SKEWED, SO NO NEED TO EXPLORE THE RIGHT SIDE?
            // WE KNOW THE UNIQUE ANSWER LIES IN THE LEFT SIDE ONLY
        }
    }

    
}
}


// Time: O[n ^ ((T/M)+1)]
// Space: O(T/M)