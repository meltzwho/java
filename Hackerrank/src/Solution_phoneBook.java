import java.util.*;
import java.io.*;

public class Solution_phoneBook{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int len=in.nextInt();
		in.nextLine();
		Map<String, Integer> phoneBook=new HashMap<>();
		for(int i=0;i<len;i++){
			String name=in.nextLine();
			int phoneNum=in.nextInt();
			in.nextLine();
			phoneBook.put(name, phoneNum);
		}
		while(in.hasNext()){
			String query=in.nextLine();
			if(phoneBook.get(query)!=null){
				System.out.println(String.format(
						"%s=%d", query, phoneBook.get(query)));
			}
			else
				System.out.println("Not found");
		}
	}
}