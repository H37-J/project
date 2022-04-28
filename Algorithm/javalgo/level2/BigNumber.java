import java.util.Arrays;
import java.util.Comparator;

public class BigNumber {
    
    public static void main(String... args){
        int[] numbers={0,0,0,0,0};
        solution(numbers);
        // sort(numbers);
    }

    public static String solution(int[] numbers){
        String answer="";
        Comparator<String> comp=new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                return ((s2+s1).compareTo(s1+s2));
            }
        };
        String[] arr=Arrays.stream(numbers).boxed().map(String::valueOf).sorted(comp).toArray(String[]::new);
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("0") && answer.equals("") && i!=arr.length-1) continue;
            answer+=arr[i];
        }
        System.out.println(answer);
        return answer;
    }

    public static long combination(int[] numbers, int n,int depth,long max){
        if(depth==n){
            String str="";
            for(int v : numbers){
                str+=Integer.toString(v);  
            }
            if(max < Long.parseLong(str)){
                max=Long.parseLong(str); 
            }
            return max;
        }
        for(int i = depth; i < n; i++){
            swap(numbers,depth,i);
            max = combination(numbers,n,depth+1,max);
            swap(numbers,depth,i);
        }

        return max;
    }

    public static String sort(int[] numbers){
        String answer="";
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String e1,String e2){
                int index1=0;
                int index2=0;
                if(e1.equals(e2)) return 0;
                while(e1.charAt(index1)==e2.charAt(index2)){
                    if(index1!=index2) break;
                    index1=Math.min(index1+1,e1.length()-1);
                    index2=Math.min(index2+1,e2.length()-1);
                }
                if(e1.charAt(index1)==e2.charAt(index2) && e1.length() > e2.length()) return 0;
                if(e1.charAt(index1) < e2.charAt(index2)) return 1;
                else return -1;
            }
        };
        String[] arr=Arrays.stream(numbers).boxed().map(String::valueOf).sorted(comp).toArray(String[]::new);
        for(int i=0; i<arr.length; i++) answer+=arr[i];
        System.out.println(answer);
        return answer;
    }

    public static void swap(int[] arr, int depth, int i){
        int temp=arr[depth];
        arr[depth]=arr[i];
        arr[i]=temp;
    }
}









// numbers	return
// [6, 10, 2]	"6210"
// [3, 30, 34, 5, 9]	"9534330"