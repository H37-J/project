public class Nanum1 {
    
    public static void main(String... args){
        int num=12;
        solution(num);
        System.out.println(solution(num));
    }

    public static int solution(int num){
        int answer=-1;
        for(int i=2; i<num; i++){
            if(num % i ==1){
                answer=i;
                break;
            }
        }
        return answer;
    }
}
