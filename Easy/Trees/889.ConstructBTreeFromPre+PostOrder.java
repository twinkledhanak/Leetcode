// Pre: 1,2,4,5,3,6,7
// Pos: 4,5,2,6,7,3,1

//Inor: 4,2,5,1,6,3,7

/*
Refer roots from Pre-order
Refer children from Post-order

root = 1, start of preorder and end of postorder
problem is to find the break point for left and right children

In preoder, root = 1,then 2
post => 4 to 2(inclusive) = lhs ; 3(inclusive) to 1(exclusive) = rhs
Build on top of this idea
*/