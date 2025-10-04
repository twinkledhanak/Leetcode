
class Solution {
    public static Map<Integer,List<String>> map;

    static{
        // Adding elements as a list directly helps
        map = new HashMap<>();
        map.put(2,Arrays.asList("a","b","c"));
        map.put(3,Arrays.asList("d","e","f"));
        map.put(4,Arrays.asList("g","h","i"));
        map.put(5,Arrays.asList("j","k","l"));
        map.put(6,Arrays.asList("m","n","o"));
        map.put(7,Arrays.asList("p","q","r","s"));
        map.put(8,Arrays.asList("t","u","v"));
        map.put(9,Arrays.asList("w","x","y","z")); 
    }

    public List<String> letterCombinations(String digits) {
        return helper(digits,map);
    }


    // EVEN WHEN THE MAP IS STATIC, IT HAS TO BE PASSED IN AS A PARAMETER
    public List<String> helper(String digits, Map<Integer,List<String>> map){
        List<String> mainRes = new ArrayList<>();

        // ******************************* Base cases *******************************
        // ""
        if(digits.length() == 0)
            return new ArrayList<>();
        // "2" or "3"
        if(digits.length() == 1){
            Integer key = digits.charAt(0) - '0';   // '2' - '0' 
            // Existential crisisssssss
            // We do not return anything for this base case
            // Integer.parseInt() and Integer.valueOf() does NOT work here
            // !!!!!!!!!!!Note the addAll(...)
            mainRes.addAll(map.get(key)); 
        }

        // ******************************* Prep for Recursion *******************************
        // 5, 73 -- assume that result for 73 will be from recursion
        Integer key = digits.charAt(0) - '0';
        List<String> list = map.get(key); 


        // ******************************* RECURSION *******************************
        // 5, call(73)
        // 7, call(3)
        // Recursion uses stack, I wanted to pass 3 and append 7
        // But always go from higher to lower call -> direction where parameter size decreases
        // We have to reduce in order to reach base case
        // We cannot go increasing parameter size ever in recursion
        String rem = digits.substring(1);
        List<String> res = helper(rem,map);
        

        // ******************************* Post Recursion *******************************
          
        // I have two lists, I have to combine
        for(String l: list){
            for(String r: res){
                mainRes.add(l+r);
            }
        }

        return mainRes;
    }

}
/*
Time complexity: O(4^n * n), where N is the length of digits. Note that 4 in this expression is referring to the maximum value 
length in the hash map, eg, p,q,r,s, and not to the length of the input.

The worst-case is where the input consists of only 7s and 9s. In that case, we have to explore 4 additional paths for every extra 
digit. Then, for each combination, it costs up to N to build the combination. This problem can be generalized to a scenario 
where numbers correspond with up to M digits, in which case the time complexity would be O(m^n * n)
// For the problem constraints, we're given, M=4, because of digits 7 and 9 having 4 letters each.

*/