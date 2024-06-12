// The idea is to have two conditions: 
// One in which we will take the element into consideration, 
// Second in which we won't take the element into consideration.
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list);
        return ans;
    }

    public void helper(List<List<Integer>> ans,int start,int[] nums,List<Integer> list) {
        // END CONDITION/ PRUNING CONDITIONS
        // CAN BE ONE OR MANY
        if (start >= nums.length) { // when start is 4, for an array of length 3, [1,2,3], we know we have reached leaf nodes
            ans.add(new ArrayList<>(list));
        } 

        // DECISION LOGIC AT EACH STEP
        else {
            // add the element and start the  recursive call
            list.add(nums[start]);
            helper(ans, start + 1, nums, list); // LHS SUB-TREE, a little bit different in terms of types of input encountered


            // remove the element and do the backtracking call.
            list.remove(list.size() - 1);
            helper(ans, start + 1, nums, list); // RHS SUBTREE, a little bit different in terms of types of input encountered
        }
    }
}
