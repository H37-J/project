import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.maxBy;
import static java.util.Comparator.comparing;

public class StreamUtils {

    public static void main(String... args) {

        // String
        System.out.println("-Start String Stream-");
        String[] arr = { "dd", "aaa", "CC", "cc", "b" };
        String[] str = sortToLength(arr);

        map2();

        inter();

        mapToInt();

        max();

        // Optional
        Optional<String> optVal = Optional.of("abc");
        String str1 = optVal.get(); // optVal에 저장된 값을 반환. null이면 예외발생
        String str2 = optVal.orElse(""); // optVal에 저장된 값이 null이면 ""를 반환
        String str3 = optVal.orElseGet(String::new); // null을 대체할 값을 반환하는 람다식 지정
        String str4 = optVal.orElseThrow(NullPointerException::new); // null일 때 지정된 예외를 발생
    }

    // 정렬
    public static List<String> sortToLength(List<String> list) {
        return list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

    public static String[] sortToLength(String[] arr) {
        return Arrays.stream(arr).sorted(Comparator.comparing(String::length)).toArray(String[]::new);
    }

    // 배열로 변환
    public static Integer[] toArray(HashSet<Integer> set) {
        return set.stream().toArray(Integer[]::new);
    }

    public static Integer[] toArray(List<Integer> list) {
        return list.stream().toArray(Integer[]::new);
    }

    public static Integer[] toArray(int[] arr) {
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }

    // 배열 -> 리스트로
    public static List<Integer> toList(Integer[] arr) {
        return Arrays.stream(arr).collect(Collectors.toList());
    }

    public static List<Integer> toList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    // mapToObj
    public static void mapToObj() {
        IntStream random = new Random().ints(1, 46);
        Stream<String> stream = random.distinct().limit(6).sorted().mapToObj(i -> i + ",");
        stream.forEach(System.out::println);
    }

    // reduce
    public static void reduce() {
        IntStream.rangeClosed(1, 5).reduce((x, y) -> x + y).stream().forEach(System.out::println);
    }

    // map
    public static void map() {
        List<String> str = Arrays.asList("1", "2");
        List<Integer> in = str.stream().map(Integer::parseInt).collect(Collectors.toList());
        in.forEach(System.out::println);
    }

    // mapToInt
    public static void mapToInt() {
        List<String> list = Arrays.asList("ajioj", "baaa");
        List<Integer> lengths = list.stream().mapToInt(String::length).boxed().collect(Collectors.toList());
        lengths.stream().forEach(System.out::println);
    }

    // map2
    public static void map2() {
        List<Integer> list = Arrays.asList(1, 2);
        list = list.stream().map(x -> x * x).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    // flatmap
    public static void flatmap() {
        String[][] arrays = new String[][] { { "a1", "a2" }, { "b1", "b2" }, { "c1", "c2", "c3" } };
        Stream<String[]> stream4 = Arrays.stream(arrays);
        Stream<String> stream5 = stream4.flatMap(s -> Arrays.stream(s));
        stream5.forEach(System.out::println);
    }

    public static void findFirst() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Optional<Integer> value = list.stream().filter(x -> x > 2).findFirst();
        System.out.println(value.get());
    }

    // Consumer
    public static void consumer() {
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("hell");

        IntConsumer con = s -> System.out.println(s * 100);
        con.accept(3);

        Consumer<String> con2 = s -> System.out.println(s.toUpperCase());
        List<String> list = Arrays.asList("a", "b");
        list.forEach(con2);
    }

    // BiConsumer
    public static void BiConsumer() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        BiConsumer<Integer, String> bi = (key, value) -> System.out.println("key:" + key + "value:" + value);
        map.forEach(bi);
    }

    // redecue
    public static void redu() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> result = stream.reduce(Integer::sum);
        Integer result2 = stream.reduce(10, (e1, e2) -> e1 + e2);
        System.out.println(result);
        System.out.println(result2);
    }

    // match
    public static void match() {
        List<String> elements = Arrays.asList("a", "a1", "b", "b1", "c", "c1");
        boolean result = elements.stream().anyMatch(e -> e.startsWith("a"));
        System.out.println(result);
        ;
    }

    // compare
    public static void max2() {
        List<String> elements = Arrays.asList("a", "a1", "b", "b1", "c", "c1");
        Optional<String> result = elements.stream().max(String::compareToIgnoreCase);
        System.out.println(result);

        List<String> langs = Arrays.asList("java", "kotlin", "haskell", "ruby", "javascript");
        final Comparator<String> comp2 = (p1, p2) -> Integer.compare(p1.length(), p2.length());
        Optional<String> largest = langs.stream().max(comp2);
        System.out.println(largest);
    }

    // sorted
    public static void sorted() {
        List<String> elements = Arrays.asList("a", "a1", "b", "b1", "c", "c1");
        elements.stream().sorted(Comparator.reverseOrder());
        elements.stream().sorted(Comparator.comparing(String::length));
    }

    // limit
    public static void limit() {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.limit(5);
        stream2.forEach(System.out::println);

        List<String> list2 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Stream<String> stream3 = list2.stream();
        Stream<String> stream4 = stream3.skip(5);
        stream4.forEach(System.out::println);
    }

    // BinaryOperator
    public static void BinaryOperator() {
        BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 + n2;
        Integer sum = binaryOperator.apply(10, 100);
        System.out.println(sum);
    }

    // Predicate
    public static void predicate() {
        Predicate<Integer> Predicate1 = e1 -> e1 > 10;
        boolean result = Predicate1.test(11);
        System.out.println(result);
    }

    // BiPredicate
    public static void BiPredicate() {
        BiPredicate<Integer, Integer> BiPredicate1 = (e1, e2) -> e1 > e2;
        BiPredicate<Integer, Integer> BiPredicate2 = (e1, e2) -> e1 * e2 > 10;
        boolean result = BiPredicate1.and(BiPredicate2).test(11, 10);
        boolean result2 = BiPredicate1.or(BiPredicate2).test(11, 10);
        System.out.println(result);
    }

    // joining
    public static void joining() {
        Stream<String> stream = Stream.of("a", "b");
        String result = stream.collect(Collectors.joining());
        System.out.println(result);
    }

    // 숫자만추출
    public static void getChars() {
        String str = "aaa1234, ^&*2233pp";
        IntStream stream = str.chars();
        String intStr = stream.filter((ch) -> (48 <= ch && ch <= 57)).mapToObj(ch -> (char) ch).map(Object::toString)
                .collect(Collectors.joining());
        System.out.println(intStr);
    }

    // max
    public static void max() {
        Stream<String> fruits = Stream.of("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");
        Function<String, Integer> getCount = fruit -> fruit.length();
        Optional<String> result = fruits.collect(maxBy(comparing(getCount)));
        System.out.println("result: " + result.orElse("no item"));
    }

    // forEach출력
    public static <T> void forEachOut(Stream<T> s) {
        s.forEach(System.out::println);
    }

    interface Excutable {
        void doSome(String text);
    }

    public static class Printer {
        public static void printSome(String text) {
            System.out.println(text);
        }
    }

    public static void inter() {
        Excutable ex = Printer::printSome;
        ex.doSome("test");
    }

}
