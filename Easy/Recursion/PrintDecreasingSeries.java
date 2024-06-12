printSeries(n);

public void printSeries(int n){
    if(n<1)
        return;
    System.out.println(n);
    printSeries(n-1);    
}


// input: 5
// output:
5
4
3
2
1


// Print Increasing
if(n<1)
    return
printSeries(n-1)    
System.out.println(n);