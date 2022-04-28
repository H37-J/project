public class Sqrt {
    
    public static void main(String... args){
        double n=121;
        System.out.println(solution(n));
    }

    public static long solution(double n){
        double s=Math.sqrt(n);
        if((int)s != s) return -1;
        return (long)(s+1) * (long)(s+1);
    }
}
