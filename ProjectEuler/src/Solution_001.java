public class Solution_001 {
	public static void main(String args[]){
		int sum=0;
		for(int i=1;i<=333;i++){
			sum+=i*3;
		}
		for(int i=1;i<=199;i++){
			sum+=i*5;
		}
		for(int i=1;i<=66;i++){
			sum-=5*3*i;
		}
		System.out.print(sum);
	}
}
