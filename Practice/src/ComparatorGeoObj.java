import java.io.*;
import java.util.*;

public class ComparatorGeoObj implements Comparator<GeometricObject>, Serializable {
	
	public static void main(String[] args){
		GeometricObject rect1=new Rectangle(20,4);
		GeometricObject rect2=new Rectangle(20,5);
		ComparatorGeoObj max=new ComparatorGeoObj();
		System.out.println(max.compare(rect1, rect2));
		
	}
	
	public int compare(GeometricObject o1,GeometricObject o2){
		double area1=o1.getArea();
		double area2=o2.getArea();
		
		if(area1<area2)
			return -1;
		else if(area1==area2)
			return 0;
		else
			return 1;
	}
}

