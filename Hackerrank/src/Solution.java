import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> intSet=new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int largest=0,num,rm=0,size;
        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            deque.addLast(num);
            if(deque.size()==m){
                intSet.addAll(deque);
                size=intSet.size();
                if(size>largest)
                    largest=size;
                rm=deque.removeFirst();
                intSet.remove(rm);
            }
        }
        System.out.print(largest);
    }
}
//test case #8 in 1.17s