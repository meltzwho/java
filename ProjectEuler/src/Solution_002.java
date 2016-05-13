import java.util.*;

public class Solution_002 {
	public static void main(String args[]){
		int fibSum=0;
		int[] fibs=new int[3];
		fibs[0]=0;
		fibs[1]=1;
		while(true){
			fibs[2]=fibs[0]+fibs[1];
			fibs[0]=fibs[1];
			fibs[1]=fibs[2];
			if(fibs[2]>=4000000)
				break;
			if(fibs[2]%2==0)
				fibSum+=fibs[2];
		}
		System.out.print(fibSum);
	}
}
