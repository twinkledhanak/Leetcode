/*
The developers working on a social media network app want to analyze user behavior. There are n event logs where userEvent[i] 
denotes the userId for the usr that triggered the ith event. The team wants to analyze the subarrays of the logs which are 
consistent, that is, the frequency of the most frequent user in the subarray is equal to the frequency of the least frequent
 user in the whole array. Find the maximum length of consistent logs. The constraints: 1<=n<=3*10^5 1<=userEvent[I]<=10^9

-> Max window length where freq of all elements is same => freq = min freq of entire array
-> Find the min freq of entire array
-> In sliding window fashion, start with a dynamic window - 1 element at a time, no sorting
*/

import java.util.HashMap;

public class Solution {
    public int maxLengthOfConsistentLogs(int[] userEvent) {
        int n = userEvent.length;
        
        // Step 1: Find the minimum frequency in the entire array
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int userId : userEvent) {
            freqMap.put(userId, freqMap.getOrDefault(userId, 0) + 1);
        }
        int minFreq = Integer.MAX_VALUE;
        for (int freq : freqMap.values()) {
            minFreq = Math.min(minFreq, freq);
        }

        // Step 2: Use sliding window to find the maximum length of consistent logs
        HashMap<Integer, Integer> windowFreqMap = new HashMap<>();
        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            int endUserId = userEvent[end];
            windowFreqMap.put(endUserId, windowFreqMap.getOrDefault(endUserId, 0) + 1);
            
            // Ensure the condition: max frequency in window equals minFreq
            while (true) {
                int maxFreqInWindow = 0;
                for (int freq : windowFreqMap.values()) {
                    maxFreqInWindow = Math.max(maxFreqInWindow, freq);
                }

                if (maxFreqInWindow == minFreq) {
                    break;
                } else {
                    // Reduce window size from the left
                    int startUserId = userEvent[start];
                    windowFreqMap.put(startUserId, windowFreqMap.get(startUserId) - 1);
                    if (windowFreqMap.get(startUserId) == 0) {
                        windowFreqMap.remove(startUserId);
                    }
                    start++;
                }
            }
            // Calculate the length of the current valid window
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] userEvent = {1, 2, 2, 1, 2, 1, 1};
        System.out.println("Maximum length of consistent logs: " + solution.maxLengthOfConsistentLogs(userEvent));
    }
}
