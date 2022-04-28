public class Dejin {
    
    public static void main(String... args){
        int N=8;
        int A=4;
        int B=5;
        solution(N,A,B);
    }

    public static int solution(int n,int a,int b){
        int answer=1;
        if(a>b){
            int temp=a;
            a=b;
            b=temp;
        }
        
        while(b-1!=a || a/2 == b / 2){
            float tempA=(float) a / 2;
            a=(int)Math.ceil(tempA);
            float tempB=(float) b / 2;
            b=(int)Math.ceil(tempB);
            answer++;
        }
        System.out.println(answer);
        return answer;
    }
    
}



// N	A	B	answer
// 8	4	7	3