// https://leetcode.com/problems/count-good-numbers/description/

/**
My approach:
Creating a recursion tree and according to fan-outs at every level, come up with 
some formula

when level=0, even index; possible choices-> 0,2,4,6,8 = 5
when level=1, odd index; possible choices-> 2,3,5,7=4

It seems that each level of tree has different fan-out depending on level no.

Tried to comeup with something like: 5^(height) * 4^(height)
but couldnt figure it out further
*/