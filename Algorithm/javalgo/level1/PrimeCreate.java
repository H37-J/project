
import java.util.*;

public class PrimeCreate {

    // 주어진 배열로 소수를 만드는 문제
    public static void main(String... args) {
        int[] arr = { 1, 2, 7 };
        boolean[] visited = new boolean[arr.length];
        ArrayList<Integer> list = new ArrayList<>();

        combination(arr, 0, 0, 0, list);

        // for(int value : list){
        // System.out.println(value);
        // }
    }

    public static void combination(int[] arr, int count, int sum, int start, ArrayList<Integer> list) {

        if (count == 2) {
            System.out.print(","+sum);
            list.add(sum);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            System.out.print(count + "," + i+" ");
            combination(arr, count + 1, sum += arr[i], i + 1, list);
            System.out.println("");

            sum -= arr[i];
        }
    }

    public static boolean primeCheck(int num) {

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0 || num < 2) {
            return false;
        }

        for (int i = 3; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static int primeCount(ArrayList<Integer> list) {
        int count = list.size();
        for (int value : list) {
            if (value % 2 == 0) {
                count--;
                continue;
            }

            for (int i = 3; i <= (int) Math.sqrt(value); i += 2) {
                if (value % i == 0) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }

}
