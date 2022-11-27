import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args)
    {
        List<String> strList1 = Arrays.asList("void","int","float","double","decimal");
        List<String> strList2 = Arrays.asList("void","int","float","double","bool");
        List<Integer> intList = new ArrayList<>();
        List<Integer> intList1 = Arrays.asList(2, 1, 4, 7, 10, 3, 4, 7);
        List<Integer> intList2 = Arrays.asList(9, 1, 1, 7, 13, 3, 15, 7);

        System.out.println("Task 1: MidValue = " + MidValue(intList1));
        System.out.println("Task 2: NewStrings = " + EditString(strList1));
        System.out.println("Task 3: SqrUniqueValue = " + ReturnSqr(intList1));
        System.out.println("Task 4: StringStartedByChar = " + ReturnString(strList1, 'd'));
        System.out.println("Task 5: LastString = " + ReturnLast(strList1));
        System.out.println("Task 5: EmptyList = " + ReturnLast(intList));
        System.out.println("Task 6: SumEvenNumbers = " + SumEven(intList1));
        System.out.println("Task 6: NaNEvenNumbers = " + SumEven(intList2));
        System.out.println("Task 7: ConvertListToMap = " + ConvertToMap(strList2));
    }

    public static double MidValue(List<Integer> intList)
    {
        return intList.stream()
                .flatMapToInt(IntStream::of)
                .average()
                .getAsDouble();
    }

    public static List<String> EditString(List<String> strList)
    {
        return strList.stream()
                .map(n -> "_new_"+n.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> ReturnSqr(List<Integer> intList)
    {
        return intList.stream()
                .filter(n -> intList.stream().filter(x -> x == n).count() < 2)
                .map(n -> (int)Math.pow(n, 2))
                .collect(Collectors.toList());
    }

    public static List<String> ReturnString(List<String> strList, char ch)
    {
        return strList.stream()
                .filter(n -> n.charAt(0) == ch)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T ReturnLast(List<T> list)
    {
        try {
            return list.stream().reduce((first, second) -> second).orElseThrow();
        }
        catch (NoSuchElementException ex){
            System.out.println("Exception: " + ex.getMessage());
            return null;
        }
    }

    public static int SumEven(List<Integer> intList)
    {
        return intList.stream()
                .flatMapToInt(IntStream::of)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static Map<Character, String> ConvertToMap(List<String> strList)
    {
        return strList.stream()
                .collect(Collectors.toMap(
                        k->k.charAt(0),
                        v->v.substring(1)));
    }
}
