import java.util.ArrayList;
import java.util.Arrays;

import math.factorial;

public class Jul2 {

    public static void main(String... args) {
        int n = 4;
        int k = 6;
        ArrayList<Integer> list = new ArrayList<>();
        
    }

    public static int factorial(int n) {
        if (n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}

// n k result
// 3 5 [3,1,2]