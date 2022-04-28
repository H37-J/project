import java.util.ArrayList;

public class Fibo {
    
    public static void main(String... args){
        int n=7;
        int answer=solution(n);
        System.out.println(answer);
    }

    public static int solution(int n){
        ArrayList<Integer> list=new ArrayList<>();
        if(n==0) return 0;
        if(n==1) return 1;

        list.add(solution(0));
        list.add(solution(1));
        for(int i=2; i<=n; i++){
            if(i >= 3){ 
                list.add((list.get(i - 1) + list.get(i - 2)) % 1234567); 
                continue;
            }
            list.add(((solution(i - 1) + solution(i - 2))) % 1234567); 
        }

        return list.get(n);
    }
}
