public class StringUtils {
    
    public static void main(String[] args){
        //문자열 반대로
        assert reverse("abc").equals("cba");
        String reverse=reverse("abc");
        System.out.println(reverse);

        //로테이션 

    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverse2(String str){

        if(str==null || str.isEmpty()){
            return str;
        }

        char[] value=str.toCharArray();
        for(int i=0,j=str.length()-1; i<j; i++,j--){
            char temp=value[i];
            value[i]=value[j];
            value[j]=temp;
        }
        return new String(value);
    }

    public static String rotation(String s,int n){
        return s.substring(n)+s.substring(0,n);
    }
}


