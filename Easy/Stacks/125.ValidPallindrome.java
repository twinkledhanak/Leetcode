class Solution {
    public boolean isPalindrome(String s) {
        boolean result = true;
        String regex = "[^a-zA-Z0-9]";
        s = s.replaceAll(regex, "").toLowerCase();
        int a = 0, b = s.length()-1;

        while(a<b){
            if(s.charAt(a)!=s.charAt(b)){
                result=false;
                break;
            }
            a++; b--;
        }

        return result;

    }
}        
