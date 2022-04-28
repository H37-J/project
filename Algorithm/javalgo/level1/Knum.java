import java.util.Arrays;

public class Knum {

//     array	commands	return
// [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
    public static void main(String[] args){
        int[] arr={1,5,2,6,3,7,4};
        int[][] command={ {2,5,3}, {4,4,1}, {1,7,3}};

        solution(arr,command);

    }

    public static int[] solution(int[] arr,int[][] command){
        int start=0,end=0,index=0;
        int n = command.length;
        int[] copy=new int[n];
        int[] answer=new int[n];

        for(int i=0; i<n; i++){
           start=command[i][0]-1;
           end=command[i][1];
           index=command[i][2];

           copy=Arrays.copyOfRange(arr, start, end);
           Arrays.sort(copy);
           answer[i]=copy[index-1];
        }
        return answer;
    }
}
