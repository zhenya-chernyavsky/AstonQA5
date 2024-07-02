import java.util.*;
public class Book {
    private Map<String, List<String>> phoneBook;
    public Book() {
        phoneBook = new HashMap<>();
    }
    public void add(String name, String number) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        phoneBook.get(name).add(number);
    }
    public List<String> get(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public static void main(String[] args) {
        Book phoneBook = new Book();

        phoneBook.add("Krasniy", "443332211");
        phoneBook.add("Siniy", "334445665");
        phoneBook.add("Krasniy", "293456571");

        System.out.println("Krasniy: " + phoneBook.get("Krasniy"));
        System.out.println("Siniy: " + phoneBook.get("Siniy"));
    }
}