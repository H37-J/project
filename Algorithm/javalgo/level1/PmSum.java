public class PmSum {
//     absolutes	signs	result
// [4,7,12]	[true,false,true]	9
// [1,2,3]	[false,false,true]	0

    public static void main(String... args){
        int[] absolutes={4,7,12};
        boolean[] signs={true,false,true};
        solution(absolutes,signs);
    }

    public static int solution(int[] absolutes,boolean[] signs){
        int sum=0;
        for(int i=0; i<absolutes.length; i++){
            if(signs[i]==true) sum+=absolutes[i];
            else sum-=absolutes[i];
        }
        return sum;
    }
}
