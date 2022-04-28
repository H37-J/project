public class Money {
    
//     price	money	count	result
// 3	20	4	10

    public static void main(String... args){
        int price=6;
        int money=20;
        int count=1;

        System.out.println(solution(price, money, count));
    }

    public static long solution(long price, int money, int count){
        long original_price=price;
    
        for(int i=2; i<=count; i++){
            price+=original_price * i;
        }

        return money >= price ? 0 : price-money;
    }
}
