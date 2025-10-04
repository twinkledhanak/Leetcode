public class Solution extends Relation {
    
    private int numberOfPeople;
    
    public int findCelebrity(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) { // 0 knows 0? 0 knows 1? 0 knows 2?
                celebrityCandidate = i; // if(o doesnt know 1, o remains a possible candidate, otherwise update candidate to i)
            } // 0 knows 1? Yes. 0 cannot be a celeb then. 1 could be the
        }



        if (isCelebrity(celebrityCandidate)) { // check if this possible celebrity is actually a celebrity or no
            return celebrityCandidate;
        }
        return -1;
    }
    
    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) { // for all people, check if o doesnt know anyone of them
            if (i == j) continue; // Don't ask if they know themselves.

            // if we say, i is celeb. If i knows j, ret false OR ; if j doesnt know i, ret false
            if (knows(i, j) || !knows(j, i)) { // 0 -> 1, 0 -> 2 ddd
                return false;
            }
        }
        return true;
    }
}

/**
Time Complexity : O(n).

Our code is split into 2 parts.

The first part finds a celebrity candidate. This requires doing n−1 calls to knows(...) API, and so is O(n).

The second part is the same as before—checking whether or not a given person is a celebrity. We determined that this is O(n).

Therefore, we have a total time complexity of O(n+n)=O(n).

Space Complexity : O(1).

Same as above. We are only using constant extra space.

*/