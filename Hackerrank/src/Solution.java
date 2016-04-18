import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int largestSum=0;
        for(int i=0;i<4;i++){
        	for(int j=0;j<4;j++){
        		int currentSum=arr[i][j]+arr[i][j+1]+arr[i][j+2];
        		currentSum+=arr[i+1][j+1];
        		currentSum+=arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
        		if(i==0 && j==0)
        			largestSum=currentSum;
        		if(currentSum>largestSum)
        			largestSum=currentSum;
        	}
        }
        System.out.print(largestSum);
    }
}