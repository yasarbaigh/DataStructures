package org.yasar.ds.string.points;

public class Point {

	public int x;
	public int y;

	public Point() {
		x = 0;
		y = 0;
	}
	
	public int hashCode() {
		
		return super.hashCode();
	}
	public boolean equals(Object objt) {
	
		if(objt == null) 
			return false;
		
		Point that = (Point) objt;
		boolean flag = this.x == that.x ? true : false; 
		
		if(flag) {
			
			return this.y == that.y ? true : false;
		}
		
		return false;
	}
}
