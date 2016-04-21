import java.util.*;

public class Solution_deque {
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
            intSet.add(num);
            if(deque.size()==m){
                size=intSet.size();
                if(size>largest)
                    largest=size;
                rm=deque.removeFirst();
                if(!deque.contains(rm))
                    intSet.remove(rm);
            }
        }
        System.out.print(largest);
    }
}