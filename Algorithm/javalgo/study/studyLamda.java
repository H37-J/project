import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class studyLamda {

    public static void main(String[] args){
        Function<String, Integer> function = str -> str.length();
        function.apply("test"); //4

        IntStream.range(1, 4).mapToObj(e -> "a" + e).forEach(e -> System.out.println(e));
        Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i).forEach(e -> System.out.println(e));

        //min
        OptionalInt min = IntStream.of(1, 2, 3).min();
        int result = min.orElse(0);
        System.out.println(result);

        //average
        int[] arr = {1, 2, 3};
        Arrays.stream(arr).average().ifPresent(System.out::println);
        Long count = Arrays.stream(arr).count();
        System.out.println(count);
        IntStream.of(1, 2, 3).average().ifPresent(System.out::println);

        //collect() 스트림의 최종연산 매개변수로 Collector, Collectors를 받음
        List<Product> productList = Arrays.asList(new Product(1,"computer1"),
        new Product(2,"computer2"),new Product(3,"computer3"));
        List<String> nameList = productList.stream().map(Product::getName).collect(Collectors.toList());
        List<Integer> idList = productList.stream().map(Product::getId).collect(Collectors.toList());
        IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getId));
        System.out.println(statistics);

        Map<Integer, List<Product>> map = productList.stream().collect(Collectors.groupingBy(Product::getId));
        System.out.println(map.get(2).get(0).getName());

        Map<Boolean, List<Product>> mapPartion = productList.stream().collect(Collectors.partitioningBy(p -> p.getId() > 2));
        System.out.println(mapPartion);

        //match
        List<String> names = Arrays.asList("t", "te", "tes", "test");
        boolean anyMatch = names.stream().anyMatch(name -> name.contains("t"));
        boolean allMatch = names.stream().allMatch(name -> name.length() > 3);
        boolean noneMatch = names.stream().noneMatch(name -> name.endsWith("t"));

        //flatmap
        List<List<String>> flatList = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
        List<String> flat = flatList.stream() .flatMap(Collection::stream) .collect(Collectors.toList());
        flat.stream().forEach(e -> System.out.println(e));

        List<Product> products = Arrays.asList(new Product(1,"computer1"), new Product(2,"computer2"));
        products.stream().flatMapToInt(p -> IntStream.of(p.getId())).average().ifPresent(System.out::println);
    }

}

class Product{
    int id;
    String name;

    public Product(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }
}
