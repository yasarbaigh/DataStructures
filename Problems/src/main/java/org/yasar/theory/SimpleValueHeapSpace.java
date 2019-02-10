package org.yasar.theory;

//https://stackoverflow.com/questions/79923/what-and-where-are-the-stack-and-heap/80113#80113

//https://stackoverflow.com/questions/6801676/heap-vs-stack-vs-perm-space
public class SimpleValueHeapSpace {
  //The Class (loaded by a classloader) is in the PermGen

	    private static final int MAGIC_CONSTANT = 42; //Static fields are stored in PermGen
	    private static final SimpleValueHeapSpace INSTANCE = new SimpleValueHeapSpace(1); //Static field objects are created in the heap normally,
	    //with the reference in the PermGen ('class statics' moved to the heap from Java 7+)
	    
	    
	    private static SimpleValueHeapSpace previousInstance; //Mutable static fields also have their reference in PermGen so they can easily cause memory leaks

	    private int value; //Member variables will be part of the heap

	    public SimpleValueHeapSpace(int realValue) {
	        value = realValue;
	        //...
	    }

	    public static int subtract(SimpleValueHeapSpace val1, SimpleValueHeapSpace val2) {
	         ///....
	    	return -1;
	    	
	    }

	    public int add(SimpleValueHeapSpace other) { //Only one copy of any method (static or not) exists - in PermGen
	         int sum = value + other.value; //Local values in methods are placed in the Stack memory
	         return sum;
	    }

	

	public static void main(String[] args) {

	    SimpleValueHeapSpace val1 = null;
	    SimpleValueHeapSpace val2 = new SimpleValueHeapSpace(3); //Both of these variables (references) are stored in the Stack 

	    val1 = new SimpleValueHeapSpace(14); //The actual objects we create and add to the variables are placed in the Heap 
	    //(app global memory, initially in the Young Gen space and later moved to old generation, unless they are very large they can immediately go old gen)

	    int prim = val1.add(val2); //primitive value is stored directly in the Stack memory
	    Integer boxed = new Integer(prim); //but the boxed object will be in the heap (with a reference (variable) in the Stack)

	    String message = "The output is: "; //In Java 7+ the string is created in the heap, in 6 and below it is created in the PermGen
	    System.out.println(message + prim);

	}
}





