
import java.util.HashSet;

public class PrimeRecursive {
    
    public static void main(String... args){
        String numbers="0370";
        char[] chars=numbers.toCharArray();
        HashSet<Integer> set=new HashSet<>();
        for(int i=1; i<=numbers.length(); i++){
            recursive(chars,0,0,i,set);
        }
        set.stream().forEach(System.out::println);

    }

    public static void recursive(char[] chars,int index,int count,int k,HashSet<Integer> set) {
        if(count==k){
            String answer="";
            for(int i=0; i<count; i++){
                answer+=chars[i];
            }
            if(primeCheck(Integer.parseInt(answer))) set.add(Integer.parseInt(answer));
        }

        for(int i=index; i<chars.length; i++){
            swap(chars,index,i);
            recursive(chars,index+1,count+1,k,set);
            swap(chars,index,i);
        }
    }   

    public static boolean primeCheck(int number){
        if(number == 2) return true;
        if(number == 0 || number ==1 || number % 2 ==0) return false;
        for(int i=3; i<=(int)Math.sqrt(number); i+=2){
            if(number % i == 0) return false;
        }
        return true;
    }

    public static void swap(char[] arr, int index, int i){
        char temp=arr[index];
        arr[index]=arr[i];
        arr[i]=temp;
    }   
}


// numbers	return
// "17"	3
// "011"	2