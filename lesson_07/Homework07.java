import java.util.*;

public class Homework07 {
    private static List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
    private static String words = "to be or not to be that is the question whether this nobler in the mind to suffer";

    // 1. Напишите код, с помощью которого можно напечатать только нечетные числа в консоль.
    static void printOdds(List<Integer> lst) {
        for (int e : lst) {
            if (e % 2 != 0) {
                System.out.print(e + " ");
            }
        }
        System.out.println();
    }

    // 2. Напишите код, с помощью которого можно напечатать только четные числа без повторений в порядке возрастания.
    static void printEvenAscending(List<Integer> lst) {
        for (int e : new TreeSet<Integer>(lst)) {
            if (e % 2 == 0) {
                System.out.print(e + " ");
            }
        }
        System.out.println();
    }

    // 3. Напишите код, который выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли.
    static void printUniqueWords(String text) {
        Set<String> uniqueWords = new HashSet<>(List.of(text.split("\\s+")));
        for (var word : uniqueWords) {
            System.out.println(word);
        } 
    }

    // 4. Напишите код, который выводит в консоль все количество дублей из списка слов
    static void printNumberOfRepeatingWords(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> repeats = new HashMap<>();
        
        for (var word : words) {
            repeats.put(word, repeats.getOrDefault(word, 0) + 1);
        }
        
        for (int num : repeats.values()) {
            if (num > 1) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printOdds(nums);

        printEvenAscending(nums);

        printUniqueWords(words);

        printNumberOfRepeatingWords(words);
    }
}
