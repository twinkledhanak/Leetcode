//https://leetcode.com/discuss/study-guide/5050162/Beginners-Guide-for-DFS-on-GridMatrix-or-Three-Variations/
// SAME THING, BUT DONE IN 3 DIFFERENT WAYS

// USUALLY, if the return type for boundary condition is true and the DFS call has to return something, it returns true.




// TYPE 1:
// All base cases are combined into one
// Eg. Number of Islands, DFS doesnt return anything, we just have all the cells marked as visited
DFS(){
	//Single Base Case 
	if boundary of Matrix is crossed  
		return 
		
    //Eg. Marking the current co-ordinate on grid as visited, we just mark it '0' instead of '#'  
	// Getting all cells connected to a given cell => Main aim of DFS  
	// Marking all these connected cells as visited
	// We had a variable outside in the main to keep track of no of islands
	Process the current coordinate
	
	//Recursive calls for Neighbours
	DFS( right );
	DFS( down );
	DFS( left );
	DFS( up );
} 

// **************************************************************************************************************

// TYPE 2:
// Separate base case before every recursive call
// Eg. Surrounded regions
DFS(){
	// No boundary check, we have already covered everything. We are already processing the boundary cells

    //Eg. Marking the current co-ordinate on grid as visited 
	Process the current coordinate

	// Getting all cells connected to a given cell => Main aim of DFS
	// Marking all these connected cells as E (some identifier to say that these are as useless as X is)
	// 
	
	// We will have a lot of calls, so to PRUNE them, we can add relevant conditions
	Base Case for going right
	DFS( right );
	//if (col < this.COLS - 1) 
    //    this.DFS(board, row, col + 1); // can go right
	
	Base Case for going down
	DFS( down );
	
	Base Case for going left
	DFS( left );
	
	Base Case for going up 
	DFS( up );
}

// **************************************************************************************************************

// TYPE 3:
// Combining everything into Direction vector
// Eg. Number of Islands
int dir[4][2]={{0,1},{1,0},{-1,0},{0,-1}}
DFS(){
	Process the current Coordinate 
	for(int i=0;i<4;i++){
		//nx and ny are just the neighbours coordinates 
		int nx = dir[i][0]+current_x_coordinate
		int ny = dir[i][1]+current y coordinate 
		
		BaseCase check on nx and ny we just calculated 
			DFS(nx, ny )
	}
}