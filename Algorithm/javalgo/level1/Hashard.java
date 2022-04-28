public class Hashard {
    
    public static void main(String... args){
        int num=13;
        System.out.println(solution(num));
    }

    public static boolean solution(int num){
        int sum=0;
        int copy=num;
        do{
            sum+=copy%10;
            copy=copy/10;
        }while(copy!=0);
        return num % sum == 0;
    }
}
