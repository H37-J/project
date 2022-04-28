package others;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args){
        System.out.println("Enter number of idscs on Pole 1:");
        Scanner scanner=new Scanner(System.in);
        int numberOfDiscs= scanner.nextInt();
        shift(numberOfDiscs,"폴1","폴2","폴3");
        scanner.close();
    }

    public static void shift(int n, String startPole, String intermediatePole, String endPole) {
        // if n becomes zero the program returns thus ending the loop.
        if (n != 0) {
          // Shift function is called in recursion for swapping the n-1 disc from the startPole to the
          // intermediatePole33
          shift(n - 1, startPole, endPole, intermediatePole);
          System.out.format("Move %d from %s to %s\n", n, startPole, endPole); // Result Printing
          shift(n - 1, intermediatePole, startPole, endPole);
          System.out.println(startPole);
        }
      }
}
