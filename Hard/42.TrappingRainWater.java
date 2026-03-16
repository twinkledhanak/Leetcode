/**
Regular Two pointer style doesnt work here as we are looking
for global minimum and maximum
	•	Use two pointers at left and right ends
	•	Keep track of maxLeft and maxRight
	•	Move the pointer with smaller height toward center

At any given index i, water level at that index i is determined as:
water at i = Min(leftMax of i, rightMax of i) - height[i]
*/

int left = 0, right = n-1;
int maxLeft = 0, maxRight = 0;
int water = 0;

while(left <= right){

    // if left side has smaller height
    if(height[left] < height[right]){

        // check if it is bigger than global of left side    
        if(height[left] >= maxLeft) 
            maxLeft = height[left];
        else 
            water += maxLeft - height[left];
        left++; // do not forget
    } else {
        // check if it is bigger than global of right side    
        if(height[right] >= maxRight) 
            maxRight = height[right];
        else 
            water += maxRight - height[right];
        right--;
    }
    
}