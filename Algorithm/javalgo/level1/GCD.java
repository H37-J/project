public class GCD {
   
    public static void main(String... args){
        int n=8;
        int m=12;
        System.out.println(gcd(n,m));
        System.out.println(lcm(n,m));
    }

    public static int gcd(int n,int m){
        if(n<m){
            int temp=m;
            m=n;
            n=temp;
        }
        return n % m == 0 ? m : gcd(m, n % m);
    }

    public static int lcm(int n,int m){
        return (n * m) / gcd(n,m);
    }
}
