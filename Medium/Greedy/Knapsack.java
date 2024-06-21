// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
class Main{
    public static void main(String args[]){
        int[] profit = new int[]{7,12,20,1};
        int[] weight = new int[]{2,3,4,1};
        int capacity = 8;
        double result = maxProfit(profit,weight,capacity);
        System.out.println("Max Profit: "+result);
    }


    public static double maxProfit(int[] profit, int[] weight, int capacity){
        double profitVal = 0;
        // 1. Calculate profit/weight and store in maxheap

        PriorityQueue<MyPair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.getValues(), a.getValues()));
        for(int i=0; i<profit.length; i++){
            //System.out.println("Index: "+i+" p/w: "+(double)profit[i]/weight[i]);
            pq.offer(new MyPair(i,(double)profit[i]/weight[i]));
        }
        
        for(MyPair mp: pq){
            System.out.println("Index: "+mp.getIndex()+" value: "+mp.getValues());
        }
        

        while(capacity > 0){
            MyPair elem = pq.peek();
            pq.poll();
            
            
            System.out.println("Polled Index: "+elem.getIndex()+" value: "+elem.getValues());
        	int i = elem.getIndex();

            if(capacity >= weight[i]){
            	//System.out.println("Cap: "+capacity);
                capacity -= weight[i];
                profitVal += profit[i];
            }
            else{
                //System.out.println("invvalid Cap: "+capacity);
                int cap = Math.abs(weight[i] - capacity);
                capacity -= cap;
                profitVal += ((double)cap/weight[i]) * profit[i];
                //System.out.println("calc: "+(cap/weight[elem.getIndex()]) * profit[elem.getIndex()]);
            }
           System.out.println("remaining Cap: "+capacity);

        }

        return profitVal;



    }

    public static class MyPair{
        int index;
        double value;

        public MyPair(int index, double value){
            this.index=index;
            this.value=value;
        }

        public int getIndex(){
            return this.index;
        }


        public double getValues(){
            return this.value;
        }
    }


}

