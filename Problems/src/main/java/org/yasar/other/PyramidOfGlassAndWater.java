package org.yasar.other;

class PyramidOfGlassAndWater {

	/**
There are some glasses with equal capacity as 1 litre. The glasses are kept as follows:

    			   1
		         2   3
		      4    5    6
		    7    8    9   10
You can put water to only top glass. If you put more than 1 litre water to 1st glass, water overflows and fills equally in both 2nd and 3rd glasses. Glass 5 will get water from both 2nd glass and 3rd glass and so on.
If you have X litre of water and you put that water in top glass, how much water will be contained by jth glass in ith row?

Example. If you will put 2 litre on top.
1st â 1 litre
2nd â 1/2 litre
3rd â 1/2 litre

I have thought of a recursive approach. This approach is easy to understand and memory efficient.

Consider that rows are numbered starting from 1 and columns are numbered from 1.
So triangle will look like.

			            1				-> Row 1
			        1		2			-> Row 2
			    1	    2	    3		-> Row 3
			1		2		3		4	-> Row 4

Input is amount poured at topmost glass and required rownumber and column number.

For a given glass if water is poured on it; then it can store only 1 unit; 
and remaining water is divided into half and passed to right child and left child.
So amount passed to each child  = (amount at this glass -1) /2
Its children will have row number as (current row number +1)
Its left child will have column number same as current cup
Its right child will have column number as (current column number +1)

So start with topmost glass as current glass.
If required row number matches 
       then if required column matches amount is minimum(1,actual amonut)
       otherwise it is other cup of same row. So no need to go further down
else i.e. row does not match then 
       call the same function to get the amount of water in required cup by pouring water in left child 
       call the same function to get the amount of water in required cup by pouring water in right child 
       sum two amounts to get total amount from both path.
       value in the cup min(1, above sum) 
       
       SAMPLE OUTPUT 
       
       	    findWaterInGlass(10,1,1)=1.0
			findWaterInGlass(10,2,1)=1.0
			findWaterInGlass(10,2,2)=1.0
			findWaterInGlass(10,3,1)=1.0
			findWaterInGlass(10,3,2)=1.0
			findWaterInGlass(10,3,3)=1.0
			findWaterInGlass(10,4,1)=0.375
			findWaterInGlass(10,4,2)=1.0
			findWaterInGlass(10,4,3)=1.0
			findWaterInGlass(10,4,4)=0.375
			findWaterInGlass(10,5,1)=0.0
			findWaterInGlass(10,5,2)=0.0
			findWaterInGlass(10,5,3)=0.0
			findWaterInGlass(10,5,4)=0.0
			findWaterInGlass(10,5,5)=0.0
	 *    
	 */
	
	public static float findWaterInGlass(float inputAtTop, int rownum,int colnum){
		return findWaterInGlassInternal(inputAtTop,1,1,rownum,colnum);
	}

	public static float findWaterInGlassInternal(float input,int currentRow,int currentCol, int requiredRown,int requiredColnum){
		if(requiredColnum>requiredRown) throw new RuntimeException("requiredColnum>requiredRown");
		if(currentRow==requiredRown){
			if(currentCol==requiredColnum) 
				return min(input,1);
			else
				return 0;
		}else{
			// Pour water in right side and in left side equally
			float waterForNextLevel = (input-1)/2;
			if(waterForNextLevel>0){
				float waterFromLeftBranch= findWaterInGlassInternal(waterForNextLevel,currentRow+1,currentCol,requiredRown,requiredColnum) ; 
				float waterFromRightBranch	= findWaterInGlassInternal(waterForNextLevel,currentRow+1,currentCol+1,requiredRown,requiredColnum);
				return min(waterFromLeftBranch+waterFromRightBranch,1);
			}else{
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		int totalRounum =5;
		int waterQuantity =10;
		for(int i=1;i<=totalRounum;i++){
			for(int j=1;j<=i;j++){
				System.out.println("findWaterInGlass("+waterQuantity+","+i+","+j+")="+ findWaterInGlass(waterQuantity,i,j));
			}
		}
		
	}
	public static float  min(float a, float b){
		return a<b?a:b;
	}
}
