/*
Approach:

My solution was n^2 with a prefix array but I was able to pass all the test cases by making a slight optimization in the 
implementation. I made the observation that if you are scanning the array from left to right, and you match on a pair (L,R)
that is stable, then you know that L cannot ever be in another stable pair. So I incremented my count for L and set R to be L + 2.
Why can we do this? Because all of the elements in the array are strictly positive. if there was another server to the right of R 
that balanced with L, then the new sum in between them would include R and thus be larger than L (contradiction). Let me know if 
this helps!
*/