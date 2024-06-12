public void backtrack(List<Integer> list, int firstNum, List<List<Integer>> ans) {
    // considered along the tree path, when we are done adding 2 elements
    // OR
    // considered along the length of result set obtained at node of every level
    // which is same in both cases here
    if (list.size() == k) {
        ans.add(new ArrayList<>(list));
        return;
    }
    
    // Whenever there is a list, we iterate
    for (int num = firstNum; num <= n; num++) {
        list.add(num); // add element
        backtrack(list, num + 1, ans);
        list.remove(list.size() - 1); // remove element at last index that was recently added
        // This removal indicates going back to previous state, hence backtracking
    }

    return;
}

// Time: O(n!/(k-1)! * (n-k)!)
// Space: O(k)