public class studyfour {
    ///동적 계획법

    public static void main(String[] args){
        int result = fibo(6);
        System.out.println(result);
    }

    public static int fibo(int n){
        return n == 0 ? 0 : n == 1 ? 1 : fibo(n - 1) + fibo(n - 2);
    }
}
