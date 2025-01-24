import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }
    public void add (String lastName, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(lastName, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put (lastName,numbers);
    }
    public List<String> get (String lastName) {
        return
                phoneBook.getOrDefault(lastName, new ArrayList<>());
    }
    public void printAll() {
        for(Map.Entry<String,List<String>> entry : phoneBook.entrySet()) {
            System.out.println("Фамилия: " + entry.getKey() + ". Номера: " + entry.getValue());
        }
    }
    public static void main (String [] args) {
PhoneBook phoneBook = new PhoneBook();
phoneBook.add("Иванов", "666-666-66");
phoneBook.add("Кириллов", "222-222-22");
phoneBook.add("Кириллов", "777-777-77");
phoneBook.add("Иванов", "333-333-33");
phoneBook.add("Петров", "999-999-99");
phoneBook.add("Петров", "111-111-11");
        System.out.println("Номера для Ивановна:" + phoneBook.get("Иванов"));
        System.out.println("Номера для Кириллова:" + phoneBook.get("Кириллов"));
        System.out.println("Номера для Петрова:" + phoneBook.get("Петров"));

        System.out.println("Телефонный справочник:");
        phoneBook.printAll();
    }
}

