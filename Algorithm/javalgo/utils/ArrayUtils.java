public class ArrayUtils {

    public static void main(String... args){

    }

    public static void clones(){
      
        Integer[] arr={1,2,3,4,5};
        Integer[] arr2=arr.clone(); //깊은 복사 서로 주소 값이 다름
    }

    public static void arraycopys(){
        Integer[] arr={1,2,3,4,5};
        Integer[] copy = new Integer[arr.length];

        System.arraycopy(arr, 0, copy, 0, 5); //깊은복수
        //복사 할 배열,시작인덱스,복사 될 대상,시작,끝
    }
}
