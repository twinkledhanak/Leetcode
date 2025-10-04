Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: Using library sort function is not allowed.
Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]

Template (To be provided to the candidate): 

// red, white, blue
// Brute force
// Bubble sort - O(n^2)
// Merge sort - O(nlogN)

// Two pointer approach
// p2
//     [0 1 2 0 1 2]
//     [0 1 1 0 2 2]    
// idx: 0 1 2 3 4 5
// p1 = 0
// p2 = 5

/*
//     [0 1 2 0 1 2]
//     [0 1 1 0 2 2]    
// idx: 0 1 2 3 4 5

//     [0 1 2 0 1 2]
//     [0 1 1 0 2 2]    
// idx: 0 1 2 3 4 5


*/

public class Solution {
    public void sortColors(ArrayList<Integer> a) {
        
        // we are focussing on sorting 2's first
        // 
        int p1 = 0, p2 = a.length-1;
        while(p1 < p2){
            // focussing on 2's
            if(a.get(p1) != 2){
                p1+=1;
            }
            else{
                if(a.get(p1) != a.get(p2)){
                    // swap, 
                    int temp = a.get(p1);
                    a.get(p1) = a.get(p2);
                    a.get(p2) = temp;
                    
                }
                p2--;
            }
           
        }
        
        // we are focussing on sorting 1's first
        p1
        
        
        
        
        
    }
}



Question:
Write a program to calculate the price of a pizza. Prompt the user for 3 things

* Base Bread ( Options: Gluten Free, Regular )
* Size ( Small, Medium, Large, Extra Large )
* Toppings ( Pepperoni, jalapenos, pineapple )


/*
1. Base price for Bread
2. Price by Size
3. Price by Toppings

Approach:
Hashmap -> stores prices for every category
1 pizza

UI -> Bread, Size, Toppings

*/


class Solution{
    
    private static final Map<String,Integer> pricesMap = new HashMap<>();
    pricesMap("glutenfree",5);
    pricesMap("regular",3);
    pricesMap("small",5);
    pricesMap("medium",7);
    pricesMap("large",10);
    pricesMap("extralarge",12);
    pricesMap("pepperoni",2);
    
    public static void main(Strings args[]){
        
        try{
        
        String regexPattern = "[^a-zA-Z0-9]";
        float pizzaPrice = 0;
        constant float largeSizeFactor = 0.5;
        constant float normalSizeFactor = 1;
        
        
        // Input
        System.out.println("Please enter your base bread: Options: Gluten Free, Regular");
        Scanner sc = new Scanner();
        String baseBread = sc.nextString();
        
        System.out.println("Please enter your size: Options: Small, Medium, Large, Extra Large");
        Scanner sc = new Scanner();
        String pizzaSize = sc.nextString();
        
        System.out.println("Please enter your size: Options: Pepperoni, jalapenos, pineapple. 
        Enter it one by one. Max 3 options");
        Scanner sc = new Scanner();
        List<String> toppings = new ArrayList<>();
        int noOptions = 3;
        
        for(int i=0; i<noOptions; i++){
            toppings.add(sc.nextString());
        }
        
        // Processing
        
        // bread
        if(map.containsKey(baseBread)){
            pizzaPrice += map.get(baseBread);
        }
        
        // size
        if(map.containsKey(pizzaSize)){
            pizzaPrice += map.get(pizzaSize);
        }
        
        
        // toppings
        pizzaPrice += getPriceForToppings(toppings,pizzaSize);
        
        }
        catch(Exception e){
            System.out.println("Error: "+e);
        }
        
        return price;
        
    }
    
    
    public String preProcess(String s){
        s = String.replaceAll(regexPattern,"");
        s = String.replaceAll("\\s+","").toLowerCase();
    }
    
    
    public float getPriceForToppings(List<String> toppings,String pizzaSize){
        float sizeFactor = preProcess(pizzaSize).equals("large") ? largeSizeFactor : normalSizeFactor;
        
        for(String top: toppings){
            if(map.containsKey(top)){
            price += (sizeFactor * map.get(top));
            }
            
        }
        
    }
    
}


