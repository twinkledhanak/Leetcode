import java.util.*;

// https://leetcode.com/discuss/interview-question/5726879/Hardest-OA-of-my-life-till-now-or-CISCO-OA-or-Even-GPT-failed!!

public class MinCostMachineRearrangement {

    public static int getMinimumCost(int[] machineCount, int[] finalMachineCount, int shiftingCost) {
        int n = machineCount.length;
        Map<Integer,Integer> map = new HashMap<>();
        int totalCost = 0,cost1=0,cost2=0;
        Set<Integer> toBeRemoved = new HashSet<>();

        // create a map of style two sum
        for(int i=0; i<n; i++)
            map.put(i,machineCount[i]);
        
        PriorityQueue<Integer> elemHeap = new PriorityQueue<>(); // minHeap
        PriorityQueue<Integer> finalHeap = new PriorityQueue<>(); // minHeap

        //we do not have list, we have arrays
        for(int x: machineCount)
            elemHeap.add(x);
        for(int y: finalMachineCount)
            finalHeap.add(y);

        while(!elemHeap.isEmpty() && !finalHeap.isEmpty()){
            int elem = elemHeap.poll(); // get Min1
            int finalElem = finalHeap.poll(); // get Min from final
            if(elem == finalElem)
                finalHeap.add(elem);
            
            // continue only if elem doesnt exists in set
            if(!toBeRemoved.contains(elem)){

                //Option1: go over the map to see if two's comple exists
                //Option2: use shiftingCost
                System.out.println("Comparing: elem: "+elem+" finalElm: "+finalElem);
                if(map.containsKey(finalElem-elem)){
                    cost2 = shiftingCost;
                    toBeRemoved.add(finalElem-elem);
                }
                    
                cost1 = (finalElem-elem);
                
                totalCost += Math.min(cost1,cost2);
                System.out.println("Cost1: "+cost1+" cost2: "+cost2);
                System.out.println("totalCost: "+totalCost);
            }
            

        }

        return totalCost;
        
    }


    public static void main(String[] args) {
        int[] machineCount = {2, 3, 5, 7};
        int[] finalMachineCount = {5, 10, 5};
        int shiftingCost = 2;
        
        int result = getMinimumCost(machineCount, finalMachineCount, shiftingCost);
        System.out.println(result);  // Output should be 5 as per the example
    }
}
