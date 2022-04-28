package math;

public class AbsoluteMax {
    
    public static void main(String... args){
        int[] numbers={-2,-10,9};
        System.out.println(absMax(numbers));
    }

    public static int absMax(int[] numbers){
        int max=numbers[0];
        for(int i=1; i<numbers.length; i++){
            if(Math.abs(numbers[i])>Math.abs(max)){
                max=numbers[i];
            }
        }
        return max;
    }
}
