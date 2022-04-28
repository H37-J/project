package math;

public class factorial {

    public static void main(String... args){
        assert factorial(5) == 120;
    }
    

    public static long factorial(int n){
        if(n<0){
            throw new IllegalArgumentException("number is negative");
        }
        return n==0 || n==1 ? 1 : n * factorial(n-1);
    }
}
