package math;

public class PowRecursion {

    public static void main(String[] args){
        long result = pow(2,3);
        System.out.println(result);
    }
    
    public static long pow(int a,int b){
        return b == 0 ? 1 : a * pow(a,b-1);
    }
}
