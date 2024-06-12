
// My SOLUTION
class Solution {
    public String reverseWords(String s) {
        String regex = "\s+";
        s = s.replaceAll(regex," ");
        //System.out.println("Individual: "+s);
        String result = "";
        
        String[] tokens = s.split(" ");
        int n = tokens.length;


        // Swapping, but can be also done using libraries
        for(int i=0; i<n/2; i++){
            String temp = tokens[i];
            tokens[i] = tokens[n-i-1];
            tokens[n-i-1] = temp;
        }

        for(String x: tokens){
            x = x.replaceAll(regex,"");
            if(x.length() > 0){
                //System.out.println("Now:"+x+"..");
                result = result.concat(x).concat(" ");
            }
            
        }

        return result.trim();
    }
}

// Time: O(n)
// Space: O(n)