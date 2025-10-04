/**
Time complexity: 
n is the maximum length of encoded string. 
maxK is the maximum value of k, countK is the count of nested k values
O(n * (maxK ^ countK))

Space: O(sum( n * (maxK ^ countK) ))
*/

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == ']') {
                // We have to keep popping chars until [, then apply the operation to expand string and push it back to stack


                List<Character> decodedString = new ArrayList<>();
                // Step 1: Get the encoded string
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop()); // This will append the chars in reverse direction Eg. ac
                }

                // Step 2: Get rid of the [
                // pop [ from the stack
                stack.pop();

                // Step 3: Get the number (it can be a single digit or multiple digits, Eg. 12 , so first 1, then 2 as stack pop)
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base; // stack.pop() - '0' is to convert char to Integer
                    base *= 10;
                }

                
                // decode k[decodedString], by pushing decodedString k times into stack
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j)); // so, if we have 3[a] , instead of pushing aaa into stack, we are 
                        // pushing three records -> a, a, a
                    }
                    k--;
                }



            }
            // push the current character to stack
            else {
                stack.push(s.charAt(i)); // Keep pushing until we encounter a ]
            }
        }      



        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop(); // directly append to result array of type char
        }
        return new String(result); // build a string from character array
    }
}

/**
Second approach:
n is the maximum length of encoded string. 
maxK is the maximum value of k, 
Time: O(maxK*n)
*/

class Solution {
    String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            // Number 
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } 

            // [
            else if (ch == '[') {
                // push the number k to countStack
                countStack.push(k);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and k
                currentString = new StringBuilder();
                k = 0;
            } 

            // ]
            else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } 

            // just some char
            else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}



