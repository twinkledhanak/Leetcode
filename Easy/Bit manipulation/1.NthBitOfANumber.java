/**
Print 5th bit of a number

*/

Given: x = 0001 0010
The value of 5th bit can be either 1 or 0
k = 5th bit 
2^k=2^5=16

x & 16 => 0001 0000 => 16
We need to divide this by 16 to get either 0 or 1 in their position 

(x & 16) / 16 => Gives 5th bit 

x << 1	Left shift by 1 bit (equivalent to multiplying x by 2). Each bit of x is shifted one position to the left, adding a 0 on the right.
x >> 1	Right shift by 1 bit (equivalent to integer division by 2). Each bit of x is shifted one position to the right, discarding the rightmost bit.

x & 2	Bitwise AND with 2. It checks if the second least significant bit in x is set to 1. If it is, the result is 2; otherwise, it is 0.
x % 2	Modulo 2 operation. It checks whether x is even or odd. If x is even, the result is 0; if x is odd, the result is 1.