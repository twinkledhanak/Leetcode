/**

The first intuition is to use binary OR for adding numbers
But, we use XOR instead
@TODO - Verify
*/


public int addNumbers(int a, int b){

    int carry;

    while(b!=0){
        c = a & b; // Get the carry
        a = a ^ b; // store the sum
        b = c << 1; // Left shift, multiply by 2
    }

    return a;
}