class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)) {
                // If the top asteroid in the stack is smaller, then it will explode.
                // Hence pop it from the stack, also continue with the next asteroid in the stack.
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }
                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                flag = false;
                break;
            }

            if (flag) {
                stack.push(asteroid);
            }
        }

        // Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[stack.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = stack.peek();
            stack.pop();
        }

        return remainingAsteroids;
    }
}
/*
Here, N is the number of asteroids in the list.

Time complexity: O(N).

We iterate over each asteroid in the list, and for each asteroid, we might iterate over the asteroids we have in the stack and keep popping until they explode. The important point is that each asteroid can be added and removed from the stack only once. Therefore, each asteroid can be processed only twice, first when we iterate over it and then again while popping it from the stack. Therefore, the total time complexity is equal to O(N).

Space complexity: O(N).

The only space required is for the stack; the maximum number of asteroids that could be there in the stack is N when there is no asteroid collision. The final list that we return, remainingAsteroids, is used to store the output, which is generally not considered part of space complexity. Hence, the total space complexity equals O(N).

*/


////////////
/*
What I was attempting to write:
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int stackSign = 1, elemSign = 1, n = asteroids.length();

        if(n <= 1)
            return asteroids;

        stack.push(asteroids[0]);

        for(int i=1; i<asteroids.length; i++){
            stackSign =  stack.top() > 0 ? 1 : -1;
            elemSign = a > 0 ? 1 : -1;
            if(stackSign == elemSign)
                stack.push(a);
            else{
                // -5 and 10
                int elem = stack.pop(); // 10
                stackSign =  stack.top() > 0 ? 1 : -1;
                elemSign = a > 0 ? 1 : -1;
                int result = getCollisionResult(elem,a);
                if(result > 0)
                    stack.push(result);
                    // ** Check, now we need to repeat the same process again
            } 



        }


    }


    public int getCollisionResult(int a, int b){
        // -5; 10
        int direction = 1, dirA = 1, dirB = 1;
        dirA = a > 0 ? 1 : -1; dirB = b > 0 ? 1 : -1; 
        if(Math.abs(a) != Math.abs(b))
            direction = (Math.abs(a) > Math.abs(b))? dirA : dirB;
        else 
            direction = 0;

        return direction * Math.max(Math.abs(a),Math.abs(b)); // return 10

    }
}


*/