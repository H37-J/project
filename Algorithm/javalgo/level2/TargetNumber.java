
public class TargetNumber {
    
    public static void main(String... args){
        int[] numbers={1,1,1};
        int target=-1;
        int answer=0;

        for(int i=1; i<=numbers.length; i++){
            answer+=solution(numbers,target,0,i,0,0,0);
        }
    }

    public static int solution(int[] numbers, int target,int sum,int n,int index,int count,int num){
        if(n==count){
            for(int v : numbers){
                sum+=v;
            }         
            if(sum==target){
                num=num+1;
            } 
            return num;
        }

        for(int i=index; i < numbers.length; ++i){
            numbers[i]=-numbers[i];
            num=solution(numbers,target,sum,n,i+1,count+1,num);
            numbers[i]=-numbers[i];
        }
        return num;
    }
}


// numbers	target	return
// [1, 1, 1, 1, 1]	3	5