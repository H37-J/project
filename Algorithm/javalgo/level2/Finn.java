public class Finn {

    public static void main(String... args) {
        int n = 15;
        solution(n);
    }

    public static int solution(int n) {
        int num = 1;
        int sum = 0;
        int copy=num;
        int count = 0;

        while (num != n) {
            sum += copy;
            copy++;

            if (n == sum) {
                count++;
                num++;
                copy=num;
                sum = 0;
            }else if(sum > n){
                num++;
                copy=num;
                sum=0;
            }
        }

        count++;


        return count;
    }
}
