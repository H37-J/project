public class OddEven {
   
    public static void main(String... args){
        int num=3;
        System.out.println(solution(num));
    }

    public static String solution(int num){
        if(num % 2 == 0) return "Even";
        else return "Odd";  
    }
}
