import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        String[] strings = {"the", "then", "there", "soulful","melody","collections","beautiful","very important"};
        //Getting the longest string

        //Using simple for the old fashion way
        String longest = "";
        for(String s: strings)
            if(s != null && longest.compareTo(s) < 0)
                longest = s;
        System.out.println("For approach: "+ longest);

        //Using a recursive way
        longest = "";
        longest = findLongestString(strings, 0, longest);
        System.out.println("Recursive approach: " + longest);

        //Using Stream API
        longest = Arrays.stream(strings)
                .reduce((x,y)-> {
                    if(x.length() > y.length())
                        return x;
                    return y;
                })
                .get();
        System.out.println("Stream APU Reduce approach: " + longest);
        //Using Stream API max
        longest = Arrays.stream(strings)
                .max(Comparator.comparingInt(String::length))
                .get();
        System.out.println("Stream APU Max approach: " + longest);
        //counting words that contains an "e" and size is greater than 5
        long countEs = Arrays.stream(strings)
                .filter(s -> s.contains("e"))
                .filter(s -> s.length() > 5)
                .count();
        System.out.println("Stream API words that contains 'e' and are greater than 5: " + countEs);
        //------
        List<String> myList = Arrays.asList("a1","b2","b1","c2","d5","c1","x7","c3");
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        //Using findFirst Method
        Optional<String> result = myList.stream().findFirst();
        if (result.isPresent()) {
            System.out.println(result.get());
        }
        else {
            System.out.println("no value");
        }

        //Use case of ifPresent
        //Create an Optional Int
        OptionalInt opint = OptionalInt.of(2234);
        //apply ifPresent(IntConsumer)
        opint.ifPresent((value) -> {
            value = value * 2;
            System.out.println("Value after modification:=> "
                    + value);
        });

        //Use case of Average
        //Creating a stream
        IntStream stream = IntStream.of(2,3,4,5,6,7,8,9);
        //Create OptionalDouble container
        OptionalDouble obj = stream.average();
        //return true if the element is present, and return that element
        if (obj.isPresent()) {
            System.out.println(obj.getAsDouble());
        }
        else {
            System.out.println("-1");
        }

        //Use case of mapToInt
        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");
        //Using Stream mapToInt and displaying the corresponding int stream
        list.stream().mapToInt(num -> Integer.parseInt(num))
                .filter(num -> num % 3 == 0)
                .forEach(System.out::println);

        //Use case of max
        List<Integer> list_int = Arrays.asList(-9, 12, 4, 8 , 3);
        System.out.print("The maximum value is : ");
        Integer var = list_int.stream().max(Integer::compare).get();
        System.out.print(var+ "\n");

        //Use case of anyMatch
        boolean answer = list_int.stream().anyMatch(n
                -> (n * (n + 1)) / 4 == 5);
        // Displaying the result
        System.out.println(answer);

        //Use case of noneMatch
        Stream<String> streaming
                = Stream.of("CSE", "C++", "Java", "DS");
        boolean answ = streaming.noneMatch(str -> (str.length() == 4));
        System.out.println(answ);

        //Use case of get
        int element = list_int.get(2);
        System.out.println(element);

    }
    private static String findLongestString(String[] strings, int i, String longest){
        if(i < strings.length && longest.length() < strings[i].length())
            longest = strings[i];
        if(i <= strings.length)
            longest = findLongestString(strings, i+1, longest);
        return longest;
    }
}
