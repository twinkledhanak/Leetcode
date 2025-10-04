/**
JUDE SIR FTW
*/


class Solution {
    public int hammingWeight(int n) {
    byte a;
    int count=0;
    while(n != 0){
        a = (byte)(n%2); // n%2 gives last digit; but if we typecast it to (byte) it gives bit
        if(a==1)
            count++;
        n = n/2;
    }

    return count;
}
}

// For hamming distance, not sure if this might work
// Integer.bitCount(x^y);


/**
Time: O(n) where n=32, so approx O(1)
Space: O(1)
*/
public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) { // we change the mask 32 times, once for each bit 
        if ((n & mask) != 0) {
            bits++;
        }
        mask <<= 1; // keep shifting the mask left
    }
    return bits;
}


public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
        count++;
        n &= (n - 1);
    }
    count sum;
}