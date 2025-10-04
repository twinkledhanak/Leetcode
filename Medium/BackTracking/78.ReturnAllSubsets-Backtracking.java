// I followed my earlier pattern and still found an answer for this question
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> possibleCand = new ArrayList();
        List<List<Integer>> result = new ArrayList<>();
        /// Most important variable: start
        int start = 0; // 1.
        return helper(possibleCand,nums,result,start);
    }

    public List<List<Integer>> helper(List<Integer> possibleCand, int[] candidates,  List<List<Integer>> result,
    int start){

        // ONE learning: If we want to add everything leading upto base,
        // We may not need to have a return statement!!
        if(possibleCand.size() <= candidates.length){ 
            result.add(new ArrayList<>(possibleCand)); 
        }

        for(int c=start; c<candidates.length; c++){  //2.
            possibleCand.add(candidates[c]);
            helper(possibleCand,candidates,result,c+1); //3.
            possibleCand.remove(possibleCand.size()-1);
        }

        return result;
    }
}

// We used c+1, why?
// When I have explored adding 1 and got [1]. While drawing the tree I realized that when I go further down from 1,
// I need not have [1,1] in my final answer. So I can skip using 1 again. Meaning - skip current index and directly use the next one
// c+1 ensures in the next exploration when we deepen the tree from 1, we do not add 1 again to get [1,1]
// Instead we start with 2 and get [1,2] - 1 still is the node and 2 is the choice


/**
Below code makes the two choices very explicit

*/

public void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
    if (index == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }

    // Choice 1: include nums[index]
    current.add(nums[index]);
    helper(nums, index + 1, current, result);
    current.remove(current.size() - 1);

    // Choice 2: exclude nums[index]
    helper(nums, index + 1, current, result);
}







// The idea is to have two conditions: 
// One in which we will take the element into consideration, 
// Second in which we won't take the element into consideration.
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, 0, nums, list); // index and list are extra params
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
/*
Sometimes, we have all choices array.
We can consider all values(mini choices) within the choices[]
We add/remove these mini-choices and make backtrack call


But sometimes, we have 2 higher level choices, choices1[] and choices2[]
We have to do backtrack for both these

// Time: O(n * 2^n)
// Space: O(n)
*/