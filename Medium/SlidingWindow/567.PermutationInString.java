class Solution {

    public boolean isPermutation(String s1, String subs) {
        // They are of same length, will have same character set
        //System.out.println("Comparing: "+s1+" "+subs);
        // @TODO: Come up with a better approach to check if they are permutation of each other!
        char[] ch1 = s1.toCharArray();
        char[] ch2 = subs.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1,ch2);
    }

    public boolean checkInclusion(String s1, String s2) {
        // s1 - length = window size
        // Fixed window type problem, the smaller string's length is the size of the sliding window
        // We slide through bigger string, extract a substring using sliding window approach and then check for permutation
        int l1 = s1.length();
        int start = 0, end = 0;
        String subs = "";
        boolean exists = false;

        for(end=0; end<s2.length(); end++){
             subs = subs + s2.charAt(end);
            
             if(end >= (l1-1)){
                if(isPermutation(s1,subs)){
                    exists=true;
                    break;
                }
                subs = subs.substring(1,subs.length());
             }
        }

    return exists;
    }
}


// Latest Feb 2026 Solution:
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        int start=0, end=0;
        int[] map = new int[26];
        int[] map2 = new int[26];

        for(char ch: s1.toCharArray()){
            map[ch-'a'] += 1;
        }

        for(end=0; end<s2.length(); end++){
            // Keep increasing
            map2[s2.charAt(end) - 'a'] += 1;
            
            
            // Now that we have a valid window
            // check if window valid - yes? return true  
            if((end-start) == windowSize-1){
                if(isValid(map,map2))
                    return true;
                else{
                    map2[s2.charAt(start) - 'a'] -= 1;
                    start += 1;
                }

            }

        }

        return false;
    }


    public boolean isValid(int[] map, int[] map2){
        for(int i=0; i<map.length; i++){
            if(map[i] != map2[i])
                return false;
        }

        return true;
    }
}