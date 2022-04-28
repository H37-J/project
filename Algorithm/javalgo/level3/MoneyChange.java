import java.util.Arrays;

public class MoneyChange {
   
    public static void main(String... args){
        int n=5;
        int[] money={1,2,5};
        Arrays.sort(money);
        solution(n,money,0,0,0);
    }

    public static int solution(int n,int[] money,int sum,int answer,int index){
        if(n==sum) {
            answer++;
            index=index+1;
            System.out.println(answer);
            return answer;
        }
        if(sum>n) return answer;

        for(int i=index; i<money.length; i++){
            sum+=money[index];
            answer=solution(n,money,sum,answer,index);
        }
        return answer;
    }
}


// n	money	result
// 5	[1,2,5]	4