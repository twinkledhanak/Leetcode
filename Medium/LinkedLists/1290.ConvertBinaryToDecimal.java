/**
Given head of a Singly LL
We have 1 -> 0 -> 1 (which is 5 in decimal)
To convert, we know that - 2^2 + 0 + 2^0 = 5
We do not know the index at which we are. We do not know the length of LL.
But, we still find out the decimal representation
Reversing the LL might not be a good option
My approach -> Traverse the LL and store its values to array. 

Option2: We can also traverse and find the LL length. Then use it 

Option3: We can reverse the LL and then we will traverse and multiply
*/


class Solution {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;    
        }
        return num;
    }
}

/*
Eg. 1 -> 0 -> 1
1: num = 1
0: num = (1 << 1) | 0 = 2
1: num = (2 << 1) | 1 = (2*2) | 1 = 5
*/

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val; // OR '|' is for addition
            head = head.next;    
        }
        return num;
    }
}

// Time: O(n); Space: O(1)