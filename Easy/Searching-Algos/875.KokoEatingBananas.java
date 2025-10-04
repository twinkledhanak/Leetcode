class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries 
        

        //******
        // left is 1; I had kept it as left = Integer.MIN_VALUE; I wanted the min value of piles to be the start
        // BUT IT DOES NOT WORK
        // Range: 1 to max(piles)
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }


        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            // ******************
            // NOT hourSpent += pile/middle; it is what I had put earlier
            // when the pile size is not perfectly divisible by the eating speed., eg, 3.456789 needs to be considered as 4
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
}