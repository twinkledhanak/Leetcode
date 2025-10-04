class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int start=0, end=skill.length-1;

        // Target: 6, how to get that?
        long sum = 0, indivSum = 0;
        for(int s: skill)
            sum += s;

        long target = sum/(skill.length/2);
        while(start < end){
            indivSum += (skill[start]*skill[end]);
            if((skill[start]+skill[end]) != target)
                return -1;
            start += 1;
            end -= 1;
        }

        return indivSum;
    }
}
// Lot of important takeaways from this problem
/**
Get the target for each partiton 
Sum of entire array / no of partitions => 18 / (6/2)
We sort the entire array and then pair the weakest element (from lhs) with strongest elements (from rhs) so that overall
the partion crosses median skill

*/