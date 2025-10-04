public void swap(int x, int y){
    if(x != y){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }
}