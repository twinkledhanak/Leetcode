class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int maxLen = 0;
        int domFreq = 0;
        char domChar = 'A';
        int[] map = new int[26]; // Java puts all to 0

        for(end = 0; end<s.length(); end++){
            char ch = s.charAt(end);
            map[ch-'A']+= 1;

            // Maintaining the dominant char and freq
            if(domFreq < map[ch-'A']){
                domFreq = map[ch-'A'];
                domChar = ch;
            }

            // Shrinking invariant
            while((end-start+1) - domFreq > k){
                // shrink
                map[s.charAt(start)-'A'] -=1;
                start+=1;
            }

            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }
}

// My thought process:
/**
I know how dynamic sliding window works.
1. Expand the window
2. Try to do something (in this case, whatever is asked in question)
3. Have the invariant and work with it like: while(negative of invariant){ shrink the window}


My idea is as follows:
1. Go over the window starting from first character
2. Maintain an array of characters with frequency, index 0 is A, index 1 is B, etc
3. Insert the first character in array.
If the character does not exist (its freq is still 0 or arr[index]=0)
simply insert it. Mark it as dominant character.

4. Go to next string character and check, again
This time, if it exists - 
Increment its frequency.
Update the dominant character based on comparing freq of dominant and current char, record length at this point.

5. Now, when we proceed to next character - when we encounter a character that is new,
It means it has violated our window (I think invariant is we are trying to maintain a window of same characters), so see if we can repair it before we decide to shrink it.

Repair -> decrement k - keep the current dominant char as it is
If k is already 0, window cannot be repaired and it is time to shrink it.

I cannot understand how and how much to shrink. Let us analyze this deeply step by step. I want to try to learn to arrive at a solution by finding defects in my thinking approach for a problem

Then later on as I discussed:

Key defects in your approach
	1.	Thinking any new character automatically violates the window — wrong. The window is valid as long as (window length - maxFreq) ≤ k.
	2.	Trying to calculate exact shrink amount upfront — unnecessary. Shrink stepwise until invariant is satisfied.
	3.	Updating dominant character too aggressively — you only need maxFreq for invariant; don’t constantly track which character is dominant exactly.


In this problem:
	•	k = the maximum number of character replacements allowed in the current substring (window) to make it all the same.


What I thought was the invariant:

Adding a new character to window breaks it and makes it invalid


What actually is the invariant:

When no of wrong characters in window are more than k, we cannot replace all of them.
So, for a valid window, 
freq of dominant chars + wrong chars = no of all chars in window or window length
no of wrong chars <= k
More mathematically,

windowLength - freq of dominant chars <= k


In dynamic window, we always negate the invarint, so condition becomes =
while(windowlength - freq of dominant chars > k ) {shrink}
while((end-start+1) - domfreq > k ) {shrink}

How to even arrive at this?
The question literally says it:
Return the length of the longest substring containing the same letter you can get after performing the operations at most k times

*/