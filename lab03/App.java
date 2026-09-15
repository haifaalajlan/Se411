package lab03;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

     
        String[] names = {"Sara", "Nora", "Lama"};
        PrintableList<String> stringList = new PrintableList<>(names);
        stringList.printList();

        Integer[] numbers = {10, 20, 30};
        PrintableList<Integer> integerList = new PrintableList<>(numbers);
        integerList.printList();

     
        NumberBox<Integer> intBox = new NumberBox<>();
        intBox.setItem(10);
        System.out.println("Integer sum: " + intBox.sum(5));

        NumberBox<Double> doubleBox = new NumberBox<>();
        doubleBox.setItem(10.5);
        System.out.println("Double sum: " + doubleBox.sum(5.5));

     
        List<String> words = Arrays.asList("Apple", "Banana", "Orange");
        printList(words);

        List<Integer> nums = Arrays.asList(10, 20, 30);
        System.out.println("Sum of numbers: " + sumNumbers(nums));
    }

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }
}