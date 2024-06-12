class Solution {
    public String reorganizeString(String s) {

        // ALWAYS STORE CHARACTER FREQUENCY IN AN ARRAY, INSTEAD OF A HASHMAP
        var charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Max heap ordered by character counts
        // PQ HAS ELEMENTS -> [CHARACTER,FREQUENCY]
        // ORDER THE ELEMENTS IN DESC ORDER OF FREQ, WHICH IS B[1]-A[1]
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                // ADD VALUES TO PQ
                pq.offer(new int[] {i + 'a', charCounts[i]});
            }
        }
            
        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                        sb.append((char) first[0]);
                        if (--first[1] > 0) {
                            pq.offer(first);
                        }
            } 
            else {
                        if (pq.isEmpty()) {
                            return "";
                        }
                        
                        var second = pq.poll();
                        sb.append((char) second[0]);
                        if (--second[1] > 0) {
                            pq.offer(second);
                        }
                        
                        pq.offer(first);
            }
        }
        
        return sb.toString();
    }
}