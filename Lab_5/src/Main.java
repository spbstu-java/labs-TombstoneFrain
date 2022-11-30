import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args)
    {
        List<String> strList1 = Arrays.asList("void","int","float","double","decimal");
        List<String> strList2 = Arrays.asList("void","int","float","double","bool");
        Queue<Integer> intList = new LinkedList<>();
        List<Integer> intList1 = Arrays.asList(2, 1, 4, 7, 10, 3, 4, 7);
        Set<Integer> intList2 = Set.of(9, 1, 5, 11, 13, 3, 15, 7);

        System.out.println("Task 1: MidValue = " + midValue(intList1));
        System.out.println("Task 2: NewStrings = " + editString(strList1));
        System.out.println("Task 3: SqrUniqueValue = " + returnSqr(intList1));
        System.out.println("Task 4: StringStartedByChar = " + returnString(strList1, 'd'));
        System.out.println("Task 5: LastString = " + returnLast(strList1));
        System.out.println("Task 5: EmptyList = " + returnLast(intList));
        System.out.println("Task 6: SumEvenNumbers = " + sumEven(intList1));
        System.out.println("Task 6: NaNEvenNumbers = " + sumEven(intList2));
        System.out.println("Task 7: ConvertListToMap = " + convertToMap(strList2));
    }

    public static double midValue(Collection<Integer> intList)
    {
        return intList.stream()
                .flatMapToInt(IntStream::of)
                .average()
                .getAsDouble();
    }

    public static List<String> editString(Collection<String> strList)
    {
        return strList.stream()
                .map(n -> "_new_"+n.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> returnSqr(Collection<Integer> intList)
    {
        return intList.stream()
                .filter(n -> intList.stream().filter(x -> x == n).count() < 2)
                .map(n -> (int)Math.pow(n, 2))
                .collect(Collectors.toList());
    }

    public static List<String> returnString(Collection<String> strList, char ch)
    {
        return strList.stream()
                .filter(n -> n.charAt(0) == ch)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T returnLast(Collection<T> list)
    {
        try {
            return list.stream().reduce((first, second) -> second).orElseThrow();
        }
        catch (NoSuchElementException ex){
            System.out.println("Exception: " + ex.getMessage());
            return null;
        }
    }

    public static int sumEven(Collection<Integer> intList)
    {
        return intList.stream()
                .flatMapToInt(IntStream::of)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static Map<Character, String> convertToMap(Collection<String> strList)
    {
        return strList.stream()
                .collect(Collectors.toMap(
                        k->k.charAt(0),
                        v->v.substring(1)));
    }
}
