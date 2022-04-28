package math;

public class Combinations {
    
    public static long factorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        return n==0 || n==1 ? 1 : n * factorial(n-1);
    }

    public static long combinations(int n,int k){
        return factorial(n) / (factorial(k) * factorial(n-k));
    }
}
