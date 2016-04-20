import java.util.*;
import java.io.*;

public class Solution_uniqueInput{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		HashSet<String> validPairs=new HashSet<>();
		int pairs=in.nextInt();
		in.nextLine();
		for(int i=0;i<pairs;i++){
			validPairs.add(in.nextLine());
			System.out.println(validPairs.size());
		}
	}
}