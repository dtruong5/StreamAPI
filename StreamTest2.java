import java.util.*;
import java.util.stream.IntStream;

public class StreamTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20, 2);
        List<String> list_str = Arrays.asList("apple", "orange", "strawberry", "kiwi", "mango");
        System.out.println("**************************************");
        System.out.println("Using filter, sorted and foreach method");
        //Using filter, sorted and foreach method.
        list.stream()
                .filter(num -> num % 5 == 0)
                .sorted()
                .forEach(System.out::println);
        System.out.println("**************************************");
        System.out.println("Using map method");
        //Using map method
        list_str.stream().map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("**************************************");
        System.out.println("Using findFist and get method");

        //Using findFirst and get method
        Optional<Integer> result = list.stream().findFirst();
        System.out.println(result.get());
        System.out.println("**************************************");
        System.out.println("Using ifPresent method");


        //Using ifPresent method
        OptionalInt opint = OptionalInt.empty();

        opint.ifPresent((value) -> {
            value = value * 2;
            System.out.println("Value after modification:=> "
                    + value);
        });
        System.out.println("As OptionalInt is empty value, and"
                + " is not modified");
        System.out.println("**************************************");
        System.out.println("using average method");
        //Using Average
        IntStream stream = IntStream.of(1,2,3,4,5,6);
        OptionalDouble obj = stream.average();
        if (obj.isPresent()) {
            System.out.println(obj.getAsDouble());
        }
        else {
            System.out.println("-1");
        }
        System.out.println("**************************************");
        System.out.println("Using mapToInt method");
        //Using mapToInt
        list_str.stream().mapToInt(str -> str.length()).forEach(System.out::println);
        System.out.println("**************************************");
        System.out.println("Using max method");
        //Using max method
        Optional<Integer> var = list.stream()
                .max(Comparator.reverseOrder());
        if (var.isPresent()) {
            System.out.println(var.get());
        }
        else {
            System.out.println("-1");
        }
        System.out.println("**************************************");
        System.out.println("Using anyMatch and noMatch method");
        boolean answer = list.stream().anyMatch(n
                -> (n * (n + 1)) / 4 == 5);
        boolean answer2 = list.stream().noneMatch(num -> num < 0);
        System.out.println("there is a number such that (n * (n + 1)) /4 == 5: "+ answer);
        System.out.println("there is no integer in the list that less than 0: "+ answer2);

    }
}
