import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

public class Recursive {
    
    public static void main(String... args){
        int answer=sum(5);
        System.out.println(answer);

        //2진수
        BinaryNumber(9);

        //글자 거꾸로
        primaryReverse("hell");

        //배열의 합
        System.out.println("-- 배열의 합 재귀--");
        int[] array={1,2,3,4};
        System.out.println(doSum(array));

        //n개중의 r개를 선택하여 더한 배열내의 합 조합
        System.out.println("--배열의 합 내에서 소수찾기--");
        int[] arr={1,2,4,6,7};
        HashSet<Integer> list=new HashSet<>();
        boolean[] visited=new boolean[arr.length];
        combi(arr, 0, 3, list, visited);
        int count=primeCheck(list);
        list.stream().forEach(System.out::println);
        System.out.println(count);
    }

    //팩토리얼
    private static int sum(int n){
        if(n==1){
            return 1;
        }

        return n+sum(n-1);
    }

    //2진수로 변환
    private static void BinaryNumber(int n){
        if(n<2){
            System.out.println(n);
        }
        else{
            BinaryNumber(n/2);
            System.out.print("n:"+n+",");
            System.out.println(n%2);
        }
    }

    //글자 거꾸로 출력하기
    private static void primaryReverse(String str){
        if(str.length()==0){
            return;
        }else{
            System.out.println(str.substring(1));
            primaryReverse(str.substring(1));
            System.out.println(str.charAt(0));
        }
    }

    //배열탐색
    private static int search(int begin,int end,int[] data,int target){
        if(begin>end){
            return -1;
        }else if(target==data[begin]){
            return begin;
        }else{
            return search(begin+1,end,data,target);
        }
    }

    //배열합산
    private static int doSum(int[] array){
        
        if(array.length <=1){
            return array[0];
        }

        int[] nextTarget=Arrays.copyOfRange(array,1,array.length);
        return array[0]+doSum(nextTarget);
    }

    //회문 판별
    private static boolean checkPalindrome(String word){
        if(word.length()<=1){
            return true;
        }

        if(word.charAt(0) == word.charAt(word.length()-1)){
            return checkPalindrome(word.substring(1,word.length()-1));
        }else{
            return false;
        }
    }

    //순열
    private static void swap(int[] arr,int depth,int i){
        int temp=arr[depth];
        arr[depth]=arr[i];
        arr[i]=temp;
    }

    private static void permutation(int[] arr,int depth,int r){
        if(depth==r){
            print(arr,r);
            return;
        }

        for(int i=depth; i<arr.length; i++){
            swap(arr,depth,i);
            permutation(arr,depth+1,r);
            swap(arr,depth,i);
        }
    }

    private static void combi(int[] arr,int start,int r,HashSet<Integer> list,boolean[] visited){
            
        if(r==0){
            int sum=0;
            for(int i=0; i<arr.length; i++){
                if(visited[i]){
                    sum+=arr[i];
                }
            }
            list.add(sum);
        }

        for(int i=start; i<arr.length; i++){
            visited[i]=true;
            combi(arr,i+1,r-1,list,visited);
            visited[i]=false;
        }
    }

    private static int primeCheck(HashSet<Integer> list){
        int N=100;
        int answer=0;
        Boolean[] prime=new Boolean[N+1];

        Arrays.fill(prime,true);

        for(int i=2; i<=N; i++){
            if(prime[i]==false) continue;
            for(int j=2; j<=N; j++){
                if(i * j > N) break;
                prime[i*j]=false;
            }
        }
        prime[0]=false;
        prime[1]=false;

        for(Integer s: list){
            if(prime[s]==true) {
                answer++;
            }
        }

        return answer;
    }



    private static void print(int[] arr,int r){
        int[] printarr=arr.clone();

        if(printarr.length>r){
            for(int i=0; i<printarr.length; i++){
                if(i+1>r){
                    printarr[i]=-1;
                }
            }
        }

        System.out.println("Array: " + Arrays.toString(printarr));
    }
}
