import java.util.*;
import java.io.*;

public class Solution_arrayList{
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		ArrayList<int[]> list=new ArrayList<>();
		for(int i=0;i<n;i++){
			int d=in.nextInt();
			int[] ints=new int[d];
			for(int j=0;j<d;j++){
				ints[j]=in.nextInt();
			}
			list.add(ints);
		}
		int q=in.nextInt();
		for(int i=0;i<q;i++){
			int x=in.nextInt();
			int y=in.nextInt();
			int[] ints=list.get(x-1);
			try{
				System.out.println(ints[y-1]);
			}catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("ERROR!");
			}
		}
	}
	
}