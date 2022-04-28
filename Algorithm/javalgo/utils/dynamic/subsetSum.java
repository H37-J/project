package dynamic;

public class subsetSum {
    
    public static void main(String[] args){
        int[] arr=new int[] {1,2,3};
        boolean[] visited=new boolean[arr.length];
        subsetSum(arr,6,visited);
        
    }

    private static boolean subsetSum(int[] arr , int sum,boolean[] visited){
        int n = arr.length;
        int num=0;

        for(int i = 0; i < n; i++){
            if(visited[i]==true) continue;
            num+=arr[i];
            visited[i]=true;

            if(sum==num){
                return true;
            }else{
                
            }
        }

        return false;

    }
}
