import java.util.*;

public class Words {
    public static void main(String[] args) {

        String[] words = {
                "apple", "apple", "orange", "banana", "grape",
                "apple", "banana", "lemon", "lemon", "apple"
        };

        Set<String> Words = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + Words);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Количество повторов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}